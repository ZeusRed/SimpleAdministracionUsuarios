
<%@page import="java.util.List" %>
<%@page import="Modelo.Direccion" %>
<%@page import="Logica.DireccionesManager" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Direcciones</title>
    </head>
    <body>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
        <% String path = request.getContextPath(); %>

        <div class="row col-lg-12">
            <div class="container">

                <%
     String error="";
     error=(String)request.getAttribute("error");
     if(error==null)
     error="";
     
int idusuario=(int) request.getAttribute("usuario");
                %>
                <h4 style="color:red"><%=error%></h4>
            </div>
        </div>
        <br/>
        <div class="row col-lg-12">
            <div class="container">
                <form method="post" action="<%= path %>/NuevaDireccionUsuarioSet">
                    <input style="Display:none;" type="text" name="usuario" value="<%=idusuario %>"/>
                    <button type="submit" class="btn btn-primary" aria-label="Left Align"  >
                        Nuevo
                    </button> 
                </form>
            </div>
        </div>
        <br/>

        <div class="row col-lg-12">
            <div class="container">
                <table class="table table-striped table-bordered dt-responsive nowrap" >

                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Calle</th>
                            <th>Colonia</th>
                            <th>Numero</th>

                            <th>Opciones</th>
                        </tr>

                    </thead>
                    <tbody>
                        <% 
              List<Direccion> direcciones=(List<Direccion>) request.getAttribute("listaUsuarioDireccionRender");
                          for(Direccion u: direcciones){
                        %>

                        <tr>
                            <td> <%= u.getIdDireccion()%> </td>
                            <td> <%= u.getCalle()%> </td>
                            <td> <%= u.getColonia()%> </td>
                            <td> <%= u.getNumero()%> </td>
                            <td>

                                <form method="post" action="<%= path %>/EliminarDireccion">
                                    <button type="submit" class="btn btn-default" aria-label="Left Align" value="<%=u.getIdDireccion()%>" name="direccion" >
                                        Eliminar
                                    </button> 
                                    <input style="Display:none;" type="text" name="usuario" value="<%=idusuario %>"/>
                                </form>

                                <form method="post" action="<%= path %>/ConsultaDireccionesUsuarioEditar">
                                    <input style="Display:none;" type="text" name="usuario" value="<%=idusuario %>"/>

                                    <button type="submit" class="btn btn-default" aria-label="Left Align" value="<%=u.getIdDireccion()%>" name="direccion" >
                                        Editar
                                    </button> 
                                    <input style="Display:none;" type="text" name="usuario" value="<%=idusuario %>"/>
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
                        <br/>
        <form method="post" action="<%= path %>/EditarUsuario">
            <button type="submit" class="btn btn-default" aria-label="Left Align" value="1" name="submitUsuario" >
                Regresar
            </button>
        </form>
    </body>
</html>
