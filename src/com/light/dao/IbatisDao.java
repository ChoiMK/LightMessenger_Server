package com.light.dao;

import java.util.List;

import com.light.vo.CtVO;
import com.light.vo.DiaVO;
import com.light.vo.FdVO;
import com.light.vo.GbkVO;
import com.light.vo.HpVO;
import com.light.vo.ImgVO;
import com.light.vo.MemVO;
import com.light.vo.MsgVO;
import com.light.vo.NumVO;



public interface IbatisDao {
	
	public List<CtVO> selectCt(CtVO vo);
	public List<FdVO> selectFd(FdVO vo);
	public List<MemVO> selectMem(MemVO vo);
	public List<GbkVO> selectGbk(GbkVO vo);
	public List<ImgVO> selectImg(ImgVO vo);
	public List<DiaVO> selectDia(DiaVO vo);
	public List<HpVO> selectHp(HpVO vo);
	public List<MsgVO> selectMsg(MsgVO vo);
	
	
	
	public List<MemVO> selectMemfl(MemVO vo);
	public List<GbkVO> selectGbkpost(GbkVO vo);
	public List<GbkVO> selectGbkcomment(GbkVO vo);
	public List<DiaVO> selectDiapost(DiaVO vo);
	public List<DiaVO> selectDiacomment(DiaVO vo);
	public List<ImgVO> selectImgpost(ImgVO vo);
	public List<ImgVO> selectImgcomment(ImgVO vo);
	
	public List<CtVO> selectCtList();
	public List<FdVO> selectFdList();
	public List<MemVO> selectMemList();
	public List<GbkVO> selectGbkList();
	public List<ImgVO> selectImgList();
	public List<DiaVO> selectDiaList();
	public List<HpVO> selectHpList();
	public List<MsgVO> selectMsgList();
	
	
	public void insertCt(CtVO vo);
	public void insertFd(FdVO vo);
	public void insertMem(MemVO vo);
	public void insertGbk(GbkVO vo);
	public void insertImg(ImgVO vo);
	public void insertDia(DiaVO vo);
	public void insertHp(HpVO vo);
	public void insertMsg(MsgVO vo);
	
	
	
	public void updateCt(CtVO vo);
	public void updateFd(FdVO vo);
	public void updateMem(MemVO vo);
	public void updateGbk(GbkVO vo);
	public void updateImg(ImgVO vo);
	public void updateDia(DiaVO vo);
	public void updateHp(HpVO vo);
	public void updateMsg(MsgVO vo);
	

	public void deleteCt(String ctCd);
	public void deleteFd(String fdRegnum);
	public void deleteMem(String memId);
	public void deleteGbk(String gbkNum);
	public void deleteImg(String imgfraNum);
	public void deleteDia(String diaNum);
	public void deleteHp(String hpCd);
	public void deleteMsg(String msgNum);
	
	public List<FdVO> deleteFdlt(FdVO vo);
	
	
	public Object selectSq(NumVO vo);
	
	
	
	
	
	
}
