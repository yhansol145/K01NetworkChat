package multichat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
인터페이스를 구현한 클래스로 extend 대신 implements를 사용한다.
용어도 '상속'이 아닌 '구현'이라 표현한다.
 */
public class IConnectImpl implements IConnect {
	
	public Connection con;
	public PreparedStatement psmt; //동적쿼리 실행을 위한 객체
	public ResultSet rs;
	public CallableStatement csmt;
	public Statement stmt;
	
	//기본생성자(디폴트생성자)
	public IConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	//인자생성자1
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	//인자생성자2
	public IConnectImpl(String driver, String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			Class.forName(driver);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	//오라클에 연결
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	
	/*
	오버라이딩의 목적으로 정의한 메소드. 쿼리실행은 각각의 클래스에서
	진행하게 된다.
	 */
	@Override
	public void execute() {
	}
	
	//자원반납
	@Override
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		}
		catch(Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
	
	//사용자로부터 입력값을 받음
	@Override
	public String scanValue(String title) {
		Scanner scan = new Scanner(System.in);
		System.out.print(title +"을(를) 입력 : ");
		String inputStr = scan.nextLine();
		/*
		equalsIgnoreCase()
			: equals()와 동일하게 문자열이 같은지 비교하는 메소드로
			다른점은 대소문자를 구분하지 않는다.
		 */
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			//프로그램 자체가 즉시 종료된다.
			System.exit(0);
		}
		return inputStr;
	}
	
}
