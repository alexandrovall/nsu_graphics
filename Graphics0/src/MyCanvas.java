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
        private int width = 600;
        private int height = 400;
        private BufferedImage image = null;
        public MyCanvas(int width, int height)
        {
            setPreferredSize(new Dimension(width, height));
            this.width = width;
            this.height = height;
        }
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, width, height, null);
        }
        public void setImage(BufferedImage image)
        {
            this.image = image;
            repaint();
        }
    }
