
package DAO;

import Conexion.ConexionSQL;
import DTO.Estadia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EstadiaDAO implements CRUD<Estadia>{

    @Override
    public boolean registrar(Estadia e) {
         String sql = """
            INSERT INTO Estadia
            (idHuesped, idHabitacion,
             fechaHoraIngreso, fechaHoraSalidaProgramada,
             noches, precioPorNoche, total,
             cantidadPersonas, estado)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'ACTIVA')
        """;
         
        String sqlHabitacion = """
            UPDATE Habitacion
            SET estado = 'OCUPADA'
            WHERE idHabitacion = ?
                                """;
        Connection con = null;

        try {
            con = ConexionSQL.conectar();
            con.setAutoCommit(false);

            // Insertar estadía
            PreparedStatement psEstadia = con.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS
            );

            psEstadia.setInt(1, e.getIdHuesped());
            psEstadia.setInt(2, e.getIdHabitacion());
            psEstadia.setObject(3, e.getFechaHoraIngreso());
            psEstadia.setObject(4, e.getFechaHoraSalidaProgramada());
            psEstadia.setInt(5, e.getNoches());
            psEstadia.setDouble(6, e.getPrecioPorNoche());
            psEstadia.setDouble(7, e.getTotal());
            psEstadia.setInt(8, e.getCantidadPersonas());

            psEstadia.executeUpdate();

            // Obtener ID generado
            ResultSet rs = psEstadia.getGeneratedKeys();
            if (rs.next()) {
                e.setIdEstadia(rs.getInt(1));
            }

            // Ocupar habitación
            PreparedStatement psHabitacion = con.prepareStatement(sqlHabitacion);
            psHabitacion.setInt(1, e.getIdHabitacion());
            psHabitacion.executeUpdate();

            con.commit();
            return true;

        } catch (Exception ex) {
            try {
                if (con != null) con.rollback();
            } catch (SQLException ignored) {}
            ex.printStackTrace();
            return false;
        }
    
    }

    @Override
    public boolean eliminar(int id) {
        String sqlEstadia = """
            UPDATE Estadia
            SET estado = 'ANULADA'
            WHERE idEstadia = ?
              AND estado = 'ACTIVA'
        """;

        String sqlHabitacion = """
            UPDATE Habitacion
            SET estado = 'DISPONIBLE'
            WHERE idHabitacion = (
                SELECT idHabitacion
                FROM Estadia
                WHERE idEstadia = ?
            )
        """;

        Connection con = null;

        try {
            con = ConexionSQL.conectar();
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(sqlEstadia);
            ps1.setInt(1, id);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(sqlHabitacion);
            ps2.setInt(1, id);
            ps2.executeUpdate();

            con.commit();
            return true;

        } catch (Exception ex) {
            try {
                if (con != null) con.rollback();
            } catch (SQLException ignored) {}
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modificar(Estadia e) {
        String sql = """
            UPDATE Estadia
            SET noches = ?,
                precioPorNoche = ?,
                total = ?,
                cantidadPersonas = ?
            WHERE idEstadia = ?
              AND estado = 'ACTIVA'
        """;

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, e.getNoches());
            ps.setDouble(2, e.getPrecioPorNoche());
            ps.setDouble(3, e.getTotal());
            ps.setInt(4, e.getCantidadPersonas());
            ps.setInt(5, e.getIdEstadia());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
           System.err.println("Error en EstadiaDAO.modificar(): " + ex.getMessage());
            ex.printStackTrace();
            throw new RuntimeException("Error al modificar la estadia en la base de datos.", ex);
        }
    }

    @Override
    public Estadia buscar(int id) {
        String sql = "SELECT * FROM Estadia WHERE idEstadia = ?";
        Estadia estadia = null;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                estadia = new Estadia();
                estadia.setIdEstadia(rs.getInt("idEstadia"));
                estadia.setIdHuesped(rs.getInt("idHuesped"));
                estadia.setIdHabitacion(rs.getInt("idHabitacion"));
                estadia.setFechaHoraIngreso(rs.getObject("fechaHoraIngreso", LocalDateTime.class));
                estadia.setFechaHoraSalidaProgramada(rs.getObject("fechaHoraSalidaProgramada", LocalDateTime.class));
                estadia.setFechaHoraSalidaReal(rs.getObject("fechaHoraSalidaReal", LocalDateTime.class));
                estadia.setNoches(rs.getInt("noches"));
                estadia.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                estadia.setTotal(rs.getDouble("total"));
                estadia.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                estadia.setEstado(rs.getString("estado"));
            }    
        } catch(Exception e) {
            System.err.println("Error en EstadiaDAO.buscar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la estadía por ID en la base de datos.", e);
        }
        return estadia;
    }

    @Override
    public List<Estadia> listar() {
        List<Estadia> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Estadia";
        
         try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Estadia estadia = new Estadia();
                estadia.setIdEstadia(rs.getInt("idEstadia"));
                estadia.setIdHuesped(rs.getInt("idHuesped"));
                estadia.setIdHabitacion(rs.getInt("idHabitacion"));
                estadia.setFechaHoraIngreso(rs.getObject("fechaHoraIngreso", LocalDateTime.class));
                estadia.setFechaHoraSalidaProgramada(rs.getObject("fechaHoraSalidaProgramada", LocalDateTime.class));
                estadia.setFechaHoraSalidaReal(rs.getObject("fechaHoraSalidaReal", LocalDateTime.class));
                estadia.setNoches(rs.getInt("noches"));
                estadia.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                estadia.setTotal(rs.getDouble("total"));
                estadia.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                estadia.setEstado(rs.getString("estado"));
                lista.add(estadia);
            }    
        } catch(Exception e) {
            System.err.println("Error en EstadiaDAO.listar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar estadias de la base de datos.", e);
        }
        return lista;
    }
    
    //METODO PARA FINALIZAR LAS ESTADIAS
    public boolean finalizarEstadia(int idEstadia, int idHabitacion) {

        String sqlEstadia = """
        UPDATE Estadia
        SET fechaHoraSalidaReal = ?,
            estado = 'FINALIZADA'
        WHERE idEstadia = ?
          AND estado = 'ACTIVA'
    """;

        String sqlHabitacion = """
        UPDATE Habitacion
        SET estado = 'DISPONIBLE'
        WHERE idHabitacion = ?
    """;

        Connection con = null;

        try {
            con = ConexionSQL.conectar();
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(sqlEstadia);
            ps1.setObject(1, LocalDateTime.now());
            ps1.setInt(2, idEstadia);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(sqlHabitacion);
            ps2.setInt(1, idHabitacion);
            ps2.executeUpdate();

            con.commit();
            return true;

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ignored) {
            }
            e.printStackTrace();
            return false;
        }
    }

    //METODO PARA LISTAR SÓLO LAS ESTADIAS QUE ESTEN ACTIVAS
    public List<Estadia> listarEstadiasActivas() {
        List<Estadia> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Estadia WHERE estado = 'ACTIVA'";
        
         try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Estadia estadia = new Estadia();
                estadia.setIdEstadia(rs.getInt("idEstadia"));
                estadia.setIdHuesped(rs.getInt("idHuesped"));
                estadia.setIdHabitacion(rs.getInt("idHabitacion"));
                estadia.setFechaHoraIngreso(rs.getObject("fechaHoraIngreso", LocalDateTime.class));
                estadia.setFechaHoraSalidaProgramada(rs.getObject("fechaHoraSalidaProgramada", LocalDateTime.class));
                estadia.setNoches(rs.getInt("noches"));
                estadia.setTotal(rs.getDouble("total"));
                estadia.setEstado(rs.getString("estado"));
                lista.add(estadia);
            }    
        } catch(Exception e) {
            System.err.println("Error en EstadiaDAO.listarEstadiasActivas(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar las estadias activas de la base de datos.", e);
        }
        return lista;
    }
}
