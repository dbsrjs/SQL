package s21217_JypJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreatePreEmp  {

    public static void main(String[] args) throws Exception {
    	//1. 드라이버 로드
    	Class.forName("oracle.jdbc.OracleDriver");
    	
    	//2. 연결 객체 생성
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = DriverManager.getConnection(url, "sw212", "1234");
    	
    	//3. 준비상태 객체 생성
        String sql = "insert into pc_emp values(?, ?, ?, ?, ?, ? , ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("사원추가 페이지입니다.");
        
        System.out.print("사원명(name)? > ");
        pstmt.setString(2, sc.next());
        
        System.out.print("생년월일(birth-YYYYMMDD)? > ");
        pstmt.setString(4, sc.next());
        
        System.out.print("연락처(tel)? > ");
        pstmt.setInt(5,  sc.nextInt());
        
        System.out.print("주소(address)? > ");
        pstmt.setString(6, sc.next());
        
        pstmt.setInt(1, 5);//사원번호
        pstmt.setString(3, "slave");//직급
        pstmt.setInt(7, 100);
    	//4. 발사 버튼
        System.out.println(pstmt.executeUpdate());   
    }
}
