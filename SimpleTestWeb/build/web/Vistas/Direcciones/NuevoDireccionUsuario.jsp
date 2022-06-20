
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Dirección</title>
    </head>
    <body>
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
         <% String path = request.getContextPath(); %>  
            <br/>
     
      
              <div class="row col-lg-12">
            <div class="container">
                <form method="post" action="<%= path %>/NuevaDireccionUsuario">
                <input style="Display:none;" type="text" name="usuario" value="<%=idusuario %>"/>

                    <br/>
                    <table class="table table-striped table-bordered dt-responsive nowrap" >

                        <thead>
                            <tr>
                                <th>Campo</th>
                                <th>Valor</th>
                            </tr>

                        </thead>

                        <tbody>
                            <tr>
                                <th>Calle</th>
                                <th><input type="text" name="calle"/></th>
                            </tr>
                            <tr>
                                <th>Colonia</th>
                                <th><input type="text" name="colonia"/></th>
                            </tr>
                            <tr>
                                <th>Codigo Postal</th>
                                <th><input type="text" name="cp"/></th>
                            </tr>
                            <tr>
                                <th>Numero</th>
                                <th><input type="text" name="numero"/></th>
                            </tr>
                             
                        </tbody>
 
                    </table

                    <div class="row col-md-12">
                        <div class="container">

                            <div class="col-md-3">

                                <button type="submit" class="btn btn-primary" aria-label="Left Align" value="1" name="submitDireccion">
                                    Regresar
                                </button>
                            </div>
                            <div class="col-md-3">

                                <input type="reset" class="btn btn-primary" value="Limpiar">

                            </div>
                            <div class="col-md-3">
                                <button type="submit" class="btn btn-primary" aria-label="Left Align" value="2" name="submitDireccion">
                                    Guardar
                                </button>
                            </div>
                        </div>
                    </div>
            </div>
    </body>
</html>
