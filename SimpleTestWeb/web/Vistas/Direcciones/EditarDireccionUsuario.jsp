<%@page import="Controlador.ConsultaDireccionesUsuarioEditar" %>
<%@page import="Modelo.Direccion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Direccion</title>
    </head>
    <body>
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
                <% Direccion u=(Direccion)request.getAttribute("direccionRender");
        String uus="";
        int idusuario=(int) request.getAttribute("usuario");
        %>
        <% String path = request.getContextPath(); %>
        <div class="row col-lg-12">
            <div class="container">


                <form method="post" action="<%= path %>/EditarDireccion">
                        <input style="Display:none;" type="text" name="usuario" value="<%=idusuario %>"/>
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
                                <th><input type="text" readonly="true" name="id" value="<%= u.getIdDireccion()%>" /></th>
                            </tr>
                            
                            <tr>
                                <th>calle</th>
                                <th><input type="text" name="calle" value="<%= u.getCalle()%>" /></th>
                            </tr>
                            
                            <tr>
                                <th>colonia</th>
                                <th><input type="text" name="colonia" value="<%= u.getColonia()%>"/></th>
                            </tr>
                            
                            <tr>
                                <th>Codigo Postal</th>
                                <th><input type="text" name="cp" value="<%= u.getCodigoPostal()%>"/></th>
                            </tr>
                            
                            
                            <tr>
                                <th>Numero</th>
                                <th><input type="text" name="numero" value="<%= u.getNumero()%>"/></th>
                            </tr>
                         
                        </tbody>
 
                    </table
 
                    <br/>
                    <br/>
                    <br/>
                    <br/>

                    <div class="row col-md-12">
                        <div class="col-md-3">

                            <button type="submit" class="btn btn-primary" aria-label="Left Align" value="1" name="submitDireccion">
                                Regresar
                            </button>
                        </div>
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-primary" aria-label="Left Align" value="2" name="submitDireccion">
                                Actualizar
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>
