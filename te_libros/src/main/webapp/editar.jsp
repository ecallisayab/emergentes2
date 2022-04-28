<%@page import="com.emergentes.modelo.Libro"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Libro libro = (Libro) request.getAttribute("libro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos de libro</h1>
        <form action="MainController" method="POST">
            <input type="hidden" name="id" value="${libro.id}">
            <table>
                <tr>
                    <td>ISBN</td>
                    <td>
                        <input type="text" name="isbn" value="${libro.isbn}" required>
                    </td>
                </tr>
                <tr>
                    <td>Título</td>
                    <td>
                        <input type="text" name="titulo" value="${libro.titulo}" required>
                    </td>
                </tr>
                <tr>
                    <td>Categoría</td>
                    <td>
                        <input type="text" name="categoria" value="${libro.categoria}" required>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Enviar">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
