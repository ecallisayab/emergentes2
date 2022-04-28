package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOImplementacion;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO modelo = new UsuarioDAOImplementacion();
        Usuario usuario = new Usuario();
        String action = request.getParameter("action") != null ? request.getParameter("action") : "view";
        int id;
        switch(action) {
            case "add":
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    usuario = modelo.getById(id);
                } catch (Exception e) {
                    System.out.println("Error en la consulta: "+e.getMessage());
                }
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;
                
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    modelo.delete(id);
                } catch (Exception e) {
                    System.out.println("Error en la consulta: "+e.getMessage());
                }
                response.sendRedirect("UsuarioController");
                break;
                
            case "view":
                List<Usuario> lista = new ArrayList<Usuario>(); 
                try {
                    lista = modelo.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("usuarios", lista);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO modelo = new UsuarioDAOImplementacion();
        Usuario usuario = new Usuario();
        int id = Integer.parseInt(request.getParameter("id"));
        
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setCorreo(request.getParameter("correo"));
        usuario.setClave(request.getParameter("clave"));
        
        if (id == 0) {
            try {
                modelo.insert(usuario);
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
        } else {
            usuario.setId(id);
            try {
                modelo.update(usuario);
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
        }
        response.sendRedirect("UsuarioController");
    }

}
