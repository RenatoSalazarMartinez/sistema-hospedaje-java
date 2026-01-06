
package DAO;

import Conexion.ConexionSQL;
import DTO.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO implements CRUD<Pago>{

    @Override
    public boolean registrar(Pago p) {
        String sql = """
                     INSERT INTO Pago(idEstadia, monto, metodoPago, fechaPago, estado) 
                     VALUES (?, ?, ?, ?, 'PAGADO');
                     """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); 
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            con.setAutoCommit(false);
            ps.setInt(1, p.getIdEstadia());
            ps.setDouble(2, p.getMonto());
            ps.setString(3, p.getMetodoPago());
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));

            
            if(ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    p.setIdPago(rs.getInt(1));
                }
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en PagoDAO.registrar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al registrar el pago en la base de datos.", e);
        }
        return ok;
    }

    
    //ANULAR UN PAGO, YA QUE NUNCA SE BORRA UN PAGO EN SISTEMAS REALES
    @Override
    public boolean eliminar(int id) {
        String sql = """
                     UPDATE Pago
                     SET estado = 'ANULADO'
                     WHERE idPago = ?
                     AND estado = 'PAGADO'
                     """;
        boolean ok = false;
        
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en PagoDAO.eliminar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar(anular) el pago de la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean modificar(Pago p) {
        String sql = """
             UPDATE Pago 
             SET monto = ?, metodoPago = ?
             WHERE idPago = ? AND estado = 'PAGADO';
             """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setDouble(1, p.getMonto());
            ps.setString(2, p.getMetodoPago());
            ps.setInt(3, p.getIdPago());
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en PagoDAO.modificar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al modificar el pago en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public Pago buscar(int id) {
        String sql = "SELECT * FROM Pago WHERE idPago = ?";
        Pago pago = null;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setIdEstadia(rs.getInt("idEstadia"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setMetodoPago(rs.getString("metodoPago"));
                pago.setFechaPago(rs.getObject("fechaPago", LocalDateTime.class));
                pago.setEstado(rs.getString("estado"));
            }    
        } catch(Exception e) {
            System.err.println("Error en PagoDAO.buscar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar el pago por ID en la base de datos.", e);
        }
        return pago;
    }

    @Override
    public List<Pago> listar() {
        List<Pago> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Pago";
        
         try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setIdEstadia(rs.getInt("idEstadia"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setMetodoPago(rs.getString("metodoPago"));
                pago.setFechaPago(rs.getObject("fechaPago", LocalDateTime.class));
                pago.setEstado(rs.getString("estado"));
                lista.add(pago);
            }    
        } catch(Exception e) {
            System.err.println("Error en PagoDAO.listar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar los pagos de la base de datos.", e);
        }
        return lista;
    }
    
    //METODO PARA LISTAR PAGOS POR ESTADIA
    public List<Pago> listarPorEstadia(int idEstadia) {
        List<Pago> lista = new ArrayList<>();
        
        String sql = """
                     SELECT idPago, idEstadia, monto, metodoPago, fechaPago, estado 
                     FROM Pago
                     WHERE idEstadia = ? AND estado = 'PAGADO'
                     """;
        
         try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idEstadia);
             ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setIdEstadia(rs.getInt("idEstadia"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setMetodoPago(rs.getString("metodoPago"));
                pago.setFechaPago(rs.getObject("fechaPago", LocalDateTime.class));
                pago.setEstado(rs.getString("estado"));
                lista.add(pago);
            }    
        } catch(Exception e) {
            System.err.println("Error en PagoDAO.listarPorEstadia(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar los pagos por estadia de la base de datos.", e);
        }
        return lista;
    }
}
