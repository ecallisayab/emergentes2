package com.emergentes.controlador;

import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("listaProductos") == null) {
            ArrayList<Producto> listaux = new ArrayList<Producto>();
            sesion.setAttribute("listaProductos", listaux);            
        }

        ArrayList<Producto> lista = (ArrayList<Producto>) sesion.getAttribute("listaProductos");
        
        String op = request.getParameter("op");
        String opcion = (op != null) ? op : "view";
        
        Producto prod = new Producto();
        int id, pos;
        switch (opcion) {   
             case "nuevo":
                request.setAttribute("miProducto", prod);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
             case "editar":
                 id= Integer.parseInt(request.getParameter("id"));
                 pos = buscarIndice(request,id);
                 prod = lista.get(pos);
                 request.setAttribute("miProducto", prod);
                 request.getRequestDispatcher("editar.jsp").forward(request, response);
                 break;
                 
             case "eliminar":
                id= Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                lista.remove(pos);
                sesion.setAttribute("listaProductos", lista);
                response.sendRedirect("index.jsp");
                break;
                 
            case "view":
                response.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        ArrayList<Producto> Lista = (ArrayList<Producto>) sesion.getAttribute("listaProductos");
        Producto prod = new Producto();
        prod.setId(Integer.parseInt(request.getParameter("id")));
        prod.setDescripcion(request.getParameter("descripcion"));
        prod.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        prod.setPrecio(Float.parseFloat(request.getParameter("precio")));
        prod.setCategoria(request.getParameter("categoria"));
        int idt = prod.getId();
        if (idt == 0) {
            int ultID;
            ultID = ultimoId(request);
            prod.setId(ultID);
            Lista.add(prod);
        } else {
            Lista.set(buscarIndice(request, idt), prod);
        }
        sesion.setAttribute("listaProductos", Lista);
        response.sendRedirect("index.jsp");
    }
    
    private int buscarIndice(HttpServletRequest request, int id) {
        HttpSession session = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>) session.getAttribute("listaProductos");
        int  i = 0;
        if (lista.size() > 0) {
            while (i<lista.size()) {
                if (lista.get(i).getId() == id) {
                    break;
                } else {
                    i++;
                }
            }
        }
        return i;   
    }
    
    private int ultimoId(HttpServletRequest request) {
        HttpSession sesion = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>) sesion.getAttribute("listaProductos");
        int idaux = 0;
        for (Producto item: lista){
            idaux = item.getId();
        } 
        return idaux + 1;
    }

}
