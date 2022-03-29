<%@page import="java.util.ArrayList" %>
<%@page import="com.emergentes.practica02.Tarea" %>
<%
if (session.getAttribute("tareas") == null) {
    ArrayList<Tarea> lista = new ArrayList<Tarea>();
    session.setAttribute("tareas", lista);
}
ArrayList<Tarea> lista = (ArrayList<Tarea>) session.getAttribute("tareas");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tareas pendientes</h1>
        <a href="nueva_tarea.jsp">Nuevo</a>
        <br><br>
        <table cellpadding="2" cellspacing="0" border="1">
            <tr>
                <td>ID</td>
                <td>Tarea</td>
                <td>Completado</td>
                <td></td>
            </tr>
            <%
            if (lista != null) {
                for (Tarea item : lista) {
            %>
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getTarea()%></td>
                <td>
                    <input type="checkbox" <%if (item.getEstado().equals("si")) {%>checked<%}%>>
                </td>
                <td>
                    <a href="BorrarTareaServlet?id=<%=item.getId()%>">Eliminar</a>
                </td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>
