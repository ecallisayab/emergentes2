package com.emergentes.practica01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class usuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        
        Usuario user = new Usuario();
        user.setNombre(nombre);
        user.setApellidos(apellidos);
        user.setCorreo(correo);
        user.setContrasena(contrasena);
        
        request.setAttribute("usuario", user);
        request.getRequestDispatcher("mostrar_usuario.jsp").forward(request, response);
    }

}
