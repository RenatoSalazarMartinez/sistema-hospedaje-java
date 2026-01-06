
package Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
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


public class FrmEstadias extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmEstadias.class.getName());

    
    public FrmEstadias() {
        configurarApariencia();
        initComponents();
        inyectarMonitorCuadricula();
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
        tablaEstadias = new javax.swing.JTable();
        panelGraficos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Estadías");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestión de Estadías");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(164, 164, 164));
        jLabel7.setText("Administrar las estadías del hospedaje");

        btnNuevaHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevaHabitacion.setText("Nueva Estadía");
        btnNuevaHabitacion.addActionListener(this::btnNuevaHabitacionActionPerformed);

        tablaEstadias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Huésped", "Habitación", "Ingreso", "Salida Programada", "Noches", "Precio por noche", "Total", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tablaEstadias);

        javax.swing.GroupLayout panelGraficosLayout = new javax.swing.GroupLayout(panelGraficos);
        panelGraficos.setLayout(panelGraficosLayout);
        panelGraficosLayout.setHorizontalGroup(
            panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        panelGraficosLayout.setVerticalGroup(
            panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevaHabitacion))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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
        abrirDialogoNuevaEstadia();
    }//GEN-LAST:event_btnNuevaHabitacionActionPerformed

    private void inyectarMonitorCuadricula() {
        // Rediseño a Cuadrícula de 3 filas x 6 columnas para las 18 habitaciones
        // Esto hace que el panel sea más ancho y menos alto, optimizando el espacio.
        JPanel panelCuadricula = new JPanel(new GridLayout(3, 6, 12, 12));
        panelCuadricula.setBackground(new Color(250, 251, 253));
        panelCuadricula.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 18; i++) {
            int numHab = 101 + i;
            // Simulamos estados para la demostración visual
            String estado = (i % 3 == 0) ? "DISPONIBLE" : (i % 3 == 1) ? "OCUPADA" : "LIMPIEZA";
            panelCuadricula.add(new TarjetaHabitacion(numHab, estado));
        }
        
        // Reemplazar el panel anterior por la nueva cuadrícula
        javax.swing.GroupLayout layout = (javax.swing.GroupLayout) jPanel1.getLayout();
        layout.replace(panelGraficos, panelCuadricula);
        panelGraficos = panelCuadricula;
        
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private void configurarApariencia() {
        try {
            FlatIntelliJLaf.setup();
            UIManager.put("Button.arc", 12);
            UIManager.put("Component.arc", 12);
            UIManager.put("TextComponent.arc", 12);
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void personalizarDiseno() {
        jPanel1.setBackground(new Color(250, 251, 253));
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jLabel1.setForeground(new Color(30, 41, 59));
        jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel7.setForeground(new Color(100, 116, 139));

        btnNuevaHabitacion.setBackground(new Color(37, 99, 235));
        btnNuevaHabitacion.setForeground(Color.WHITE);
        btnNuevaHabitacion.setFont(new Font("Segoe UI", Font.BOLD, 14));

        tablaEstadias.setRowHeight(35);
        jScrollPane2.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));
        jScrollPane1.setBorder(null);
    }

    // COMPONENTE DE TARJETA INDIVIDUAL 
    private class TarjetaHabitacion extends JPanel {
        private final int numero;
        private final String estado;
        private Color colorFondo;
        private Color colorTexto;

        public TarjetaHabitacion(int numero, String estado) {
            this.numero = numero;
            this.estado = estado;
            configurarColores();
            setPreferredSize(new Dimension(130, 90)); // Ajustado para que entren 6 por fila
            setBackground(Color.WHITE);
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
        }

        private void configurarColores() {
            switch (estado) {
                case "DISPONIBLE" -> {
                    colorFondo = new Color(34, 197, 94); // Verde
                    colorTexto = Color.WHITE;
                }
                case "OCUPADA" -> {
                    colorFondo = new Color(239, 68, 68); // Rojo
                    colorTexto = Color.WHITE;
                }
                case "LIMPIEZA" -> {
                    colorFondo = new Color(245, 158, 11); // Naranja
                    colorTexto = Color.WHITE;
                }
                default -> {
                    colorFondo = new Color(100, 116, 139);
                    colorTexto = Color.WHITE;
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dibujar fondo de color según estado
            g2.setColor(colorFondo);
            g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 15, 15);

            // Dibujar Texto
            g2.setColor(colorTexto);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 16));
            g2.drawString("HAB " + numero, 15, 35);
            
            g2.setFont(new Font("Segoe UI", Font.BOLD, 11));
            g2.drawString(estado, 15, 55);
        }
    }
    
    private void abrirDialogoNuevaEstadia() {
        JDialog dialog = new JDialog(this, "Registrar Estadía", true);
        dialog.setLayout(new BorderLayout());
        
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
        pnlForm.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 25));
        pnlForm.setBackground(Color.WHITE);

        // Título alineado a la izquierda
        JLabel lblTituloDl = new JLabel("Nueva Estadía");
        lblTituloDl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTituloDl.setForeground(new Color(30, 41, 59));
        lblTituloDl.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlForm.add(lblTituloDl);

        // Subtítulo alineado a la izquierda
        JLabel lblSubtituloDl = new JLabel("Complete los datos para el registro de huésped");
        lblSubtituloDl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtituloDl.setForeground(new Color(100, 116, 139));
        lblSubtituloDl.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlForm.add(lblSubtituloDl);

        pnlForm.add(Box.createVerticalStrut(25));

        // Panel de campos (Grid)
        JPanel pnlGrid = new JPanel(new GridLayout(4, 2, 20, 15));
        pnlGrid.setBackground(Color.WHITE);
        pnlGrid.setAlignmentX(Component.LEFT_ALIGNMENT); // Asegurar alineación del grid también

        pnlGrid.add(crearCampoEstilizado("Huésped (DNI/Nombre)", "Buscar..."));
        pnlGrid.add(crearCampoEstilizado("Nro Habitación", "Ej: 101"));
        
        // INTEGRACIÓN DE JCALENDAR
        pnlGrid.add(crearCampoFecha("Fecha de Ingreso"));
        pnlGrid.add(crearCampoFecha("Salida Programada"));
        
        pnlGrid.add(crearCampoEstilizado("Cant. Noches", "Autocalcular..."));
        pnlGrid.add(crearCampoEstilizado("Precio x Noche", "0.00"));
        pnlGrid.add(crearCampoEstilizado("Adelanto (S/.)", "0.00"));
        pnlGrid.add(crearSelectorEstilizado("Estado Inicial", new String[]{"Ocupada", "Reservada"}));

        pnlForm.add(pnlGrid);
        
        // Botonera
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
        pnlBotones.setBackground(new Color(248, 250, 252));
        JButton btnCan = new JButton("Cancelar");
        JButton btnGuar = new JButton("Confirmar Registro");
        btnGuar.setBackground(new Color(37, 99, 235));
        btnGuar.setForeground(Color.WHITE);
        btnGuar.setPreferredSize(new Dimension(150, 35));

        btnCan.addActionListener(e -> dialog.dispose());
        pnlBotones.add(btnCan);
        pnlBotones.add(btnGuar);

        dialog.add(pnlForm, BorderLayout.CENTER);
        dialog.add(pnlBotones, BorderLayout.SOUTH);
        
        dialog.pack();
        dialog.setSize(650, 550);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private JPanel crearCampoFecha(String titulo) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setOpaque(false);
        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setPreferredSize(new Dimension(200, 35));
        dateChooser.setBackground(Color.WHITE);
        dateChooser.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        
        p.add(lbl, BorderLayout.NORTH);
        p.add(dateChooser, BorderLayout.CENTER);
        return p;
    }

    private JPanel crearCampoEstilizado(String titulo, String placeholder) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setOpaque(false);
        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        JTextField txt = new JTextField();
        txt.setPreferredSize(new Dimension(200, 35));
        txt.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholder);
        p.add(lbl, BorderLayout.NORTH);
        p.add(txt, BorderLayout.CENTER);
        return p;
    }

    private JPanel crearSelectorEstilizado(String titulo, String[] opciones) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setOpaque(false);
        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        JComboBox<String> combo = new JComboBox<>(opciones);
        combo.setPreferredSize(new Dimension(200, 35));
        p.add(lbl, BorderLayout.NORTH);
        p.add(combo, BorderLayout.CENTER);
        return p;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FrmEstadias().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelGraficos;
    private javax.swing.JTable tablaEstadias;
    // End of variables declaration//GEN-END:variables
}
