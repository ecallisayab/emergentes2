<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de producto</title>
    </head>
    <body>
        <h1>Registro de producto</h1>
        <form action="productoServlet" method="POST">
            <label>Producto</label>
            <input type="text" name="producto" placeholder="Ingrese nombre producto" required>
            <br><br>
            <label>Categoría</label>
            <select name="categoria" required>
                <option value="">--Seleccione una opción--</option>
                <option value="Hardware">Hardware</option>
                <option value="Software">Software</option>
            </select>
            <br><br>
            <label>Existencia</label>
            <input type="number" name="existencia" placeholder="Ingrese existencias" min="0" required>
            <br><br>
            <label>Precio</label>
            <input type="number" name="precio" placeholder="Ingrese precio" min="0" step="0.1" required>
            <br><br>
            <button type="submit">Enviar</button>
        </form>
        <br><br>
        <a href="index.jsp">Volver al menú</a>
    </body>
</html>
