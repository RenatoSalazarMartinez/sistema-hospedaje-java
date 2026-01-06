
package Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class FrmHabitaciones extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmHabitaciones.class.getName());

    
    public FrmHabitaciones() {
        configurarApariencia();
        initComponents();
        personalizarDiseno();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnNuevaHabitacion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Habitaciones");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestión de Habitaciones");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(164, 164, 164));
        jLabel7.setText("Administrar las habitaciones del hotel");

        btnNuevaHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevaHabitacion.setText("Nueva Habitación");
        btnNuevaHabitacion.addActionListener(this::btnNuevaHabitacionActionPerformed);

        tablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero", "Capacidad", "Estado", "Acciones"
            }
        ));
        jScrollPane2.setViewportView(tablaHabitaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevaHabitacion))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnNuevaHabitacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaHabitacionActionPerformed
        abrirDialogoNuevaHabitacion();
    }//GEN-LAST:event_btnNuevaHabitacionActionPerformed

    private void configurarApariencia() {
        try {
            FlatIntelliJLaf.setup();
            // Configuración de bordes redondeados globales
            UIManager.put("Button.arc", 12);
            UIManager.put("Component.arc", 12);
            UIManager.put("TextComponent.arc", 12);
            UIManager.put("ScrollBar.trackArc", 999);
            UIManager.put("ScrollBar.thumbArc", 999);
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void personalizarDiseno() {
        // 1. Fondo del panel principal
        jPanel1.setBackground(new Color(250, 251, 253));

        // 2. Títulos
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jLabel1.setForeground(new Color(30, 41, 59));

        jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel7.setForeground(new Color(100, 116, 139));

        // 3. Botón "Nueva Habitación"
        btnNuevaHabitacion.setBackground(new Color(37, 99, 235));
        btnNuevaHabitacion.setForeground(Color.WHITE);
        btnNuevaHabitacion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNuevaHabitacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // 4. Personalización de la Tabla
        tablaHabitaciones.setRowHeight(40);
        tablaHabitaciones.setShowHorizontalLines(true);
        tablaHabitaciones.setGridColor(new Color(241, 245, 249));
        tablaHabitaciones.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tablaHabitaciones.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tablaHabitaciones.getTableHeader().setBackground(Color.WHITE);
        tablaHabitaciones.getTableHeader().setForeground(new Color(71, 85, 105));
        tablaHabitaciones.setSelectionBackground(new Color(239, 246, 255));
        tablaHabitaciones.setSelectionForeground(new Color(37, 99, 235));
        
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        for (int i = 0; i < tablaHabitaciones.getColumnCount(); i++) {
            tablaHabitaciones.getColumnModel().getColumn(i).setCellRenderer(render);
        }

        // 5. ScrollPanes
        jScrollPane1.setBorder(null);
        jScrollPane2.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
    }

    private void abrirDialogoNuevaHabitacion() {
        JDialog dialog = new JDialog(this, "Registrar Habitación", true);
        dialog.setLayout(new BorderLayout());
        
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
        pnlForm.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 25));
        pnlForm.setBackground(Color.WHITE);

        JLabel lblTitulo = new JLabel("Nueva Habitación");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Subtítulo Gris 
        JLabel lblSubtitulo = new JLabel("Complete los datos para registrar una nueva unidad");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSubtitulo.setForeground(new Color(148, 163, 184));
        lblSubtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        pnlForm.add(lblTitulo);
        pnlForm.add(lblSubtitulo);
        pnlForm.add(Box.createVerticalStrut(20)); 
        
        // 1. Número de Habitación (JTextField)
        pnlForm.add(crearCampoEstilizado("Número de Habitación", "Ej: 101, 204..."));
        pnlForm.add(Box.createVerticalStrut(10)); 
        
        // 2. Capacidad (JTextField)
        pnlForm.add(crearCampoEstilizado("Capacidad", "Número de personas"));
        pnlForm.add(Box.createVerticalStrut(12)); 
        
        // 3. Estado (JComboBox)
        pnlForm.add(crearSelectorEstilizado("Estado de Habitación", new String[]{"Disponible", "Ocupada", "Mantenimiento", "Limpieza"}));
        
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBotones.setBackground(Color.WHITE);
        pnlBotones.setBorder(BorderFactory.createEmptyBorder(10, 15, 20, 25));
        
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnGuardar = new JButton("Guardar Habitación");
        btnGuardar.setBackground(new Color(37, 99, 235));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 13));

        btnCancelar.addActionListener(e -> dialog.dispose());
        btnGuardar.addActionListener(e -> {
            // Aquí iría la lógica de guardado
            dialog.dispose();
        });

        pnlBotones.add(btnCancelar);
        pnlBotones.add(btnGuardar);

        dialog.add(pnlForm, BorderLayout.CENTER);
        dialog.add(pnlBotones, BorderLayout.SOUTH);
        
        dialog.pack();
        dialog.setSize(420, 450); 
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private JPanel crearCampoEstilizado(String titulo, String placeholder) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setBackground(Color.WHITE);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbl.setForeground(new Color(71, 85, 105));

        JTextField txt = new JTextField();
        txt.setPreferredSize(new Dimension(300, 30)); 
        txt.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholder);

        p.add(lbl, BorderLayout.NORTH);
        p.add(txt, BorderLayout.CENTER);
        return p;
    }

    private JPanel crearSelectorEstilizado(String titulo, String[] opciones) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setBackground(Color.WHITE);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbl.setForeground(new Color(71, 85, 105));

        JComboBox<String> combo = new JComboBox<>(opciones);
        combo.setPreferredSize(new Dimension(300, 30));

        p.add(lbl, BorderLayout.NORTH);
        p.add(combo, BorderLayout.CENTER);
        return p;
    }
    
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FrmHabitaciones().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaHabitaciones;
    // End of variables declaration//GEN-END:variables
}
