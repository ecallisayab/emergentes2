<%@page import="com.emergentes.practica01.Libro"%>
<%
Libro ins = (Libro) request.getAttribute("libro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de libro</title>
    </head>
    <body>
        <h1>Datos de libro</h1>
        <p><b>Título: </b> <%=ins.getTitulo()%></p>
        <p><b>Autor: </b><%=ins.getAutor()%></p>
        <p><b>Resumen: </b><%=ins.getResumen()%></p>
        <p><b>Medio: </b><%=ins.getMedio()%></p>
        <br><br>
        <a href="registro_libro.jsp">Volver al formulario</a>
    </body>
</html>
