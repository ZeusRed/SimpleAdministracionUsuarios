/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.DireccionesManager;
import Logica.UsuarioManager;
import Modelo.Direccion;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Acer ES 15
 */
@WebServlet(name = "EliminarDireccion", urlPatterns = {"/EliminarDireccion"})
public class EliminarDireccion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int valorSubmit = Integer.parseInt(request.getParameter("direccion"));
       int idusuario = Integer.parseInt(request.getParameter("usuario"));
            DireccionesManager manager = new DireccionesManager();
            int estatus = manager.EliminarDireccion(valorSubmit);
             request.setAttribute("usuario",idusuario);
            if (estatus == 1) {


                List<Direccion> direcciones = manager.GetDireccionesUsuario(idusuario);

                request.setAttribute("listaUsuarioDireccionRender", direcciones);
                request.getRequestDispatcher("/Vistas/Direcciones/DireccionesUsuario.jsp").forward(request, response);
            } else {
                String error = "Error no se pudo eliminar el registro ";
                request.setAttribute("error", error);
               request.getRequestDispatcher("/Vistas/Direcciones/DireccionesUsuario.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
