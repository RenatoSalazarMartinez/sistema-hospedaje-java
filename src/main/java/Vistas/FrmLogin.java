
package Vistas;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class FrmLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmLogin.class.getName());

    
    public FrmLogin() {
        initComponents();
        configurarFlatLaf();
        personalizarComponentes();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconLogin.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("WELCOME HOME!");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Sistema de Hospedaje");

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Usuario");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtUsuario.addActionListener(this::txtUsuarioActionPerformed);

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Contraseña");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUsuario)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarse.setText("Regístrate");
        btnRegistrarse.addActionListener(this::btnRegistrarseActionPerformed);

        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(this::btnIniciarSesionActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("¿Olvidaste tu contraseña?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2))))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(266, 266, 266))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(57, 57, 57)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void configurarFlatLaf() {
        try {
            // Aplicar FlatLaf
            FlatIntelliJLaf.setup();
            
            txtUsuario.putClientProperty("JTextField.placeholderText", "Usuario");
            txtUsuario.putClientProperty("JTextField.iconTextGap", 13);
            txtContraseña.putClientProperty("JTextField.placeholderText", "Contraseña");
            txtContraseña.putClientProperty("JTextField.iconTextGap", 13);
            
            //Icono dentro de los campos
            // Iconos dentro del campo (FlatLaf)
            txtUsuario.putClientProperty(
                    "JTextField.leadingIcon",
                    loadIcon("/img/IconUsuario.png")
            );
            txtContraseña.putClientProperty(
                    "JTextField.leadingIcon",
                    loadIcon("/img/IconCandado.png")
            );
            
            // Personalizar colores globales
            UIManager.put("Button.arc", 26); // Bordes redondeados en botones
            UIManager.put("Component.arc", 8); // Bordes redondeados en componentes
            UIManager.put("TextComponent.arc", 8); // Bordes redondeados en campos de texto
            
            // Colores personalizados
            UIManager.put("Button.background", new Color(59, 130, 246)); // Blue-500
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.hoverBackground", new Color(37, 99, 235)); // Blue-600
            
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    private void personalizarComponentes() {
        // Fondo del panel principal con gradiente suave
        jPanel1.setBackground(new Color(248, 250, 252)); // slate-50
        
        // Panel contenedor de campos
        jPanel2.setBackground(Color.WHITE);
        jPanel2.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1), // border color
            BorderFactory.createEmptyBorder(20, 20, 20, 20) // padding
        ));
        
        // Estilos de las etiquetas
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jLabel2.setForeground(new Color(15, 23, 42)); // slate-900
        
        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jLabel3.setForeground(new Color(100, 116, 139)); // slate-500
        
        jLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel4.setForeground(new Color(51, 65, 85)); // slate-700
        
        jLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel5.setForeground(new Color(51, 65, 85)); // slate-700
        
        jLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jLabel6.setForeground(new Color(100, 116, 139)); // slate-500
        
        // Campos de texto
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsuario.setPreferredSize(new Dimension(361, 36));
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        txtContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtContraseña.setPreferredSize(new Dimension(361, 36));
        txtContraseña.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        // Botón Registrarse (outline)
        btnRegistrarse.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRegistrarse.setPreferredSize(new Dimension(130, 36));
        btnRegistrarse.setBackground(Color.WHITE);
        btnRegistrarse.setForeground(new Color(51, 65, 85));
        btnRegistrarse.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
        btnRegistrarse.setFocusPainted(false);
        
        // Botón Iniciar Sesión (primary)
        //btnIniciarSesion.putClientProperty("JButton.buttonType", "roundRect");
        btnIniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIniciarSesion.setPreferredSize(new Dimension(130, 36));
        btnIniciarSesion.setBackground(new Color(59, 130, 246)); // blue-500
        btnIniciarSesion.setForeground(Color.WHITE);
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.setFocusPainted(false);
        
        // Hover effects (opcional, requiere listeners)
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarSesion.setBackground(new Color(37, 99, 235)); // blue-600
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarSesion.setBackground(new Color(59, 130, 246)); // blue-500
            }
        });
        
        btnRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarse.setBackground(new Color(248, 250, 252)); // slate-50
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarse.setBackground(Color.WHITE);
            }
        });
    }
    
    private javax.swing.Icon loadIcon(String path) {
        return new javax.swing.ImageIcon(getClass().getResource(path));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Configurar FlatLaf ANTES de crear la ventana
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> new FrmLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
