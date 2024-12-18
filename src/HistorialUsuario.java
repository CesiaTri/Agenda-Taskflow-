import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven_cell.TableActionCellEditor;
import raven_cell.TableActionCellRender;
import raven_cell.TableActionEvent;

/**
 * Esta clase representa una ventana que muestra el historial de tareas de un usuario.
 * Permite visualizar, buscar y filtrar tareas en función de diferentes criterios como nombre, prioridad o estado.
 * 
 * La clase también gestiona la carga de tareas asociadas a un usuario específico y proporciona métodos para manipular las tareas y su visualización.
 */
public class HistorialUsuario extends javax.swing.JFrame {

    /**
    * Instancia de la clase Escalar para ajustar imágenes en la interfaz gráfica.
    */
    Escalar escalar = new Escalar();

    /**
    * Representa al usuario actual que está utilizando la aplicación.
    */
    private Usuario UsuarioActual = new Usuario();

    /**
    * Ruta del directorio del usuario en el sistema de archivos.
    */
    private String userHome = "C:\\Users\\Cesia\\Desktop";

    /**
    * Ruta para el archivo de tareas del usuario específico.
    */
    private String fileListaTareas = userHome + "\\Taskflow\\Tareas\\Usuario";

    /**
    * Ruta para el directorio donde se almacenan las tareas del usuario.
    */
    private String direcTareas = userHome + "\\Taskflow\\Tareas\\Usuario";

    /**
    * Lista que contiene todas las tareas del usuario.
    */
    public ArrayList<Tarea> lista;

    /**
    * Lista utilizada para almacenar las tareas filtradas según ciertos criterios
    * (nombre, prioridad, estado). Permite realizar búsquedas dentro de la lista de tareas.
    */
    public ArrayList<Tarea> listaBuscar = new ArrayList<>();

    /**
    * Filtro para buscar tareas por nombre.
    */
    public String nombre = "";

    /**
    * Filtro para buscar tareas por prioridad.
    */
    public String prioridad = "";

    /**
    * Filtro para buscar tareas por estado.
    */
    public String estado = "";

    /**
    * Índice actual de la tarea seleccionada en la lista de tareas.
    */
    public int indice = 0;

    /**
    * Contador para realizar un seguimiento de las tareas o resultados en el historial.
    */
    public int cont = 0;
    
    /**
    * Constructor de la clase HistorialUsuario.
    * Inicializa los componentes de la interfaz gráfica, ajusta las imágenes en las etiquetas correspondientes,
    * carga el usuario actual, configura las rutas de los archivos de tareas y filtra las tareas completadas
    * para mostrarlas en la tabla de historial.
    */
    public HistorialUsuario() {
        initComponents();
        
        setLocationRelativeTo(null);
        escalar.escalarLabel(jLabel1, "\\imagenes\\logo.png");
        escalar.escalarLabel(ImagenUsuario, "\\imagenes\\usuario.png");
        escalar.escalarLabel(lblInicio, "\\imagenes\\Inicio.png");
        escalar.escalarLabel(lblPerfil, "\\imagenes\\Perfil.png");
        escalar.escalarLabel(lblMisTareas, "\\imagenes\\MisTareas.png");
        escalar.escalarLabel(lblHistorial, "\\imagenes\\Historial.png");
        escalar.escalarLabel(lblSalir, "\\imagenes\\Salir.png");
        escalar.escalarLabel(lblEsq, "\\imagenes\\esquina1.png");
        escalar.escalarLabel(lblTareasActuales, "\\imagenes\\TareasActuales.png");
        
        UsuarioActual=UsuarioActual.obtenerUsuarioActual();
        lblNombreUsuario.setText(UsuarioActual.getUsuario());
        
        fileListaTareas=fileListaTareas+UsuarioActual.getId()+"\\ListaTareas.txt";
        direcTareas=direcTareas+UsuarioActual.getId();
        
        Tarea aux= new Tarea();
        File direcListaTareas = new File(fileListaTareas);
        lista=aux.ListaTareas(direcTareas);
        
        ArrayList<Tarea> auxiliar=new ArrayList<Tarea>();
        for (int a=0;a<lista.size();a++){
            if(lista.get(a).getEstado().equals("Completada"))
                auxiliar.add(lista.get(a));
        }
        lista.clear();
        lista=new ArrayList<Tarea>(auxiliar);
        
        cont=lista.size();
        
        File carpeta=new File(direcTareas);
        if (carpeta.exists() && carpeta.isDirectory())
            rellenarTabla(lista);
    }
    
    /**
    * Obtiene una tarea específica de la lista de tareas.
    * Compara el número de tarea y el nombre de la tarea proporcionada con las tareas en la lista.
    * Si encuentra una coincidencia, devuelve la tarea correspondiente y actualiza el índice de la tarea seleccionada.
    *
    * @param buscar La tarea que se desea buscar en la lista, basada en el número y nombre de tarea.
    * @return La tarea encontrada que coincide con los criterios de búsqueda, o una nueva tarea si no se encuentra.
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
    * Establece la lista de tareas, filtrando aquellas que están marcadas como "Completada".
    * Actualiza el contador de tareas completadas, vacía la tabla de la interfaz y luego rellena
    * la tabla con las tareas filtradas o realiza una búsqueda según los filtros aplicados.
    */
    public void setLista(){
        ArrayList<Tarea> auxiliar=new ArrayList<Tarea>();
        for (int a=0;a<lista.size();a++){
            if(lista.get(a).getEstado().equals("Completada"))
                auxiliar.add(lista.get(a));
        }
        lista.clear();
        lista=new ArrayList<Tarea>(auxiliar);
        
        cont=lista.size();
        
        vaciarTabla();
        if((nombre.equals("") && prioridad.equals("") && estado.equals("")) || (nombre.equals("Buscar por nombre") && prioridad.equals("Prioridad") && estado.equals("Estado")) )
            rellenarTabla(lista);
        else
            buscarTarea();
    }
    
    /**
    * Vacía todas las filas de la tabla en la interfaz de usuario.
    * Elimina las filas de la tabla comenzando desde la última hacia la primera.
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
    * Rellena la tabla con los datos de la lista de tareas.
    * Itera sobre la lista de tareas y agrega una fila en la tabla por cada tarea.
    * Se utiliza un modelo de tabla personalizado con un renderizador para mostrar las tareas.
    * 
    * @param lista Lista de tareas que se desea mostrar en la tabla.
    */
    private void rellenarTabla(ArrayList<Tarea> lista) {
    // Iteramos sobre el ArrayList usando su tamaño (size())
        for (int aux = 0; aux < lista.size(); aux++) {
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
        table.setDefaultRenderer(Object.class, new TareaRenderer2(lista));
    }
    
    /**
    * Filtra las tareas según los criterios de búsqueda proporcionados: texto de búsqueda, prioridad y estado.
    * Recorre la lista de tareas y agrega aquellas que coinciden con los filtros a una nueva lista.
    * 
    * @param textoBusqueda El texto de búsqueda para filtrar las tareas por nombre.
    * @param prioridadSeleccionada La prioridad seleccionada para filtrar las tareas.
    * @param estadoSeleccionado El estado seleccionado para filtrar las tareas.
    * @param lista La lista de tareas a filtrar.
    * @return Una lista con las tareas que coinciden con los criterios de búsqueda.
    */
    public ArrayList<Tarea> filtrarTareas(String textoBusqueda, String prioridadSeleccionada, String estadoSeleccionado, ArrayList<Tarea> lista) {
        ArrayList<Tarea> listaBusqueda = new ArrayList<Tarea>();

        // Recorremos la lista original de tareas
        for (Tarea tarea : lista) {
            boolean coincide = true;

            
            if (textoBusqueda != null && !textoBusqueda.trim().isEmpty() && !textoBusqueda.equals("Buscar por nombre")) {
                String textoLower = textoBusqueda.toLowerCase();
                boolean nombreCoincide = tarea.getNombre().toLowerCase().contains(textoLower);
                if (!nombreCoincide) {
                    coincide = false;
                }
            }

            // Filtramos por la prioridad seleccionada
            if (!prioridadSeleccionada.equals("Prioridad") && coincide) {
                if (!tarea.getPrioridad().equals(prioridadSeleccionada)) {
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
    * Realiza la búsqueda de tareas aplicando los filtros de nombre y prioridad.
    * Actualiza la tabla con los resultados de la búsqueda o muestra un mensaje si no se encuentran tareas.
    * 
    * Se limpia la tabla, se filtran las tareas con los criterios actuales y se vuelve a llenar la tabla con las tareas encontradas.
    * Si no hay tareas que coincidan, se muestra un mensaje de error y se rellena la tabla con todas las tareas.
    */
    public void buscarTarea() {
        prioridad=(String) CBPrioridad.getSelectedItem();
        nombre=TFBuscar.getText();

        vaciarTabla(); // Actualiza la variable de prioridad
        
        listaBuscar.clear(); 
        listaBuscar=filtrarTareas(nombre,prioridad,estado,lista);
            
            if(!listaBuscar.isEmpty()){
                for(int aux=0;aux<listaBuscar.size(); aux++){
                    Object[] newRow = new Object[] { listaBuscar.get(aux).getNumeroTarea(), listaBuscar.get(aux).getNombre(), listaBuscar.get(aux).getPrioridad(), listaBuscar.get(aux).getEstado(), null };
                    addRowWithActionButtons(newRow);
                }
                table.setDefaultRenderer(Object.class, new TareaRenderer2(lista));
            }else{
                JOptionPane.showMessageDialog(null, "No existen tareas con esta informacion");
                rellenarTabla(lista);
                TFBuscar.setText("Buscar por nombre");
                CBPrioridad.setSelectedItem("Prioridad");
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
        PR_TareasActuales = new PanelRound();
        lblTareasActuales = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Pantalla = new PanelRound();
        BTBuscar = new PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblEsq = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        TFBuscar = new javax.swing.JTextField();
        CBPrioridad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        BTReiniciar = new PanelRound();
        jLabel13 = new javax.swing.JLabel();

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

        Menu.add(PR_MisTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 50));

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

        Menu.add(PR_Historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 50));

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

        Pantalla.add(BTBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 110, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(25, 35, 60));
        jLabel12.setText("Historial");
        Pantalla.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 340, 50));
        Pantalla.add(lblEsq, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 50, 40));

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
        Pantalla.add(TFBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 500, 40));

        CBPrioridad.setBackground(new java.awt.Color(25, 35, 60));
        CBPrioridad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CBPrioridad.setForeground(new java.awt.Color(255, 255, 255));
        CBPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridad", "Baja", "Media", "Alta" }));
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
        Pantalla.add(CBPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo", "Estado", ""
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

        Pantalla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 650, 360));

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

        Pantalla.add(BTReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, 110, 40));

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
        PerfilUsuario ventana = new PerfilUsuario();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_PerfilMousePressed

    private void PR_MisTareasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMouseEntered
        Color color = new Color(237,181,94);
        PR_MisTareas.setBackground(color);
    }//GEN-LAST:event_PR_MisTareasMouseEntered

    private void PR_MisTareasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMouseExited
        Color color = new Color(25,35,60);
        PR_MisTareas.setBackground(color);
    }//GEN-LAST:event_PR_MisTareasMouseExited

    private void PR_MisTareasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_MisTareasMousePressed
        MisTareasUsuario ventana = new MisTareasUsuario();
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
        InicioUsuario ventana = new InicioUsuario();
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
        HistorialUsuario ventana = new HistorialUsuario();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_HistorialMousePressed

    private void PR_TareasActualesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMouseEntered
        Color color = new Color(237,181,94);
        PR_TareasActuales.setBackground(color);
    }//GEN-LAST:event_PR_TareasActualesMouseEntered

    private void PR_TareasActualesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMouseExited
        Color color = new Color(25,35,60);
        PR_TareasActuales.setBackground(color);
    }//GEN-LAST:event_PR_TareasActualesMouseExited

    private void PR_TareasActualesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PR_TareasActualesMousePressed
        TareasActualesUsuario ventana = new TareasActualesUsuario();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PR_TareasActualesMousePressed

    private void BTReiniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMouseEntered
        Color color = new Color(214,80,68);
        BTReiniciar.setBackground(color);
    }//GEN-LAST:event_BTReiniciarMouseEntered

    private void BTReiniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMouseExited
        Color color = new Color(237,181,94);
        BTReiniciar.setBackground(color);
    }//GEN-LAST:event_BTReiniciarMouseExited

    /**
    * Maneja el evento de presionar el botón de reiniciar.
    * Este método limpia la tabla de la interfaz, vuelve a cargar las tareas completas
    * y restablece los filtros de búsqueda a sus valores predeterminados.
    * 
    * @param evt El evento de mouse que se dispara al presionar el botón de reiniciar.
    */
    private void BTReiniciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTReiniciarMousePressed
        vaciarTabla();
        rellenarTabla(lista);
        TFBuscar.setText("Buscar por nombre");
        CBPrioridad.setSelectedItem("Prioridad");
        nombre="";
        prioridad="";
    }//GEN-LAST:event_BTReiniciarMousePressed

    private void BTBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMouseEntered
        Color color = new Color(214,80,68);
        BTBuscar.setBackground(color);
    }//GEN-LAST:event_BTBuscarMouseEntered

    private void BTBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMouseExited
        Color color = new Color(237,181,94);
        BTBuscar.setBackground(color);
    }//GEN-LAST:event_BTBuscarMouseExited

    /**
    * Maneja el evento de presionar el botón de búsqueda.
    * Este método llama a la función `buscarTarea` para realizar la búsqueda de tareas
    * según los filtros seleccionados.
    * 
    * @param evt El evento de mouse que se dispara al presionar el botón de búsqueda.
    */
    private void BTBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTBuscarMousePressed
        buscarTarea();
    }//GEN-LAST:event_BTBuscarMousePressed

    /**
    * Maneja el evento de presionar el campo de texto de búsqueda.
    * Si el texto en el campo de búsqueda es el valor predeterminado "Buscar por nombre",
    * se limpia el campo para permitir la entrada del usuario.
    * 
    * @param evt El evento de mouse que se dispara al presionar el campo de texto de búsqueda.
    */
    private void TFBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFBuscarMousePressed
        if(TFBuscar.getText().equals("Buscar por nombre")){
            TFBuscar.setText("");
        }
    }//GEN-LAST:event_TFBuscarMousePressed

    /**
    * Maneja el evento de cambio de selección en el combo box de prioridad.
    * Este método llama a la función `buscarTarea` para realizar la búsqueda de tareas
    * según el valor seleccionado en el combo box de prioridad.
    * 
    * @param evt El evento que se dispara cuando el estado del item del combo box cambia.
    */
    private void CBPrioridadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBPrioridadItemStateChanged
        buscarTarea();
    }//GEN-LAST:event_CBPrioridadItemStateChanged

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
            java.util.logging.Logger.getLogger(HistorialUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialUsuario().setVisible(true);
            }
        });
    }
    
    /**
    * Agrega una nueva fila con datos regulares y botones de acción (editar, eliminar, ver) 
    * a la tabla. Además, configura los eventos de acción asociados con las filas de la tabla.
    * 
    * @param rowData Los datos de la fila que se agregan a la tabla. Este arreglo de objetos contiene
    *                la información que se mostrará en las celdas de la fila.
    */
    private void addRowWithActionButtons(Object[] rowData) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    // Aquí agregamos la fila con los datos regulares
    model.addRow(rowData);
    
    // Ahora configuramos el editor y el renderer para la columna de acciones, para que contenga los botones
    TableActionEvent event = new TableActionEvent() {
        @Override
        public void onEdit(int row) {
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
                    
                EditarTareaCompletadaUsuario ventana= new EditarTareaCompletadaUsuario(HistorialUsuario.this);
                ventana.listaTareas(lista);
                ventana.setIndice(indice);
                ventana.setVisible(true);
                }
            setLista();
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
            
            setLista();
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
                    
                DetallesTareaPropia ventana= new DetallesTareaPropia();
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
    private PanelRound BTReiniciar;
    private javax.swing.JComboBox<String> CBPrioridad;
    private javax.swing.JLabel ImagenUsuario;
    private PanelRound Menu;
    private PanelRound PR_Historial;
    private PanelRound PR_Inicio;
    private PanelRound PR_MisTareas;
    private PanelRound PR_Perfil;
    private PanelRound PR_Salir;
    private PanelRound PR_TareasActuales;
    private PanelRound Pantalla;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}