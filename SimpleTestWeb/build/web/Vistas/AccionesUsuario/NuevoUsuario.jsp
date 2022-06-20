 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         
        <title>Nuevo</title>
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
        <br/>
        <br/>
        <% String path = request.getContextPath(); %>
        <div class="row col-lg-12">
            <div class="container">
                <form method="post" action="<%= path %>/NuevoUsuario">
                    <br/>
                    <table class="table table-striped table-bordered dt-responsive nowrap" >

                        <thead>
                            <tr>
                                <th>Campo</th>
                                <th>Valor</th>
                            </tr> <form method="post" action="<%= path %>/NuevoUsuario">

                        </thead>

                        <tbody>
                            <tr>
                                <th>Nombre</th>
                                <th><input type="text" name="nombre"/></th>
                            </tr>
                            <tr>
                                <th>Apellido Paterno</th>
                                <th><input type="text" name="apPaterno"/></th>
                            </tr>
                            <tr>
                                <th>Apellido Materno</th>
                                <th><input type="text" name="apMaterno"/></th>
                            </tr>
                            <tr>
                                <th>Correo</th>
                                <th><input type="email" name="correo"/></th>
                            </tr>
                            <tr>
                                <th>Contraseña</th>
                                <th><input type="password" name="password"/></th>
                            </tr>
                            <tr>
                                <th>Confirmar Contraseña</th>
                                <th><input type="password" name="passwordConfirmar"/></th>
                            </tr>
                        </tbody>
 
                    </table

                    <div class="row col-md-12">
                        <div class="container">

                            <div class="col-md-3">

                                <button type="submit" class="btn btn-primary" aria-label="Left Align" value="1" name="submitUsuario">
                                    Regresar
                                </button>
                            </div>
                            <div class="col-md-3">

                                <input type="reset" class="btn btn-primary" value="Limpiar">

                            </div>
                            <div class="col-md-3">
                                <button type="submit" class="btn btn-primary" aria-label="Left Align" value="2" name="submitUsuario">
                                    Guardar
                                </button>
                            </div>
                        </div>
                    </div>
            </div>

        </form>
    </div>
</body>
</html>
