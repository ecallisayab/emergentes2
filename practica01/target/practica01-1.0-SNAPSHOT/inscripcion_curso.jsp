<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscripción en curso</title>
    </head>
    <body>
        <h1>Inscripción en curso</h1>
        <form action="cursoServlet" method="POST">
            <label>Nombre</label>
            <input type="text" name="nombre" placeholder="Ingrese nombre" required>
            <br><br>
            <label>Apellidos</label>
            <input type="text" name="apellidos" placeholder="Ingrese apellidos" required>
            <br><br>
            <label>Curso</label>
            <select name="curso" required>
                <option value="">--Seleccione una opción--</option>
                <option value="Programación">Programación</option>
                <option value="Base de Datos">Base de Datos</option>
                <option value="Linux">Linux</option>
                <option value="Redes">Redes</option>
            </select>
            <br><br>
            <button type="submit">Enviar</button>
        </form>
        <br><br>
        <a href="index.jsp">Volver al menú</a>
    </body>
</html>
