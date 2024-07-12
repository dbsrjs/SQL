package s21217_JypJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcMain {
	public static void main(String[] args) {
		
		Connection con = DBConnect.getConnection();
		PreparedStatement pstmt;
				
		Scanner sc = new Scanner(System.in);
		boolean 진행 = true;
		
		System.out.println("SW212 PC방에 오신걸 환영합니다.");
		
		while(진행) {
			System.out.printf("메뉴를 선택하세요.");
			System.out.printf("(1)Create (2)Read (3)Update (4)Delete (5)Exit > ");
			int 선택 = sc.nextInt();
			
			switch(선택) {
			case 1:  // (1)Create
				
				
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
