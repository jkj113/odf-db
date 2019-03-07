package osf.food.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";  //접속 주소 => 전화번호
    private static final String USER = "osfu";
    private static final String PASSWORD = "12345678";
    private static final String CLASS_NAME = "oracle.jdbc.OracleDriver"; 
    //오라클에만 전화 할 수 있는 유심칩 어디다 전화할지 알려줘야 한다.
    private static Connection con;
    
    private static boolean open()  {
    try {
		Class.forName(CLASS_NAME);
		con = DriverManager.getConnection(URL, USER, PASSWORD); //전화하고
		return true;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();   
	}
    	return false;
    }
   //connection만 얻으면 된다. 그래서 public 나머지는 private(어떻게 거는지 알 필요 없다. 바꾸는 정보 X)
  public static Connection getCon() {
	  if(con==null) {
		  if(open()) {
			  return con;
		  }
	  }
	  return null;
  }
  public static void close() {
	  if(con != null) {  //끊었다고 해서 null이 아닌 것이 아니야??? - 저기 남아 있다??
		  try {
			if(!con.isClosed()) {    //끊어졌는지 확인
				  con.close();
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	  con = null; //전화기를 버려 (남아있는 전화기를 없앤다.JVM에서)
  }
}
