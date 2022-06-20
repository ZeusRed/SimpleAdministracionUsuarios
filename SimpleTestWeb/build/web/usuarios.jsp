 
<%@page import="java.util.List" %>
<%@page import="Modelo.Usuario" %>
<%@page import="Logica.UsuarioManager" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
        <title>Usuarios</title>
    </head>
    <body>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
        <br/>
     
        <div class="row col-lg-12">
            <div class="container">


                <% String path = request.getContextPath(); %>
     <form method="post" action="<%= path %>/NuevoUsuarioSet">
               <!-- <button type="button" class="btn btn-primary" aria-label="Left Align"
                        onclick="location.href = '../SimpleTestWeb/Vistas/AccionesUsuario/NuevoUsuario.jsp'">-->
               <button type="submit">
                    Nuevo
                </button>
     </form>
            </div>
        </div>
        <br/>
        <br/>
        <div class="row col-lg-12">
            <div class="container">

                <%
     String error="";
     error=(String)request.getAttribute("error");
     if(error==null)
     error="";
                %>
                <h4 style="color:red"><%=error%></h4>
            </div>
        </div>
        <br/>
        <br/>

        <div class="row col-lg-12">
            <div class="container">
                <table class="table table-striped table-bordered dt-responsive nowrap" >

                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Ap Paterno</th>
                            <th>Ap Materno</th>
                            <th>Correo</th>
                            <th>Opciones</th>
                        </tr>

                    </thead>
                    <tbody
                        <% 
              List<Usuario> usuarios=(List<Usuario>) request.getAttribute("listaUsuariosRender");
                          for(Usuario u: usuarios){
                        %>
                        <tr>
                    <td> <%= u.getIdUsuario()%> </td>
                    <td> <%= u.getNombre()%> </td>
                    <td> <%= u.getApPaterno()%> </td>
                    <td> <%= u.getApMaterno()%> </td>
                    <td> <%= u.getCorreo()%> </td>
                    <td>
                         <form method="post" action="<%= path %>/ConsultaDireccionesUsuario">
                            <button type="submit" class="btn btn-default" aria-label="Left Align" value="<%=u.getIdUsuario()%>" name="usuario" >
                                 Direcciones
                            </button>
                        </form>
                        <form method="post" action="<%= path %>/ConsultaUsuarioEditar">
                            <button type="submit" class="btn btn-default" aria-label="Left Align" value="<%=u.getIdUsuario()%>" name="editar">
                             Editar
                            </button>  
                        </form>    
                        <form method="post" action="<%= path %>/EliminarUsuario">
                            <button type="submit" class="btn btn-default" aria-label="Left Align" value="<%=u.getIdUsuario()%>" name="eliminar" >
                                 Eliminar
                            </button>
                        </form>
                    </td>

                    <% 
                        }
                    %>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
                  
    </body>
</html>
