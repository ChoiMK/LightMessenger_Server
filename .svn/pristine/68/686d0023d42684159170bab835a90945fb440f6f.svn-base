package com.light.messenger.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javafx.stage.Stage;

import com.light.biz.IbatisBiz;
import com.light.biz.impl.IbatisBizImpl;
import com.light.messenger.MessengerClientInf;
import com.light.messenger.MessengerServerInf;
import com.light.server.file.ImageSendServer;
import com.light.server.file.ReceiveTCPServer;
import com.light.server.file.SendTCPServer;
import com.light.server.file.TCPFileServer;
import com.light.vo.DiaVO;
import com.light.vo.FdVO;
import com.light.vo.GbkVO;
import com.light.vo.HpVO;
import com.light.vo.ImgVO;
import com.light.vo.MemVO;
import com.light.vo.MsgVO;
import com.light.vo.NumVO;

public class MessengerServer extends UnicastRemoteObject implements MessengerServerInf{
	
	public MessengerServer() throws RemoteException {
		
	}
	
	
	
	private HashMap<String,MessengerClientInf> userMap = new HashMap<String,MessengerClientInf>(); //유저맵
	private HashMap<Integer, ArrayList<MessengerClientInf>> chatListMap = new HashMap<Integer, ArrayList<MessengerClientInf>>();
	private HashMap<Integer, ArrayList<String>> chatUserMap = new HashMap<Integer, ArrayList<String>>();
	
	private List<FdVO> friendLsit = new ArrayList<FdVO>(); //친구리스트
	private static Registry registry;
	private IbatisBiz biz = new IbatisBizImpl();
	private String filename="";
	private String filefild="";
	private MessengerClientInf client;
	
	
	@Override
	public List<String> connectionUser(String userId) throws RemoteException {
		//친구목록 다 가져오기
		FdVO vo = new FdVO();
		vo.setFdMem(userId);
		List<FdVO> fdList = new ArrayList<FdVO>();
		fdList = biz.selectFd(vo);
		ArrayList<String> friendList = new ArrayList<String>();
				
		for(int i=0; i<fdList.size(); i++){
			friendList.add(fdList.get(i).getFdLt());		
		}		
		//로그인한애들 다 가져오기
		ArrayList<String> userList = new ArrayList<String>(); 
		Iterator<String> userMapIt  =userMap.keySet().iterator();
		while(userMapIt.hasNext()){
			userList.add(userMapIt.next());
		}
		//친구목록에서 로그인한애들만 골라내고
		friendList.retainAll(userList);		
		//채팅하고 있는 사람들
		int chatidx = 0;
		Iterator<Integer> chatidxIt = chatUserMap.keySet().iterator();
		while (chatidxIt.hasNext()) {
			Integer idx = chatidxIt.next();
			if (chatUserMap.get(idx).indexOf(userId)>-1) {
				chatidx = idx;
			}

		}
		
		ArrayList<String> chatUserList = new ArrayList<String>();
		chatUserList=chatUserMap.get(chatidx);
		//친구목록에에서 로그인한애들만 골라내고 채팅하고있는 유저들은 제외
		friendList.removeAll(chatUserList);		
		return friendList;
	}
	
	
	//로그인체크
	@Override
	public boolean loginCheck(String id, String pw) throws RemoteException {
		boolean cheak;
	      MemVO vo = new MemVO();
	      vo.setMemId(id);
	      vo.setMemPw(pw);
	      List<MemVO> result = biz.selectMem(vo);
	      if(result.size()==1){
	    	 vo = result.get(0);
	    	 if(vo.getMemWrlwtr().equals("YES")){
	         cheak = true;
	    	 }else{
	    		 cheak = false;
	    	 }
	      }else{
	         cheak = false;
	      }
	      return cheak;
	   
	}
	
	//로그인할시 유저맵에 담아아아아~~
	@Override
	public void contactList(String id, MessengerClientInf client) throws RemoteException {
		userMap.put(id,client);		
	}
	
	//친구추가를 위한 검색
	@Override
	public List<String> search(String id, String user) throws RemoteException {
		List<MemVO> resultList = new ArrayList<MemVO>();
		List<String> result = new ArrayList<String>();
//		String memId = id;
		MemVO vo = new MemVO();
		if(id.isEmpty() || id.equals("")){
			vo.setMemId(user);
			resultList = biz.selectMemfl(vo); //전체 리스트 다 뿌려주시와요
			for(int i = 0 ; i<resultList.size(); i++){
				String memberId = resultList.get(i).getMemId();
				result.add(i,memberId);
			}
		}else{
			vo.setMemId(user);
			  vo.setMemNic(id);
			  resultList = biz.selectMemfl(vo);// 한명만 뿌려주시와요
			  if(resultList.size()!=0){
				  result.add(resultList.get(0).getMemId());
			  }
		}
		
		return result;
	}
	
	
	//친구목록
	@Override
	public List<FdVO> getUserList(String id) throws RemoteException {
		FdVO vo = new FdVO();
		vo.setFdMem(id);
		List<FdVO> resultList = new ArrayList<FdVO>();
		resultList = biz.selectFd(vo);
		//vo.getFdLt();
		return resultList;
		
	}


	//채팅참여
		@Override
		public void joinChat(int check, int newChatIdx, String friendId, ArrayList<MessengerClientInf> chatList, ArrayList<String> chatUserList) throws RemoteException {
			if(check==1){
				
			}else{
				MessengerClientInf inviteClient = userMap.get(friendId);
				chatList = chatListMap.get(newChatIdx);
				chatUserList = chatUserMap.get(newChatIdx);
				chatList.add(inviteClient);
				chatUserList.add(friendId);
			}
			
		}
		//채팅방 만들기
		@Override
		public int makeNewChat(String myId, String friendId) throws RemoteException {
			
			boolean isConnect = userMap.keySet().contains(friendId);
			int result = 0;
			
			if (isConnect) { // 친구가 접속되어있으면 true
				ArrayList<MessengerClientInf> chatList = new ArrayList<>();
				ArrayList<String> chatUserList = new ArrayList<String>(); // 채팅하는 사람들의 아이디를 저장할 리스트
				
				MessengerClientInf chatOwnerClient = userMap.get(myId);	//초대를보낸 유저의 클라이언트를 가져와서
						
				chatList.add(chatOwnerClient);	// 채팅리스트에 추가
				
				//새로운 채팅방 번호
				int newChatIdx = 0;
				//기존에 채팅방이 있었으면
				if(chatListMap.size()>0){
					Set<Integer> chatListKeySet = chatListMap.keySet();
					TreeSet<Integer> chatListTreeKeySet = new TreeSet<>(chatListKeySet);
					newChatIdx = chatListTreeKeySet.last() + 1;
				//채팅방이 하나도 없었으면 
				}else{
					newChatIdx = 1;
				}
				
				chatListMap.put(newChatIdx, chatList);	//해당 방번호로 채팅방개설
				
				//방번호와 아이디를 저장
				chatUserList.add(myId);
				chatUserMap.put(newChatIdx, chatUserList);
				
				//초대받은유저의 아이디의 클라이언트를 가져온다.
				MessengerClientInf inviteClient = userMap.get(friendId);
				inviteClient.chatInvite(newChatIdx, myId, friendId, chatList, chatUserList); //클라이언트로 초대메시지 보냄
				result = newChatIdx;
			
			} else { // 친구가 접속 안되있으면 false
				result = -1 ;
			}

			return result;
		}
	
	@Override
	public void inviate(String sendId, String receveId, int ChatIdx)
			throws RemoteException {
		ArrayList<MessengerClientInf> chatList = new ArrayList<>();
		MessengerClientInf inviteClient = userMap.get(receveId);
		inviteClient.chatInvite(ChatIdx, sendId, receveId, chatList, null);
	}
		
	@Override
	public int chatIdx(String id) throws RemoteException {
		
		return 0;
	}
	
	
	@Override
	public void setChatMsg(int newChatIdx, String msg) throws RemoteException {
		ArrayList<MessengerClientInf> chatList = chatListMap.get(newChatIdx);		
		for(MessengerClientInf client : chatList){
			client.setChatMsg(msg);
		}
		
	}
	
	public static void main(String[] args) {
		try {
			
			registry = java.rmi.registry.LocateRegistry.createRegistry(1099);
			MessengerServerInf server = new MessengerServer();
			Naming.rebind("rmi://192.168.201.252/chat", server);
			System.out.println("서버시작~~!!!!!!!!");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean nicCheak(String nic) throws RemoteException {
		boolean result;
		List<MemVO> asd = null;
		MemVO vo = new MemVO();
		vo.setMemNic(nic);
		asd = biz.selectMem(vo);
		if(asd.size() == 0 ){
			result = true;
		}else{
			result = false;
		}
		return result;
	}

	@Override
	public boolean idCheak(String id) throws RemoteException {
		boolean result;
		List<MemVO> asd = null;
		MemVO vo = new MemVO();
		vo.setMemId(id);
		asd = biz.selectMem(vo);
		if(asd.size() == 0 ){
			result = true;
		}else{
			
			result = false;
		}
		return result;
	}

	@Override
	public void insertData(String id, String pw, String nic, String email,
			String name, String address, String hp, String bir, String gen)
			throws RemoteException {
		MemVO vo = new MemVO();
		vo.setMemId(id);
		vo.setMemPw(pw);
		vo.setMemNic(nic);
		vo.setMemEmail(email);
		vo.setMemNm(name);
		vo.setMemAdd(address);
		vo.setMemPhonum(hp);
		vo.setMemBir(bir);
		vo.setMemGn(gen);
		biz.insertMem(vo);
		
	}

	@Override
	public String idReturn(String email, String name) throws RemoteException {
		MemVO vo = new MemVO();
		vo.setMemNm(name);
		vo.setMemEmail(email);
		List<MemVO> result = biz.selectMem(vo);
		String id = "";
		if(result.size()==0){
			return id="";
		}else{
			for(int i =0 ; i< result.size(); i++){
				MemVO vo2 = new MemVO();
				vo2 = result.get(i);
				if(i==0){
					id += vo2.getMemId();
				}else{
					id += ", " + vo2.getMemId();
				}
				}
			return id;

	}
	}

	@Override
	public String pwReturn(String email, String name, String id)
			throws RemoteException {
		MemVO vo = new MemVO();
		vo.setMemId(id);
		vo.setMemNm(name);
		vo.setMemEmail(email);
		List<MemVO> result = biz.selectMem(vo);
		String pw = "";
		if(result.size()==0){
			return pw="";
		}else{
			pw = result.get(0).getMemPw();
			return pw;

	}

	}

	@Override
	public void userSave(String id, String user) {
		FdVO vo = new FdVO();
		vo.setFdMem(user);
		vo.setFdLt(id);
		biz.insertFd(vo);
		
	}

	@Override
	public List<MemVO> selectMem() throws RemoteException {
		List<MemVO> list = new ArrayList<MemVO>();
	    list =  biz.selectMemList();
		
		return list;
	}

	@Override
	public List<MemVO> selectMem(String values) throws RemoteException {
		MemVO vo = new MemVO();
		vo.setMemWrlwtr(values);
		List<MemVO> list = new ArrayList<MemVO>();
	    list =   biz.selectMem(vo);
		
		return list;
	}

	@Override
	public void update(MemVO vo) throws RemoteException {
		biz.updateMem(vo);
		
	}

	@Override
	public void deleteDia(String num) throws RemoteException {
		biz.deleteDia(num);
		
	}

	@Override
	public void deletegbk(String num) throws RemoteException {
		biz.deleteGbk(num);
		
	}

	@Override
	public List<DiaVO> setTabledata(DiaVO vo) throws RemoteException {
		List<DiaVO> list = new ArrayList<>();
		list = biz.selectDia(vo);
		return list;
	}

	@Override
	public List<GbkVO> setTabledata(GbkVO vo) throws RemoteException {
		List<GbkVO> list = new ArrayList<>();
		list = biz.selectGbk(vo);
		return list;
	}

	@Override
	public List<DiaVO> setTabledataDia() throws RemoteException {
		List<DiaVO> list = new ArrayList<>();
		list = biz.selectDiaList();
		return list;
	}

	@Override
	public List<GbkVO> setTabledataGbk() throws RemoteException {
		List<GbkVO> list = new ArrayList<>();
		list = biz.selectGbkList();
		return list;
	}

	@Override
	public void setMsg(String snedUser, String receiveUser, String content) throws RemoteException {
		MsgVO vo = new MsgVO();
		MessengerClientInf client;
		
		vo.setMsgMem(snedUser);
		vo.setMsgRecmem(receiveUser);
		vo.setMsgHt(content);
		vo.setMsgSenmem(snedUser);
		biz.insertMsg(vo);
		if (userMap.get(receiveUser) != null) {
			client = userMap.get(receiveUser);
			client.setMsg(snedUser, receiveUser, content);
		}		
		
	}

	@Override
	public List<HpVO> selectHp(HpVO vo) throws RemoteException {
		List<HpVO> list = new ArrayList<HpVO>();
		list = biz.selectHp(vo);
		return list;
	}

	@Override
	public List<MemVO> selectmemList(MemVO vo) throws RemoteException {
		List<MemVO> list = new ArrayList<MemVO>();
		list =  biz.selectMem(vo);
		return list;
	}

	@Override
	public void update(HpVO vo) throws RemoteException {
		biz.updateHp(vo);
		
	}

	@Override
	public void deleteimg(String num) throws RemoteException {
		biz.deleteImg(num);
	}

	@Override
	public List<ImgVO> setTabledata(ImgVO vo) throws RemoteException {
		List<ImgVO> list = biz.selectImg(vo);
		return list;
	}

	@Override
	public List<ImgVO> setTabledataimg() throws RemoteException {
		List<ImgVO> list = new ArrayList<>();
		list = biz.selectImgList();
		return list;
	}

	@Override
	public void update(GbkVO vo) throws RemoteException {
		biz.updateGbk(vo);
		
	}

	@Override
	public void update(DiaVO vo) throws RemoteException {
		biz.updateDia(vo);
		
	}

	@Override
	public void update(ImgVO vo) throws RemoteException {
		biz.updateImg(vo);
		
	}

	@Override
	public void insert(GbkVO vo) throws RemoteException {
		biz.insertGbk(vo);
	}

	@Override
	public void insert(DiaVO vo) throws RemoteException {
		biz.insertDia(vo);
	}

	@Override
	public void insert(ImgVO vo) throws RemoteException {
		biz.insertImg(vo);
		
	}

	@Override
	   public void fileset(String id) throws RemoteException {
	      TCPFileServer sv = new TCPFileServer();
	      sv.setUser(id);
	      sv.serverRun();
	      MemVO vo = new MemVO();
	      vo.setMemId(id);
	      List<MemVO> list =selectmemList(vo);
	      vo = list.get(0);
	      vo.setMemImg("D:/aa/"+id+".jpg");
	      biz.updateMem(vo);
	      
	   }

	@Override
	public String fileinsert() throws RemoteException {
		NumVO vo = new NumVO();
		vo = (NumVO) biz.selectSq(vo);
		String id = vo.getSequence();
	      TCPFileServer sv = new TCPFileServer();
	      sv.setUser(id);
	      sv.serverRun();
	      String img = "D:/aa/"+id+".jpg";
		return img;
	}

	
	
	
	public void fileboo(String name) throws RemoteException {
		ReceiveTCPServer sv = new ReceiveTCPServer();
		filefild = sv.serverRun(name);
		filename = name;
	}

	public void fileboo2(String UserId, String path) throws RemoteException {
        	Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				
					SendTCPServer sv2 = new SendTCPServer();
					sv2.serverRun(filefild);
			}
		});
    thread.start();
    if (userMap.get(UserId) != null) {
		client = userMap.get(UserId);
		client.resivefile(path);
	}else{
		
	}
	
	 
	}
	public String filenamert(){
		return filename;
	}
	
	
	@Override
	public void fileUpdate(String id) throws RemoteException {
	      TCPFileServer sv = new TCPFileServer();
	      sv.setUser(id);
	      sv.serverRun();
		
	}

	@Override
	public List<MsgVO> selectMsgList(MsgVO vo) throws RemoteException {
		List<MsgVO> list = new ArrayList<MsgVO>();
		list = biz.selectMsg(vo);
		return list;
	}

	@Override
	public void deleteMsg(String num) throws RemoteException {
		biz.deleteMsg(num);
	}

	@Override
	public void updateMsg(MsgVO vo) throws RemoteException {
		biz.updateMsg(vo);
		
	}

	@Override
	public void chatExit(String userId,int chatIdx) throws RemoteException {
		MessengerClientInf client = userMap.get(userId);
		ArrayList<MessengerClientInf> chatList=chatListMap.get(chatIdx);
		ArrayList<String> chatUserList	=  chatUserMap.get(chatIdx);
		chatList.remove(client);
		chatUserList.remove(userId);
		String msg = userId+"님이 퇴장하셨습니다.";
		this.setChatMsg(chatIdx, msg);
	}

	public void sendImg(String filepath, final int rnd) throws RemoteException {

		filefild = filepath;
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				ImageSendServer imgsend = new ImageSendServer();
				imgsend.serverRun(filefild,rnd);
			}
		});
		thread.start();
	}




	@Override
	public void userlogOut(String userId) throws RemoteException {
		 userMap.remove(userId);
		
		
	}


	@Override
	public ArrayList<String> userOnOff(String userId) throws RemoteException {
		
		FdVO vo = new FdVO();
		vo.setFdMem(userId);
		List<FdVO> fdList = new ArrayList<FdVO>();
		fdList = biz.selectFd(vo);
		ArrayList<String> friendList = new ArrayList<String>();
		
		for(int i=0; i<fdList.size(); i++){
			friendList.add(fdList.get(i).getFdLt());		
		}
		
		
		//로그인한애들 다 가져오기
		ArrayList<String> userList = new ArrayList<String>(); 
		Iterator<String> userMapIt  =userMap.keySet().iterator();
		while(userMapIt.hasNext()){
			userList.add(userMapIt.next());
		}
		
		
		//친구목록에서 로그인한애들만 골라내고
		friendList.retainAll(userList);
		
		return friendList;
	}


	@Override
	public ArrayList<MessengerClientInf> clientList(String userId)throws RemoteException {
		
		FdVO vo = new FdVO();
		vo.setFdMem(userId);
		List<FdVO> fdList = new ArrayList<FdVO>();
		fdList = biz.selectFd(vo);
		ArrayList<String> friendList = new ArrayList<String>();
		
		for(int i=0; i<fdList.size(); i++){
			friendList.add(fdList.get(i).getFdLt());		
		}
		
		// 로그인한애들 다 가져오기
		ArrayList<String> userList = new ArrayList<String>();
		Iterator<String> userMapIt = userMap.keySet().iterator();
		while (userMapIt.hasNext()) {
			userList.add(userMapIt.next());
		}

		// 친구목록에서 로그인한애들만 골라내고
		friendList.retainAll(userList);
		
		ArrayList<MessengerClientInf>clientList = new ArrayList<MessengerClientInf>();
		
		for(int i=0; i<friendList.size();i++){
			clientList.add(userMap.get(friendList.get(i)));
		}
		
		
		return clientList;
	}


	@Override
	public void deleteFd(String fdRegnum) throws RemoteException {
		biz.deleteFd(fdRegnum);
	}

}
