package s21217_JypJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcMain {
	public static void main(String[] args) throws Exception {
		
		Connection con = DBConnect.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
				
		Scanner sc = new Scanner(System.in);
		boolean 진행 = true;
		
		System.out.println("SW212 PC방에 오신걸 환영합니다.");
		
		while(진행) {
			//테이블 선택(사용자에게  입력 -> 해당 테이블을 선택)
			//테이블이라는 변수에 테이블명을 저장
			//ResultSet -> 컬럼명, 행의 갯수 등등의 정보는 알 수 없다.
			//ResultSetMataData
			String 테이블명 = "pc_menu";
			
			System.out.printf("메뉴를 선택하세요.");
			System.out.printf("(1)Create (2)Read (3)Update (4)Delete (5)Exit > ");
			int 선택 = sc.nextInt();
			
			switch(선택) {
			case 1:  // (1)Create
				//MENU_NO는 기본키라서 자동생성 해줘야함.
				String sql1 = "select MAX(menu_no) from ?";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, 테이블명);
				rs = pstmt.executeQuery();
				rs.next();
				
				System.out.println(rs.getString(1));
				
				String sql2 = "insert into ? value(?, ?, ?, ?)";
				
				break;
			case 2:  // (2)Read

				
				break;
			case 3:  // (3)Update

				
				break;
			case 4:  // (4)Delete

				
				break;
			default:
				System.out.println("Bye~");
				진행 = false;
			}
		}
	}

}
