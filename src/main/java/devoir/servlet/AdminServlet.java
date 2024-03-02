package devoir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet{

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
				+ "<body>"
				+ "<nav  class=\"navbar navbar-expand-lg navbar-light bg-light\">"
				+ " <img src=\"img/logo-iscae.png\" style=\" width:100px;  \" > "
				+ "<div class=\"container text-center pt-3\"><h2>Admin</h2></div>"
				+ "</nav>");
		
		out.println("<div class=container>");
		out.println("<div class=\"form-group\">"
				+ "    <label>Nom directeur </label>"
				+ "    <input type=\"text\" class=\"form-control w-25\" id=nameDr />"
				+ "    <label> Mot de Passe </label>"
				+ "    <input type=\"text\" class=\"form-control w-25\" id=passwordDr />"
				+ "  </div>"
				+ "  <button class=\"btn btn-primary\" onclick=AjouterDr() >Enregistrer</button>");
//***List de Cours : 
				out.println("<h2 class=text-center>Liste de Cours</h2><table class=\"table\">"
						+ "  <thead id=headTableCours></thead>");
				out.println("<tbody id=listCours>");
				out.println("</tbody></table>");
//***List de Directeurs : 
				out.println("<h2 class=text-center>Liste de directeurs</h2><table class=\"table\">"
						+ "  <thead id=headTableDr></thead>");
				out.println("<tbody id=listDr>");
				out.println("</tbody></table>");
//***List de Enseignants: 
				out.println("<h2 class=text-center>Liste de enseignants</h2><table class=\"table\">"
						+ "  <thead id=headTableEn></thead>");
				out.println("<tbody id=listEn>");
				out.println("</tbody></table>");
//***Form pour changer le mot de passe
		out.println("<form class=\" mt-5 form-control\" action=Dashboard/AdminResource method=POST >"
				+ "  <div class=\"form-group\">"
				+ "    <label>Modifier le Mot de Passe </label>"
				+ "    <input type=\"text\" class=\"form-control mb-2\"  name=password placeholder=\"Mot de Pass\">"
				+ "  </div>"
				+ "  <button type=\"submit\" class=\"btn btn-primary\">Modifier</button>"
				+ "</form>");
		out.println("</div>"
				+ "<script>"
				+ "async function  getAllCours(){"
				+ "var cours = await fetch('Dashboard/CoursApi',  {method: 'GET' }  ) ;  var result = await cours.json();"
				+ "document.getElementById('headTableCours').innerHTML='<tr><th scope=col>NOM Matier</th><th scope=col>Jours</th><th scope=col>Créneau</th></tr>';"
				+ "document.getElementById('listCours').innerHTML='';"
				+ "; Object.values(result).forEach(values=> {" 
				+ "var tr = '<tr><td>'+values.name+'</td><td>'+values.day+'</td><td>'+values.timeSlot+'</td></tr>';"
				+ "document.getElementById('listCours').innerHTML+=tr} );"
				+ "}"
				+ "async function  getAllDr(){"
				+ "var cours = await fetch('Dashboard/DirecteurApi',  {method: 'GET' }  ) ;  var result = await cours.json();"
				+ "document.getElementById('headTableDr').innerHTML='<tr><th>ID</th><th scope=col>NOM</th></tr>';"
				+ "document.getElementById('listDr').innerHTML='';"
				+ "; Object.values(result).forEach(values=> {" 
				+ "var tr = '<tr><td>'+values.id+'</td><td>'+values.name+'</td></tr>';"
				+ "document.getElementById('listDr').innerHTML+=tr} );"
				+ "}"
				+ "async function  getAllEn(){"
				+ "var cours = await fetch('Dashboard/EnseignantApi',  {method: 'GET' }  ) ;  var result = await cours.json();"
				+ "document.getElementById('headTableEn').innerHTML='<tr><th>ID</th><th scope=col>NOM</th></tr>';"
				+ "document.getElementById('listEn').innerHTML='';"
				+ "; Object.values(result).forEach(values=> {" 
				+ "var tr = '<tr><td>'+values.id+'</td><td>'+values.name+'</td></tr>';"
				+ "document.getElementById('listEn').innerHTML+=tr} );"
				+ "}"
				+ "getAllEn() ; getAllDr(); getAllCours();"
				+ "function AjouterDr(){"
				+ "var username = document.getElementById('nameDr').value ;"
				+ "var password = document.getElementById('passwordDr').value ;"
				+ "fetch('Dashboard/DirecteurApi', {method: 'PUT' ,headers: {'Content-Type': 'application/json'},  body: JSON.stringify({ name : username  , password : password }) }" 
				+ ");"
				+ "getAllDr()"
				+ "}"
				+ "</script>");
	
		out.println("</body></html>");
		out.close();
	}
	
	
}
