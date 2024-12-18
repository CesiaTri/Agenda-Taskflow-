
import java.util.ArrayList;

/**
 * Clase que representa la vista del perfil de un usuario en la interfaz gráfica.
 * Esta clase maneja la visualización del perfil de un usuario, 
 * permitiendo acceder y modificar información relacionada con el usuario actual.
 * También se encarga de la visualización y ajuste de componentes gráficos mediante la clase Escalar.
 */
public class PerfilView extends javax.swing.JFrame {

    /**
     * Instancia de la clase Escalar, que se utiliza para realizar el escalado de imágenes
     * en los componentes de la interfaz gráfica, como los JLabel.
     */
    Escalar escalar = new Escalar();

    /**
     * Instancia del objeto Usuario que representa al usuario actualmente activo o cuyo
     * perfil se está visualizando. 
     */
    public Usuario UsuarioActual = new Usuario();
    
    /**
    * Establece los valores del usuario en los componentes gráficos de la interfaz.
    * Este método actualiza las etiquetas de la interfaz con la información del usuario proporcionado.
    * 
    * @param usuario El objeto Usuario cuyo información se va a mostrar en la interfaz.
    */
    public void setUsuario(Usuario usuario){
        this.UsuarioActual=usuario;
        lblUsuario.setText(UsuarioActual.getUsuario());
        lblID.setText(Integer.toString(UsuarioActual.getId()));
        lblEmail.setText(UsuarioActual.getCorreo());
        lblNivel.setText(UsuarioActual.getNivel());
    }
    
    /**
    * Constructor de la clase PerfilView.
    * Inicializa los componentes gráficos, ajusta la ubicación de la ventana, 
    * escala las imágenes mostradas en los JLabels, y muestra la información del usuario actual.
    */
    public PerfilView() {
        initComponents();
        
        setLocationRelativeTo(null);
        escalar.escalarLabel(lblFotoUsuario, "\\imagenes\\usuario.png");
        escalar.escalarLabel(lblFondo, "\\imagenes\\fondo3.png");
        
        lblUsuario.setText(UsuarioActual.getUsuario());
        lblID.setText(Integer.toString(UsuarioActual.getId()));
        lblEmail.setText(UsuarioActual.getCorreo());
        lblNivel.setText(UsuarioActual.getNivel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new PanelRound();
        lblFotoUsuario = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        BT_Cerrar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(255, 255, 255, 100));
        panelRound2.setForeground(new java.awt.Color(204, 204, 204));
        panelRound2.setRoundBottomLeft(40);
        panelRound2.setRoundBottomRight(40);
        panelRound2.setRoundTopLeft(40);
        panelRound2.setRoundTopRight(40);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound2.add(lblFotoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 130, 120));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("ID           :");
        panelRound2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 110, 20));

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(51, 51, 51));
        lblID.setText("00001");
        panelRound2.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(25, 35, 60));
        panelRound2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 290, 10));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Usuario  :");
        panelRound2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 110, 20));

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario.setText("Usuario de prueba");
        panelRound2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Nivel      :");
        panelRound2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, 20));

        lblNivel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(51, 51, 51));
        lblNivel.setText("Administrador");
        panelRound2.add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(25, 35, 60));
        panelRound2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 290, 10));

        jSeparator6.setForeground(new java.awt.Color(25, 35, 60));
        panelRound2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 290, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Email      :");
        panelRound2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, 20));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(51, 51, 51));
        lblEmail.setText("prueba1@gmail.com");
        panelRound2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));

        BT_Cerrar.setBackground(new java.awt.Color(255, 255, 255));
        BT_Cerrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BT_Cerrar.setForeground(new java.awt.Color(102, 102, 102));
        BT_Cerrar.setText("Cerrar");
        BT_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CerrarActionPerformed(evt);
            }
        });
        panelRound2.add(BT_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        getContentPane().add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 420));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BT_CerrarActionPerformed

    /**
     * Este es el punto de entrada principal de la ventana.
     *@param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerfilView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cerrar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private static javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFotoUsuario;
    private static javax.swing.JLabel lblID;
    private static javax.swing.JLabel lblNivel;
    private static javax.swing.JLabel lblUsuario;
    private PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
