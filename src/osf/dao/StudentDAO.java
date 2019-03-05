package osf.dao;

import java.util.List;

import osf.vo.StudentInfoVO;

public interface StudentDAO {
	public List<StudentInfoVO> selectStudentInfoList();
	public StudentInfoVO selectStudentInfo();
	public int insertStudentInfo(StudentInfoVO si);
	public int updateStudentInfo(StudentInfoVO si);
	public int deleteStudentInfo(StudentInfoVO si);
}
