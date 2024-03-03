package devoir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreneauServlet extends HttpServlet{
	
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
				+ "</head>"
				+ "<body>");
		out.println("<div class=\"container vh-100 d-flex flex-column justify-content-center align-items-center\" >");
		out.println("<div id=msg class=\"bg-info w-100\"></div>");
		out.println("<div class=\"form-group\">"
				+ "    <label>Nom Matier </label>"
				+ "    <input type=\"text\" class=form-control id=nameMatier required/>"
				+ "    <label>Jour</label>"
				+ "    <input type=\"text\" class=form-control id=jour required/>"
				+ "		<label>plage horaire</label>"
				+ "		<select id=timeSlot class=form-control>"
				+ "		<option value=8h-10h >8h-10h</option>"
				+ "		<option value=10h-12h >10h-12h</option>"
				+ "		<option value=15h-17h >15h-17h</option>"
				+ "		<option value=17h-19h >17h-19h</option>"
				+ "		</select>"
				+ "  <button type=submit class=\"btn btn-primary\" onclick=AjouterCreneau() >Ajouter</button>");
		out.println("</div></div>");
		
		out.println("<script>");
		out.println("function AjouterCreneau(){"
				+ "var name = document.getElementById('nameMatier').value ;"
				+ "var jour = document.getElementById('jour').value ;"
				+ "var timeslot = document.getElementById('timeSlot').value ;"
				+ "fetch('Dashboard/CoursApi', {method: 'PUT' ,headers: {'Content-Type': 'application/json'}, "
				+ "body: JSON.stringify({ name : name  , timeSlot: timeslot , day: jour }) }" 
				+ ").then(response =>{"
				+ "if(response.status ==204) {document.getElementById('msg').innerHTML='Créneau Ajouter'}"
				+ "else {document.getElementById('msg').innerHTML='Veuillez ressayer'} });"
				+ "}");
		out.println("</script></body></html>");
		out.close();
	}

}
