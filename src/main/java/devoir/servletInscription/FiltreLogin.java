package devoir.servletInscription;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class FiltreLogin extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	throws IOException, ServletException {
       
		String name = request.getParameter("username"); 
		String pass = request.getParameter("password"); 
		String post = request.getParameter("userPost");
		
		if (name.equals(devoir.AdminResource.admin.get(1).name) && pass.equals(devoir.AdminResource.admin.get(1).password) && post.equals("Admin")) {
			chain.doFilter(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");  
			rd.include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


}
