package Logica;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer ES 15
 */
public class UsuarioManager extends Conexion {

    public List<Usuario> GetUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
       
        try {
             Connection conexion = getConection();
            String query = "select * from usuario";
            PreparedStatement st = conexion.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApPaterno(rs.getString(3));
                usuario.setApMaterno(rs.getString(4));
                usuario.setCorreo(rs.getString(5));
                usuario.setPassword(rs.getString(6));
                usuarios.add(usuario);

            }
            System.out.println("Registros obtenidos correctamente");

            conexion.close();

        } catch (SQLException E) {
            System.out.println("Error________________:" + E.getMessage());
        
            return null;
        }
        return usuarios;

    }

    public Usuario GetUsuario(int idUsuario) {
        Usuario usuario = new Usuario();
        try {

            Connection con = getConection();
            String query = "select * from usuario where idUsuario=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApPaterno(rs.getString(3));
                usuario.setApMaterno(rs.getString(4));
                usuario.setCorreo(rs.getString(5));
                usuario.setPassword(rs.getString(6));

            }
            System.out.println("Registro obtenido correctamente");
            con.close();

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return null;
        }
        return usuario;

    }

    public int RegistraUsuario(Usuario u) {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "insert into usuario(Nombre,ApPaterno,ApMaterno,correo,password)" + "values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, u.getNombre());
            st.setString(2, u.getApPaterno());
            st.setString(3, u.getApMaterno());
            st.setString(4, u.getCorreo());
            st.setString(5, u.getPassword());
            // st.setInt(6, u.getIdcattipousuario());

            estatus = st.executeUpdate();
            System.out.println("Registrado correctamente");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }

    public int ActualizaUsuario(Usuario u) {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "update usuario set Nombre=?, ApPaterno=?,ApMaterno=?,correo=?,password=? where idUsuario=? ";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, u.getNombre());
            st.setString(2, u.getApPaterno());
            st.setString(3, u.getApMaterno());
            st.setString(4, u.getCorreo());
            st.setString(5, u.getPassword());
             st.setInt(6, u.getIdUsuario());
            //st.setInt(6, u.getIdcattipousuario());

            estatus = st.executeUpdate();
            System.out.println("Registrado correctamente");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }

    public int EliminaUsuario(int idUsuario) {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "delete from usuario  where idUsuario=? ";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, idUsuario);
            estatus = st.executeUpdate();

            System.out.println("Eliminado correctamente");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }

    public int LoginUsuario(String correo, String password){
        int estatus = 0;
        try {
           Connection c = getConection();
                String query = "select * from usuario where correo=? and password=?";
                PreparedStatement st = c.prepareStatement(query);
                
                st.setString(1, correo);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    estatus=1;
                }
                
                System.out.println("logeado correctamente");
                c.close();
      
                
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }
    
   
}
