package s21217_JypJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			// 테이블 선택(사용자에게 입력 -> 해당 테이블을 선택)
			// 테이블이라는 변수에 테이블명을 저장
			// ResultSet -> 컬럼명, 행의 갯수 등등의 정보는 알수 없다. 
			// ResultSetMataData
			
			// 이번 예제에서는 테이블을 정해놓고 간다!
			String 테이블명 = "pc_menu";
			
			System.out.printf("메뉴를 선택하세요.");
			System.out.printf("(1)Create (2)Read (3)Update (4)Delete (5)Exit > ");
			int 선택 = sc.nextInt();
			
			switch(선택) {
			case 1:  // (1)Create
				// MENU_NO는 기본키 -> 자동생성해주자
				String sql1 = "select MAX(menu_no) from "+테이블명;
				pstmt = con.prepareStatement(sql1);
//				pstmt.setString(1, 테이블명);
				rs = pstmt.executeQuery();
				rs.next();
				
				System.out.println(rs.getInt(1));
				int 번째 = rs.getInt(1)+1;
						
				String sql2 = "insert into "+테이블명+" values(?,?,?,?)";
				pstmt = con.prepareStatement(sql2);
//				pstmt.setString(1, 테이블명); 
				pstmt.setInt(1, 번째);
				System.out.printf("%d 번째 메뉴입니다.\n", 번째);
				
				// type 입력받기
				System.out.printf("메뉴 type: ");
				pstmt.setString(2, sc.next());
				
				// menu_name 입력받기
				System.out.printf("메뉴명: ");
				pstmt.setString(3, sc.next());
				
				// menu_price 입력받기
				System.out.printf("메뉴가격: ");
				pstmt.setInt(4, sc.nextInt());
				
				pstmt.executeUpdate();
				break;
			case 2:  // (2)Read
				String sql3 = "select * from "+테이블명;
				pstmt = con.prepareStatement(sql3);
				
				rs = pstmt.executeQuery();

				System.out.println("메뉴번호   메뉴타입     메뉴명    메뉴가격");
				System.out.println("====================================");
				while(rs.next()) {
					int 번호 = rs.getInt(1);
					String 타입 = rs.getString(2);
					String 명 = rs.getString(3);
					int 가격 = rs.getInt(4);
					
					System.out.printf("%2d  %2s  %-10s  %-8d \n", 번호, 타입, 명, 가격);
				
				}
				System.out.println("====================================");				
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
