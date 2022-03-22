<%@page import="com.emergentes.practica01.Inscripcion"%>
<%
Inscripcion ins = (Inscripcion) request.getAttribute("inscripcion");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de inscripción</title>
    </head>
    <body>
        <h1>Datos de inscripción</h1>
        <p><b>Nombre: </b> <%=ins.getNombre()%></p>
        <p><b>Apellidos: </b><%=ins.getApellidos()%></p>
        <p><b>Curso: </b><%=ins.getCurso()%></p>
        <br><br>
        <a href="inscripcion_curso.jsp">Volver al formulario</a>
    </body>
</html>
