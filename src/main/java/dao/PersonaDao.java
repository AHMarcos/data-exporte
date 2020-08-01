/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Persona;

/**
 *
 * @author marqu
 */
public class PersonaDao extends Conexion implements IPersona {

    @Override
    public void registrar(Persona persona) throws Exception {
        String sql = "insert into PERSONA (IDPER,NOMPER,APEPER,DNIPER) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, persona.getIDPER());
            ps.setString(2, persona.getNOMPER());
            ps.setString(3, persona.getAPEPER());
            ps.setString(4, persona.getDNIPER());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar" + e.getMessage());
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Persona persona) throws Exception {
        String sql = "update PERSONA set NOMPER=?,APEPER=?,DNIPER=? where IDPER=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER());
            ps.setString(2, persona.getAPEPER());
            ps.setString(3, persona.getIDPER());
            ps.setString(4, persona.getIDPER());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar" + e.getMessage());
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Persona persona) throws Exception {
        String sql = "delete from PERSONA where IDPER=?";
        try {
            this.conectar();
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, persona.getIDPER());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar" + e.getMessage());
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Persona> ListarPersona() throws Exception {
        List<Persona> listado;
        Persona persona;
        String sql = "select * from PERSONA";

        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                persona = new Persona();
                persona.setIDPER(rs.getString("IDPER"));
                persona.setNOMPER(rs.getString("NOMPER"));
                persona.setAPEPER(rs.getString("APEPER"));
                persona.setDNIPER(rs.getString("DNIPER"));
                listado.add(persona);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listado;
    }

}
