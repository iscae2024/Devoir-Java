package devoir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DirecteurServlet extends HttpServlet{

	public void service (HttpServletRequest req,HttpServletResponse rep) 
			throws ServerException , IOException
	{	
		
		rep.setContentType("text/html");
		PrintWriter out = rep.getWriter();
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>Directeur</title>"
				+ "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />"
				+ "</head>"
				+ "<body>"
				+ "<nav  class=\"navbar navbar-expand-lg navbar-light bg-light\">"
				+ " <img src=\"img/logo-iscae.png\" style=\" width:100px;  \" > "
				+ "<div class=\"container text-center d-flex pt-3\"><h2>Directeur</h2>"
				+ "<a class=\"btn btn-primary\" href=\"AjouterCours\">Ajouter un créneau</a>"
				+ "</div></nav>");
		
		out.println("<div class=container>");
		out.println("<div class=\"form-group\"><form action=Dashboard/CoursApi method=POST>"
				+ "    <label>Nom Matier </label>"
				+ "    <input type=\"text\" class=form-control id=nameMatier name=name required/>"
				+ "    <label>Jour</label>"
				+ "    <input type=\"text\" class=form-control id=jour name=day required/>"
				+ "		<label>plage horaire</label>"
				+ "		<select id=timeSlot class=form-control name=timeSlot>"
				+ "		<option value=8h-10h >8h-10h</option>"
				+ "		<option value=10h-12h >10h-12h</option>"
				+ "		<option value=15h-17h >15h-17h</option>"
				+ "		<option value=17h-19h >17h-19h</option>"
				+ "		</select>"
				+ "	<input type=hidden id=hiddenInput name=id/>"
				+ " <button type=submit class=\"btn btn-primary mt-2\" disabled=true id=modifier >Modifier</button>");
		out.println("</div>");
		//***List de Cours : 
		out.println("<h2 class=text-center>Liste de Cours</h2><table class=\"table\">"
				+ "  <thead id=headTableCours></thead>");
		out.println("<tbody id=listCours>");
		out.println("</tbody></table>");
		out.println("</div>");
		out.println("<script>"
				+ "async function  getAllCours(){"
				+ "var cours = await fetch('Dashboard/CoursApi',  {method: 'GET' }  ) ;  var result = await cours.json();"
				+ "document.getElementById('headTableCours').innerHTML='<tr><th scope=col>NOM Matier</th><th scope=col>Jours</th><th scope=col>Créneau</th></tr>';"
				+ "document.getElementById('listCours').innerHTML='';"
				+ "; Object.values(result).forEach(values=> {" 
				+ "var tr = '<tr><td>'+values.name+'</td><td>'+values.day+'</td><td>'+values.timeSlot+'</td><td><button class=\"btn btn-info\" onclick=getInfo('+values.id+') >Modifier</button></td></tr>';"
				+ "document.getElementById('listCours').innerHTML+=tr} );"
				+ "}"
				+ "getAllCours();"
				+ "async function getInfo(id){"
				+ "var cours = await fetch('Dashboard/CoursApi?id='+id,  {method: 'GET' }  ) ;  var result = await cours.json();"
				+ ""
				+ "; Object.values(result).forEach(values=> {" 
				+ "document.getElementById('nameMatier').value =values.name;"
				+ "document.getElementById('jour').value = values.day;"
				+ "document.getElementById('timeSlot').value=values.timeSlot;"
				+ "document.getElementById('hiddenInput').value=id;"
				+ "document.getElementById('modifier').disabled = false"
				+ "});"
				+ "}");
		out.println("</script></body></html>");
	}

}
