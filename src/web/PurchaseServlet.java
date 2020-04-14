package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PurchaseServlet
 */
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
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

		request.setAttribute("name",name);
		request.setAttribute("order",order);
		request.setAttribute("tax",tax);
		request.setAttribute("total",total);
		request.setAttribute("cd",cd);
		request.setAttribute("price",price);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Purchase.jsp");
		rd.forward(request, response);
	}

}
