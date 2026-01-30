package tw.tina.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.tina.apis.Gift;

public class GiftDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/iii";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String SQL_FIND_ALL = """
			SELECT id , name , feature , addr , tel, picurl
			FROM gift
			ORDER BY id
			LIMIT ?,?
			""";
	private static final String SQL_QUERY_KEY = """
			SELECT id , name , feature , addr , tel, picurl
			FROM gift
			WHERE name LIKE ? OR feature LIKE ? OR addr LIKE ? OR tel LIKE ?
			ORDER BY addr
			""";

	private int page, rpp;

	public GiftDAO() {
	}

	public GiftDAO(int page, int rpp) {
		this.page = page;
		this.rpp = rpp;
	}

	public List<Gift> findAll() throws Exception {
		List<Gift> gifts = new ArrayList<Gift>();
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SQL_FIND_ALL);) {

			pstmt.setInt(1, (page - 1) * rpp);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Gift gift = new Gift();
				gift.setId(rs.getLong("id"));
				gift.setName(rs.getString("name"));
				gift.setFeature(rs.getString("feature"));
				gift.setAddr(rs.getString("addr"));
				gift.setTel(rs.getString("tel"));
				gift.setPicurl(rs.getString("picurl"));
				gifts.add(gift);
			}
		}
		return gifts;
	}

	public List<Gift> search(String keyword) throws Exception {
		String k = (keyword == null) ? "" : keyword.trim(); // 去除頭尾空白
		String like = "%" + k + "%";
		List<Gift> gifts = new ArrayList<Gift>();
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_KEY)) {
			pstmt.setString(1, like);
			pstmt.setString(2, like);
			pstmt.setString(3, like);
			pstmt.setString(4, like);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Gift gift = new Gift();
					gifts.add(gift);

					gift.setId(rs.getLong("id"));
					gift.setName(rs.getString("name"));
					gift.setFeature(rs.getString("feature"));
					gift.setAddr(rs.getString("addr"));
					gift.setTel(rs.getString("tel"));
					gift.setPicurl(rs.getString("picurl"));
				}
			}

		}
		return gifts;

	}

}
