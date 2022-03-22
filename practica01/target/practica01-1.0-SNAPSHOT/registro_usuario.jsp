<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de usuario</title>
    </head>
    <body>
        <h1>Registro de usuario</h1>
        <form action="usuarioServlet" method="POST">
            <label>Nombre</label>
            <input type="text" name="nombre" placeholder="Ingrese nombre" required>
            <br><br>
            <label>Apellidos</label>
            <input type="text" name="apellidos" placeholder="Ingrese apellidos" required>
            <br><br>
            <label>Correo electrónico</label>
            <input type="email" name="correo" placeholder="Ingrese correo electrónico" required>
            <br><br>
            <label>Contraseña</label>
            <input type="password" name="contrasena" placeholder="Ingrese contraseña" required>
            <br><br>
            <button type="submit">Enviar</button>
        </form>
        <br><br>
        <a href="index.jsp">Volver al menú</a>
    </body>
</html>
