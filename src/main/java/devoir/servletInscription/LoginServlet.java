package devoir.servletInscription;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void service (HttpServletRequest req,HttpServletResponse rep) 
			throws ServerException , IOException, ServletException
	{	
		 
		rep.setContentType("text/html");
		PrintWriter out = rep.getWriter();
		if (req.getParameter("userPost").equals("Admin")){
			RequestDispatcher rd = req.getRequestDispatcher("/AdminServices");  
			rd.include(req, rep);
			}
		if(req.getParameter("userPost").equals("Directeur")) {
			RequestDispatcher rd = req.getRequestDispatcher("/Directeur");  
			rd.include(req, rep);
		}
		if (req.getParameter("userPost").equals("ES")) {
			RequestDispatcher rd = req.getRequestDispatcher("/Enseignant");  
			rd.include(req, rep);
		}
	}
	
}
