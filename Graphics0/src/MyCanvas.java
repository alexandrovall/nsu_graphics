import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Андрей on 03.03.14.
 */


public class MyCanvas extends JPanel implements IMyPanel
{
    /** Image for drowing (canvas) */
    private BufferedImage image = null;

    /**
     * Constructor
     * @param width is width of the canvas
     * @param height is height of the canvas
     */
    public MyCanvas(int width, int height)
    {
        setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
    }

    /**
     * Draw a image
     * @param g is graphics for drawing
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, null, null);
    }

    /**
     * Sets the new image and draws it
     * @param image is new image
     */
    public void setImage(BufferedImage image)
    {
        this.image = image;
        repaint();
    }

    /**
     *  For correct drawing
     * @return the size of JPanel
     */
    public Dimension getSizeOfPanel()
    {
        return this.getSize();
    }

    public void setSizeOfPanel(Dimension size)
    {
        setPreferredSize(size);
    }
}
