package com.emergentes.practica02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerificarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = "Bienvenido a nuestro sitio Web";
        boolean paginaVisitada = false;
        Cookie cukis[] = request.getCookies();
        if (cukis != null) {
            for (Cookie c : cukis) {
                if (c.getName().equals("practica02")) {
                    titulo = "Gracias por visitarnos nuevamente";
                    paginaVisitada = true;
                }
            }
        }
        
        if (!paginaVisitada) {
            Cookie c = new Cookie("practica02", "1");
            c.setMaxAge(3600);
            response.addCookie(c);
        }
        
        request.setAttribute("titulo", titulo);
        request.getRequestDispatcher("index.jsp").forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
