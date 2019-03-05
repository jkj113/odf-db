package osf.service.impl;

import java.util.List;

import osf.dao.StudentDAO;
import osf.dao.impl.StudentDAOImpl;
import osf.service.StudentInfoService;
import osf.vo.StudentInfoVO;

public class StudentInfoServiceImpl implements StudentInfoService {
	private StudentDAO sdao = new StudentDAOImpl();

	@Override
	public List<StudentInfoVO> selectStudentInfoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentInfoVO selectStudentInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudentInfo(StudentInfoVO si) {
		// TODO Auto-generated method stub
		return sdao.insertStudentInfo(si);
	}

	@Override
	public int updateStudentInfo(StudentInfoVO si) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudentInfo(StudentInfoVO si) {
		// TODO Auto-generated method stub
		return 0;
	}

}
