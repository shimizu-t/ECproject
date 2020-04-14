package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");


		LoginJdbc jdbc =new LoginJdbc();

		boolean check =jdbc.login(name, password);

		ArrayList<Categorybean> categorylist2 = new ArrayList<Categorybean>();

		categorylist2 = jdbc.categoryname();



		if(check==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("categoryname", categorylist2);
			session.setAttribute("username",name);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Serch.jsp");
			rd.forward(request, response);
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("caution", "正しい名前またはパスワードを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Entry.jsp");
			rd.forward(request, response);
		}
	}

}
