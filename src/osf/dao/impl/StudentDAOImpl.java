package osf.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import osf.dao.StudentDAO;
import osf.db.DBConnector;
import osf.vo.StudentInfoVO;

public class StudentDAOImpl implements StudentDAO {

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
	String sql = "insert into student_info";
	sql += " (si_num, si_id, si_pwd, si_name, si_age, si_phone, ci_num)";
	sql += " values(SEQ_student_info_si_num.nextval,";
	sql += " ?,?,?,?,?,?)";
	try {
		PreparedStatement ps = DBConnector.getCon().prepareStatement(sql);
		ps.setString(1, si.getSiId());
		ps.setString(2, si.getSiPwd());
		ps.setString(3, si.getSiName());
		ps.setInt(4, si.getSiAge());
		ps.setString(5, si.getSiPhone());
		ps.setInt(6, si.getCiNum());
		return	ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return 0;
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
