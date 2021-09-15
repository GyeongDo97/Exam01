package Pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	private Connection conn; //DB Ŀ�ؼ� ���� ��ü
	private final String USERNAME = "root";//DBMS���� �� ���̵�
	private final String PASSWORD = "1234";//DBMS���� �� ��й�ȣ
	private final String URL = "jdbc:mysql://localhost/db01";//DBMS������ db��

	public MySQL() {
		try {
			System.out.println("[ ������ ]");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("[ ����̹� �ε� ���� ]");
		} catch (Exception e) {
			System.out.println("[ ����̹� �ε� ���� ]");
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
				System.out.println("[ Create �޼��� ���� ���� ]");
			}
		}catch (Exception e) {
			System.out.println("[ Create �޼��� ���� ���� ]");
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

	


