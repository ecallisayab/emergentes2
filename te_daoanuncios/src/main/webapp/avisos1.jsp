<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%
List<Aviso> listado = (List<Aviso>)request.getAttribute("avisos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Avisos</h1>
        <p><a href="AvisoController?action=add">Nuevo</a></p>
        <table border="1" cellspacing="0" cellpadding="5">
        	<tr>
        		<th>ID</th>
        		<th>Título</th>
        		<th>Contenido</th>
        		<th>Acción</th>
        	</tr>
        	 <c:forEach var="item" items="${listado}">
        	<tr>
        		<td>${item.id}</td>
        		<td>${item.titulo}</td>
        		<td>${item.contenido}</td>
        		<td>
        			<a href="AvisoController?action=edit&id=${item.id}">Editar</a>
        			<a href="AvisoController?action=delete&id=${item.id}" onclick="confirm('Está seguro de eliminar el registro?')">Eliminar</a>
        		</td>
        	</tr>
        	</c:forEach>
        </table>
    </body>
</html>
