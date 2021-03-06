package Pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	private Connection conn; //DB 커넥션 연결 객체
	private final String USERNAME = "root";//DBMS접속 시 아이디
	private final String PASSWORD = "1234";//DBMS접속 시 비밀번호
	private final String URL = "jdbc:mysql://localhost/db01";//DBMS접속할 db명

	public MySQL() {
		try {
			System.out.println("[ 생성자 ]");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("[ 드라이버 로딩 성공 ]");
		} catch (Exception e) {
			System.out.println("[ 드라이버 로딩 실패 ]");
			try {
				conn.close();
			} catch (SQLException e1) {    }
		}
	}

	public void create(String name, String age) {
		String sql = "insert into table01 values(?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, age); 

			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("[ Create 메서드 삽입 성공 ]");
			}
		}catch (Exception e) {
			System.out.println("[ Create 메서드 삽입 실패 ]");
		}    finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
					return;
				}
			} catch (Exception e2) {}
		}
	}
}

	


