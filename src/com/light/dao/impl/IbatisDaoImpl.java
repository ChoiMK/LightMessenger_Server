package com.light.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.light.dao.IbatisDao;
import com.light.ibatis.SqlMapConfig;
import com.light.vo.CtVO;
import com.light.vo.DiaVO;
import com.light.vo.FdVO;
import com.light.vo.GbkVO;
import com.light.vo.HpVO;
import com.light.vo.ImgVO;
import com.light.vo.MemVO;
import com.light.vo.MsgVO;
import com.light.vo.NumVO;

public class IbatisDaoImpl implements IbatisDao {
	private SqlMapClient sqlMap = SqlMapConfig.getSqlMapInstance();

	public Object selectSq(NumVO vo){
	      Object result = "";
	      
	      try {
	          result = sqlMap.queryForObject("msg.selectSq");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return result;
	   }
	@Override
	public List<CtVO> selectCt(CtVO vo) {
		List<CtVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ctCd", vo.getCtCd());
		paramMap.put("ctHt", vo.getCtHt());
		paramMap.put("ctPp", vo.getCtPp());
		paramMap.put("ctDt", vo.getCtDt());
		paramMap.put("ctMem", vo.getCtMem());
		try {
			resultList = sqlMap.queryForList("msg.selectCt", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	@Override
	public List<FdVO> selectFd(FdVO vo) {
		List<FdVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("fdRegnum", vo.getFdRegnum());
		paramMap.put("fdGr", vo.getFdGr());
		paramMap.put("fdLt", vo.getFdLt());
		paramMap.put("fdMem", vo.getFdMem());

		try {
			resultList = sqlMap.queryForList("msg.selectFd", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<MemVO> selectMem(MemVO vo) {
		List<MemVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("memId", vo.getMemId());
		paramMap.put("memImg", vo.getMemImg());
		paramMap.put("memEmail", vo.getMemEmail());
		paramMap.put("memPw", vo.getMemPw());
		paramMap.put("memAdd", vo.getMemAdd());
		paramMap.put("memNm", vo.getMemNm());
		paramMap.put("memPhonum", vo.getMemPhonum());
		paramMap.put("memGn", vo.getMemGn());
		paramMap.put("memNic", vo.getMemNic());
		paramMap.put("memBir", vo.getMemBir());
		paramMap.put("memWrlwtr", vo.getMemWrlwtr());

		try {
			resultList = sqlMap.queryForList("msg.selectMem", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<GbkVO> selectGbk(GbkVO vo) {
		List<GbkVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("gbkNum", vo.getGbkNum());
		paramMap.put("gbkCon", vo.getGbkCon());
		paramMap.put("gbkWridt", vo.getGbkWridt());
		paramMap.put("gbkMem", vo.getGbkMem());
		paramMap.put("gbkWrimem", vo.getGbkWrimem());
		paramMap.put("gbkPtkid", vo.getGbkPtkid());
		paramMap.put("gbkHp", vo.getGbkHp());
		paramMap.put("gbkTit", vo.getGbkTit());

		try {
			resultList = sqlMap.queryForList("msg.selectGbk", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<ImgVO> selectImg(ImgVO vo) {
		List<ImgVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("imgfraNum", vo.getImgfraNum());
		paramMap.put("imgfraTit", vo.getImgfraTit());
		paramMap.put("imgfraDt", vo.getImgfraDt());
		paramMap.put("imgfraImg", vo.getImgfraImg());
		paramMap.put("imgfraCon", vo.getImgfraCon());
		paramMap.put("imgfraWrimem", vo.getImgfraWrimem());
		paramMap.put("imgfraPtkid", vo.getImgfraPtkid());
		paramMap.put("imgfraMem", vo.getImgfraMem());
		paramMap.put("imgfraHp", vo.getImgfraHp());

		try {
			resultList = sqlMap.queryForList("msg.selectImg", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<DiaVO> selectDia(DiaVO vo) {
		List<DiaVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("diaNum", vo.getDiaNum());
		paramMap.put("diaTit", vo.getDiaTit());
		paramMap.put("diaCon", vo.getDiaCon());
		paramMap.put("diaWridt", vo.getDiaWridt());
		paramMap.put("diaWrimem", vo.getDiaWrimem());
		paramMap.put("diaPtkid", vo.getDiaPtkid());
		paramMap.put("diaMem", vo.getDiaMem());
		paramMap.put("diaHp", vo.getDiaHp());

		try {
			resultList = sqlMap.queryForList("msg.selectDia", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<HpVO> selectHp(HpVO vo) {
		List<HpVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("hpCd", vo.getHpCd());
		paramMap.put("hpCredt", vo.getHpCredt());
		paramMap.put("hpMawrt", vo.getHpMawrt());
		paramMap.put("hpSttwrt", vo.getHpSttwrt());
		paramMap.put("hpClo", vo.getHpClo());
		paramMap.put("hpMem", vo.getHpMem());


		try {
			resultList = sqlMap.queryForList("msg.selectHp", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<MsgVO> selectMsg(MsgVO vo) {
		List<MsgVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("msgRownum", vo.getMsgRownum());
		paramMap.put("msgNum", vo.getMsgNum());
		paramMap.put("msgDt", vo.getMsgDt());
		paramMap.put("msgSenmem", vo.getMsgSenmem());
		paramMap.put("msgRecmem", vo.getMsgRecmem());
		paramMap.put("msgHt", vo.getMsgHt());
		paramMap.put("msgMem", vo.getMsgMem());
		paramMap.put("msgWtr", vo.getMsgWtr());

		try {
			resultList = sqlMap.queryForList("msg.selectMsg", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<CtVO> selectCtList() {
		List<CtVO> resultList = null;
		try {
			resultList = sqlMap.queryForList("msg.selectCtList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<FdVO> selectFdList() {
		List<FdVO> resultList = null;
		try {
			resultList = sqlMap.queryForList("msg.selectFdList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<MemVO> selectMemList() {

		List<MemVO> resultList = null;
		try {
			resultList = sqlMap.queryForList("msg.selectMemList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	@Override
	public List<GbkVO> selectGbkList() {

		List<GbkVO> resultList = null;
		try {
			resultList = sqlMap.queryForList("msg.selectGbkList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	@Override
	public List<ImgVO> selectImgList() {

		List<ImgVO> resultList = null;
		try {
			resultList = sqlMap.queryForList("msg.selectImgList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	@Override
	public List<DiaVO> selectDiaList() {

		List<DiaVO> resultList = null;
		try {
			resultList = sqlMap.queryForList("msg.selectDiaList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	@Override
	public List<HpVO> selectHpList() {

		List<HpVO> resultList = null;
		try {
			resultList = sqlMap.queryForList("msg.selectHpList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	@Override
	public List<MsgVO> selectMsgList() {

		List<MsgVO> resultList = null;
		try {
			resultList = sqlMap.queryForList("msg.selectMsgList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	@Override
	public void insertCt(CtVO vo) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ctCd", vo.getCtCd());
		paramMap.put("ctHt", vo.getCtHt());
		paramMap.put("ctPp", vo.getCtPp());
		paramMap.put("ctMem", vo.getCtMem());

		try {
			sqlMap.insert("msg.insertCt", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertFd(FdVO vo) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("fdRegnum", vo.getFdRegnum());
		paramMap.put("fdGr", vo.getFdGr());
		paramMap.put("fdLt", vo.getFdLt());
		paramMap.put("fdMem", vo.getFdMem());

		try {
			sqlMap.insert("msg.insertFd", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertMem(MemVO vo) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("memId", vo.getMemId());
		paramMap.put("memImg", vo.getMemImg());
		paramMap.put("memEmail", vo.getMemEmail());
		paramMap.put("memPw", vo.getMemPw());
		paramMap.put("memAdd", vo.getMemAdd());
		paramMap.put("memNm", vo.getMemNm());
		paramMap.put("memPhonum", vo.getMemPhonum());
		paramMap.put("memGn", vo.getMemGn());
		paramMap.put("memNic", vo.getMemNic());
		paramMap.put("memBir", vo.getMemBir());
		paramMap.put("memWrlwtr", vo.getMemWrlwtr());

		try {
			sqlMap.insert("msg.insertMem", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertGbk(GbkVO vo) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("gbkNum", vo.getGbkNum());
		paramMap.put("gbkCon", vo.getGbkCon());
		paramMap.put("gbkMem", vo.getGbkMem());
		paramMap.put("gbkWrimem", vo.getGbkWrimem());
		paramMap.put("gbkPtkid", vo.getGbkPtkid());
		paramMap.put("gbkHp", vo.getGbkHp());
		paramMap.put("gbkTit", vo.getGbkTit());

		try {
			sqlMap.insert("msg.insertGbk", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertImg(ImgVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("imgfraNum", vo.getImgfraNum());
		paramMap.put("imgfraTit", vo.getImgfraTit());
		paramMap.put("imgfraImg", vo.getImgfraImg());
		paramMap.put("imgfraCon", vo.getImgfraCon());
		paramMap.put("imgfraWrimem", vo.getImgfraWrimem());
		paramMap.put("imgfraPtkid", vo.getImgfraPtkid());
		paramMap.put("imgfraMem", vo.getImgfraMem());
		paramMap.put("imgfraHp", vo.getImgfraHp());

		try {
			sqlMap.insert("msg.insertImg", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertDia(DiaVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("diaNum", vo.getDiaNum());
		paramMap.put("diaTit", vo.getDiaTit());
		paramMap.put("diaCon", vo.getDiaCon());
		paramMap.put("diaWrimem", vo.getDiaWrimem());
		paramMap.put("diaPtkid", vo.getDiaPtkid());
		paramMap.put("diaMem", vo.getDiaMem());
		paramMap.put("diaHp", vo.getDiaHp());

		try {
			sqlMap.insert("msg.insertDia", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertHp(HpVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("hpCd", vo.getHpCd());
		paramMap.put("hpMawrt", vo.getHpMawrt());
		paramMap.put("hpSttwrt", vo.getHpSttwrt());
		paramMap.put("hpClo", vo.getHpClo());
		paramMap.put("hpMem", vo.getHpMem());

		try {
			sqlMap.insert("msg.insertHp", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertMsg(MsgVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("msgNum", vo.getMsgNum());
		paramMap.put("msgSenmem", vo.getMsgSenmem());
		paramMap.put("msgRecmem", vo.getMsgRecmem());
		paramMap.put("msgHt", vo.getMsgHt());
		paramMap.put("msgMem", vo.getMsgMem());

		try {
			sqlMap.insert("msg.insertMsg", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateCt(CtVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ctCd", vo.getCtCd());
		paramMap.put("ctHt", vo.getCtHt());
		paramMap.put("ctPp", vo.getCtPp());

		try {
			sqlMap.update("msg.updateCt", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateFd(FdVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("fdRegnum", vo.getFdRegnum());
		paramMap.put("fdGr", vo.getFdGr());
		paramMap.put("fdLt", vo.getFdLt());

		try {
			sqlMap.update("msg.updateFd", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateMem(MemVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("memId", vo.getMemId());
		paramMap.put("memImg", vo.getMemImg());
		paramMap.put("memEmail", vo.getMemEmail());
		paramMap.put("memPw", vo.getMemPw());
		paramMap.put("memAdd", vo.getMemAdd());
		paramMap.put("memNm", vo.getMemNm());
		paramMap.put("memPhonum", vo.getMemPhonum());
		paramMap.put("memGn", vo.getMemGn());
		paramMap.put("memNic", vo.getMemNic());
		paramMap.put("memBir", vo.getMemBir());
		paramMap.put("memWrlwtr", vo.getMemWrlwtr());

		try {
			sqlMap.update("msg.updateMem", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateGbk(GbkVO vo) {


		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("gbkNum", vo.getGbkNum());
		paramMap.put("gbkCon", vo.getGbkCon());
		paramMap.put("gbkWrimem", vo.getGbkWrimem());
		paramMap.put("gbkPtkid", vo.getGbkPtkid());
		paramMap.put("gbkTit", vo.getGbkTit());
		

		try {
			sqlMap.update("msg.updateGbk", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	

	}

	@Override
	public void updateImg(ImgVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("imgfraNum", vo.getImgfraNum());
		paramMap.put("imgfraTit", vo.getImgfraTit());
		paramMap.put("imgfraImg", vo.getImgfraImg());
		paramMap.put("imgfraCon", vo.getImgfraCon());
		paramMap.put("imgfraWrimem", vo.getImgfraWrimem());
		paramMap.put("imgfraPtkid", vo.getImgfraPtkid());
		

		try {
			sqlMap.update("msg.updateImg", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateDia(DiaVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("diaNum", vo.getDiaNum());
		paramMap.put("diaTit", vo.getDiaTit());
		paramMap.put("diaCon", vo.getDiaCon());
		paramMap.put("diaWrimem", vo.getDiaWrimem());
		paramMap.put("diaPtkid", vo.getDiaPtkid());
		

		try {
			sqlMap.update("msg.updateDia", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateHp(HpVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("hpCd", vo.getHpCd());
		paramMap.put("hpMawrt", vo.getHpMawrt());
		paramMap.put("hpSttwrt", vo.getHpSttwrt());
		paramMap.put("hpClo", vo.getHpClo());
		

		try {
			sqlMap.update("msg.updateHp", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateMsg(MsgVO vo) {

		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("msgNum", vo.getMsgNum());
		paramMap.put("msgSenmem", vo.getMsgSenmem());
		paramMap.put("msgRecmem", vo.getMsgRecmem());
		paramMap.put("msgHt", vo.getMsgHt());
		paramMap.put("msgWtr", vo.getMsgWtr());


		try {
			sqlMap.update("msg.updateMsg", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCt(String ctCd) {
		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ctCd", ctCd);
		
		try {
			sqlMap.delete("msg.deleteCt", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFd(String fdRegnum) {
		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("fdRegnum", fdRegnum);
		
		try {
			sqlMap.delete("msg.deleteFd", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMem(String memId) {

		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("memId", memId);
		
		try {
			sqlMap.delete("msg.deleteMem", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		

	}

	@Override
	public void deleteGbk(String gbkNum) {

		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("gbkNum", gbkNum);
		
		try {
			sqlMap.delete("msg.deleteGbk", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		

	}

	@Override
	public void deleteImg(String imgfraNum) {

		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("imgfraNum", imgfraNum);
		
		try {
			sqlMap.delete("msg.deleteImg", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		

	}

	@Override
	public void deleteDia(String diaNum) {

		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("diaNum", diaNum);
		
		try {
			sqlMap.delete("msg.deleteDia", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		

	

	}

	@Override
	public void deleteHp(String hpCd) {

		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("hpCd", hpCd);
		
		try {
			sqlMap.delete("msg.deleteHp", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		

	

	}

	@Override
	public void deleteMsg(String msgNum) {

		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("msgNum", msgNum);
		
		try {
			sqlMap.delete("msg.deleteMsg", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	@Override
	public List<MemVO> selectMemfl(MemVO vo) {
		List<MemVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("memId", vo.getMemId());
		paramMap.put("memNic",vo.getMemNic());
		try {
			resultList = sqlMap.queryForList("msg.selectMemfl",paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<GbkVO> selectGbkpost(GbkVO vo) {
		List<GbkVO> resultList = null;
	HashMap<String, String> paramMap = new HashMap<String, String>();
	paramMap.put("gbkMem", vo.getGbkMem());

	try {
		resultList = sqlMap.queryForList("msg.selectGbkpost", paramMap);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return resultList;
	}

	@Override
	public List<GbkVO> selectGbkcomment(GbkVO vo) {
		List<GbkVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("gbkNum", vo.getGbkNum());

		try {
			resultList = sqlMap.queryForList("msg.selectGbkcomment", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<DiaVO> selectDiapost(DiaVO vo) {
		List<DiaVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("diaMem", vo.getDiaMem());

		try {
			resultList = sqlMap.queryForList("msg.selectDiapost", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<DiaVO> selectDiacomment(DiaVO vo) {
		List<DiaVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("diaNum", vo.getDiaNum());

		try {
			resultList = sqlMap.queryForList("msg.selectDiacomment", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<ImgVO> selectImgpost(ImgVO vo) {
		List<ImgVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("imgfraMem", vo.getImgfraMem());

		try {
			resultList = sqlMap.queryForList("msg.selectIMGpost", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<ImgVO> selectImgcomment(ImgVO vo) {
		List<ImgVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("imgfraNum", vo.getImgfraNum());

		try {
			resultList = sqlMap.queryForList("msg.selectIMGcomment", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}
	@Override
	public List<FdVO> deleteFdlt(FdVO vo) {
		List<FdVO> resultList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("fdMem", vo.getFdMem());

		try {
			resultList = sqlMap.queryForList("msg.deleteFdlt", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	

}
