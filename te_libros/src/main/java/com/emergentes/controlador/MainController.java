package com.emergentes.controlador;

import com.emergentes.modelo.Libro;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = request.getParameter("op") != null ? request.getParameter("op") : "list";
            ArrayList<Libro> lista = new ArrayList<Libro>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("list")) {
                String sql = "SELECT * FROM libros";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Libro libro = new Libro();
                    libro.setId(rs.getInt("id"));
                    libro.setIsbn(rs.getString("isbn"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setCategoria(rs.getString("categoria"));
                    lista.add(libro);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            if (op.equals("nuevo")) {
                Libro libro = new Libro();
                request.setAttribute("libro", libro);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            }
            
            if (op.equals("editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Libro libro = new Libro();
                String sql = "SELECT * FROM libros WHERE id=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while(rs.next()) {
                    libro.setId(rs.getInt("id"));
                    libro.setIsbn(rs.getString("isbn"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setCategoria(rs.getString("categoria"));
                }
                request.setAttribute("libro", libro);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            }
            
            if (op.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "DELETE FROM libros WHERE id=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("MainController");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar: "+e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Libro libro = new Libro();
            libro.setId(id);
            libro.setIsbn(request.getParameter("isbn"));
            libro.setTitulo(request.getParameter("titulo"));
            libro.setCategoria(request.getParameter("categoria"));
            
            ConexionDB modelo = new ConexionDB();
            Connection conn = modelo.conectar();
            PreparedStatement ps;
            ResultSet rs;
            
            if (id == 0) {
                String sql = "INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, libro.getIsbn());
                ps.setString(2, libro.getTitulo());
                ps.setString(3, libro.getCategoria());
                ps.executeUpdate();
            } else {
                String sql = "UPDATE libros SET isbn=?, titulo=?, categoria=? WHERE id=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, libro.getIsbn());
                ps.setString(2, libro.getTitulo());
                ps.setString(3, libro.getCategoria());
                ps.setInt(4, libro.getId());
                ps.executeUpdate();
            }
            response.sendRedirect("MainController");
        } catch (SQLException e) {
            System.out.println("Error en SQL: "+e.getMessage());
        }
    }

}
