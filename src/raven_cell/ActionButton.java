
package raven_cell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * Clase personalizada que extiende JButton para crear un botón circular con un efecto visual 
 * de cambio de color al presionar el mouse. El color de fondo del botón cambia dependiendo del estado 
 * del mouse (presionado o no).
 * 
 * Este botón tiene un área de dibujo circular, y cambia su color al ser presionado. El color del 
 * fondo es más oscuro cuando el botón es presionado, proporcionando una respuesta visual al usuario.
 */
public class ActionButton extends JButton {
    
    /**
     * Indica si el botón ha sido presionado por el mouse.
     */
    private boolean mousePress;

    /**
     * Constructor de la clase ActionButton. Configura el botón para que no tenga área de contenido 
     * relleno, ajustando los bordes y añadiendo un MouseListener para gestionar el estado del mouse 
     * al ser presionado o liberado.
     */
    public ActionButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                mousePress = true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                mousePress = false;
            }
        });
    }
    
    /**
     * Dibuja el componente, configurando el área circular y el color de fondo del botón en función del 
     * estado del mouse (presionado o no). 
     * 
     * El botón cambia su color dependiendo de si el mouse está presionado o no, siendo más oscuro 
     * cuando el mouse está presionado.
     *
     * @param grphcs El objeto Graphics utilizado para realizar el dibujo.
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        if (mousePress) {
            g2.setColor(new Color(158, 158, 158));
        } else {
            g2.setColor(new Color(199, 199, 199));
        }
        g2.fill(new Ellipse2D.Double(x, y, size, size));
        g2.dispose();
        super.paintComponent(grphcs);
    }
}
