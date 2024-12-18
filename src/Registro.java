import java.awt.Color;
import java.io.*;

/**
 * Clase que representa la ventana de registro de un usuario en la interfaz gráfica.
 * Esta clase se encarga de la creación de un nuevo usuario,
 * así como de la validación de los datos introducidos en el formulario de registro.
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Instancia de la clase Escalar, que se utiliza para realizar el escalado de imágenes
     * en los componentes de la interfaz gráfica, como los JLabel.
     */
    Escalar escalar = new Escalar();

    /**
     * Ruta del directorio de usuario en el sistema, donde se guardan los archivos relacionados
     * con el usuario, como los de los registros.
     */
    private String userHome = "C:\\Users\\Cesia\\Desktop";

    /**
     * Ruta del archivo de texto que contiene la lista de usuarios registrados. 
     */
    private String fileUsuarios = userHome + "\\Taskflow\\Usuarios.txt";
    
    /**
    * Constructor de la clase Registro.
    * Este constructor inicializa los componentes gráficos de la interfaz, ajusta la ubicación de la ventana
    * al centro de la pantalla y escala las imágenes mostradas en los JLabels.
    */
    public Registro() {
        initComponents();
        
        setLocationRelativeTo(null);
        escalar.escalarLabel(jLabel2, "\\imagenes\\fondo1.jpg");
        escalar.escalarLabel(lblLogo, "\\imagenes\\logo.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelRound2 = new PanelRound();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        BTLogin = new javax.swing.JLabel();
        panelRound1 = new PanelRound();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BT_Registro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TF_Usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        TF_Correo = new javax.swing.JTextField();
        PF_Contraseña = new javax.swing.JPasswordField();
        PF_Contraseña2 = new javax.swing.JPasswordField();
        Aviso = new javax.swing.JLabel();
        PR_Salir = new PanelRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(0, 0, 0, 200));
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRound2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 10, 30));
        panelRound2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 90, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("    Registrarse");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 130, 40));

        BTLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTLogin.setForeground(new java.awt.Color(153, 153, 153));
        BTLogin.setText("    Iniciar Sesion");
        BTLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTLoginMousePressed(evt);
            }
        });
        panelRound2.add(BTLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 130, 40));

        jPanel2.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 400, 40));

        panelRound1.setBackground(new java.awt.Color(0, 0, 0, 200));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 80, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" TASKFLOW");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));
        panelRound1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 240, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Correo:");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 100, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirmar contraseña :");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 180, 40));
        panelRound1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 240, 10));

        BT_Registro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BT_Registro.setForeground(new java.awt.Color(102, 102, 102));
        BT_Registro.setText("Registrarse");
        BT_Registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BT_RegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BT_RegistroMouseExited(evt);
            }
        });
        BT_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_RegistroActionPerformed(evt);
            }
        });
        panelRound1.add(BT_Registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 130, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña:");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 120, 40));

        TF_Usuario.setBackground(new java.awt.Color(0, 0, 0, 0));
        TF_Usuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_Usuario.setForeground(new java.awt.Color(102, 102, 102));
        TF_Usuario.setText("Ingrese su usuario");
        TF_Usuario.setBorder(null);
        TF_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TF_UsuarioMousePressed(evt);
            }
        });
        TF_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_UsuarioActionPerformed(evt);
            }
        });
        panelRound1.add(TF_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 240, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuario:");
        panelRound1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, 40));
        panelRound1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 240, 10));
        panelRound1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 240, 10));

        TF_Correo.setBackground(new java.awt.Color(0, 0, 0, 0));
        TF_Correo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_Correo.setForeground(new java.awt.Color(102, 102, 102));
        TF_Correo.setText("Ejemplo@gmail.com");
        TF_Correo.setBorder(null);
        TF_Correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TF_CorreoMousePressed(evt);
            }
        });
        TF_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_CorreoActionPerformed(evt);
            }
        });
        panelRound1.add(TF_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 240, -1));

        PF_Contraseña.setBackground(new java.awt.Color(0, 0, 0, 0));
        PF_Contraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PF_Contraseña.setForeground(new java.awt.Color(102, 102, 102));
        PF_Contraseña.setText("**********");
        PF_Contraseña.setBorder(null);
        PF_Contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PF_ContraseñaMousePressed(evt);
            }
        });
        PF_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PF_ContraseñaActionPerformed(evt);
            }
        });
        panelRound1.add(PF_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 240, -1));

        PF_Contraseña2.setBackground(new java.awt.Color(0, 0, 0, 0));
        PF_Contraseña2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PF_Contraseña2.setForeground(new java.awt.Color(102, 102, 102));
        PF_Contraseña2.setText("**********");
        PF_Contraseña2.setBorder(null);
        PF_Contraseña2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PF_Contraseña2MousePressed(evt);
            }
        });
        panelRound1.add(PF_Contraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 240, -1));

        Aviso.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Aviso.setForeground(new java.awt.Color(102, 102, 255, 125));
        panelRound1.add(Aviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 240, 20));

        jPanel2.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 400, 420));

        PR_Salir.setBackground(new java.awt.Color(0, 0, 0,150));
        PR_Salir.setRoundBottomLeft(10);
        PR_Salir.setRoundBottomRight(10);
        PR_Salir.setRoundTopLeft(10);
        PR_Salir.setRoundTopRight(10);
        PR_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_SalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_SalirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_SalirMousePressed(evt);
            }
        });
        PR_Salir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("x");
        PR_Salir.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        jPanel2.add(PR_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 40, 40));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 630));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Método que maneja el evento de clic en el componente BTLogin.
    * Al presionar el componente, se abre la ventana de inicio de sesión (Login) y
    * se cierra la ventana actual.
    * 
    * @param evt El evento de mouse que ha ocurrido al hacer clic en jLabel9.
    */
    private void BTLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTLoginMousePressed
        Login ventana = new Login();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BTLoginMousePressed

    private void BT_RegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_RegistroMouseEntered
        Color color = new Color(237,181,94);
        BT_Registro.setBackground(color);
        BT_Registro.setForeground(Color.WHITE);
    }//GEN-LAST:event_BT_RegistroMouseEntered

    private void BT_RegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_RegistroMouseExited
        BT_Registro.setBackground(Color.LIGHT_GRAY);
        BT_Registro.setForeground(Color.GRAY);
    }//GEN-LAST:event_BT_RegistroMouseExited

    /**
    * Maneja el evento de acción del botón de registro.
    * Este método verifica si las contraseñas coinciden y si el usuario no existe ya en el archivo.
    * Si las contraseñas son iguales y el usuario no existe, registra al nuevo usuario,
    * guarda los datos del usuario actual y abre la ventana de inicio de usuario.
    * Si el usuario ya existe, muestra un mensaje de aviso. Si hay algún campo vacío o las contraseñas no coinciden, también muestra un mensaje de error.
    * 
    * @param evt El evento de acción que ha ocurrido al presionar el botón de registro.
    */
    private void BT_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_RegistroActionPerformed
        Usuario act=new Usuario();
        act= new Usuario(act.IDUsuarioNuevo(fileUsuarios),TF_Usuario.getText(),PF_Contraseña.getText(), "base",TF_Correo.getText());
        
        File usuariosFile= new File(fileUsuarios);
        
        if(PF_Contraseña.getText().equals(PF_Contraseña2.getText()) && !PF_Contraseña.getText().equals("**********")){
            if(!act.Usuario_Existe(usuariosFile,act.getUsuario())){
                act.Registrar_Usuario(act, fileUsuarios);

                act.guardarUsuarioActual(act);

                InicioUsuario ventana= new InicioUsuario();
                ventana.setVisible(true);
                this.dispose();
            }else{
                Aviso.setText("*El usuario ya esta siendo usado*");
            }
        }else{
            if(TF_Usuario.getText().equals("Ingrese su usuario") || TF_Correo.getText().equals("Ejemplo@gmail.com") || PF_Contraseña.getText().equals("**********") || PF_Contraseña2.getText().equals("**********"))
                Aviso.setText("*Ingrese sus datos*");
            else
                Aviso.setText("*Las contraseñas no coinciden*");
        }
    }//GEN-LAST:event_BT_RegistroActionPerformed

    /**
    * Maneja el evento de clic en el campo de texto para el nombre de usuario.
    * Este método restablece el texto y color de los campos cuando se hace clic en ellos para ingresar datos.
    * 
    * @param evt El evento de mouse que ha ocurrido al hacer clic en el campo de texto.
    */
    private void TF_UsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TF_UsuarioMousePressed
        if(TF_Usuario.getText().equals("Ingrese su usuario")){
            TF_Usuario.setText("");
            TF_Usuario.setForeground(Color.LIGHT_GRAY);
        }
        if(TF_Correo.getText().isEmpty()){
            TF_Correo.setForeground(Color.GRAY);
            TF_Correo.setText("Ejemplo@gmail.com");
        }
        if(String.valueOf(PF_Contraseña.getPassword()).isEmpty()){
            PF_Contraseña.setForeground(Color.GRAY);
            PF_Contraseña.setText("**********");
        }
        if(String.valueOf(PF_Contraseña2.getPassword()).isEmpty()){
            PF_Contraseña2.setForeground(Color.GRAY);
            PF_Contraseña2.setText("**********");
        }
    }//GEN-LAST:event_TF_UsuarioMousePressed

    private void TF_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_UsuarioActionPerformed

    private void PR_SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMouseEntered
        Color color = new Color(237,181,94);
        PR_Salir.setBackground(color);
    }//GEN-LAST:event_PR_SalirMouseEntered

    private void PR_SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMouseExited
        Color color = new Color(0,0,0,150);
        PR_Salir.setBackground(color);
    }//GEN-LAST:event_PR_SalirMouseExited

    private void PR_SalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMousePressed
        System.exit(0);
    }//GEN-LAST:event_PR_SalirMousePressed

    private void TF_CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_CorreoActionPerformed
        
    }//GEN-LAST:event_TF_CorreoActionPerformed

    private void PF_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PF_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PF_ContraseñaActionPerformed

    /**
    * Maneja el evento de clic en el campo de texto para el correo electrónico.
    * Este método restablece el texto y color de los campos cuando se hace clic en el campo de correo electrónico
    * para que el usuario ingrese datos nuevos. Si el campo de correo está vacío, establece el texto predeterminado
    * y cambia el color de los otros campos de entrada.
    * 
    * @param evt El evento de mouse que ha ocurrido al hacer clic en el campo de texto para el correo.
    */
    private void TF_CorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TF_CorreoMousePressed
        if(TF_Correo.getText().equals("Ejemplo@gmail.com")){
            TF_Correo.setText("");
            TF_Correo.setForeground(Color.LIGHT_GRAY);
        }
        if(TF_Usuario.getText().isEmpty()){
            TF_Usuario.setForeground(Color.GRAY);
            TF_Usuario.setText("Ingrese su usuario");
        }
        if(String.valueOf(PF_Contraseña.getPassword()).isEmpty()){
            PF_Contraseña.setForeground(Color.GRAY);
            PF_Contraseña.setText("**********");
        }
        if(String.valueOf(PF_Contraseña2.getPassword()).isEmpty()){
            PF_Contraseña2.setForeground(Color.GRAY);
            PF_Contraseña2.setText("**********");
        }
    }//GEN-LAST:event_TF_CorreoMousePressed

    /**
    * Maneja el evento de clic en el campo de texto para la contraseña.
    * Este método restablece el texto y color de los campos cuando se hace clic en el campo de contraseña
    * para que el usuario ingrese datos nuevos. Si el campo de contraseña está vacío, establece el texto predeterminado
    * y cambia el color de los otros campos de entrada.
    * 
    * @param evt El evento de mouse que ha ocurrido al hacer clic en el campo de texto para la contraseña.
    */
    private void PF_ContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PF_ContraseñaMousePressed
        if(PF_Contraseña.getText().equals("**********")){
            PF_Contraseña.setText("");
            PF_Contraseña.setForeground(Color.LIGHT_GRAY);
        }
        if(TF_Correo.getText().isEmpty()){
            TF_Correo.setForeground(Color.GRAY);
            TF_Correo.setText("Ejemplo@gmail.com");
        }
        if(TF_Usuario.getText().isEmpty()){
            TF_Usuario.setForeground(Color.GRAY);
            TF_Usuario.setText("Ingrese su usuario");
        }
        if(String.valueOf(PF_Contraseña2.getPassword()).isEmpty()){
            PF_Contraseña2.setForeground(Color.GRAY);
            PF_Contraseña2.setText("**********");
        }
    }//GEN-LAST:event_PF_ContraseñaMousePressed

    /**
    * Maneja el evento de clic en el campo de texto para la confirmación de la contraseña.
    * Este método restablece el texto y color de los campos cuando se hace clic en el campo de confirmación de contraseña
    * para que el usuario ingrese datos nuevos. Si el campo de confirmación de contraseña está vacío, establece el texto predeterminado
    * y cambia el color de los otros campos de entrada.
    * 
    * @param evt El evento de mouse que ha ocurrido al hacer clic en el campo de texto para la confirmación de contraseña.
    */
    private void PF_Contraseña2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PF_Contraseña2MousePressed
        if(PF_Contraseña2.getText().equals("**********")){
            PF_Contraseña2.setText("");
            PF_Contraseña2.setForeground(Color.LIGHT_GRAY);
        }
        if(TF_Correo.getText().isEmpty()){
            TF_Correo.setForeground(Color.GRAY);
            TF_Correo.setText("Ejemplo@gmail.com");
        }
        if(TF_Usuario.getText().isEmpty()){
            TF_Usuario.setForeground(Color.GRAY);
            TF_Usuario.setText("Ingrese su usuario");
        }
        if(String.valueOf(PF_Contraseña.getPassword()).isEmpty()){
            PF_Contraseña.setForeground(Color.GRAY);
            PF_Contraseña.setText("**********");
        }
    }//GEN-LAST:event_PF_Contraseña2MousePressed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Aviso;
    private javax.swing.JLabel BTLogin;
    private javax.swing.JButton BT_Registro;
    private javax.swing.JPasswordField PF_Contraseña;
    private javax.swing.JPasswordField PF_Contraseña2;
    private PanelRound PR_Salir;
    private javax.swing.JTextField TF_Correo;
    private javax.swing.JTextField TF_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblLogo;
    private PanelRound panelRound1;
    private PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}