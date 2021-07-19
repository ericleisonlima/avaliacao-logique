package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LinkDAO;

/**
 * Servlet implementation class InsertUrlController
 */
@WebServlet("/InsertUrlController")
public class InsertUrlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUrlController() {
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
		String msg = "Está Funcionado!!!";
		try {
			LinkDAO linkDAO = new LinkDAO();
			if(!linkDAO.create(request.getParameter("url"))) msg = "Não está funcionando";
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("encurtadorurl.jsp").forward(request, response);
		//response.sendRedirect("encurtadorurl.jsp");
	}

}
