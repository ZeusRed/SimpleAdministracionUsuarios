/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.7
 * Generated at: 2022-06-07 21:42:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Vistas.AccionesUsuario;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import Controlador.ConsultaCatalogoTipoUsuarios;
import Modelo.Usuario;

public final class EditarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("Controlador.ConsultaCatalogoTipoUsuarios");
    _jspx_imports_classes.add("Modelo.Usuario");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"//cdn.datatables.net/1.10.11/css/jquery.dataTables.css\">\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf8\" src=\"//cdn.datatables.net/1.10.11/js/jquery.dataTables.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          <br/>\n");
      out.write("        <br/>\n");
      out.write("        <div class=\"row col-lg-12\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                ");

     String error="";
     error=(String)request.getAttribute("error");
     if(error==null)
     error="";
                
      out.write("\n");
      out.write("                <h4 style=\"color:red\">");
      out.print(error);
      out.write("</h4>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
 Usuario u=(Usuario)request.getAttribute("usuarioRender");
        String uus="";
        
      out.write("\n");
      out.write("        ");
 String path = request.getContextPath(); 
      out.write("\n");
      out.write("        <div class=\"row col-lg-12\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <form method=\"post\" action=\"");
      out.print( path );
      out.write("/EditarUsuario\">\n");
      out.write("                    <table class=\"table table-striped table-bordered dt-responsive nowrap\" >\n");
      out.write("\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Campo</th>\n");
      out.write("                                <th>Valor</th>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                        </thead>\n");
      out.write("\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Id</th>\n");
      out.write("                                <th><input type=\"text\" readonly=\"true\" name=\"id\" value=\"");
      out.print( u.getIdUsuario());
      out.write("\" /></th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Nombre</th>\n");
      out.write("                                <th><input type=\"text\" name=\"nombre\" value=\"");
      out.print( u.getNombre());
      out.write("\" /></th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Apellido Paterno</th>\n");
      out.write("                                <th><input type=\"text\" name=\"apPaterno\" value=\"");
      out.print( u.getApPaterno());
      out.write("\"/></th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Apellido Materno</th>\n");
      out.write("                                <th><input type=\"text\" name=\"apMaterno\" value=\"");
      out.print( u.getApMaterno());
      out.write("\"/></th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Correo</th>\n");
      out.write("                                <th><input type=\"email\" name=\"correo\" value=\"");
      out.print( u.getCorreo());
      out.write("\"/></th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Contraseña</th>\n");
      out.write("                                <th><input type=\"password\" name=\"password\" value=\"");
      out.print( u.getPassword());
      out.write("\"/></th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Confirmar Contraseña</th>\n");
      out.write("                                <th><input type=\"password\" name=\"passwordConfirmar\" value=\"");
      out.print( u.getPassword());
      out.write("\"/></th>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write(" \n");
      out.write("                    </table\n");
      out.write(" \n");
      out.write("                    <br/>\n");
      out.write("                    <br/>\n");
      out.write("                    <br/>\n");
      out.write("                    <br/>\n");
      out.write("\n");
      out.write("                    <div class=\"row col-md-12\">\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\" aria-label=\"Left Align\" value=\"1\" name=\"submitUsuario\">\n");
      out.write("                                Regresar\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\" aria-label=\"Left Align\" value=\"2\" name=\"submitUsuario\">\n");
      out.write("                                Actualizar\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
