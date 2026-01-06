
package DTO;


public class Usuario {
    private int idUsuario;
    private String username, password, rol, estado;

    public Usuario() {
    }

    public Usuario(String username, String password, String rol, String estado) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }
    
    public Usuario(int idUsuario, String username, String password, String rol, String estado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
