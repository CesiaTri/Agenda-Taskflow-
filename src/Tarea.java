import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * La clase Tarea representa una tarea en un sistema de gestión de tareas.
 * Cada tarea tiene un número de tarea, nombre, descripción, prioridad, estado, comentario,
 * usuario asignado y fecha de entrega.
 * 
 * Esta clase permite crear, modificar, eliminar, guardar y obtener información de tareas.
 * También incluye métodos para gestionar los archivos relacionados con las tareas y para 
 * calcular la fecha de entrega de la tarea.
 */
public class Tarea {
     /**
     * Número de la tarea.
     */
    public int numTarea;

    /**
     * Nombre de la tarea.
     */
    public String nombre;

    /**
     * Descripción de la tarea.
     */
    public String descripcion;

    /**
     * Prioridad de la tarea.
     */
    public String prioridad;

    /**
     * Estado de la tarea (Por hacer, En progreso, Completada).
     */
    public String estado;

    /**
     * Comentarios asociados a la tarea.
     */
    public String comentario;

    /**
     * Usuario asignado a la tarea.
     */
    public String usuarioAsignado;

    /**
     * Día de la fecha de entrega de la tarea.
     */
    public int dia;

    /**
     * Mes de la fecha de entrega de la tarea.
     */
    public String mes;

    /**
     * Año de la fecha de entrega de la tarea.
     */
    public int year;

    /**
     * Constructor por defecto de la clase Tarea.
     */
    public Tarea(){
    }

    /**
     * Constructor de la clase Tarea con parámetros.
     * 
     * @param NumeroTarea El número de la tarea.
     * @param Nombre El nombre de la tarea.
     * @param Descripcion La descripción de la tarea.
     * @param Prioridad La prioridad de la tarea.
     * @param UsuarioAsignado El usuario asignado a la tarea.
     * @param dia El día de la fecha de entrega.
     * @param mes El mes de la fecha de entrega.
     * @param year El año de la fecha de entrega.
     */
    public Tarea(int NumeroTarea,String Nombre,String Descripcion,String Prioridad,String UsuarioAsignado,int dia,String mes,int year){
        numTarea=NumeroTarea;
        nombre=Nombre;
        descripcion=Descripcion;
        prioridad=Prioridad;
        estado="Por hacer";
        comentario=null;
        usuarioAsignado=UsuarioAsignado;
        this.dia=dia;
        this.mes=mes;
        this.year=year;
    }
    /**
     * Constructor de la clase Tarea con parámetros.
     * 
     * @param NumeroTarea El número de la tarea.
     * @param Nombre El nombre de la tarea.
     * @param Descripcion La descripción de la tarea.
     * @param Prioridad La prioridad de la tarea.
     * @param UsuarioAsignado El usuario asignado a la tarea.
     * @param dia El día de la fecha de entrega.
     * @param mes El mes de la fecha de entrega.
     */
    public Tarea(int NumeroTarea,String Nombre,String Descripcion,String Prioridad,String UsuarioAsignado,int dia,String mes){
        numTarea=NumeroTarea;
        nombre=Nombre;
        descripcion=Descripcion;
        prioridad=Prioridad;
        estado="Por hacer";
        comentario=null;
        usuarioAsignado=UsuarioAsignado;
        this.dia=dia;
        this.mes=mes;
    }
    
    /**
     * Constructor de la clase Tarea con parámetros.
     * 
     * @param NumeroTarea El número de la tarea.
     * @param Nombre El nombre de la tarea.
     * @param Descripcion La descripción de la tarea.
     * @param Prioridad La prioridad de la tarea.
     * @param Estado El estado de la tarea.
     * @param UsuarioAsignado El usuario asignado a la tarea.
     * @param dia El día de la fecha de entrega.
     * @param mes El mes de la fecha de entrega.
     */
    public Tarea(int NumeroTarea,String Nombre,String Descripcion,String Prioridad,String Estado,String UsuarioAsignado,int dia,String mes){
        numTarea=NumeroTarea;
        nombre=Nombre;
        descripcion=Descripcion;
        prioridad=Prioridad;
        estado=Estado;
        comentario=null;
        usuarioAsignado=UsuarioAsignado;
        this.dia=dia;
        this.mes=mes;
    }
    
    /**
     * Constructor de la clase Tarea con parámetros.
     * 
     * @param aux. La Tarea a copiar
     */
    public Tarea(Tarea aux){
        numTarea=aux.getNumeroTarea();
        nombre=aux.getNombre();
        descripcion=aux.getDescripcion();
        prioridad=aux.getPrioridad();
        estado=aux.getEstado();
        comentario=null;
        usuarioAsignado=aux.getUsuarioAsignado();
        this.dia=aux.getDia();
        this.mes=aux.getMes();
        this.year=aux.getYear();
    }

    // Métodos de acceso y modificación

    /**
     * Obtiene el año de la tarea.
     * 
     * @return El año de la tarea.
     */
    public int getYear() {
        return year;
    }

    /**
     * Obtiene el día de la tarea.
     * 
     * @return El día de la tarea.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Obtiene el mes de la tarea.
     * 
     * @return El mes de la tarea.
     */
    public String getMes() {
        return mes;
    }

    /**
     * Obtiene el número de la tarea.
     * 
     * @return El número de la tarea.
     */
    public int getNumeroTarea(){
        return numTarea;
    }

    /**
     * Obtiene el nombre de la tarea.
     * 
     * @return El nombre de la tarea.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción de la tarea.
     * 
     * @return La descripción de la tarea.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la prioridad de la tarea.
     * 
     * @return La prioridad de la tarea.
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Obtiene el estado de la tarea.
     * 
     * @return El estado de la tarea.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obtiene el comentario de la tarea.
     * 
     * @return El comentario de la tarea.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Obtiene el usuario asignado a la tarea.
     * 
     * @return El usuario asignado a la tarea.
     */
    public String getUsuarioAsignado() {
        return usuarioAsignado;
    }

    // Métodos de modificación

    /**
     * Establece el número de la tarea.
     * 
     * @param numero El nuevo número de la tarea.
     */
    public void setNumeroTarea(int numero) {
        this.numTarea = numero;
    }

    /**
     * Establece el nombre de la tarea.
     * 
     * @param nombre El nuevo nombre de la tarea.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la descripción de la tarea.
     * 
     * @param descripcion La nueva descripción de la tarea.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece la prioridad de la tarea.
     * 
     * @param prioridad La nueva prioridad de la tarea.
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Establece el estado de la tarea.
     * 
     * @param estado El nuevo estado de la tarea.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece un comentario para la tarea.
     * 
     * @param comentario El comentario para la tarea.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Establece el usuario asignado a la tarea.
     * 
     * @param usuarioAsignado El usuario asignado a la tarea.
     */
    public void setUsuarioAsignado(String usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    /**
     * Establece el día en que se debe completar la tarea.
     * 
     * @param dia El nuevo día de la tarea.
     */
    public void setDia(int dia){
        this.dia = dia;
    }

    /**
     * Establece el mes en que se debe completar la tarea.
     * 
     * @param mes El nuevo mes de la tarea.
     */
    public void setMes(String mes){
        this.mes = mes;
    }

    /**
     * Establece el año en que se debe completar la tarea.
     * 
     * @param year El nuevo año de la tarea.
     */
    public void setYear(int year){
        this.year = year;
    }
    
    /**
     * Elimina una tarea tanto del archivo de lista de tareas como de su archivo individual.
     * 
     * @param direccion La dirección donde se encuentran los archivos de tareas.
     * @param tarea La tarea a eliminar.
     * @param listaTareas El archivo donde se almacenan todas las tareas.
     * @param direc La dirección donde se guardarán los archivos temporales.
     */
    public void eliminarTarea(String direccion, Tarea tarea, String listaTareas,String direc) {
        File lista = new File(listaTareas);
        String lineaABorrar = tarea.getNumeroTarea() + "|" + tarea.getNombre();

        File archivoTemporal = new File(direc+ "\\auxiliar.txt");
        try {
            

            try (BufferedReader lector = new BufferedReader(new FileReader(lista));
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
            }

            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar eliminar la tarea.");
            e.printStackTrace();
        }
        if (lista.delete()) {
                archivoTemporal.renameTo(lista);
                System.out.println("Tarea eliminada de la lista.");
            }else{
                System.out.println("No se pudo eliminar la Tarea"+tarea.getNumeroTarea()+" de la lista");
            }

            File archivo = new File(direccion);
            if (archivo.delete()) {
                System.out.println("Archivo de tarea eliminado.");
            }else{
                System.out.println("No se pudo eliminar la Tarea"+tarea.getNumeroTarea());
                System.out.println("Resultado de delete(): " + archivo.delete());
            }
    }
    
    /**
     * Crea un archivo para una nueva tarea en la ubicación especificada.
     * 
     * @param direccion La dirección donde se debe crear el archivo de la tarea.
     * @param act La tarea a crear.
     */
    public void CrearNuevaTarea (String direccion,Tarea act){
        File archivo =new File(direccion + "\\"+ act.getNumeroTarea()+".txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado en: " + archivo.getAbsolutePath());
            } else {
                System.out.println("El archivo ya existe en: " + archivo.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }
    
    /**
     * Guarda una tarea en su archivo correspondiente y en el archivo de lista de tareas.
     * 
     * @param direccion La ubicación donde guardar el archivo de la tarea.
     * @param act La tarea a guardar.
     * @param listaTareas El archivo de lista de tareas.
     */
    public void guardarTarea (String direccion,Tarea act,String listaTareas){
        File archivo=new File(direccion+"\\"+act.getNumeroTarea()+".txt");
        FileWriter escribir;
        PrintWriter linea;
        File ListaTareas=new File(listaTareas);
        
        try{
            escribir = new FileWriter(ListaTareas,true);
            linea = new PrintWriter(escribir);
            if(ListaTareas.length() == 0)
                escribir.write(act.getNumeroTarea()+"|"+act.getNombre()+"\n");
            else
                escribir.write(act.getNumeroTarea()+"|"+act.getNombre()+"\n");
            linea.close();
        }catch(IOException exepcion){
            exepcion.printStackTrace(System.out);
        }
        
        try {
            escribir = new FileWriter(archivo,true);
            linea = new PrintWriter(escribir);
            escribir.write("NumeroTarea:"+act.getNumeroTarea()+"\n");
            escribir.write("Nombre:"+act.getNombre()+"\n");
            escribir.write("Descripcion:"+act.getDescripcion()+"\n");
            escribir.write("Prioridad:"+act.getPrioridad()+"\n");
            escribir.write("Estado:"+act.getEstado()+"\n");
            escribir.write("UsuarioAsignado:"+act.getUsuarioAsignado()+"\n");
            escribir.write("Comentario:"+act.getComentario()+"\n");
            escribir.write("Dia:"+act.getDia()+"\n");
            escribir.write("Mes:"+act.getMes()+"\n");
            escribir.write("Año:"+act.getYear()+"\n");
            linea.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar la partida en el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene los detalles de una tarea desde su archivo.
     * 
     * @param direccion La dirección del archivo de la tarea.
     * @param NumeroTarea El número de la tarea a obtener.
     * @return Un objeto Tarea con los detalles leídos del archivo.
     */
    public Tarea DetallesTarea (String direccion,int NumeroTarea){
        File archivo=new File (direccion);
        String contenido=null;
        String nombre=null;
        String descripcion=null;
        String prioridad=null;
        String estado=null;
        String comentario=null;
        String usuarioAsignado=null;
        int dia=0;
        String mes= null;
        int year=0;
        
        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while(contenido != null){
                if(contenido.contains("Nombre:")){
                    nombre=contenido.substring(7,contenido.length());
                }
                if(contenido.contains("Descripcion:")){
                    descripcion=contenido.substring(12,contenido.length());
                }
                if(contenido.contains("Prioridad:")){
                    prioridad=contenido.substring(10,contenido.length());
                }
                if(contenido.contains("Estado:")){
                    estado=contenido.substring(7,contenido.length());
                }
                if(contenido.contains("UsuarioAsignado:")){
                    usuarioAsignado=contenido.substring(16,contenido.length());
                }
                if(contenido.contains("Comentario:")){
                    comentario=contenido.substring(11,contenido.length());
                }
                if(contenido.contains("Dia:")){
                    String aux=contenido.substring(4,contenido.length());
                    dia=Integer.parseInt(aux);
                }
                if(contenido.contains("Mes:")){
                    mes=contenido.substring(4,contenido.length());
                }
                if(contenido.contains("Año:")){
                    String aux=contenido.substring(4,contenido.length());
                    year=Integer.parseInt(aux);
                }
                contenido = lectura.readLine();
            }
        } catch (IOException excepcion) {
            excepcion.printStackTrace();
        }
        Tarea nueva=new Tarea(NumeroTarea,nombre,descripcion,prioridad, estado,usuarioAsignado,dia,mes);
        nueva.setYear(year);
        return nueva;
    }
    
    /**
     * Obtiene el número de la siguiente tarea disponible para crear.
     * 
     * @param direccion La dirección donde se encuentra el archivo de lista de tareas.
     * @return El número de la próxima tarea.
     */
    public int numeroNuevaTarea(String direccion){
        int numero=0;
        File archivo=new File (direccion);
        String contenido="";
        Tarea aux=new Tarea();
        
        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while(contenido != null){
                aux=aux.indiceTarea(contenido);
                numero=aux.getNumeroTarea();
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
     * Obtiene el número total de tareas en el archivo de lista de tareas.
     * 
     * @param direccion La dirección del archivo de lista de tareas.
     * @return El número total de tareas en el archivo.
     */
    public int tareasTotal(String direccion){
        int numero=0;
        File archivo=new File (direccion);
        String contenido="";
        
        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while(contenido != null){
                numero++;
                contenido = lectura.readLine();
            }
        } catch (IOException excepcion) {
            numero=0;
        }
        return numero;
    }
    
    /**
     * Convierte una cadena de texto que representa el número de la tarea y su nombre
     * en un objeto Tarea.
     * 
     * @param contenido La línea del archivo que contiene el número y nombre de la tarea.
     * @return Un objeto Tarea correspondiente.
     */
    public Tarea indiceTarea(String contenido){
        int aux=0;
        int n=0;
        for(char c: contenido.toCharArray()){
            if(c=='|'){
                aux=n;
            }
            n++;
        }
        String nombre=contenido.substring(aux+1,contenido.length());
        String numero=contenido.substring(0,aux);
        int num=Integer.parseInt(numero);
        Tarea act = new Tarea (num,nombre,null,null,null,0,null);
        return act;
    }
    
    /**
     * Edita una tarea, tanto en su archivo individual como en la lista de tareas.
     * 
     * @param direccion La ubicación del archivo de la tarea.
     * @param act La tarea editada.
     * @param listaTareas El archivo de lista de tareas.
     * @param ant La tarea original antes de la edición.
     */
    public void editarTarea(String direccion,Tarea act, String listaTareas, Tarea ant){
        String userHome = "C:\\Users\\Cesia\\Desktop";
        File archivo=new File(direccion);
        FileWriter escribir;
        PrintWriter linea;
        File ListaTareas=new File(listaTareas);
        String lineaEditar= ant.getNumeroTarea()+"|"+ant.getNombre();
        
        try {
            File archivoTemporal = new File(userHome + "\\Taskflow\\Tareas\\auxiliar.txt");

            BufferedReader lector = new BufferedReader(new FileReader(ListaTareas));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;

            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaEditar)) {
                    escritor.write(lineaActual);
                    escritor.newLine();
                }else{
                    escritor.write(act.getNumeroTarea()+"|"+act.getNombre());
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();
            
            if (ListaTareas.delete()) {
                archivoTemporal.renameTo(ListaTareas);
                System.out.println("lista borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
            
            if (archivo.delete()) {
                System.out.println("Línea borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
            
            String direcTareas = userHome + "\\Taskflow\\Tareas";
            act.CrearNuevaTarea(direcTareas, act);
            
            try {
            escribir = new FileWriter(archivo,true);
            linea = new PrintWriter(escribir);
            escribir.write("NumeroTarea:"+act.getNumeroTarea()+"\n");
            escribir.write("Nombre:"+act.getNombre()+"\n");
            escribir.write("Descripcion:"+act.getDescripcion()+"\n");
            escribir.write("Prioridad:"+act.getPrioridad()+"\n");
            escribir.write("Estado:"+act.getEstado()+"\n");
            escribir.write("UsuarioAsignado:"+act.getUsuarioAsignado()+"\n");
            escribir.write("Comentario:"+act.getComentario()+"\n");
            escribir.write("Dia:"+act.getDia()+"\n");
            escribir.write("Mes:"+act.getMes()+"\n");
            escribir.write("Año:"+act.getYear()+"\n");
            linea.close();
            
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar la tarea: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar borrar la línea.");
            e.printStackTrace();
        }
    }
    
    /**
     * Edita cualquier tarea dentro de un sistema, modificando tanto su archivo
     * individual como el archivo de lista de tareas.
     * 
     * @param direccionTarea La dirección del archivo de la tarea a editar.
     * @param act La tarea editada.
     * @param listaTareas El archivo de lista de tareas.
     * @param ant La tarea original antes de la edición.
     * @param direc La dirección donde se guardarán los archivos.
     */
    public void editarCualquierTarea(String direccionTarea,Tarea act, String listaTareas, Tarea ant, String direc){
        String userHome = "C:\\Users\\Cesia\\Desktop";
        File archivo=new File(direccionTarea);
        FileWriter escribir;
        PrintWriter linea;
        File ListaTareas=new File(listaTareas);
        String lineaEditar= ant.getNumeroTarea()+"|"+ant.getNombre();
        
        try {
            File archivoTemporal = new File(direc+"\\auxiliar.txt");

            BufferedReader lector = new BufferedReader(new FileReader(ListaTareas));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;

            while ((lineaActual = lector.readLine()) != null) {
                if (!lineaActual.equals(lineaEditar)) {
                    escritor.write(lineaActual);
                    escritor.newLine();
                }else{
                    escritor.write(act.getNumeroTarea()+"|"+act.getNombre());
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();
            
            if (ListaTareas.delete()) {
                archivoTemporal.renameTo(ListaTareas);
                System.out.println("Línea borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
            
            if (archivo.delete()) {
                System.out.println("Línea borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
            
            act.CrearNuevaTarea(direc, act);
            
            try {
            escribir = new FileWriter(archivo,true);
            linea = new PrintWriter(escribir);
            escribir.write("NumeroTarea:"+act.getNumeroTarea()+"\n");
            escribir.write("Nombre:"+act.getNombre()+"\n");
            escribir.write("Descripcion:"+act.getDescripcion()+"\n");
            escribir.write("Prioridad:"+act.getPrioridad()+"\n");
            escribir.write("Estado:"+act.getEstado()+"\n");
            escribir.write("UsuarioAsignado:"+act.getUsuarioAsignado()+"\n");
            escribir.write("Comentario:"+act.getComentario()+"\n");
            escribir.write("Dia:"+act.getDia()+"\n");
            escribir.write("Mes:"+act.getMes()+"\n");
            escribir.write("Año:"+act.getYear()+"\n");
            linea.close();
            
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar la tarea: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar borrar la línea.");
            e.printStackTrace();
        }
    }
    
    /**
     * Obtiene una lista de todas las tareas presentes en el archivo de lista de tareas.
     * 
     * @param direc La ubicación donde se encuentra el archivo de lista de tareas.
     * @return Un ArrayList de objetos Tarea representando todas las tareas.
     */
    public ArrayList<Tarea> ListaTareas(String direc) {
        File archivo = new File(direc + "\\ListaTareas.txt");
        String contenido = "";
        ArrayList<Tarea> act = new ArrayList<>(); 
        Tarea aux = new Tarea();

        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            contenido = lectura.readLine();
            while (contenido != null) {
                act.add(aux.indiceTarea(contenido));
                contenido = lectura.readLine();
            }
        } catch (IOException excepcion) {
            excepcion.printStackTrace();
        }

        for (int ind = 0; ind < act.size(); ind++) {
            String direccion = direc + "\\" + act.get(ind).getNumeroTarea() + ".txt";
            act.set(ind, aux.DetallesTarea(direccion, act.get(ind).getNumeroTarea()));
        }

        return act;
    }
    
    /**
     * Obtiene la fecha de entrega de la tarea en formato Date.
     * 
     * @return La fecha de entrega de la tarea.
     */
    public Date getFechaEntrega() {
        int yearToUse = (year != 0) ? year : java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        String monthStr = mes;
        int month = convertirMesAMesNumero(monthStr);  
        
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(yearToUse, month - 1, dia);
        return cal.getTime();
    }

    /**
     * Convierte el nombre del mes a su número correspondiente.
     * 
     * @param mes El nombre del mes.
     * @return El número correspondiente al mes.
     */
    private int convertirMesAMesNumero(String mes) {
        switch (mes) {
            case "Enero": return 1;
            case "Febrero": return 2;
            case "Marzo": return 3;
            case "Abril": return 4;
            case "Mayo": return 5;
            case "Junio": return 6;
            case "Julio": return 7;
            case "Agosto": return 8;
            case "Septiembre": return 9;
            case "Octubre": return 10;
            case "Noviembre": return 11;
            case "Diciembre": return 12;
            default: return 1;
        }
    }
}
