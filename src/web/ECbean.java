package web;

import java.io.Serializable;

public class ECbean implements Serializable {

	private int user_id= 0;
	private String login_cd = "";
	private String login_pw = "";


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLogin_cd() {
		return login_cd;
	}
	public void setLogin_cd(String login_cd) {
		this.login_cd = login_cd;
	}
	public String getLogin_pw() {
		return login_pw;
	}
	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}





}
