<%@page import="com.emergentes.modelo.Producto"%>
<%
    Producto item = (Producto) request.getAttribute("miProducto");
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
            <h1><%= (item.getId() == 0) ? "Nuevo registro" : "Editar registro" %></h1>
            <form action="MainController" method="POST">
                <input type="hidden" name="id" value="<%= item.getId()%>"/>
                <table>
                    <tr>
                        <td>Descripción</td>
                        <td><input type="text" name="descripcion" value="<%= item.getDescripcion()%>" required/></td>
                    </tr>
                    <tr>
                        <td>Cantidad</td>
                        <td><input type="number" name="cantidad" value="<%= item.getCantidad()%>" min="0" required/></td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td><input type="number" name="precio" value="<%= item.getPrecio()%>" min="0"  step="0.01" required/></td>
                    </tr>
                    <tr>
                        <td>Categoría</td>
                        <td>
                            <select name="categoria" required>
                                <option value="">--Seleccione una opción--</option>
                                <option value="Bebidas" <% if (item.getCategoria().equals("Bebidas")) {%> selected <%}%>>Bebidas</option>
                                <option value="Galletas" <% if (item.getCategoria().equals("Galletas")) {%> selected <%}%>>Galletas</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Enviar"/></td>
                    </tr>
                </table>
            </form>
            <br>
            <a href="MainController?op=view">Ir al listado</a>
            </center>
    </body>
</html>
