<%@page import="Controlador.ConsultaUsuarioEditar" %>
<%@page import="Modelo.Usuario" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         
        <title>Editar</title>
    </head>
    <body>
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
        <% Usuario u=(Usuario)request.getAttribute("usuarioRender");
        String uus="";
        %>
        <% String path = request.getContextPath(); %>
        <div class="row col-lg-12">
            <div class="container">


                <form method="post" action="<%= path %>/EditarUsuario">
                    <table class="table table-striped table-bordered dt-responsive nowrap" >

                        <thead>
                            <tr>
                                <th>Campo</th>
                                <th>Valor</th>
                            </tr>

                        </thead>

                        <tbody>
                            <tr>
                                <th>Id</th>
                                <th><input type="text" readonly="true" name="id" value="<%= u.getIdUsuario()%>" /></th>
                            </tr>
                            <tr>
                                <th>Nombre</th>
                                <th><input type="text" name="nombre" value="<%= u.getNombre()%>" /></th>
                            </tr>
                            <tr>
                                <th>Apellido Paterno</th>
                                <th><input type="text" name="apPaterno" value="<%= u.getApPaterno()%>"/></th>
                            </tr>
                            <tr>
                                <th>Apellido Materno</th>
                                <th><input type="text" name="apMaterno" value="<%= u.getApMaterno()%>"/></th>
                            </tr>
                            <tr>
                                <th>Correo</th>
                                <th><input type="email" name="correo" value="<%= u.getCorreo()%>"/></th>
                            </tr>
                            <tr>
                                <th>Contraseña</th>
                                <th><input type="password" name="password" value="<%= u.getPassword()%>"/></th>
                            </tr>
                            <tr>
                                <th>Confirmar Contraseña</th>
                                <th><input type="password" name="passwordConfirmar" value="<%= u.getPassword()%>"/></th>
                            </tr>
                        </tbody>
 
                    </table
 
                    <br/>
                    <br/>
                    <br/>
                    <br/>

                    <div class="row col-md-12">
                        <div class="col-md-3">

                            <button type="submit" class="btn btn-primary" aria-label="Left Align" value="1" name="submitUsuario">
                                Regresar
                            </button>
                        </div>
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-primary" aria-label="Left Align" value="2" name="submitUsuario">
                                Actualizar
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>
