package s21217_JypJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delete {
	public static void main(String[] args) throws Exception {
		//0. 데이터베이스 연결
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "sw212", "1234");
		
		String 쿼리문 = "select menu_name from pc_menu";
		PreparedStatement pstmt = con.prepareStatement(쿼리문);
		
		ResultSet rs = pstmt.executeQuery();
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		
		//1. pc_menu 꺼내오기
		while(rs.next()) {
			cnt++;
			System.out.printf("%d.%-6s\t", cnt, rs.getString(1));
			
			if(cnt % 5 == 0)
				System.out.println();
		}
		
		System.out.println();
		
		//2. 삭제할 메뉴 선택받기
		System.out.print("삭제할 메뉴를 선택하세요. > ");
		int choice = sc.nextInt();
		
		//3. 삭제 발사버튼 만들기
		String 쿼리문2 = "delete from pc_menu where menu_no = ? ";
						
		pstmt = con.prepareStatement(쿼리문2);
		
		pstmt.setInt(1, choice);
		
		int result = pstmt.executeUpdate();
		if(result == 1) {
			System.out.println(choice + "번 정상적으로 삭제되었습니다.");
		}
	}
}
