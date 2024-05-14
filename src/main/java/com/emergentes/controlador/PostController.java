/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.PostDAO;
import com.emergentes.dao.PostDAOImpl;
import com.emergentes.modelo.Post;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhomara
 */
public class PostController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Post pos = new Post();
            PostDAO dao = new PostDAOImpl();
            int id;
            
            String accion = (request.getParameter("action") != null)? request.getParameter("action"): "view";
            switch(accion){
                case "add":
                    request.setAttribute("post", pos);
                    request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                    break;
                case "edit":
                    // aviso controller action = edit &id + 3
                    id = Integer.parseInt(request.getParameter("id"));
                    try {
                        // obtener el objecto  que corresponde al registro
                        pos = dao.getById(id);
                    } catch (Exception ex) {
                        System.out.println("Error al obtener el registro " + ex.getMessage());
                    }
                    request.setAttribute("post", pos);
                    request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                    
                    break;
                    
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    try {
                        dao.delete(id);
                    } catch (Exception ex) {
                        System.out.println("Error al eliminar el registro " + ex.getMessage());
                    }
                    response.sendRedirect("PostController");
                    break;
                    
                case "view":
                    
                    List<Post> lista = new ArrayList<Post>();
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al listar " + ex.getMessage());
                    }
                    request.setAttribute("posts", lista);
                    request.getRequestDispatcher("posts.jsp").forward(request, response);
                    
                    break;
                    
                default:
                    break;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al operar: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String fecha =request.getParameter("fecha");
            String titulo =request.getParameter("titulo");
            String contenido =request.getParameter("contenido");
            
            Post ps = new Post();
            ps.setId(id);
            ps.setFecha(fecha);
            ps.setTitulo(titulo);
            ps.setContenido(contenido);
            
            PostDAO dao = new PostDAOImpl();
            if(id == 0){
                try {
                    // nuevo
                    dao.insert(ps);
                } catch (Exception ex) {
                    System.out.println("Error al insertar el registro " + ex.getMessage());
                }
                
            }else{
                try {
                    //edit
                    dao.update(ps);
                } catch (Exception ex) {
                    System.out.println("Error al actualizar el registro " + ex.getMessage());
                }
            }
            
            response.sendRedirect("PostController");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
