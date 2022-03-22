<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de libro</title>
    </head>
    <body>
        <h1>Registro de libro</h1>
        <form action="libroServlet" method="POST">
            <label>Título</label>
            <input type="text" name="titulo" placeholder="Ingrese título" required>
            <br><br>
            <label>Autor</label>
            <input type="text" name="autor" placeholder="Ingrese autor" required>
            <br><br>
            <label>Resumen</label>
            <br>
            <textarea name="resumen" rows="5" cols="30" required></textarea>
            <br><br>
            <label>Medio</label>
            <br>
            <input type="radio" name="medio" value="Físico" required>Físico
            <br>
            <input type="radio" name="medio" value="Magnético" required>Magnético
            <br><br>
            <button type="submit">Enviar</button>
        </form>
        <br><br>
        <a href="index.jsp">Volver al menú</a>
    </body>
</html>
