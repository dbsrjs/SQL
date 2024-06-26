package s21217_JypJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CreatePre  {

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
            int 메뉴번호 = rs.getInt(1)+1;
           
//-------------- 메뉴번호 가져오는 과정
           
            String sql = "insert into PC_MENU values(?, ?, ?, ?)";
           
            PreparedStatement pstmt = con.prepareStatement(sql);
           
           
            Scanner sc = new Scanner(System.in);
            System.out.println("메뉴 추가 페이지입니다. "+메뉴번호+" 번째 메뉴를 입력합니다.");
            pstmt.setInt(1, 메뉴번호);
           
            System.out.printf("메뉴종류를 입력하세요. ");
            String 메뉴종류 = sc.next();
            pstmt.setString(2, 메뉴종류);

            System.out.printf("메뉴명을 입력하세요. ");
            String 메뉴명 = sc.next();
            pstmt.setString(3, 메뉴명);

            System.out.printf("가격를 입력하세요. ");
            int 가격 = sc.nextInt();
            pstmt.setInt(4, 가격);
           
            int 결과 = pstmt.executeUpdate();
            System.out.println(결과);     
	    }
}
