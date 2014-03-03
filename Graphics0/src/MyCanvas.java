import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.nio.Buffer;

/**
 * Created by Андрей on 03.03.14.
 */


public class MyCanvas extends JPanel
{
    /** Width of the canvas */
    private int width = 0;

    /** Height of the canvas */
    private int height = 0;

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
        this.width = width;
        this.height = height;
    }

    /**
     * Draw a image
     * @param g is graphics for drawing
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, width, height, null);
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
}
