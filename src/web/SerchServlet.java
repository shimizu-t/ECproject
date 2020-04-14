package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SerchServlet
 */
public class SerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		//キーワードをkenとし、パラメーター（値）を取得する
				String name = request.getParameter("name");

				ArrayList<Productbean> product = new ArrayList<Productbean>();

				SerchJdbc serchjdbc = new SerchJdbc();

				//jsp画面に入力された値をキーワードに
				//検索にひっかかった情報を取ってくる（あらかじめ用意したarraylistに格納）
				product = serchjdbc.serch(name);

				//リクエストオブジェクトにuselistを格納（キーワードはabc）
				request.setAttribute("result",product);

				RequestDispatcher rd = request.getRequestDispatcher("/jsp/Serch.jsp");
				rd.forward(request, response);



	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		super.doGet(request, response);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Serch.jsp");
		rd.forward(request, response);
	}



}
