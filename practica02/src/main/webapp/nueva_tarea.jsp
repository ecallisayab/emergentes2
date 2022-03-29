<%-- 
    Document   : nueva_tarea
    Created on : 29 mar. 2022, 17:11:33
    Author     : ECB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nueva tarea</h1>
        <form action="GuardarTareaServlet" method="POST">
            <label>ID</label>
            <input type="number" name="id" placeholder="Ingrese número de tarea" required>
            <br><br>
            <label>Tarea</label>
            <input type="text" name="tarea" placeholder="Ingrese tarea" required>
            <br><br>
            <label>Estado</label>
            <select name="estado" required>
                <option value="">--Seleccione una opción--</option>
                <option value="si">Completado</option>
                <option value="no">No completado</option>
            </select>
            <br><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
