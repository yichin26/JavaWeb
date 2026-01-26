package tw.tina.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.tina.apis.BCrypt;
import tw.tina.apis.Gift;
import tw.tina.apis.Member;

public class MemberDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/iii";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String SQL_LOGIN = """
			SELECT id, email, passwd, name
			FROM member
			WHERE email =?
			""";

	public Member login(String email, String passwd) throws Exception {
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);) {
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next() && BCrypt.checkpw(passwd, rs.getString("passwd"))) {
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setEmail(rs.getString("email"));
				member.setPasswd(rs.getString("passwd")); //2way:bcrypt/plain
				member.setName(rs.getString("name"));
				return member;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			rs.close();
		}
		return null;
	}

}
