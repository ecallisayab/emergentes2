package com.emergentes.practica02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BorrarTareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession sesion = request.getSession();
        ArrayList<Tarea> lista = (ArrayList<Tarea>) sesion.getAttribute("tareas");
        int contador = 0;
        for (Tarea item : lista) {
            if (item.getId().equals(id)) {
                break;
            }
            contador++;
        }
        lista.remove(contador);
        response.sendRedirect("tareas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
