
package Controlador;

import Logica.DireccionesManager;
import Modelo.Direccion;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet(name = "ConsultaDireccionesUsuario", urlPatterns = {"/ConsultaDireccionesUsuario"})
public class ConsultaDireccionesUsuario extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            int idusuario=Integer.parseInt(request.getParameter("usuario"));
            DireccionesManager manager = new   DireccionesManager();
            List<Direccion> direcciones= manager.GetDireccionesUsuario(idusuario);

            request.setAttribute("usuario",idusuario);
            request.setAttribute("listaUsuarioDireccionRender",direcciones);
            request.getRequestDispatcher("/Vistas/Direcciones/DireccionesUsuario.jsp").forward(request, response);
        }
    }

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
