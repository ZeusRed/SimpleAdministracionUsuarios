<%@page import="java.util.List" %>

<%@page import="Logica.SessionLogic" %> 
<%@page import="Modelo.Usuario" %>
<%@page import="Logica.UsuarioManager" %>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>Login</title>

   
    </head>


    <body>
        
        <br/>
              <%
                   LocalDate date = LocalDate.now();

                    Cookie c = new Cookie("fecha", date.toString());
                    c.setMaxAge(360);
                                  

                    response.addCookie(c);
                  ////-------
   SessionLogic sl= new SessionLogic();
    sl=(SessionLogic) request.getSession().getAttribute("sessionUsuario");
        if(sl!=null){
       
              request.getRequestDispatcher("Login").forward(request, response);
     }
  
                %>
        <div class="row col-lg-12">
              
                <div class="container">
                    
             
                <form method="post" action="Login" >
                    <input type="email" name="correo"  />
                    <input type="password" name="password"/>
                    <input class="btn btn-primary" type="submit"  value="Entrar"  />

                </form> 
            </div>
          </div>
        <div class="row col-lg-12">
            <div class="container">

                <%
     String error="";
     error=(String)request.getAttribute("error");
     if(error==null)
     error="";
                %>
                <p style="color:red"><%=error%></p>
            </div>
        </div>
    </body>

  
</html>

</body>
</html>
