package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginJdbc {

	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;

	public boolean login(String name, String password) {
		//Bean型を格納するArrayListを宣言

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			//urlの一番後ろは接続したいDB名
			String url = "jdbc:mysql://localhost/ecsite";
			//idとpassはDBにアクセスするときのものを使う
			String id = "root";
			String pass = "password";
			conn = DriverManager.getConnection(url, id, pass);

			String query = "select * from user where login_cd = ? AND login_pw = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			//ここで実行
			//rsに実行結果を格納する
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {

			}
		}
		return false;

	}

	public ArrayList<Categorybean> categoryname() {
		ArrayList<Categorybean> categorylist = new ArrayList<Categorybean>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			//urlの一番後ろは接続したいDB名
			String url = "jdbc:mysql://localhost/ecsite";
			//idとpassはDBにアクセスするときのものを使う
			String id = "root";
			String pass = "password";
			conn = DriverManager.getConnection(url, id, pass);

			stmt = conn.createStatement();
			//使いたいSQL文によって変わる
			String query = "select * from category";
			//参照系SQL(executeQuery)を使うか、更新系SQL(executeUpdate)を使うかで変わる
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Categorybean categorybean = new Categorybean();
				categorybean.setCat_id(rs.getInt("cat_id"));
				categorybean.setCat_name(rs.getString("cat_name"));
				categorylist.add(categorybean);
			}
			return categorylist;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {

			}

		}
		return categorylist;
	}

}
