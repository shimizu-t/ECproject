package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DetailJdbc {

	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt =null;

	public ArrayList<Productbean> detail(int pro_cd){

		ArrayList<Productbean> detaillist = new ArrayList<Productbean>();

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

					String query = "select * from product where pro_cd = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1,pro_cd);
					//ここで実行
					//rsに実行結果を格納する
					rs = pstmt.executeQuery();

					//取得した結果を全件見る
					while (rs.next()) {
						//一件一件使い終わったら中身をクリーンにする
						Productbean productbean = new Productbean();
						productbean.setPro_cd(rs.getInt("pro_cd"));
						productbean.setPro_name(rs.getString("pro_name"));
						productbean.setCat_id(rs.getInt("cat_id"));
						productbean.setPro_price(rs.getInt("pro_price"));
						productbean.setStock_no(rs.getInt("stock_no"));
						productbean.setPro_msg(rs.getString("pro_msg"));
						productbean.setPro_img(rs.getString("pro_img"));

						//すべて（一件）情報を格納されたbeanをArrayListに格納
						detaillist.add(productbean);
						}
					return detaillist;
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
				return detaillist;

	}






}
