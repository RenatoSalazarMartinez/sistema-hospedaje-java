
package Controladores;

import DAO.UsuarioDAO;
import DTO.Usuario;
import java.util.List;

public class ControladorUsuario {
    private UsuarioDAO usuarioDAO;
    
    public ControladorUsuario(){
        this.usuarioDAO = new UsuarioDAO();
    }
    
     // REGISTRAR un nuevo usuario
    public boolean crearUsuario(Usuario u) {
        if(u.getUsername() == null || u.getUsername().isEmpty()) {
            throw new IllegalArgumentException("El username es obligatorio.");
        }
        if(u.getPassword() == null || u.getPassword().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria.");
        }
        if(u.getRol() == null || u.getRol().isEmpty()) {
            throw new IllegalArgumentException("El rol es obligatorio.");
        }

        return usuarioDAO.registrar(u);
    }

    // MODIFICAR usuario
    public boolean modificarUsuario(Usuario u) {
        if(u.getIdUsuario() <= 0) {
            throw new IllegalArgumentException("ID de usuario inválido.");
        }
        return usuarioDAO.modificar(u);
    }

    // ELIMINAR (desactivar) usuario
    public boolean eliminarUsuario(int idUsuario) {
        if(idUsuario <= 0) {
            throw new IllegalArgumentException("ID de usuario inválido.");
        }
        return usuarioDAO.eliminar(idUsuario);
    }

    // BUSCAR usuario por ID
    public Usuario buscarUsuario(int idUsuario) {
        if(idUsuario <= 0) {
            throw new IllegalArgumentException("ID de usuario inválido.");
        }
        return usuarioDAO.buscar(idUsuario);
    }

    // LISTAR todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar();
    }
    
    public List<Usuario> buscarUsuarios(String texto) {
        if (texto == null || texto.isEmpty()) {
            return usuarioDAO.listar();
        }
        return usuarioDAO.buscarPorUsername(texto);
    }


    // VALIDAR LOGIN
    public Usuario login(String username, String password) {
        if(username == null || username.isEmpty()) {
            throw new IllegalArgumentException("El username no puede estar vacío.");
        }
        if(password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }

        return usuarioDAO.validarLogin(username, password);
    }
}
