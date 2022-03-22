<%@page import="com.emergentes.practica01.Usuario"%>
<%
Usuario ins = (Usuario) request.getAttribute("usuario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de usuario</title>
    </head>
    <body>
        <h1>Datos de usuario</h1>
        <p><b>Nombre: </b> <%=ins.getNombre()%></p>
        <p><b>Apellidos: </b><%=ins.getApellidos()%></p>
        <p><b>Correo: </b><%=ins.getCorreo()%></p>
        <p><b>Contraseña: </b><%=ins.getContrasena()%></p>
        <br><br>
        <a href="registro_usuario.jsp">Volver al formulario</a>
    </body>
</html>
