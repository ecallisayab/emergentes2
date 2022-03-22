package com.emergentes.practica01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String curso = request.getParameter("curso");
        
        Inscripcion inscrip = new Inscripcion();
        inscrip.setNombre(nombre);
        inscrip.setApellidos(apellidos);
        inscrip.setCurso(curso);
        
        request.setAttribute("inscripcion", inscrip);
        request.getRequestDispatcher("mostrar_inscripcion.jsp").forward(request, response);
    }

}
