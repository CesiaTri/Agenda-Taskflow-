import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * La clase Escalar proporciona métodos para redimensionar imágenes y ajustarlas a un componente gráfico,
 * como un JLabel. Esto permite que las imágenes se escalen automáticamente para adaptarse al tamaño del 
 * componente de destino.
 */
public class Escalar {
    
     /**
     * Constructor predeterminado de la clase Escalar.
     * (Si el constructor no hace nada, puedes agregar una breve descripción indicando eso.)
     */
    public Escalar() {
        // Constructor por defecto
    }
    
    /**
     * Redimensiona una imagen y la ajusta a las dimensiones de un JLabel.
     * Este método toma la imagen desde la ruta proporcionada, la redimensiona al tamaño del JLabel
     * y establece la imagen redimensionada como el icono del Label.
     * 
     * @param label El JLabel cuyo tamaño se utilizará para redimensionar la imagen.
     * @param rutaImagen La ruta del archivo de imagen a cargar y redimensionar.
     *                  La ruta debe ser relativa al paquete de recursos del proyecto.
     */
    public void escalarLabel(JLabel label, String rutaImagen){
        label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(rutaImagen)).getImage()
        .getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_DEFAULT)));
    }
}
