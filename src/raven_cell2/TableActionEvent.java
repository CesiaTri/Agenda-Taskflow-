
package raven_cell2;

/**
 * Interfaz que define los eventos de acción para las celdas de una tabla.
 * Esta interfaz proporciona métodos para realizar acciones de edición y visualización 
 * de las filas en la tabla, que pueden ser implementados por las clases que deseen 
 * manejar estas acciones.
 */
public interface TableActionEvent {
    
    /**
     * Método para manejar la acción de editar en una fila de la tabla.
     * 
     * @param row El índice de la fila que se va a editar.
     */
    public void onEdit(int row);
    
    /**
     * Método para manejar la acción de ver los detalles de una fila de la tabla.
     * 
     * @param row El índice de la fila que se va a visualizar.
     */
    public void onView(int row);
}
