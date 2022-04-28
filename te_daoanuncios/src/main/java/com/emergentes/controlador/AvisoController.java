package com.emergentes.controlador;

import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOImplementacion;
import com.emergentes.modelo.Aviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AvisoController", urlPatterns = {"/AvisoController"})
public class AvisoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AvisoDAO modelo = new AvisoDAOImplementacion();
        Aviso aviso = new Aviso();
        String action = request.getParameter("action") != null ? request.getParameter("action") : "view";
        int id;
        switch(action) {
            case "add":
                request.setAttribute("aviso", aviso);
                request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    aviso = modelo.getById(id);
                } catch (Exception e) {
                    System.out.println("Error en la consulta: "+e.getMessage());
                }
                request.setAttribute("aviso", aviso);
                request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                break;
                
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    modelo.delete(id);
                } catch (Exception e) {
                    System.out.println("Error en la consulta: "+e.getMessage());
                }
                response.sendRedirect("AvisoController");
                break;
                
            case "view":
                /*List<Aviso> lista = new ArrayList<Aviso>();
                try {
                    lista = modelo.getAll();
                } catch (Exception e) {
                    System.out.println("Error en la consulta: "+e.getMessage());
                }
                request.setAttribute("avisos", lista);
                request.getRequestDispatcher("avisos.jsp").forward(request, response);*/
                 List<Aviso> lista = new ArrayList<Aviso>(); 
                try {
                    lista = modelo.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("avisos", lista);
                request.getRequestDispatcher("avisos.jsp").forward(request, response);

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AvisoDAO modelo = new AvisoDAOImplementacion();
        Aviso aviso = new Aviso();
        int id = Integer.parseInt(request.getParameter("id"));
        
        aviso.setTitulo(request.getParameter("titulo"));
        aviso.setContenido(request.getParameter("contenido"));
        
        if (id == 0) {
            try {
                modelo.insert(aviso);
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
        } else {
            aviso.setId(id);
            try {
                modelo.update(aviso);
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
        }
        response.sendRedirect("AvisoController");
    }

}
