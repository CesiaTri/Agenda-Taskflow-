import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 * La clase PanelRound es una subclase de JPanel que permite crear paneles con esquinas redondeadas personalizables.
 * Los bordes de las esquinas pueden ser modificados de forma independiente para cada esquina..
 */
public class PanelRound extends JPanel {

    /**
     * Obtiene el valor de redondeo de la esquina superior izquierda.
     *
     * @return El radio de redondeo de la esquina superior izquierda.
     */
    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    /**
     * Establece el valor de redondeo de la esquina superior izquierda.
     *
     * @param roundTopLeft El radio de redondeo de la esquina superior izquierda.
     */
    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    /**
     * Obtiene el valor de redondeo de la esquina superior derecha.
     *
     * @return El radio de redondeo de la esquina superior derecha.
     */
    public int getRoundTopRight() {
        return roundTopRight;
    }

    /**
     * Establece el valor de redondeo de la esquina superior derecha.
     *
     * @param roundTopRight El radio de redondeo de la esquina superior derecha.
     */
    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    /**
     * Obtiene el valor de redondeo de la esquina inferior izquierda.
     *
     * @return El radio de redondeo de la esquina inferior izquierda.
     */
    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    /**
     * Establece el valor de redondeo de la esquina inferior izquierda.
     *
     * @param roundBottomLeft El radio de redondeo de la esquina inferior izquierda.
     */
    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    /**
     * Obtiene el valor de redondeo de la esquina inferior derecha.
     *
     * @return El radio de redondeo de la esquina inferior derecha.
     */
    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    /**
     * Establece el valor de redondeo de la esquina inferior derecha.
     *
     * @param roundBottomRight El radio de redondeo de la esquina inferior derecha.
     */
    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    /**
     * Radio de redondeo de la esquina superior izquierda.
     * Un valor de 0 significa que la esquina no estará redondeada.
     */
    private int roundTopLeft = 0;
    
    /**
     * Radio de redondeo de la esquina superior derecha.
     * Un valor de 0 significa que la esquina no estará redondeada.
     */
    private int roundTopRight = 0;
    
    /**
     * Radio de redondeo de la esquina inferior izquierda.
     * Un valor de 0 significa que la esquina no estará redondeada.
     */
    private int roundBottomLeft = 0;
    
    /**
     * Radio de redondeo de la esquina inferior derecha.
     * Un valor de 0 significa que la esquina no estará redondeada.
     */
    private int roundBottomRight = 0;

    /**
     * Constructor de PanelRound. Establece la propiedad de opacidad a falsa,
     * permitiendo que el fondo se vea a través del panel si es necesario.
     */
    public PanelRound() {
        setOpaque(false);
    }

    /**
     * Sobrescribe el método paintComponent para pintar el panel con bordes redondeados,
     * según los valores de redondeo establecidos en las esquinas del panel.
     * 
     * @param grphcs El objeto Graphics utilizado para dibujar el componente.
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    /**
     * Crea un área redondeada para la esquina superior izquierda.
     * 
     * @return El objeto Shape con el área redondeada para la esquina superior izquierda.
     */
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    /**
     * Crea un área redondeada para la esquina superior derecha.
     * 
     * @return El objeto Shape con el área redondeada para la esquina superior derecha.
     */
    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    /**
     * Crea un área redondeada para la esquina inferior izquierda.
     * 
     * @return El objeto Shape con el área redondeada para la esquina inferior izquierda.
     */
    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    /**
     * Crea un área redondeada para la esquina inferior derecha.
     * 
     * @return El objeto Shape con el área redondeada para la esquina inferior derecha.
     */
    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
}
