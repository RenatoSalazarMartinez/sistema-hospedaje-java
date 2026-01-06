
package DAO;

import Conexion.ConexionSQL;
import DTO.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class HuespedDAO implements CRUD<Huesped>{

    @Override
    public boolean registrar(Huesped h) {
        String sql = """
                    INSERT INTO Huesped (dni, nombres, telefono)
                    VALUES (?, ?, ?)
                     """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); 
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            con.setAutoCommit(false);
            ps.setString(1, h.getDni());
            ps.setString(2, h.getNombres());
            ps.setString(3, h.getTelefono());

            
            if(ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    h.setIdHuesped(rs.getInt(1));
                }
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en HuespedDAO.registrar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al registrar el huesped en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Huesped WHERE idHuesped = ?";
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            System.err.println("Error en HuespedDAO.eliminar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el huesped de la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean modificar(Huesped h) {
        String sql = """
            UPDATE Huesped
            SET dni = ?, nombres = ?, telefono = ?
            WHERE idHuesped = ?
             """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setString(1, h.getDni());
            ps.setString(2, h.getNombres());
            ps.setString(3, h.getTelefono());
            ps.setInt(4, h.getIdHuesped());
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en HuespedDAO.modificar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al modificar el huesped en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public Huesped buscar(int id) {
        String sql = "SELECT * FROM Huesped WHERE idHuesped = ?";
        Huesped huesped = null;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setDni(rs.getString("dni"));
                huesped.setNombres(rs.getString("nombres"));
                huesped.setTelefono(rs.getString("telefono"));   
            }    
        } catch(Exception e) {
            System.err.println("Error en HuespedDAO.buscar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar el huesped por ID en la base de datos.", e);
        }
        return huesped;
    }

    @Override
    public List<Huesped> listar() {
        List<Huesped> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Huesped";
        
         try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Huesped huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setDni(rs.getString("dni"));
                huesped.setNombres(rs.getString("nombres"));
                huesped.setTelefono(rs.getString("telefono"));
                lista.add(huesped);
            }    
        } catch(Exception e) {
            System.err.println("Error en HuespedDAO.listar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar los huespedes de la base de datos.", e);
        }
        return lista;
    }
    
    //METODO PARA BUSCAR HUESPEDES POR SU DNI
    public Huesped buscarPorDni(String dni) {

        String sql = "SELECT * FROM Huesped WHERE dni = ?";
        Huesped h = null;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                h = new Huesped();
                h.setIdHuesped(rs.getInt("idHuesped"));
                h.setDni(rs.getString("dni"));
                h.setNombres(rs.getString("nombres"));
                h.setTelefono(rs.getString("telefono"));
            }

        } catch (Exception e) {
            System.err.println("Error en HuespedDAO.buscarPorDni(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar huésped por DNI.", e);
        }

        return h;
    }
}
