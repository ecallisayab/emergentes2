<%@page import="com.emergentes.practica01.Producto"%>
<%
Producto ins = (Producto) request.getAttribute("producto");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de producto</title>
    </head>
    <body>
        <h1>Datos de producto</h1>
        <p><b>Producto </b> <%=ins.getProducto()%></p>
        <p><b>Categoría </b><%=ins.getCategoria()%></p>
        <p><b>Existencias: </b><%=ins.getExistencia()%></p>
        <p><b>Precio: </b><%=ins.getPrecio()%></p>
        <br><br>
        <a href="registro_producto.jsp">Volver al formulario</a>
    </body>
</html>
