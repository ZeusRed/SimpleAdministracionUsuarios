package Controlador;

import Logica.SessionLogic;
import Logica.UsuarioManager;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String correo = request.getParameter("correo");
            String password = request.getParameter("password");

            int login = 0;
            UsuarioManager manager = new UsuarioManager();
            SessionLogic sl0 = new SessionLogic();
            sl0 = (SessionLogic) request.getSession().getAttribute("sessionUsuario");
            if (sl0 != null) {
                login = 1;
            } else {
                login = manager.LoginUsuario(correo, password);
            }

            if (login == 1) {
                //crear cockie 
              
                       Cookie[] cks = request.getCookies();
                       Optional<String> ck=leerCookie("fecha", cks);
                     
              
                //Crea objeto de session
                SessionLogic sl = new SessionLogic();
                sl.setCorreo(correo);
                sl.setPassword(password);
                sl.setTiempoInactivoPermitido(1000);
                int tiempoPermitido = sl.getTiempoInactivoPermitido();
                HttpSession session = request.getSession();

                session.setMaxInactiveInterval(tiempoPermitido);

                session.setAttribute("sessionUsuario", sl);
                
                //response.sendRedirect(request.getContextPath() + "/Vistas/CatalogoUsuarios.jsp");
                UsuarioManager mn = new UsuarioManager();
                List<Usuario> usuarios = mn.GetUsuarios();

                request.setAttribute("listaUsuariosRender", usuarios);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);

            } else {
                String error = "Contraseña incorrecta, intentalo de nuevo";
                request.setAttribute("error", error);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
        }
    }

    public Optional<String> leerCookie(String key, Cookie[] cockies) {
        return Arrays.stream(cockies)
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
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
