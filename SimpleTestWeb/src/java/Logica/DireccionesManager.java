/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Direccion;
import Modelo.Usuario;
import Modelo.UsuarioDireccion;
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
public class DireccionesManager extends Conexion {

    public List<Direccion> GetDireccionesUsuario(int idUsuario) {
        List<Direccion> direcciones = new ArrayList<Direccion>();
        List<UsuarioDireccion> usuarioDirecciones = new ArrayList<UsuarioDireccion>();
        try {
            Connection conexion = getConection();

            String query0 = "select * from usuariodireccion where idusuario=?";

            //,PreparedStatement.RETURN_GENERATED_KEYS
            PreparedStatement st0 = conexion.prepareStatement(query0);
            st0.setInt(1, idUsuario);
            ResultSet rs0 = st0.executeQuery();
            while (rs0.next()) {

                UsuarioDireccion usuarioDireccion = new UsuarioDireccion();
                usuarioDireccion.setIdusuarioDireccion(rs0.getInt(1));
                usuarioDireccion.setIdDireccion(rs0.getInt(2));
                usuarioDireccion.setIdusuario(rs0.getInt(3));
                usuarioDirecciones.add(usuarioDireccion);

            }

            for (UsuarioDireccion item : usuarioDirecciones) {
                String query = "select * from direccion where idDireccion=?";

                PreparedStatement st = conexion.prepareStatement(query);
                st.setInt(1, item.getIdDireccion());

                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Direccion direccion = new Direccion();
                    direccion.setIdDireccion(rs.getInt(1));
                    direccion.setCalle(rs.getString(2));
                    direccion.setColonia(rs.getString(3));
                    direccion.setCodigoPostal(rs.getString(4));
                    direccion.setNumero(rs.getString(5));

                    direcciones.add(direccion);

                }
            }
            System.out.println("Registros obtenidos correctamente");

        } catch (SQLException E) {
            System.out.println("Error________________:" + E.getMessage());

            return null;
        }
        return direcciones;
    }

    public int EliminarDireccion(int idDireccion) {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query2 = "delete from usuariodireccion  where idDireccion=? ";
            PreparedStatement st2 = con.prepareStatement(query2);

            st2.setInt(1, idDireccion);
            estatus = st2.executeUpdate();
            System.out.println("Eliminado correctamente");

            String query = "delete from direccion  where idDireccion=? ";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, idDireccion);
            estatus = st.executeUpdate();

            System.out.println("Eliminado correctamente");

            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }

    public long NuevaDireccion(int idUsuario, Direccion u) {
        long estatus = 0;
        try {
            Connection con = getConection();
            String query = "insert into direccion(calle,colonia,codigopostal,numero)" + "values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, u.getCalle());
            st.setString(2, u.getColonia());
            st.setString(3, u.getCodigoPostal());
            st.setString(4, u.getNumero());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                estatus = rs.getLong(1);
                String query2 = "insert into usuariodireccion(idDireccion,idusuario)" + "values(?,?)";
                PreparedStatement st2 = con.prepareStatement(query2, PreparedStatement.RETURN_GENERATED_KEYS);

                st2.setLong(1, estatus);
                st2.setInt(2, idUsuario);
                st2.executeUpdate();
                ResultSet rs2 = st2.getGeneratedKeys();
                if (rs2.next()) {
                    estatus = rs2.getLong(1);
                }

            }
            System.out.println("Registrado correctamente");

            return 1;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }

    public Direccion GetDireccion(int idDireccion) {
        Direccion direccion = new Direccion();
        try {

            Connection con = getConection();
            String query = "select * from direccion where idDireccion=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, idDireccion);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                direccion.setIdDireccion(rs.getInt(1));
                direccion.setCalle(rs.getString(2));
                direccion.setColonia(rs.getString(3));
                direccion.setCodigoPostal(rs.getString(4));
                direccion.setNumero(rs.getString(5));

            }
            System.out.println("Registro obtenido correctamente");

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return null;
        }
        return direccion;
    }

    public int ActualizaDireccion(Direccion u) {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "update direccion set calle=?, colonia=?,codigopostal=?,numero=? where idDireccion=? ";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, u.getCalle());
            st.setString(2, u.getColonia());
            st.setString(3, u.getCodigoPostal());
            st.setString(4, u.getNumero());
            st.setInt(5, u.getIdDireccion());

            estatus = st.executeUpdate();
            System.out.println("Registrado correctamente");
           
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }
}
