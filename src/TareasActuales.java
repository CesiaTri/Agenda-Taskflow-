import java.awt.Color;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import raven_cell.TableActionCellEditor;
import raven_cell.TableActionCellRender;
import raven_cell.TableActionEvent;

/**
 * La clase TareasActuales es una ventana que muestra las tareas actuales de un usuario.
 * Gestiona las tareas, las busca en la lista, y permite filtrar por diversos criterios como nombre, prioridad, estado y usuario.
 * Además, maneja la visualización y administración de tareas de la aplicación Taskflow.
 */
public class TareasActuales extends javax.swing.JFrame {

    /**
     * Instancia de la clase Escalar utilizada para redimensionar imágenes en los componentes.
     */
    Escalar escalar = new Escalar();

    /**
     * El usuario actualmente logueado en la aplicación.
     */
    private Usuario UsuarioActual = new Usuario();

    /**
     * Ruta base del directorio donde se almacenan los archivos de tareas.
     */
    private String userHome = "C:\\Users\\Cesia\\Desktop";

    /**
     * Ruta del archivo que contiene la lista de tareas.
     */
    private String fileListaTareas = userHome + "\\Taskflow\\Tareas\\ListaTareas.txt";

    /**
     * Directorio donde se almacenan las tareas, usado para buscar las tareas por número.
     */
    private String direcTareas = userHome + "\\Taskflow\\Tareas";

    /**
     * Lista que contiene todas las tareas actuales.
     */
    public ArrayList<Tarea> lista;

    /**
     * Lista que contiene las tareas filtradas según los criterios de búsqueda.
     */
    public ArrayList<Tarea> listaBuscar = new ArrayList<>();

    /**
     * Filtro de búsqueda para el nombre de las tareas.
     */
    public String nombre = "";

    /**
     * Filtro de búsqueda para la prioridad de las tareas.
     */
    public String prioridad = "";

    /**
     * Filtro de búsqueda para el estado de las tareas.
     */
    public String estado = "";

    /**
     * Filtro de búsqueda para el usuario asociado a la tarea.
     */
    public String usuario = "";

    /**
     * Índice que podría estar relacionado con la selección de tareas en la lista.
     */
    public int indice = 0;

    /**
     * Contador utilizado para manejar las tareas, podría estar relacionado con la paginación o la cantidad de tareas.
     */
    public int cont = 0;

    /**
     * Ruta del archivo que contiene los datos de los usuarios registrados.
     */
    private String fileUsuarios = userHome + "\\Taskflow\\Usuarios.txt";

    /**
     * Lista de usuarios registrados en la aplicación.
     */
    public ArrayList<Usuario> listaUsuarios;
    
    /**
     * Constructor de la clase TareasActuales.
     * Inicializa la interfaz gráfica y asigna las imágenes a los componentes.
     */
    public TareasActuales() {
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
        escalar.escalarLabel(lblEsq, "\\imagenes\\esquina1.png");
        
        UsuarioActual=UsuarioActual.obtenerUsuarioActual();
        lblNombreUsuario.setText(UsuarioActual.getUsuario());
        
        Tarea aux= new Tarea();
        File direcListaTareas = new File(fileListaTareas);
        lista=aux.ListaTareas(direcTareas);
        cont=lista.size();
        
        Usuario auxiliar= new Usuario();
        File direcUsuarios = new File(fileUsuarios);
        listaUsuarios=auxiliar.listaUsuarios(direcUsuarios);
        
        for (int c = 0; c < listaUsuarios.size(); c++) {
            CBUsuario.addItem(listaUsuarios.get(c).getUsuario());  // Agregar el nombre de usuario al ComboBox
        }
        
        rellenarTabla(lista);

        table.setDefaultRenderer(Object.class, new TareaRenderer(lista));  // Le pasas la lista de tareas al renderizador
    }
    
    /**
    * Filtra las tareas y las muestra según el estado "En progreso" para el usuario actual.
    * Solo las tareas asignadas al usuario actual con el estado "En progreso" se mostrarán.
    */
    public void EnProgreso() {
    // Iteramos sobre el ArrayList usando su tamaño (size())
        usuario=UsuarioActual.getUsuario();
        estado="En progreso";
        vaciarTabla();
        for (int aux = 0; aux < lista.size(); aux++) {
            if(lista.get(aux).getEstado().equals("En progreso") && lista.get(aux).getUsuarioAsignado().equals(UsuarioActual.getUsuario())){
                Object[] newRow = new Object[] {
                    lista.get(aux).getNumeroTarea(),     
                    lista.get(aux).getNombre(), 
                    lista.get(aux).getPrioridad(),
                    lista.get(aux).getEstado(),
                    null                         // Campo adicional (puede ser un botón u otro dato)
                    };

                // Llamamos al método para agregar la fila con acción (posiblemente un botón)
                addRowWithActionButtons(newRow);
            }
        }
    }
    
    /**
    * Filtra las tareas y las muestra según el estado "Por hacer" para el usuario actual.
    * Solo las tareas asignadas al usuario actual con el estado "Por hacer" se mostrarán.
    */
    public void PorHacer() {
    // Iteramos sobre el ArrayList usando su tamaño (size())
        vaciarTabla();
        usuario=UsuarioActual.getUsuario();
        estado="Por hacer";
        for (int aux = 0; aux < lista.size(); aux++) {
            if(lista.get(aux).getEstado().equals("Por hacer") && lista.get(aux).getUsuarioAsignado().equals(UsuarioActual.getUsuario())){
                Object[] newRow = new Object[] {
                    lista.get(aux).getNumeroTarea(),     
                    lista.get(aux).getNombre(), 
                    lista.get(aux).getPrioridad(),
                    lista.get(aux).getEstado(),
                    null                         // Campo adicional (puede ser un botón u otro dato)
                    };

                // Llamamos al método para agregar la fila con acción (posiblemente un botón)
                addRowWithActionButtons(newRow);
            }
        }
    }
    
    /**
    * Filtra las tareas y las muestra según el estado "Completada" para el usuario actual.
    * Solo las tareas asignadas al usuario actual con el estado "Completada" se mostrarán.
    */
    public void Completadas() {
    // Iteramos sobre el ArrayList usando su tamaño (size())
        vaciarTabla();
        usuario=UsuarioActual.getUsuario();
        estado="Completada";
        for (int aux = 0; aux < lista.size(); aux++) {
            if(lista.get(aux).getEstado().equals("Completada") && lista.get(aux).getUsuarioAsignado().equals(UsuarioActual.getUsuario())){
                Object[] newRow = new Object[] {
                    lista.get(aux).getNumeroTarea(),     
                    lista.get(aux).getNombre(), 
                    lista.get(aux).getPrioridad(),
                    lista.get(aux).getEstado(),
                    null                         // Campo adicional (puede ser un botón u otro dato)
                    };

                // Llamamos al método para agregar la fila con acción (posiblemente un botón)
                addRowWithActionButtons(newRow);
            }
        }
    }
    
    /**
    * Obtiene una tarea de la lista que coincide con el número de tarea y nombre de la tarea proporcionada.
    * 
    * @param buscar La tarea que se quiere buscar en la lista.
    * @return La tarea encontrada o un objeto vacío si no se encuentra.
    */
    private Tarea obtenerTarea(Tarea buscar){
        Tarea act=new Tarea();
        for (int ind = 0; ind < lista.size(); ind++) {
            if(buscar.getNumeroTarea()==lista.get(ind).getNumeroTarea() && buscar.getNombre().equals(lista.get(ind).getNombre())){
                act=lista.get(ind);
                indice=ind;
            }
        }
        return act;
    }

    /**
    * Carga las tareas desde el archivo de tareas y actualiza la tabla con las tareas.
    * Si no hay filtros aplicados, se muestra toda la lista de tareas.
    * Si hay filtros, se realiza una búsqueda.
    */
    public void setLista(){
        Tarea aux= new Tarea();
        File direcListaTareas = new File(fileListaTareas);
        lista=aux.ListaTareas(direcTareas);
        cont=lista.size();
        
        vaciarTabla();
        
        if((nombre.equals("") && prioridad.equals("") && estado.equals("")) || (nombre.equals("Buscar por nombre") && prioridad.equals("Prioridad") && estado.equals("Estado")) ){
            rellenarTabla(lista);
            table.setDefaultRenderer(Object.class, new TareaRenderer(lista));
        }
        else{
            buscarTarea();
        }
    }
   
    /**
    * Vacía la tabla eliminando todas las filas existentes.
    */
    public void vaciarTabla(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        if(rowCount>0){
            // Eliminar filas desde la última hacia la primera
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
        }
    }
    
    /**
    * Rellena la tabla con una lista de tareas proporcionada.
    * 
    * @param lista La lista de tareas a mostrar en la tabla.
    */
    private void rellenarTabla(ArrayList<Tarea> lista) {
    // Iteramos sobre el ArrayList usando su tamaño (size())
        for (int aux = 0; aux < lista.size(); aux++) {
        // Accedemos al usuario actual usando lista.get(aux)
        
            Object[] newRow = new Object[] {
                lista.get(aux).getNumeroTarea(),     
                lista.get(aux).getNombre(), 
                lista.get(aux).getPrioridad(),
                lista.get(aux).getEstado(),
                null                         // Campo adicional (puede ser un botón u otro dato)
                };

            // Llamamos al método para agregar la fila con acción (posiblemente un botón)
            addRowWithActionButtons(newRow);
        }
    }
    
    /**
    * Filtra las tareas de acuerdo con los criterios proporcionados como texto de búsqueda, usuario seleccionado, 
    * prioridad seleccionada y estado seleccionado.
    * 
    * @param textoBusqueda El texto de búsqueda que el usuario ha ingresado.
    * @param usuarioSeleccionado El usuario seleccionado para filtrar las tareas.
    * @param prioridadSeleccionada La prioridad seleccionada para filtrar las tareas.
    * @param estadoSeleccionado El estado seleccionado para filtrar las tareas.
    * @param lista La lista de tareas que se va a filtrar.
    * @return Una lista de tareas que coinciden con los filtros aplicados.
    */
    public ArrayList<Tarea> filtrarTareas(String textoBusqueda,String usuarioSeleccionado, String prioridadSeleccionada, String estadoSeleccionado, ArrayList<Tarea> lista) {
        ArrayList<Tarea> listaBusqueda = new ArrayList<>();

        // Recorremos la lista original de tareas
        for (Tarea tarea : lista) {
            boolean coincide = true;

            // Filtramos por el texto del TextField (nombre o usuario)
            if (!textoBusqueda.equals("Buscar por nombre") && !textoBusqueda.isEmpty()) {
                String textoLower = textoBusqueda.toLowerCase();
                boolean nombreCoincide = tarea.getNombre().toLowerCase().contains(textoLower);
                if (!(nombreCoincide)) {
                    coincide = false;
                }
            }

            if (!usuarioSeleccionado.equals("Usuarios") && coincide) {
                if (!tarea.getUsuarioAsignado().equals(usuarioSeleccionado)) {
                    coincide = false;
                }
            }
            
            // Filtramos por la prioridad seleccionada
            if (!prioridadSeleccionada.equals("Prioridad") && coincide) {
                if (!tarea.getPrioridad().equals(prioridadSeleccionada)) {
                    coincide = false;
                }
            }

            // Filtramos por el estado seleccionado
            if (!estadoSeleccionado.equals("Estado") && coincide) {
                if (!tarea.getEstado().equals(estadoSeleccionado)) {
                    coincide = false;
                }
            }

            // Si la tarea coincide con todos los filtros, la agregamos a la lista de resultados
            if (coincide) {
                listaBusqueda.add(tarea);
            }
        }

        return listaBusqueda;
    }
    
    /**
    * Realiza la búsqueda de tareas según los criterios seleccionados por el usuario.
    * Filtra las tareas y actualiza la tabla con los resultados.
    */
    public void buscarTarea() {
        prioridad=(String) CBPrioridad.getSelectedItem();
        estado=(String) CBEstado.getSelectedItem();
        nombre=TFBuscar.getText();
        usuario=(String) CBUsuario.getSelectedItem();

        if(estado.equals("Todo"))
            estado="Estado";
        if(prioridad.equals("Todo"))
            prioridad="Prioridad";
        if(usuario.equals("Todo"))
            usuario="Usuarios";
            
            vaciarTabla(); // Actualiza la variable de prioridad
            Tarea auxiliar=new Tarea();
            lista=auxiliar.ListaTareas(direcTareas);
            listaBuscar.clear(); 
            listaBuscar=filtrarTareas(nombre,usuario,prioridad,estado,lista);
            
            if(!listaBuscar.isEmpty()){
                for(int aux=0;aux<listaBuscar.size(); aux++){
                    Object[] newRow = new Object[] { listaBuscar.get(aux).getNumeroTarea(), listaBuscar.get(aux).getNombre(), listaBuscar.get(aux).getPrioridad(), listaBuscar.get(aux).getEstado(), null };
                    addRowWithActionButtons(newRow);
                }
                
                table.setDefaultRenderer(Object.class, new TareaRenderer(listaBuscar)); 
            }else{
                JOptionPane.showMessageDialog(null, "No existen tareas con esta informacion");
                rellenarTabla(lista);
                table.setDefaultRenderer(Object.class, new TareaRenderer(lista)); 
                TFBuscar.setText("Buscar por nombre");
                CBPrioridad.setSelectedItem("Prioridad");
                CBEstado.setSelectedItem("Estado");
                CBUsuario.setSelectedItem("Usuarios");
            }
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
        BTBuscar = new PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblEsq = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        TFBuscar = new javax.swing.JTextField();
        CBEstado = new javax.swing.JComboBox<>();
        CBPrioridad = new javax.swing.JComboBox<>();
        BTReiniciar = new PanelRound();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        CBUsuario = new javax.swing.JComboBox<>();
        BTVaciar = new PanelRound();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        BTCrearTarea = new PanelRound();
        jLabel15 = new javax.swing.JLabel();

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

        BTBuscar.setBackground(new java.awt.Color(237, 181, 94));
        BTBuscar.setRoundBottomRight(25);
        BTBuscar.setRoundTopRight(25);
        BTBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTBuscarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTBuscarMousePressed(evt);
            }
        });
        BTBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar");
        BTBuscar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        Pantalla.add(BTBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 110, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(25, 35, 60));
        jLabel12.setText("Tareas Actuales");
        Pantalla.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 340, 50));
        Pantalla.add(lblEsq, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 40, 40));

        jSeparator3.setForeground(new java.awt.Color(25, 35, 60));
        Pantalla.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 680, 10));

        TFBuscar.setBackground(new java.awt.Color(237, 181, 94));
        TFBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TFBuscar.setForeground(new java.awt.Color(255, 255, 255));
        TFBuscar.setText("Buscar por nombre");
        TFBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TFBuscarMousePressed(evt);
            }
        });
        Pantalla.add(TFBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 500, 40));

        CBEstado.setBackground(new java.awt.Color(25, 35, 60));
        CBEstado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CBEstado.setForeground(new java.awt.Color(255, 255, 255));
        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Todo", "Por hacer", "En progreso", "Completada" }));
        CBEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBEstadoItemStateChanged(evt);
            }
        });
        Pantalla.add(CBEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 140, -1));

        CBPrioridad.setBackground(new java.awt.Color(25, 35, 60));
        CBPrioridad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CBPrioridad.setForeground(new java.awt.Color(255, 255, 255));
        CBPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridad", "Todo", "Baja", "Media", "Alta" }));
        CBPrioridad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBPrioridadItemStateChanged(evt);
            }
        });
        CBPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPrioridadActionPerformed(evt);
            }
        });
        Pantalla.add(CBPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, -1));

        BTReiniciar.setBackground(new java.awt.Color(237, 181, 94));
        BTReiniciar.setRoundBottomLeft(25);
        BTReiniciar.setRoundBottomRight(25);
        BTReiniciar.setRoundTopLeft(25);
        BTReiniciar.setRoundTopRight(25);
        BTReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTReiniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTReiniciarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTReiniciarMousePressed(evt);
            }
        });
        BTReiniciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Reiniciar");
        BTReiniciar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        Pantalla.add(BTReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, 110, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Prioridad", "Estado", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);

        Pantalla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 650, 290));

        CBUsuario.setBackground(new java.awt.Color(25, 35, 60));
        CBUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CBUsuario.setForeground(new java.awt.Color(255, 255, 255));
        CBUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuarios", "Todo" }));
        CBUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBUsuarioItemStateChanged(evt);
            }
        });
        Pantalla.add(CBUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 140, -1));

        BTVaciar.setBackground(new java.awt.Color(237, 181, 94));
        BTVaciar.setRoundBottomLeft(25);
        BTVaciar.setRoundBottomRight(25);
        BTVaciar.setRoundTopLeft(25);
        BTVaciar.setRoundTopRight(25);
        BTVaciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTVaciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTVaciarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTVaciarMousePressed(evt);
            }
        });
        BTVaciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Las Tareas");
        BTVaciar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Borrar Todas");
        BTVaciar.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 20));

        Pantalla.add(BTVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 130, 40));

        BTCrearTarea.setBackground(new java.awt.Color(237, 181, 94));
        BTCrearTarea.setRoundBottomLeft(25);
        BTCrearTarea.setRoundBottomRight(25);
        BTCrearTarea.setRoundTopLeft(25);
        BTCrearTarea.setRoundTopRight(25);
        BTCrearTarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTCrearTareaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTCrearTareaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTCrearTareaMousePressed(evt);
            }
        });
        BTCrearTarea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Crear Tarea");
        BTCrearTarea.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 0, 100, 40));

        Pantalla.add(BTCrearTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 130, 40));

        getContentPane().add(Pantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 870, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBPrioridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBPrioridadActionPerformed

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
    * Evento que se dispara cuando el usuario hace clic en el campo de texto para buscar tareas (TFBuscar).
    * Si el campo de texto contiene el texto por defecto ("Buscar por nombre"), se borra para permitir que el 
    * usuario ingrese su propia búsqueda.
    * 
    * @param evt El evento MouseEvent que genera el clic en el campo de texto.
    */
    private void TFBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFBuscarMousePressed
        if(TFBuscar.getText().equals("Buscar por nombre")){
            TFBuscar.setText("");
        }
    }//GEN-LAST:event_TFBuscarMousePressed

    private void BTBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMouseEntered
        Color color = new Color(214,80,68);
        BTBuscar.setBackground(color);
    }//GEN-LAST:event_BTBuscarMouseEntered

    private void BTBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMouseExited
        Color color = new Color(237,181,94);
        BTBuscar.setBackground(color);
    }//GEN-LAST:event_BTBuscarMouseExited

    private void BTBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMousePressed
        buscarTarea();
    }//GEN-LAST:event_BTBuscarMousePressed

    private void BTReiniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMouseEntered
        Color color = new Color(214,80,68);
        BTReiniciar.setBackground(color);
    }//GEN-LAST:event_BTReiniciarMouseEntered

    private void BTReiniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMouseExited
        Color color = new Color(237,181,94);
        BTReiniciar.setBackground(color);
    }//GEN-LAST:event_BTReiniciarMouseExited

    /**
    * Evento que se dispara cuando el usuario hace clic en el botón de reiniciar la búsqueda de tareas (BTReiniciar).
    * Este método vacía la tabla, la vuelve a llenar con todas las tareas disponibles y reinicia los campos de búsqueda
    * a sus valores predeterminados.
    * 
    * @param evt El evento MouseEvent que genera el clic en el botón de reiniciar.
    */
    private void BTReiniciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMousePressed
        vaciarTabla();
        rellenarTabla(lista);
        table.setDefaultRenderer(Object.class, new TareaRenderer(lista));
        TFBuscar.setText("Buscar por nombre");
        CBPrioridad.setSelectedItem("Prioridad");
        CBEstado.setSelectedItem("Estado");
        CBUsuario.setSelectedItem("Usuarios");
        usuario="";
        estado="";
        nombre="";
        prioridad="";
    }//GEN-LAST:event_BTReiniciarMousePressed

    /**
    * Evento que se dispara cuando se cambia la selección del JComboBox de Prioridad (CBPrioridad).
    * Este método se utiliza para ejecutar la búsqueda de tareas filtradas cada vez que se selecciona una nueva opción
    * en el JComboBox de Prioridad.
    * 
    * @param evt El evento ItemEvent que ocurre cuando se cambia la selección en el JComboBox de Prioridad.
    */
    private void CBPrioridadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBPrioridadItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            buscarTarea();
        }
    }//GEN-LAST:event_CBPrioridadItemStateChanged

    /**
    * Evento que se dispara cuando se cambia la selección del JComboBox de Estado (CBEstado).
    * Este método se utiliza para ejecutar la búsqueda de tareas filtradas cada vez que se selecciona una nueva opción
    * en el JComboBox de Estado.
    * 
    * @param evt El evento ItemEvent que ocurre cuando se cambia la selección en el JComboBox de Estado.
    */
    private void CBEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBEstadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            buscarTarea();
        }
    }//GEN-LAST:event_CBEstadoItemStateChanged

    /**
    * Evento que se dispara cuando se cambia la selección del JComboBox de Usuario (CBUsuario).
    * Este método se utiliza para ejecutar la búsqueda de tareas filtradas cada vez que se selecciona una nueva opción
    * en el JComboBox de Usuario.
    * 
    * @param evt El evento ItemEvent que ocurre cuando se cambia la selección en el JComboBox de Usuario.
    */
    private void CBUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBUsuarioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            buscarTarea();
        }
    }//GEN-LAST:event_CBUsuarioItemStateChanged

    private void BTVaciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTVaciarMouseEntered
        Color color = new Color(214,80,68);
        BTVaciar.setBackground(color);
    }//GEN-LAST:event_BTVaciarMouseEntered

    private void BTVaciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTVaciarMouseExited
        Color color = new Color(237,181,94);
        BTVaciar.setBackground(color);
    }//GEN-LAST:event_BTVaciarMouseExited

    /**
    * Evento que se dispara cuando se presiona el botón para vaciar todas las tareas.
    * Este método elimina todas las tareas de la lista, tanto de la lista interna como de los archivos
    * correspondientes. Luego, actualiza la tabla, restablece los campos de búsqueda y muestra un mensaje 
    * confirmando que todas las tareas han sido eliminadas.
    * 
    * @param evt El evento MouseEvent que ocurre cuando se presiona el botón para vaciar todas las tareas.
    */
    private void BTVaciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTVaciarMousePressed
        Tarea aux=new Tarea();
        for(int ind=0; ind<lista.size();ind++){
            String direcArchivo=direcTareas+"\\"+lista.get(ind).getNumeroTarea()+".txt";
            aux.eliminarTarea(direcArchivo,lista.get(ind),fileListaTareas,direcTareas);
        }
        JOptionPane.showMessageDialog(null, "Todas las tareas han sido eliminadas");
        setLista();
        TFBuscar.setText("Buscar por nombre");
        CBPrioridad.setSelectedItem("Prioridad");
        CBEstado.setSelectedItem("Estado");
        CBUsuario.setSelectedItem("Usuarios");
    }//GEN-LAST:event_BTVaciarMousePressed

    private void BTCrearTareaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTCrearTareaMouseEntered
        Color color = new Color(214,80,68);
        BTCrearTarea.setBackground(color);
    }//GEN-LAST:event_BTCrearTareaMouseEntered

    private void BTCrearTareaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTCrearTareaMouseExited
        Color color = new Color(237,181,94);
        BTCrearTarea.setBackground(color);
    }//GEN-LAST:event_BTCrearTareaMouseExited

    private void BTCrearTareaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTCrearTareaMousePressed
        CrearTarea ventana = new CrearTarea();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BTCrearTareaMousePressed

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
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TareasActuales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TareasActuales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TareasActuales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TareasActuales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        */
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TareasActuales().setVisible(true);
            }
        });
    }
    
    /**
    * Agrega una nueva fila a la tabla con los datos proporcionados en el parámetro 
    * y asocia botones de acción (editar, eliminar, ver) en la última columna de la tabla.
    * Los botones permiten realizar acciones sobre las tareas asociadas a esa fila.
    * 
    * @param rowData Un arreglo de objetos que contiene los datos que se agregarán a la fila.
    *               Este arreglo se usa para llenar las celdas de la fila de la tabla.
    */
    private void addRowWithActionButtons(Object[] rowData) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    // Aquí agregamos la fila con los datos regulares
    model.addRow(rowData);
    
    // Ahora configuramos el editor y el renderer para la columna de acciones, para que contenga los botones
    TableActionEvent event = new TableActionEvent() {
        @Override
        public void onEdit(int row) {
            System.out.println("Edit row : " + row);
            
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int columnCount = model.getColumnCount();
                Object[] rowData = new Object[columnCount];

                System.out.println("\n Usuarios datos");
                for (int col = 0; col < columnCount; col++) {
                    rowData[col] = model.getValueAt(selectedRow, col);
                    System.out.println(rowData[col]);
                }

                Integer value = (Integer) rowData[0];
                int intValue = value.intValue();
                    // los valores de la fila en el arreglo rowData
                    //System.out.println(Arrays.toString(rowData));
                Tarea editar=new Tarea();
                    
                    // Ahora tienes todos los valores de la fila en el arreglo rowData
                editar.setNumeroTarea(intValue);
                editar.setNombre((String) rowData[1]);
                editar=obtenerTarea(editar);
                System.out.println(Arrays.toString(rowData));
                    
                EditarTarea ventana= new EditarTarea(TareasActuales.this);
                ventana.listaTareas(lista);
                ventana.setIndice(indice);
                ventana.setVisible(true);
                
                }
        }

        @Override
        public void onDelete(int row) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int columnCount = model.getColumnCount();
                Object[] rowData = new Object[columnCount];

                System.out.println("\n Usuarios datos");
                for (int col = 0; col < columnCount; col++) {
                    rowData[col] = model.getValueAt(selectedRow, col);
                    System.out.println(rowData[col]);
                }

                Integer value = (Integer) rowData[0];
                int intValue = value.intValue();
                    // los valores de la fila en el arreglo rowData
                System.out.println(Arrays.toString(rowData));
                Tarea borrar=new Tarea();
                    
                    // Ahora tienes todos los valores de la fila en el arreglo rowData
                borrar.setNumeroTarea(intValue);
                borrar.setNombre((String) rowData[1]);
                borrar=obtenerTarea(borrar);
                System.out.println(Arrays.toString(rowData));
                
                String direcArchivo=direcTareas+"\\"+borrar.getNumeroTarea()+".txt";
                borrar.eliminarTarea(direcArchivo,borrar,fileListaTareas,direcTareas);
            }
            
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(row);
            Tarea aux= new Tarea();
            File direcListaTareas = new File(fileListaTareas);
            lista=aux.ListaTareas(direcTareas);
            cont=lista.size();
            JOptionPane.showMessageDialog(null, "Tarea Eliminada");
        }

        @Override
        public void onView(int row) {
            System.out.println("View row : " + row);
            
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int columnCount = model.getColumnCount();
                Object[] rowData = new Object[columnCount];

                System.out.println("\n Usuarios datos");
                for (int col = 0; col < columnCount; col++) {
                    rowData[col] = model.getValueAt(selectedRow, col);
                    System.out.println(rowData[col]);
                }

                Integer value = (Integer) rowData[0];
                int intValue = value.intValue();
                    // los valores de la fila en el arreglo rowData
                    //System.out.println(Arrays.toString(rowData));
                Tarea mostrar=new Tarea();
                    
                    // Ahora tienes todos los valores de la fila en el arreglo rowData
                mostrar.setNumeroTarea(intValue);
                mostrar.setNombre((String) rowData[1]);
                mostrar=obtenerTarea(mostrar);
                System.out.println(Arrays.toString(rowData));
                    
                DetallesTarea ventana= new DetallesTarea();
                ventana.setTarea(mostrar);
                ventana.setVisible(true);
                }
        }
    };

    // Asignar el editor y renderer a la columna de acciones (en este caso, columna índice 3)
    table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
    table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PanelRound BTBuscar;
    private PanelRound BTCrearTarea;
    private PanelRound BTReiniciar;
    private PanelRound BTVaciar;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JComboBox<String> CBPrioridad;
    private javax.swing.JComboBox<String> CBUsuario;
    private javax.swing.JLabel ImagenUsuario;
    private PanelRound Menu;
    private PanelRound PR_Historial;
    private PanelRound PR_Inicio;
    private PanelRound PR_MisTareas;
    private PanelRound PR_Perfil;
    private PanelRound PR_Salir;
    private PanelRound PR_TareasActuales;
    private PanelRound PR_Usuarios;
    private PanelRound Pantalla;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblEsq;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblMisTareas;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTareasActuales;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}