
package Controlador;

import Logica.UsuarioManager;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "EditarUsuario", urlPatterns = {"/EditarUsuario"})
public class EditarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int valorSubmit = Integer.parseInt(request.getParameter("submitUsuario"));
            if (valorSubmit == 2) {
                int id = Integer.parseInt(request.getParameter("id"));

                String nombre = request.getParameter("nombre");
                String app = request.getParameter("apPaterno");

                String apm = request.getParameter("apMaterno");

                String correo = request.getParameter("correo");

                String password = request.getParameter("password");
                String passwordConfirmar = request.getParameter("passwordConfirmar");
                if (password.equals(passwordConfirmar)) {

                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(id);
                    usuario.setNombre(nombre);
                    usuario.setApPaterno(app);
                    usuario.setApMaterno(apm);
                    usuario.setCorreo(correo);
                    usuario.setPassword(password);
                    UsuarioManager manager = new UsuarioManager();
                    int registro = manager.ActualizaUsuario(usuario);
                    if (registro == 1) {
                        UsuarioManager mn = new UsuarioManager();
                        List<Usuario> usuarios = mn.GetUsuarios();
                        request.setAttribute("listaUsuariosRender", usuarios);
                        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                    } else {
                        String error = "Error al generar el registro del  usuario";
                        request.setAttribute("error", error);

                        request.setAttribute("usuarioRender", usuario);
                        request.getRequestDispatcher("/Vistas/AccionesUsuario/EditarUsuario.jsp").forward(request, response);

                    }

                } else {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(id);
                    usuario.setNombre(nombre);
                    usuario.setApPaterno(app);
                    usuario.setApMaterno(apm);
                    usuario.setCorreo(correo);
                    usuario.setPassword(password);
                    String error = "Error  las contraseñas deben coincidir ";
                    request.setAttribute("error", error);
                    request.setAttribute("usuarioRender", usuario);
                    request.getRequestDispatcher("/Vistas/AccionesUsuario/EditarUsuario.jsp").forward(request, response);
                }
            } else {
                UsuarioManager mn3 = new UsuarioManager();
                List<Usuario> usuarios = mn3.GetUsuarios();
                request.setAttribute("listaUsuariosRender", usuarios);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
            }
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
