package devoir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EnseignantServlet extends HttpServlet{
	public void service (HttpServletRequest req,HttpServletResponse rep) 
			throws ServerException , IOException
	{	
		
		rep.setContentType("text/html");
		PrintWriter out = rep.getWriter();
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>Admin</title>"
				+ "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />"
				+ "</head><body>");
			out.println("<div class=\"container flex-column d-flex justify-content-center align-items-center\">");
			out.println("<h2 class=text-center>Liste des Cours</h2><table class=\"table\">"
							+ "  <thead id=headTableCours>"
							+ "  </thead>"
							+ "  <tbody id=listCours>");
			out.println("</tbody></table>");
		out.println("</div>"
				+ "<script>"
				+ "async function  getAllCours(){"
				+ "var cours = await fetch('Dashboard/CoursApi',  {method: 'GET' }  ) ;  var result = await cours.json();"
				+ "document.getElementById('headTableCours').innerHTML='<tr><th>Nom</th><th>Jour</th><th>Créneau</th></tr>';"
				+ "document.getElementById('listCours').innerHTML='';"
				+ "; Object.values(result).forEach( values => {" 
				+ "var line = '<tr><td>'+ values.name +'</td><td>'+values.day+'</td><td>'+values.timeSlot+'</td></tr>';"
				+ "document.getElementById('listCours').innerHTML+=line} );"
				+ "};"
				+ "getAllCours();"
				);
		out.println("</script></body>"
				+ "</html>");
		
		out.close();
		
	}

}
