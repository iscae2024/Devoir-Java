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
				+ "<div class=\"container text-center d-flex pt-3\"><h2>Admin</h2>"
				+ "<a class=\"btn btn-primary\" href=\"AjouterCours\">Ajouter un créneau</a>"
				+ "</div></nav>");
		
		out.println("<div class=container>");
		out.println("<div class=\"gap-5 row\">");
		out.println("<div class=\"form-group col-5\">"
				+ "    <label>Nom directeur </label>"
				+ "    <input type=\"text\" class=\"form-control\" id=nameDr />"
				+ "    <label> Mot de Passe </label>"
				+ "    <input type=\"text\" class=\"form-control\" id=passwordDr />"
				+ "  <button class=\"btn btn-primary\" onclick=AjouterDr() >Enregistrer</button> </div>");
		out.println("<div class=\"form-group col-5 \">"
				+ "    <label>Nom directeur </label>"
				+ "    <input type=\"text\" class=\"form-control\" id=nameEn />"
				+ "    <label> Mot de Passe </label>"
				+ "    <input type=\"text\" class=\"form-control\" id=passwordEn />"
				+ "  <button class=\"btn btn-primary\" onclick=AjouterEn() >Enregistrer</button></div>");
		out.println("</div>");
//***Form modifier un créneau
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
				+ " <button type=submit class=\"btn btn-primary mt-2\" onclick=getAllCours() disabled=true id=modifier >Modifier</button>");
		out.println("</form></div>");
//***List de Cours : 
				out.println("<h2 class=text-center>Liste de Cours</h2><table class=\"table\">"
						+ "<thead id=headTableCours></thead>");
				out.println("<tbody id=listCours>");
				out.println("</tbody></table>");
//***
				out.println("<div class=\"form-group\"><form action=Dashboard/DirecteurApi method=POST>"
						+ "    <label>Nom</label>"
						+ "    <input type=\"text\" class=form-control id=NameDr name=nameDr required/>"
						+ "    <label>Password</label>"
						+ "    <input type=\"text\" class=form-control id=PasswordDr name=passwordDr required/>"
						+ "	<input type=hidden id=hiddenInputDr name=id/>"
						+ " <button type=submit class=\"btn btn-primary mt-2\" onclick=getAllDr() disabled=true id=modifierDr >Modifier</button>");
				out.println("</form></div>");
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
				+ "document.getElementById('headTableCours').innerHTML='<tr><th>Nom</th><th>Jour</th><th>Créneau</th><th>Modifier</th></tr>';"
				+ "document.getElementById('listCours').innerHTML='';"
				+ "; Object.values(result).forEach(values=> {" 
				+ "var line = '<tr><td>'+ values.name +'</td><td>'+values.day+'</td><td>'+values.timeSlot+'</td><td><button class=\"btn btn-info\" onclick=modifier('+values.id+') >Modifier</button><button class=\"btn btn-danger\" onclick=deletCours('+values.id+')>Supprimer</button></td></tr>';"
				+ "document.getElementById('listCours').innerHTML+=line} );"
				+ "document.getElementById('modifier').disabled = true"
				+ "};"
				+ "async function modifier(id){"
				+ "var cours = await fetch('Dashboard/CoursApi?id='+id,  {method: 'GET' }  ) ;  var result = await cours.json();"
				+ "; Object.values(result).forEach(values=> {" 
				+ "document.getElementById('nameMatier').value =values.name;"
				+ "document.getElementById('jour').value = values.day;"
				+ "document.getElementById('timeSlot').value = values.timeSlot;"
				+ "document.getElementById('hiddenInput').value=id;"
				+ "document.getElementById('modifier').disabled = false"
				+ "});"
				+ "}"
				+ "function deletCours(id){"
				+ "fetch('Dashboard/CoursApi?id='+id,{method: 'DELETE'});"
				+ "getAllCours();"
				+ "}"
				+ "async function  getAllDr(){"
				+ "var cours = await fetch('Dashboard/DirecteurApi',  {method: 'GET' }  ) ;  var result = await cours.json();"
				+ "document.getElementById('headTableDr').innerHTML='<tr><th>ID</th><th scope=col>NOM</th><th></th></tr>';"
				+ "document.getElementById('listDr').innerHTML='';"
				+ "; Object.values(result).forEach(values=> {" 
				+ "var tr = '<tr><td>'+values.id+'</td><td>'+values.name+'</td><td><button class=\"btn btn-info\" onclick=modifierDr('+values.id+') >Modifier</button><button class=\"ml-2 btn btn-danger\" onclick=deleteDr('+values.id+')>Supprimer</button></td></tr>';"
				+ "document.getElementById('listDr').innerHTML+=tr} );"
				+ "}"
				+ "async function modifierDr(id){"
				+ "var directeur = await fetch('Dashboard/DirecteurApi?id='+id,  {method: 'GET' }  ) ;  var result = await directeur.json();"
				+ "; Object.values(result).forEach(values=> {" 
				+ "document.getElementById('NameDr').value =values.name;"
				+ "document.getElementById('PasswordDr').value = values.password;"
				+ "document.getElementById('hiddenInputDr').value=id;"
				+ "document.getElementById('modifierDr').disabled = false"
				+ "});"
				+ "}"
				+ "function deleteDr(id){"
				+ "fetch('Dashboard/DirecteurApi?id='+id,{method: 'DELETE'});"
				+ "getAllCours();"
				+ "}"
				+ ""
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
				+ "function AjouterEn(){"
				+ "var username = document.getElementById('nameEn').value ;"
				+ "var password = document.getElementById('passwordEn').value ;"
				+ "fetch('Dashboard/EnseignantApi', {method: 'PUT' ,headers: {'Content-Type': 'application/json'},  body: JSON.stringify({ name : username  , password : password }) }" 
				+ ");"
				+ "getAllEn()"
				+ "}"
				+ "</script>");
	
		out.println("</body></html>");
		out.close();
	}
	
	
}
