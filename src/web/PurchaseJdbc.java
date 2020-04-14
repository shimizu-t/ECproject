package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseJdbc {

	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;

	public void purchase(int mei_id,String user_id,int pro_cd,int mei_price) {
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

			String query = "insert into meisai values (?,?,?,now(),?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mei_id);
			pstmt.setString(2, user_id);
			pstmt.setInt(3, pro_cd);
			pstmt.setInt(4, mei_price);
			//ここで実行
			//rsに実行結果を格納する
			pstmt.executeUpdate();



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

	}

	public void decrease(int order) {

	}
}

