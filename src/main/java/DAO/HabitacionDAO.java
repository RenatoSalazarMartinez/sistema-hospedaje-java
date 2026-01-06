
package DAO;

import Conexion.ConexionSQL;
import DTO.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAO implements CRUD<Habitacion>{

    @Override
    public boolean registrar(Habitacion h) {
        String sql = """
                     INSERT INTO Habitacion(numero, capacidad, estado)
                     VALUES (?, ?, ?);
                     """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); 
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            con.setAutoCommit(false);
            ps.setInt(1, h.getNumero());
            ps.setInt(2, h.getCapacidad());
            ps.setString(3, h.getEstado());

            
            if(ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    h.setIdHabitacion(rs.getInt(1));
                }
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en HabitacionDAO.registrar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al registrar la habitacion en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Habitacion WHERE idHabitacion = ?";
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
            System.err.println("Error en HabitacionDAO.eliminar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la habitacion de la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean modificar(Habitacion h) {
        String sql = """
             UPDATE Habitacion 
             SET numero = ?, capacidad = ?, estado = ?
             WHERE idHabitacion = ?;
             """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setInt(1, h.getNumero());
            ps.setInt(2, h.getCapacidad());
            ps.setString(3, h.getEstado());
            ps.setInt(4, h.getIdHabitacion());
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en HabitacionDAO.modificar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al modificar la habitacion en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public Habitacion buscar(int id) {
        String sql = "SELECT * FROM Habitacion WHERE idHabitacion = ?";
        Habitacion habitacion = null;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                habitacion = new Habitacion();
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNumero(rs.getInt("numero"));
                habitacion.setCapacidad(rs.getInt("capacidad"));
                habitacion.setEstado(rs.getString("estado"));   
            }    
        } catch(Exception e) {
            System.err.println("Error en HabitacionDAO.buscar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la habitacion por ID en la base de datos.", e);
        }
        return habitacion;
    }

    @Override
    public List<Habitacion> listar() {
        List<Habitacion> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Habitacion";
        
         try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Habitacion h = new Habitacion();
                h.setIdHabitacion(rs.getInt("idHabitacion"));
                h.setNumero(rs.getInt("numero"));
                h.setCapacidad(rs.getInt("capacidad"));
                h.setEstado(rs.getString("estado"));
                lista.add(h);
            }    
        } catch(Exception e) {
            System.err.println("Error en HabitacionDAO.listar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar habitaciones de la base de datos.", e);
        }
        return lista;
    }
    
    //METODO PARA LISTAR LAS HABITACIONES DISPONIBLES
    public List<Habitacion> listarDisponibles() {
        List<Habitacion> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Habitacion WHERE estado = 'DISPONIBLE'";
        
         try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Habitacion h = new Habitacion();
                h.setIdHabitacion(rs.getInt("idHabitacion"));
                h.setNumero(rs.getInt("numero"));
                h.setCapacidad(rs.getInt("capacidad"));
                h.setEstado(rs.getString("estado"));
                lista.add(h);
            }    
        } catch(Exception e) {
            System.err.println("Error en HabitacionDAO.listarDisponibles(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar habitaciones disponibles de la base de datos.", e);
        }
        return lista;
    }
    
    //METODO PARA ACTUALIZAR SOLO EL ESTADO DE LA HABITACION
    public boolean actualizarEstado(int idHabitacion, String estado) {
        String sql = """
             UPDATE Habitacion 
             SET estado = ?
             WHERE idHabitacion = ?;
             """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setString(1, estado);
            ps.setInt(2, idHabitacion);
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en HabitacionDAO.actualizarEstado(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el estado de la habitacion en la base de datos.", e);
        }
        return ok;
    }
    
    
}
