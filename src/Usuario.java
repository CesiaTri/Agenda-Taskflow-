import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Representa a un usuario en el sistema, con su información básica y métodos 
 * para gestionar su registro, edición y eliminación en archivos.
 * Esta clase permite manejar las tareas asociadas al usuario y gestionar la persistencia 
 * de su información en un archivo de texto.
 */
public class Usuario {
    /** 
     * Identificador único del usuario. 
     */
    int id;

    /** 
     * Nombre de usuario.
     */
    String usuario;

    /** 
     * Contraseña del usuario. 
     */
    String contraseña;

    /** 
     * Ruta de la foto de perfil del usuario.
     */
    String fotoPerfil;

    /** 
     * Nivel de acceso del usuario.
     */
    String nivel;

    /**
     * Correo electrónico del usuario. 
     */
    String correo;

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor que inicializa un nuevo objeto Usuario con los parámetros proporcionados.
     *
     * @param id El identificador único del usuario.
     * @param usuario El nombre de usuario.
     * @param contraseña La contraseña del usuario.
     * @param correo El correo electrónico del usuario.
     */
    public Usuario(int id, String usuario, String contraseña, String correo) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fotoPerfil = "\\imagenes\\usuario.png";
        this.nivel = "base";
        this.correo = correo;
    }
    
    /**
     * Constructor que inicializa un nuevo objeto Usuario con los parámetros proporcionados.
     *
     * @param id El identificador único del usuario.
     * @param usuario El nombre de usuario.
     * @param contraseña La contraseña del usuario.
     * @param nivel El nivel de acceso del usuario.
     * @param correo El correo electrónico del usuario.
     */
    public Usuario (int id,String usuario,String contraseña, String nivel, String correo){
        this.id=id;
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.fotoPerfil="\\imagenes\\usuario.png";
        this.nivel=nivel;
        this.correo = correo;
    }
    
    /**
     * Constructor de copia que crea un nuevo usuario a partir de otro existente.
     *
     * @param aux El usuario del cual se copia la información.
     */
    public Usuario (Usuario aux){
        this.id=aux.getId();
        this.usuario=aux.getUsuario();
        this.contraseña=aux.getContraseña();
        this.fotoPerfil="\\imagenes\\usuario.png";
        this.nivel=aux.getNivel();
        this.correo = aux.getCorreo();
    }
    
    /**
     * Constructor que inicializa un nuevo objeto Usuario sin ID, 
     * con los parámetros proporcionados
     *
     * @param usuario El nombre de usuario.
     * @param contraseña La contraseña del usuario.
     * @param nivel El nivel de acceso del usuario.
     * @param correo El correo electrónico del usuario.
     */
    public Usuario (String usuario,String contraseña, String nivel, String correo){
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.fotoPerfil="\\imagenes\\usuario.png";
        this.nivel="base";
        this.correo = correo;
    }

    /**
     * Obtiene el identificador del usuario.
     * @return El id del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return El correo del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el nivel del usuario.
     * @return El nivel del usuario.
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Obtiene la foto de perfil del usuario.
     * @return La ruta de la foto de perfil del usuario.
     */
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    /**
     * Establece el identificador del usuario.
     * @param id El id del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correo El correo del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Establece el nivel del usuario.
     * @param nivel El nivel del usuario.
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Establece el nombre de usuario.
     * @param usuario El nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contraseña La contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Establece la foto de perfil del usuario.
     * @param fotoPerfil La ruta de la foto de perfil.
     */
    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    
    /**
     * Verifica si un usuario con el nombre proporcionado ya existe en el archivo.
     *
     * @param archivo El archivo en el que se buscará el usuario.
     * @param nombre El nombre de usuario a buscar.
     * @return true si el usuario existe en el archivo, false en caso contrario.
     */
    public boolean Usuario_Existe(File archivo,String nombre) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(" ");
                String nombreAct = datos[1];
                
                if (nombre.equals(nombreAct)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }
    
    /**
     * Lee todos los usuarios desde un archivo y los almacena en una lista.
     *
     * @param archivo El archivo desde el cual se leen los usuarios.
     * @return Una lista con los usuarios leídos del archivo.
     */
    public ArrayList<Usuario> listaUsuarios(File archivo) {
        ArrayList<Usuario> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(" "); 
                int id = Integer.parseInt(datos[0]);

                lista.add(new Usuario(id, datos[1], datos[2], datos[3], datos[4]));  
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lista;
    }
    
    /**
     * Registra un usuario en un archivo especificado.
     *
     * @param act El usuario a registrar.
     * @param direccion La dirección del archivo donde se guardará el usuario.
     */
    public void Registrar_Usuario(Usuario act,String direccion) {
        File direcUsuarios= new File(direccion);
        
        try (FileWriter writer = new FileWriter(direcUsuarios, true)) {
            writer.write(act.getId()+ " " +act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo() + "\n");
            System.out.println("Usuario registrado correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Elimina un usuario y sus tareas asociadas desde el sistema.
     *
     * @param userHome La ruta del directorio del usuario.
     * @param act El usuario a eliminar.
     */
    public void eliminarUsuario(String userHome, Usuario act) {
        File archivoUsuarios = new File(userHome + "\\Taskflow\\Usuarios.txt");
        File archivoTemporal = new File(userHome + "\\Taskflow\\auxiliar.txt");
        File archivoTareas = new File(userHome + "\\Taskflow\\Tareas\\Usuario" + act.getId());

        if (!eliminarCarpeta(archivoTareas)) {
            System.out.println("No se pudo eliminar la carpeta de tareas del usuario.");
        }

        try {
            if (archivoTemporal.createNewFile()) {
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo temporal.");
            e.printStackTrace();
        }

        String lineaABorrar = act.getId() + " " + act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoUsuarios));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String lineaActual;
            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaABorrar)) {
                    if(!lineaActual.equals("") && !lineaActual.isEmpty()){
                        escritor.write(lineaActual);
                        escritor.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al intentar eliminar al usuario.");
            e.printStackTrace();
        }

        if (archivoUsuarios.delete()){
            archivoTemporal.renameTo(archivoUsuarios);
            System.out.println("Usuarios.txt eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo de usuarios.txt");
            System.out.println("Resultado de delete(): " + archivoUsuarios.delete());
        }
        eliminarTareasDelUsuario(act, userHome);
    }

    /**
     * Modifica el nivel de un usuario en el archivo de usuarios.
     *
     * @param userHome La ruta del directorio del usuario.
     * @param ant El usuario con el nivel antiguo.
     * @param act El usuario con el nivel actualizado.
     */
    public void editarNivel(String userHome, Usuario ant, Usuario act) {
        File archivoUsuarios = new File(userHome + "\\Taskflow\\Usuarios.txt");
        File archivoTemporal = new File(userHome + "\\Taskflow\\auxiliar.txt");

        try {
            if (archivoTemporal.createNewFile()) {
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo temporal.");
            e.printStackTrace();
        }

        String lineaBuscar= ant.getId() + " " + ant.getUsuario() + " " + ant.getContraseña() + " " + ant.getNivel() + " " + ant.getCorreo();
        String lineaEditada= act.getId() + " " + act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo();
        System.out.println("linea a editar: "+lineaBuscar);
        System.out.println("linea nueva: "+lineaEditada);
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoUsuarios));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String lineaActual;
            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaBuscar)) {
                    if(!lineaActual.equals("") && !lineaActual.isEmpty()){
                        escritor.write(lineaActual);
                        escritor.newLine();
                        System.out.println(lineaActual);
                    }
                }else{
                    if(!lineaActual.equals("") && !lineaActual.isEmpty()){
                        escritor.write(lineaEditada);
                        escritor.newLine();
                        System.out.println(lineaEditada);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al intentar editar al usuario.");
            e.printStackTrace();
        }

        if (archivoUsuarios.delete()){
            archivoTemporal.renameTo(archivoUsuarios);
            System.out.println("Usuarios.txt eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo de usuarios.txt");
            System.out.println("Resultado de delete(): " + archivoUsuarios.delete());
        }
    }
    
    /**
     * Elimina las tareas asociadas a un usuario de su directorio.
     *
     * @param usuario El usuario cuyas tareas se eliminarán.
     * @param userHome La ruta del directorio del usuario.
     */
    private void eliminarTareasDelUsuario(Usuario usuario, String userHome) {
        String direcTareas = userHome + "\\Taskflow\\Tareas";
        ArrayList<Tarea> lista = new ArrayList<>(); 
        Tarea aux = new Tarea();

        lista = aux.ListaTareas(direcTareas);
        String direc=direcTareas;
        direcTareas=direcTareas+"\\";

        for (int a = 0; a < lista.size(); a++) {
            if (lista.get(a).getUsuarioAsignado().equals(usuario.getUsuario())) { 
                String direcTarea = direcTareas + lista.get(a).getNumeroTarea() + ".txt";
                String listaTareas = direcTareas + "ListaTareas.txt";
                aux.eliminarTarea(direcTarea, lista.get(a), listaTareas,direc);
            }
        }
    }
    
    /**
     * Elimina una carpeta y todos los archivos dentro de ella.
     *
     * @param carpeta La carpeta a eliminar.
     * @return true si la carpeta se elimina correctamente, false si ocurre un error.
     */
    public boolean eliminarCarpeta(File carpeta) {
        if (carpeta.exists() && carpeta.isDirectory()) {
            String[] archivos = carpeta.list();

            for (String archivo : archivos) {
                File archivoTemp = new File(carpeta, archivo);
                if (archivoTemp.isDirectory()) {
                    eliminarCarpeta(archivoTemp);
                } else {
                    archivoTemp.delete();
                }
            }
            return carpeta.delete(); 
        } else {
            System.out.println("La carpeta no existe o no es un directorio.");
            return false;
        }
    }
    
    /**
     * Modifica la información de un usuario en el archivo de usuarios.
     *
     * @param direcUsuarios La dirección del archivo de usuarios.
     * @param userHome La ruta del directorio del usuario.
     * @param act El usuario con la nueva información.
     * @param ant El usuario con la información antigua.
     */
    public void editarUsuario(String direcUsuarios,String userHome,Usuario act,Usuario ant){
        File archivoUsuarios=new File(direcUsuarios);
        File archivoTemporal = new File(userHome+"\\Taskflow\\auxiliar.txt");
        
        try {
            if (archivoTemporal.createNewFile()) {
                
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
        
        FileWriter escribir;
        PrintWriter linea;
        String lineaEditar =ant.getId()+" "+ ant.getUsuario()+" "+ant.getContraseña()+" "+ant.getNivel()+" "+ant.getCorreo();
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoUsuarios));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;

            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaEditar)) {
                    escritor.write(lineaActual);
                    escritor.newLine();
                }else{
                    escritor.write(act.getId()+ " " +act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo());
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();

            if (archivoUsuarios.delete()) {
                archivoTemporal.renameTo(archivoUsuarios);
                System.out.println("Línea borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar la línea del archivo.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar borrar la línea.");
            e.printStackTrace();
        }
        
        String tareasDir = userHome + "\\Taskflow\\Tareas\\";
        Tarea aux = new Tarea();
        ArrayList<Tarea> lista = aux.ListaTareas(tareasDir); 
        String listaTareasPath = tareasDir + "ListaTareas.txt";

        int totalTareas = aux.tareasTotal(listaTareasPath);

        for (int a = 0; a < totalTareas; a++) {
            if (lista.get(a).getUsuarioAsignado().equals(ant.getUsuario())) {
                Tarea temporal = lista.get(a);
                temporal.setUsuarioAsignado(act.getUsuario());
                String direcTareas = tareasDir + temporal.getNumeroTarea() + ".txt";
                aux.editarTarea(direcTareas, temporal, listaTareasPath, lista.get(a));
            }
        }
    }
    
    /**
     * Genera un nuevo ID para un usuario basado en el contenido del archivo.
     *
     * @param direccion La dirección del archivo donde se buscan los IDs.
     * @return Un nuevo ID para el usuario.
     */
    public int IDUsuarioNuevo(String direccion){
        int numero=0;
        File archivo=new File (direccion);
        String contenido="";
        Usuario aux=new Usuario();
        
        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while(contenido != null){
                String[] datos = contenido.split(" ");
                aux.setId(Integer.parseInt(datos[0]));
                numero=aux.getId();
                contenido = lectura.readLine();
            }
        } catch (IOException excepcion) {
            numero=0;
        }
        
        if(numero!=0)
            return numero+1;
        else
            return 1;
    }
    
    /**
     * Guarda la información del usuario actual en un archivo.
     *
     * @param act El usuario cuyo dato se va a guardar.
     */
    public void guardarUsuarioActual(Usuario act){
        String userHome = "C:\\Users\\Cesia\\Desktop";
        File usuarioAct = new File(userHome + "\\Taskflow\\UsuarioActual.txt");
        vaciarArchivo(userHome + "\\Taskflow\\UsuarioActual.txt");
        
        try (FileWriter writer = new FileWriter(usuarioAct, true)) {
            writer.write(act.getId()+ " " +act.getUsuario() + " " + act.getContraseña() + " " + act.getNivel() + " " + act.getCorreo() + "\n");
            System.out.println("Usuario registrado correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Vacía un archivo, eliminando todo su contenido.
     *
     * @param direc La dirección del archivo a vaciar.
     */
    public void vaciarArchivo(String direc){
         try {
            FileWriter fileWriter = new FileWriter(direc);
            
            fileWriter.close(); 
            System.out.println("Archivo vaciado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Obtiene el usuario actual desde un archivo de texto.
     *
     * @return El usuario actual.
     */
    public Usuario obtenerUsuarioActual(){
        String userHome = "C:\\Users\\Cesia\\Desktop";
        File usuarioAct = new File(userHome + "\\Taskflow\\UsuarioActual.txt");
        
        Usuario act=new Usuario(0,null,null,null,null);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(usuarioAct))) {
            String linea= reader.readLine();
            
            String[] datos = linea.split(" ");
            int id = Integer.parseInt(datos[0]);
                
            act= new Usuario(id,datos[1], datos[2] , datos[3], datos[4]);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return act;
    }
}
