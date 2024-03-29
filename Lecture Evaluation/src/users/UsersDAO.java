package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	public UsersDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/mysql";
			String dbID = "root";
			String dbPassword = "123456";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USERS WHERE userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword))
					return 1; //로그인 성공
				else
					return 0; //비밀번호 틀림
			}
			return -1; //아이디 없음
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -2; //데이터베이스 오류
		
	}
	public int join(UsersDTO users) {
		String SQL = "INSERT INTO USERS VALUES(?, ?, ?, ?, false)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, users.getUserID());
			pstmt.setString(2, users.getUserPassword());
			pstmt.setString(3, users.getUserEmail());
			pstmt.setString(4, users.getUserEmailHash());
			return pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; //회원가입 실패
	}
	public String getUserEmail(String userID) {
		String SQL = "SELECT userEmail FROM USERS WHERE userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getString(1);//이메일 주소 변환
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //데이터베이스 오류
		
	}
	public boolean getUserEmailChecked(String userID) {
		String SQL = "SELECT userEmailChecked FROM USERS WHERE userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getBoolean(1); //이메일 등록 여부 변환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false; //데이터베이스 오류
	}
	public boolean setUserEmailChecked(String userID) {
		String SQL = "UPDATE USERS SET userEmailChecked = true WHERE userID = ?";
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					pstmt.setString(1, userID);
					pstmt.executeUpdate();
					return true; //이메일 등록 설정 성공
				} catch(SQLException e) {
					e.printStackTrace();
				}
				return false; //이메일 등록 설정 실패
	}

}
