import java.awt.Color;
import java.io.File;
import javax.swing.JOptionPane;

/**
 * Ventana para editar el perfil del usuario actual.
 * Permite modificar los datos de usuario como el nombre de usuario, contraseña y correo.
 */
public class EditarPerfil extends javax.swing.JFrame {

    /**
    * Instancia de la clase Escalar, que se utiliza para escalar imágenes en la interfaz gráfica.
    */
    Escalar escalar = new Escalar();

     /**
    * Objeto Usuario que representa al usuario actual del sistema. 
    */
    private Usuario UsuarioActual = new Usuario();

     /**
    * Ruta al directorio raíz del usuario en su sistema.
    */
    private String userHome = "C:\\Users\\Cesia\\Desktop";

     /**
    * Ruta al archivo que contiene los datos de todos los usuarios del sistema. 
    */
    private String fileUsuarios = userHome + "\\Taskflow\\Usuarios.txt";
    
    /**
     * Constructor de la clase EditarPerfil. Inicializa los componentes de la interfaz y ajusta los tamaños de las imágenes.
     * Obtiene el usuario actual y muestra sus datos (nombre de usuario y correo) en los campos correspondientes.
     */
    public EditarPerfil() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        escalar.escalarLabel(jLabel1, "\\imagenes\\logo.png");
        escalar.escalarLabel(ImagenUsuario, "\\imagenes\\usuario.png");
        escalar.escalarLabel(lblInicio, "\\imagenes\\Inicio.png");
        escalar.escalarLabel(lblPerfil, "\\imagenes\\Perfil.png");
        escalar.escalarLabel(lblUsuarios, "\\imagenes\\Usuarios.png");
        escalar.escalarLabel(lblTareasActuales, "\\imagenes\\TareasActuales.png");
        escalar.escalarLabel(lblMisTareas, "\\imagenes\\MisTareas.png");
        escalar.escalarLabel(lblHistorial, "\\imagenes\\Historial.png");
        escalar.escalarLabel(lblSalir, "\\imagenes\\Salir.png");
        escalar.escalarLabel(lblFondo, "\\imagenes\\fondo5.png");
        
        UsuarioActual=UsuarioActual.obtenerUsuarioActual();
        lblNombreUsuario.setText(UsuarioActual.getUsuario());
        TFUsuario.setText(UsuarioActual.getUsuario());
        TFCorreo.setText(UsuarioActual.getCorreo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new PanelRound();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ImagenUsuario = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        PR_Perfil = new PanelRound();
        lblPerfil = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PR_Usuarios = new PanelRound();
        lblUsuarios = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PR_TareasActuales = new PanelRound();
        lblTareasActuales = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PR_MisTareas = new PanelRound();
        lblMisTareas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PR_Salir = new PanelRound();
        lblSalir = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PR_Inicio = new PanelRound();
        lblInicio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PR_Historial = new PanelRound();
        lblHistorial = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Pantalla = new PanelRound();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        PRDatos = new PanelRound();
        TFCorreo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        TFUsuario = new javax.swing.JTextField();
        PFContraseña2 = new javax.swing.JPasswordField();
        PFContraseña = new javax.swing.JPasswordField();
        BTCancelar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        BTGuardar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(25, 35, 60));
        Menu.setRoundBottomLeft(50);
        Menu.setRoundBottomRight(50);
        Menu.setRoundTopLeft(50);
        Menu.setRoundTopRight(50);
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 10));
        Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 120, 90));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TASKFLOW");
        Menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 110, 40));
        Menu.add(ImagenUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, 50));

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Usuario");
        Menu.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 100, 30));

        PR_Perfil.setBackground(new java.awt.Color(25, 35, 60));
        PR_Perfil.setRoundBottomLeft(25);
        PR_Perfil.setRoundBottomRight(25);
        PR_Perfil.setRoundTopLeft(25);
        PR_Perfil.setRoundTopRight(25);
        PR_Perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_PerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_PerfilMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_PerfilMousePressed(evt);
            }
        });
        PR_Perfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPerfil.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                lblPerfilComponentHidden(evt);
            }
        });
        PR_Perfil.add(lblPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Perfil");
        PR_Perfil.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        Menu.add(PR_Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 50));

        PR_Usuarios.setBackground(new java.awt.Color(25, 35, 60));
        PR_Usuarios.setRoundBottomLeft(25);
        PR_Usuarios.setRoundBottomRight(25);
        PR_Usuarios.setRoundTopLeft(25);
        PR_Usuarios.setRoundTopRight(25);
        PR_Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_UsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_UsuariosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_UsuariosMousePressed(evt);
            }
        });
        PR_Usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_Usuarios.add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuarios");
        PR_Usuarios.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 50));

        Menu.add(PR_Usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 50));

        PR_TareasActuales.setBackground(new java.awt.Color(25, 35, 60));
        PR_TareasActuales.setRoundBottomLeft(25);
        PR_TareasActuales.setRoundBottomRight(25);
        PR_TareasActuales.setRoundTopLeft(25);
        PR_TareasActuales.setRoundTopRight(25);
        PR_TareasActuales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_TareasActualesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_TareasActualesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_TareasActualesMousePressed(evt);
            }
        });
        PR_TareasActuales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_TareasActuales.add(lblTareasActuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tareas actuales");
        PR_TareasActuales.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 140, 50));

        Menu.add(PR_TareasActuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 50));

        PR_MisTareas.setBackground(new java.awt.Color(25, 35, 60));
        PR_MisTareas.setRoundBottomLeft(25);
        PR_MisTareas.setRoundBottomRight(25);
        PR_MisTareas.setRoundTopLeft(25);
        PR_MisTareas.setRoundTopRight(25);
        PR_MisTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_MisTareasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_MisTareasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_MisTareasMousePressed(evt);
            }
        });
        PR_MisTareas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_MisTareas.add(lblMisTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mis Tareas");
        PR_MisTareas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 90, 50));

        Menu.add(PR_MisTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 50));

        PR_Salir.setBackground(new java.awt.Color(237, 181, 94));
        PR_Salir.setRoundBottomLeft(25);
        PR_Salir.setRoundBottomRight(25);
        PR_Salir.setRoundTopLeft(25);
        PR_Salir.setRoundTopRight(25);
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
        PR_Salir.add(lblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Salir");
        PR_Salir.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        Menu.add(PR_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 110, 50));

        PR_Inicio.setBackground(new java.awt.Color(25, 35, 60));
        PR_Inicio.setRoundBottomLeft(25);
        PR_Inicio.setRoundBottomRight(25);
        PR_Inicio.setRoundTopLeft(25);
        PR_Inicio.setRoundTopRight(25);
        PR_Inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_InicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_InicioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_InicioMousePressed(evt);
            }
        });
        PR_Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_Inicio.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inicio");
        PR_Inicio.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        Menu.add(PR_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 50));

        PR_Historial.setBackground(new java.awt.Color(25, 35, 60));
        PR_Historial.setRoundBottomLeft(25);
        PR_Historial.setRoundBottomRight(25);
        PR_Historial.setRoundTopLeft(25);
        PR_Historial.setRoundTopRight(25);
        PR_Historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PR_HistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PR_HistorialMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PR_HistorialMousePressed(evt);
            }
        });
        PR_Historial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PR_Historial.add(lblHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Historial");
        PR_Historial.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 90, 50));

        Menu.add(PR_Historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 200, 50));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        Pantalla.setBackground(new java.awt.Color(255, 255, 255));
        Pantalla.setRoundBottomRight(50);
        Pantalla.setRoundTopRight(50);
        Pantalla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(25, 35, 60));
        Pantalla.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 690, 10));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(25, 35, 60));
        jLabel17.setText("Editar Perfil");
        Pantalla.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        PRDatos.setBackground(new java.awt.Color(255, 255, 255, 50));
        PRDatos.setRoundBottomLeft(35);
        PRDatos.setRoundBottomRight(35);
        PRDatos.setRoundTopLeft(35);
        PRDatos.setRoundTopRight(35);
        PRDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TFCorreo.setBackground(new java.awt.Color(0, 0, 0,0));
        TFCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TFCorreo.setForeground(new java.awt.Color(51, 51, 51));
        TFCorreo.setText("@gmail.com");
        TFCorreo.setBorder(null);
        TFCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TFCorreoMousePressed(evt);
            }
        });
        TFCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFCorreoActionPerformed(evt);
            }
        });
        PRDatos.add(TFCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 280, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Usuario :");
        PRDatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 100, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Email :");
        PRDatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 80, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Contraseña :");
        PRDatos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Confirmar Contraseña :");
        PRDatos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        PRDatos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 280, 10));

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        PRDatos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 280, 10));

        jSeparator5.setForeground(new java.awt.Color(51, 51, 51));
        PRDatos.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 280, 10));

        jSeparator6.setForeground(new java.awt.Color(51, 51, 51));
        PRDatos.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 280, 10));

        TFUsuario.setBackground(new java.awt.Color(0, 0, 0,0));
        TFUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TFUsuario.setForeground(new java.awt.Color(51, 51, 51));
        TFUsuario.setBorder(null);
        TFUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TFUsuarioMousePressed(evt);
            }
        });
        TFUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFUsuarioActionPerformed(evt);
            }
        });
        PRDatos.add(TFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 280, 30));

        PFContraseña2.setBackground(new java.awt.Color(51, 51, 51, 0));
        PFContraseña2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PFContraseña2.setForeground(new java.awt.Color(51, 51, 51));
        PFContraseña2.setText("**********");
        PFContraseña2.setBorder(null);
        PFContraseña2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PFContraseña2MousePressed(evt);
            }
        });
        PRDatos.add(PFContraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 280, 30));

        PFContraseña.setBackground(new java.awt.Color(51, 51, 51, 0));
        PFContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PFContraseña.setForeground(new java.awt.Color(51, 51, 51));
        PFContraseña.setText("**********");
        PFContraseña.setBorder(null);
        PFContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PFContraseñaMousePressed(evt);
            }
        });
        PFContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PFContraseñaActionPerformed(evt);
            }
        });
        PRDatos.add(PFContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 280, 30));

        BTCancelar.setBackground(new java.awt.Color(255, 255, 255));
        BTCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTCancelar.setForeground(new java.awt.Color(102, 102, 102));
        BTCancelar.setText("Cancelar");
        BTCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCancelarActionPerformed(evt);
            }
        });
        PRDatos.add(BTCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, -1));
        PRDatos.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 110, 100));

        BTGuardar.setBackground(new java.awt.Color(255, 255, 255));
        BTGuardar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BTGuardar.setForeground(new java.awt.Color(102, 102, 102));
        BTGuardar.setText("Guardar");
        BTGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTGuardarActionPerformed(evt);
            }
        });
        PRDatos.add(BTGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        Pantalla.add(PRDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 690, 495));
        Pantalla.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 690, 490));

        getContentPane().add(Pantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 870, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFCorreoActionPerformed

    private void TFUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFUsuarioActionPerformed

    private void PFContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PFContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PFContraseñaActionPerformed

    /**
    * Cierra la ventana actual y abre la ventana de perfil.
    * 
    * @param evt Este método se ejecuta cuando el usuario hace clic en el botón de cancelar.
    */
    private void BTCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCancelarActionPerformed
        Perfil ventana = new Perfil();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BTCancelarActionPerformed

    /**
    * Guarda los cambios en los datos del usuario y actualiza la información.
    * 
    * @param evt Este método se ejecuta cuando el usuario hace clic en el botón "Guardar". 
    */
    private void BTGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTGuardarActionPerformed
        Usuario act=new Usuario(UsuarioActual.getId(),TFUsuario.getText(),PFContraseña.getText(),UsuarioActual.getNivel(),TFCorreo.getText());
        if(!TFUsuario.getText().isEmpty() && !TFCorreo.getText().isEmpty() && !String.valueOf(PFContraseña.getPassword()).isEmpty() && !String.valueOf(PFContraseña2.getPassword()).isEmpty()){
            if(PFContraseña.getText().equals(PFContraseña2.getText())){
                if(act!=UsuarioActual){
                    act.editarUsuario(fileUsuarios, userHome, act, UsuarioActual);
                    act.guardarUsuarioActual(act);
                    
                    Perfil ventana = new Perfil();
                    ventana.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Datos Guardados");
                    this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese sus datos");
        }
    }//GEN-LAST:event_BTGuardarActionPerformed

    private void lblPerfilComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lblPerfilComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPerfilComponentHidden

    private void PR_PerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_PerfilMouseEntered
        Color color = new Color(237,181,94);
        PR_Perfil.setBackground(color);
    }//GEN-LAST:event_PR_PerfilMouseEntered

    private void PR_PerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_PerfilMouseExited
        Color color = new Color(25,35,60);
        PR_Perfil.setBackground(color);
    }//GEN-LAST:event_PR_PerfilMouseExited

    private void PR_PerfilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_PerfilMousePressed
        Perfil ventana = new Perfil();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_PerfilMousePressed

    private void PR_UsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_UsuariosMouseEntered
        Color color = new Color(237,181,94);
        PR_Usuarios.setBackground(color);
    }//GEN-LAST:event_PR_UsuariosMouseEntered

    private void PR_UsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_UsuariosMouseExited
        Color color = new Color(25,35,60);
        PR_Usuarios.setBackground(color);
    }//GEN-LAST:event_PR_UsuariosMouseExited

    private void PR_UsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_UsuariosMousePressed
        Usuarios ventana = new Usuarios();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_UsuariosMousePressed

    private void PR_TareasActualesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMouseEntered
        Color color = new Color(237,181,94);
        PR_TareasActuales.setBackground(color);
    }//GEN-LAST:event_PR_TareasActualesMouseEntered

    private void PR_TareasActualesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMouseExited
        Color color = new Color(25,35,60);
        PR_TareasActuales.setBackground(color);
    }//GEN-LAST:event_PR_TareasActualesMouseExited

    private void PR_TareasActualesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMousePressed
        TareasActuales ventana = new TareasActuales();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_TareasActualesMousePressed

    private void PR_MisTareasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMouseEntered
        Color color = new Color(237,181,94);
        PR_MisTareas.setBackground(color);
    }//GEN-LAST:event_PR_MisTareasMouseEntered

    private void PR_MisTareasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMouseExited
        Color color = new Color(25,35,60);
        PR_MisTareas.setBackground(color);
    }//GEN-LAST:event_PR_MisTareasMouseExited

    private void PR_MisTareasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMousePressed
        MisTareas ventana = new MisTareas();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_MisTareasMousePressed

    private void PR_SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMouseEntered
        Color color = new Color(214,80,68);
        PR_Salir.setBackground(color);
    }//GEN-LAST:event_PR_SalirMouseEntered

    private void PR_SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMouseExited
        Color color = new Color(237,181,94);
        PR_Salir.setBackground(color);
    }//GEN-LAST:event_PR_SalirMouseExited

    private void PR_SalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_SalirMousePressed
        Login ventana = new Login();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_SalirMousePressed

    private void PR_InicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_InicioMouseEntered
        Color color = new Color(237,181,94);
        PR_Inicio.setBackground(color);
    }//GEN-LAST:event_PR_InicioMouseEntered

    private void PR_InicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_InicioMouseExited
        Color color = new Color(25,35,60);
        PR_Inicio.setBackground(color);
    }//GEN-LAST:event_PR_InicioMouseExited

    private void PR_InicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_InicioMousePressed
        Inicio ventana = new Inicio();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_InicioMousePressed

    private void PR_HistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_HistorialMouseEntered
        Color color = new Color(237,181,94);
        PR_Historial.setBackground(color);
    }//GEN-LAST:event_PR_HistorialMouseEntered

    private void PR_HistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_HistorialMouseExited
        Color color = new Color(25,35,60);
        PR_Historial.setBackground(color);
    }//GEN-LAST:event_PR_HistorialMouseExited

    private void PR_HistorialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_HistorialMousePressed
        Historial ventana = new Historial();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_HistorialMousePressed

    /**
    * Maneja el evento de presión del mouse en el campo de texto de usuario.
    * 
    * Este método se ejecuta cuando el usuario hace clic en el campo de texto para el nombre de usuario. 
    * Si el campo contiene el nombre de usuario actual, lo borra. Si otros campos están vacíos, 
    * se llenan con los valores actuales del usuario.
    */
    private void TFUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFUsuarioMousePressed
        if(TFUsuario.getText().equals(UsuarioActual.getUsuario()))
            TFUsuario.setText("");
        if(TFCorreo.getText().isEmpty())
            TFCorreo.setText(UsuarioActual.getCorreo());
        if(String.valueOf(PFContraseña.getPassword()).isEmpty())
            PFContraseña.setText("**********");
        if(String.valueOf(PFContraseña2.getPassword()).isEmpty())
            PFContraseña2.setText("**********");
    }//GEN-LAST:event_TFUsuarioMousePressed

    /**
    * Maneja el evento de presión del mouse en el campo de texto de correo.
    * 
    * Este método se ejecuta cuando el usuario hace clic en el campo de texto para el correo. 
    * Si el campo contiene el correo actual del usuario, lo borra. Si otros campos están vacíos, 
    * se llenan con los valores actuales del usuario.
    */
    private void TFCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFCorreoMousePressed
        if(TFCorreo.getText().equals(UsuarioActual.getCorreo()))
            TFCorreo.setText("");
        if(TFUsuario.getText().isEmpty())
            TFUsuario.setText(UsuarioActual.getUsuario());
        if(String.valueOf(PFContraseña.getPassword()).isEmpty())
            PFContraseña.setText("**********");
        if(String.valueOf(PFContraseña2.getPassword()).isEmpty())
            PFContraseña2.setText("**********");
    }//GEN-LAST:event_TFCorreoMousePressed

    /**
    * Maneja el evento de presión del mouse en el campo de contraseña.
    * 
    * Este método se ejecuta cuando el usuario hace clic en el campo de contraseña. 
    * Si el campo contiene el texto predeterminado ("**********"), lo borra. 
    * Si otros campos están vacíos, los llena con los valores actuales del usuario.
    */
    private void PFContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PFContraseñaMousePressed
        if(PFContraseña.getText().equals("**********"))
            PFContraseña.setText("");
        if(TFCorreo.getText().isEmpty())
            TFCorreo.setText(UsuarioActual.getCorreo());
        if(TFUsuario.getText().isEmpty())
            TFUsuario.setText(UsuarioActual.getUsuario());
        if(String.valueOf(PFContraseña2.getPassword()).isEmpty())
            PFContraseña2.setText("**********");
    }//GEN-LAST:event_PFContraseñaMousePressed

    /**
    * Maneja el evento de presión del mouse en el campo de confirmación de contraseña.
    * 
    * Este método se ejecuta cuando el usuario hace clic en el campo de confirmación de contraseña. 
    * Si el campo contiene el texto predeterminado ("**********"), lo borra. 
    * Si otros campos están vacíos, los llena con los valores actuales del usuario.
    */
    private void PFContraseña2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PFContraseña2MousePressed
        if(PFContraseña2.getText().equals("**********"))
            PFContraseña2.setText("");
        if(TFCorreo.getText().isEmpty())
            TFCorreo.setText(UsuarioActual.getCorreo());
        if(TFUsuario.getText().isEmpty())
            TFUsuario.setText(UsuarioActual.getUsuario());
        if(String.valueOf(PFContraseña.getPassword()).isEmpty())
            PFContraseña.setText("**********");
    }//GEN-LAST:event_PFContraseña2MousePressed

    /**
    * Este es el punto de entrada principal de la ventana.
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(EditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTCancelar;
    private javax.swing.JButton BTGuardar;
    private javax.swing.JLabel ImagenUsuario;
    private PanelRound Menu;
    private javax.swing.JPasswordField PFContraseña;
    private javax.swing.JPasswordField PFContraseña2;
    private PanelRound PRDatos;
    private PanelRound PR_Historial;
    private PanelRound PR_Inicio;
    private PanelRound PR_MisTareas;
    private PanelRound PR_Perfil;
    private PanelRound PR_Salir;
    private PanelRound PR_TareasActuales;
    private PanelRound PR_Usuarios;
    private PanelRound Pantalla;
    private javax.swing.JTextField TFCorreo;
    private javax.swing.JTextField TFUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblMisTareas;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTareasActuales;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
