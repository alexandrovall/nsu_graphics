import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by Андрей on 03.03.14.
 */
public class Creator
{
    /** Width of the canvas */
    private int width = 0;

    /**Height of the canvas */
    private int height = 0;

    /** Constructor
     * @param width is width of the canvas
     * @param height is height of the canvas
     * */
    public Creator(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    /**
     * Drawing the square
     * @param len is lenght of the square
     * @return the BufferedImage with the draw a square or null(if lenght < 0 or not number)
     */
    public BufferedImage makeSquare(int len)
    {
        int halflen = len / 2;
        if(len > 0 && len < width && len < height)
        {
            BufferedImage square = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for(int i = width / 2 - halflen; i < width / 2 + halflen; i++)
            {
                for(int j = height / 2 - halflen; j < height / 2 + halflen; j++)
                {
                    square.setRGB(i, j, Color.GREEN.getRGB());
                }
            }
            return square;
        }
        else
        {
            return null;
        }
    }

    /**
     * Clears the screen
     * @return Clear BufferedImage
     */
    public BufferedImage makeClear()
    {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }
}
