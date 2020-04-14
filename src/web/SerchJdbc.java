package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SerchJdbc {
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;

	public ArrayList<Productbean> serch(String name) {
		//Bean型を格納するArrayListを宣言
		ArrayList<Productbean> productlist = new ArrayList<Productbean>();

		//mysqlを使っているならばテンプレ
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

			String query = "select * from product where pro_name like ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + name + "%");
			//ここで実行
			//rsに実行結果を格納する
			rs = pstmt.executeQuery();

			//取得した結果を全件見る
			while (rs.next()) {
				//一件一件使い終わったら中身をクリーンにする
				Productbean productbean = new Productbean();
				productbean.setPro_name(rs.getString("pro_name"));
				productbean.setPro_price(rs.getInt("pro_price"));
				productbean.setPro_cd(rs.getInt("pro_cd"));


				//すべて（一件）情報を格納されたbeanをArrayListに格納
				productlist.add(productbean);
				}
			return productlist;

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
		return productlist;

	}

}
