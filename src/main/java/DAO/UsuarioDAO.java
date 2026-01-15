
package DAO;

import Conexion.ConexionSQL;
import DTO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements CRUD<Usuario>{

    @Override
    public boolean registrar(Usuario u) {
        String sql = """
                    INSERT INTO Usuario (username, password, rol, estado)
                    VALUES (?, ?, ?, 'ACTIVO')
                     """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); 
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            con.setAutoCommit(false);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getRol());

            
            if(ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    u.setIdUsuario(rs.getInt(1));
                }
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en UsuarioDAO.registrar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al registrar el usuario en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = """
                    UPDATE Usuario
                    SET estado = 'INACTIVO'
                    WHERE idUsuario = ?
                     """;
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
            System.err.println("Error en UsuarioDAO.eliminar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el usuario de la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean modificar(Usuario u) {
        String sql = """
            UPDATE Usuario
            SET username = ?, rol = ?, estado = ?
            WHERE idUsuario = ?
             """;
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getRol());
            ps.setString(3, u.getEstado());
            ps.setInt(4, u.getIdUsuario());
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            System.err.println("Error en UsuarioDAO.modificar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al modificar el usuario en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public Usuario buscar(int id) {
        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";
        Usuario u = null;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsername(rs.getString("username"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado")); 
            }    
        } catch(Exception e) {
            System.err.println("Error en UsuarioDAO.buscar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar el usuario por ID en la base de datos.", e);
        }
        return u;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Usuario";
        
         try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsername(rs.getString("username"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));
                lista.add(u);
            }    
        } catch(Exception e) {
            System.err.println("Error en UsuarioDAO.listar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar los usuarios de la base de datos.", e);
        }
        return lista;
    }
    
    //METODO PARA PODER INICIAR SESIÓN
    public Usuario validarLogin(String username, String password) {

        String sql = """
            SELECT * FROM Usuario
            WHERE username = ?
              AND password = ?
              AND estado = 'ACTIVO'
        """;

        Usuario u = null;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsername(rs.getString("username"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));
            }

        } catch (Exception e) {
            System.err.println("Error en UsuarioDAO.validarLogin(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al validar el Login del usuario de la base de datos.", e);
        }

        return u;
    }

    // BUSCAR usuarios por username (para el buscador del JFrame)
    public List<Usuario> buscarPorUsername(String texto) {
        List<Usuario> lista = new ArrayList<>();

        String sql = """
        SELECT * FROM Usuario
        WHERE username LIKE ?
        """;

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsername(rs.getString("username"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));
                lista.add(u);
            }

        } catch (Exception e) {
            System.err.println("Error en UsuarioDAO.buscarPorUsername(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar usuarios.", e);
        }

        return lista;
    }

}
