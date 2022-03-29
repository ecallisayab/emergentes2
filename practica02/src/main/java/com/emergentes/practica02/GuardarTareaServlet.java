package com.emergentes.practica02;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GuardarTareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Tarea tarea = new Tarea();
        tarea.setId(request.getParameter("id"));
        tarea.setTarea(request.getParameter("tarea"));
        tarea.setEstado(request.getParameter("estado"));
        
        HttpSession sesion = request.getSession();
        ArrayList<Tarea> lista = (ArrayList<Tarea>) sesion.getAttribute("tareas");
        lista.add(tarea);
        response.sendRedirect("tareas.jsp");
    }

}
