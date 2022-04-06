<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%
  ArrayList<Producto> lista = (ArrayList<Producto>) session.getAttribute("listaProductos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primer Parcial - Edwin Callisaya Bautista</title>
    </head>
    <body>
        <center>
            <table border="1" cellspacing="0" cellpadding="10">
                <tr>
                    <td>
                        <h3>PRIMER PARCIAL TEM-742</h3>
                        <h3>NOMBRE: Edwin Callisaya Bautista</h3>
                        <h3>C.I.: 4332657LP</h3>
                    </td>
                </tr>
            </table>
            <h1>Productos</h1>
            <a href="MainController?op=nuevo">Nuevo registro</a>
            <br><br>
            <table border="1" cellspacing="0" cellpadding="5">
                <tr>
                    <th>Id</th>
                    <th>Descripción</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Categoría</th>
                    <th colspan="2">Acción</th>
                </tr>
                <%
                if (lista != null) {
                    for (Producto item: lista)  
                    {
                %>
                <tr>
                    <td><%= item.getId()%></td>
                    <td><%= item.getDescripcion()%></td>
                    <td><%= item.getCantidad()%></td>
                    <td><%= item.getPrecio()%></td>
                    <td><%= item.getCategoria()%></td>
                    <td> <a href="MainController?op=editar&id=<%= item.getId()%>">Modificar</a></td>
                    <td> <a href="MainController?op=eliminar&id=<%= item.getId()%>" onclick="return confirm('¿Está seguro de eliminar el registro?');">Eliminar</a></td>
                </tr>
                <%
                    }
                }
                %>
            </table>
        </center>
    </body>
</html>