package P2_route.model;

import java.util.List;


public class viewnameService {

	private viewnameDAO_interface dao;

	public viewnameService() {
		dao = new viewnameDAO();
	}

//	public viewnameVO addViewname(String id, String pwd, Integer memclass, String name, String stop,String gender,java.sql.Date bdy,
//			String addr, java.sql.Date buildtime) {
//
//		viewnameVO vnVO = new viewnameVO();
//		memVO.setMember_loginID(id);
//		memVO.setMember_password(pwd);
//		memVO.setMember_class(memclass);
//		memVO.setMember_name(name);
//		memVO.setMember_stop(stop);
//		memVO.setMember_gender(gender);
//		memVO.setMember_birthday(bdy);
//		memVO.setMember_address(addr);
//		memVO.setMember_buildtime(buildtime);
//		
//		dao.insert(memVO);
//
//		return memVO;
//		return null;
//	}

//	public viewnameVO updateViewname(String id, String pwd, String name,java.sql.Date bdy,
//			String addr) {

//		viewnameVO nvVO = new viewnameVO();
//
//		memVO.setMember_loginID(id);
//		memVO.setMember_password(pwd);
//		memVO.setMember_name(name);
//		memVO.setMember_birthday(bdy);
//		memVO.setMember_address(addr);
//		
//		dao.update(memVO);
//
//		return dao.findByPrimaryKey(id);
//		return null;
//	}
	
//	//for Struts 2
//	public void addEmp(EmpVO empVO) {
//		dao.insert(empVO);
//	}
	
//	public MemVO updateMem(String member_loginID) {
//
//		return dao.findByPrimaryKey(member_loginID);
//	}
	
//	//for Struts 2
//	public void updateMem(MemVO memVO) {
//		dao.update(memVO);
//	}

//	public void deleteEmp(String member_loginID) {
//		dao.delete(member_loginID);
//	}
//
//	public MemVO getOneMem(String member_loginID) {
//		return dao.findByPrimaryKey(member_loginID);
//	}

	public List<viewnameVO> getAll() {
		return dao.getAll();
	}
	
	public String getAllJSON(String viewArea) {
		return dao.getAllJSON(viewArea);
	}
}
