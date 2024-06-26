package s21217_JypJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Create {
	   public static void main(String[] args) throws Exception {

	       // 1.드라이버 로드
	       Class.forName("oracle.jdbc.OracleDriver");
	       

	       // 2.Connection 객체 만들기
	       String url = "jdbc:oracle:thin:@localhost:1521:xe";
	       Connection con = DriverManager.getConnection(url, "sw212", "1234");

	       // 3.Statement 객체 만들기
	       Statement st = con.createStatement();

	       // 4.ResultSet 객체 만들기
	       ResultSet rs = st.executeQuery("select max(menu_no) from PC_MENU");
	       rs.next();

	       System.out.println(rs.getInt(1));
	//-------------------------------------- 보류(menu_no을 가져오기 위해)
	       int 메뉴번호 = rs.getInt(1)+1;

	       Scanner sc = new Scanner(System.in);

	       System.out.println("메뉴 추가 페이지입니다. "+메뉴번호+" 번째 메뉴를 입력합니다.");

	       System.out.printf("메뉴종류를 입력하세요. ");
	       String 메뉴종류 = sc.next();

	       System.out.printf("메뉴명을 입력하세요. ");
	       String 메뉴명 = sc.next();


	       System.out.printf("가격를 입력하세요. ");
	       int 가격 = sc.nextInt();
	       

	       String sql = "insert into PC_MENU values( "+메뉴번호+", '"+메뉴종류+"', '"+메뉴명+"', "+가격+")";
	       

	       int 결과 = st.executeUpdate(sql);

	       System.out.println(결과);
	   }
	}
