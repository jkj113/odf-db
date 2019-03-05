package osf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static final String URL = "jdbc:orcle:thin:@localhost:1521:xe";
	private static final String USER = "osfu";
	private static final String PASSWORD = "12345678";
	private static Connection con = null; //다른데서도 복제해서 써야하니까 일단 여기에 null로 초기화 
	                                     // 안에다가 하면 con을 찾을 수 없다.
	//먼저 연결 시켜 놓을 때 Static을 사용한다. ==> Static을 먼저 읽으니까
	static {
		openCon();
		}

	private static void openCon() {
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		if(con==null) {
			try {
				con = DriverManager.getConnection(URL,USER,PASSWORD);
				} catch (SQLException e) {
				e.printStackTrace();
		}
	}return con;
}
	public static void close() {
		if(con != null) {
			try {
				if(!con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
	}
}
