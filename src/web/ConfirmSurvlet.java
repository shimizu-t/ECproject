package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmSurvlet
 */
public class ConfirmSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmSurvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int order = Integer.parseInt(request.getParameter("order"));
		int tax = Integer.parseInt(request.getParameter("tax"));
		int total = Integer.parseInt(request.getParameter("total"));
		int cd = Integer.parseInt(request.getParameter("cd"));



		PurchaseJdbc purchasejdbc = new PurchaseJdbc();

		HttpSession session = request.getSession(true);
		String user_id = (String) session.getAttribute("username");

		//変数aは仮の値を入れている
		//後で正しい値を入れる
		int a = 1;
		purchasejdbc.purchase(a,user_id,cd,total);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Confirm.jsp");
		rd.forward(request, response);




	}

}
