package multichat;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static void main(String[] args) {
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "kosmo";
			String pass = "1234";

			Connection con = DriverManager.getConnection(url, id, pass);
			if (con != null) {
				System.out.println("Oracle 연결성공");
			} else {
				System.out.println("Oracle 연결실패");
			}
		} catch (Exception e) {
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
			//sys
		}
	}
}