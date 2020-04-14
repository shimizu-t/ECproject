package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("pro_name");
		int price = Integer.parseInt(request.getParameter("pro_price"));
		int order = Integer.parseInt(request.getParameter("stock"));
		int cd = Integer.parseInt(request.getParameter("pro_cd"));

		request.setAttribute("name",name);
		request.setAttribute("price",price);
		request.setAttribute("order",order);
		request.setAttribute("cd",cd);

		int tax = (price/10);
		int total = (price * order) + (tax * order);

		request.setAttribute("tax",tax);
		request.setAttribute("total",total);


		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Cart.jsp");
		rd.forward(request, response);


	}

}
