import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by Андрей on 03.03.14.
 */
public class Creator
{
    private int width = 400;
    private int height = 200;
    public Creator(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
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
    public BufferedImage makeClear()
    {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }
}
