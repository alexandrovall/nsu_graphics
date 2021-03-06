import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyFrame extends JFrame
{
    /** Title of the ftrame */
    private static final String TITLE = "Lab №0";

    /** Title of the info */
    private static final String TITLEINFO = "Info";

    /** Title of the message about entering side of the square */
    private static final String ENTERSIDE = "Enter the side of the square";

    /** Message with info about bad size */
    private static final String BADSIZE = "Bad size!";

    /** Message with information about the developer */
    private static final String INFO = "Made by Andrey Alexandrov";

    /** String for button "File" */
    private static final String FILE = "File";

    /** String for button "Help" */
    private static final String HELP = "Help";

    /** String for button "Exit" */
    private static final String EXIT = "Exit";

    /** Width in pixels of my canvas */
    private static final int WIDTH = 600;

    /** Height in pixels of my canvas */
    private static final int HEIGHT = 400;

    /** Minimal width in pixels of my canvas */
    private static final int MINWIDTH = 600;

    /** Minimal height in pixels of my canvas */
    private static final int MINHEIGHT = 400;

    /** Drawing the square and clears the screen */
    private Creator myCreator = null;

    /** Main panel */
    private JPanel myPanel = null;

    /** Menubar with buttons */
    private JMenuBar myMenuBar = null;

    /** Toolbar with buttons */
    private JToolBar myToolBar = null;

    /** Button "Help" */
    private JButton helpButton = null;

    /** Button "Exit" */
    private JButton exitButton = null;

    /** Button "Draw square" */
    private JButton squareButton = null;

    /** Button "Clear screen" */
    private JButton clearButton = null;

    /** Menu #1 */
    private JMenu file = null;

    /** Menu for drawing */
    private JMenu draw = null;

    /** Menu with supproting info */
    private JMenu help = null;

    /** Submenu in the "File" */
    private JMenuItem create = null;

    /** Submenu in the "File"  */
    private JMenuItem open = null;

    /** Submenu in the "File"  */
    private JMenuItem save = null;

    /** Submenu in the "File" */
    private JMenuItem exit = null;

    /** Submenu in the "Draw". Drawing green square */
    private JMenuItem drawSquare = null;

    /** Submenu in the "Draw". Clear screen */
    private JMenuItem cls = null;

    /** Submenu in the "Help. Contains infor about me */
    private JMenuItem about = null;

    /** Class for drawing */
    private MyCanvas myCanvas = null;

    /** Create a frame */
    public MyFrame()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension minFrameSize = new Dimension(MINWIDTH, MINHEIGHT);
        this.setTitle(TITLE);
        this.setMinimumSize(minFrameSize);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initDrawPanel();
        myCreator = new Creator(myCanvas);
        initMenuBar();
        initToolBar();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);
        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                myCanvas.setSizeOfPanel(e.getComponent().getSize());
            }
        });
        this.setVisible(true);
    }

    /** Initiate panel */
    private void initDrawPanel()
    {
        myCanvas = new MyCanvas(WIDTH, HEIGHT);
        this.add(myCanvas);
    }

    /** Initiate menubar */
    private void initMenuBar()
    {
        myMenuBar = new JMenuBar();
        this.setJMenuBar(myMenuBar);
        file = new JMenu(FILE);
        help = new JMenu(HELP);
        myMenuBar.add(file);
        create = new JMenuItem("Create");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        file.add(create);
        file.add(open);
        file.add(save);
        file.add(exit);
        draw = new JMenu("Draw");
        drawSquare = new JMenuItem("Draw Square");
        drawSquare.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                drawSquare();
            }
        });
        cls = new JMenuItem("Clear");
        cls.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                myCanvas.setImage(myCreator.makeClear());
            }
        });
        draw.add(drawSquare);
        draw.add(cls);
        myMenuBar.add(draw);
        myMenuBar.add(help);
        about = new JMenuItem("About");
        about.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                info();
            }
        });
        help.add(about);
    }

    /** Initiate toolbar */
    private void initToolBar()
    {
        myToolBar = new JToolBar();
        squareButton = new JButton();
        clearButton = new JButton();
        helpButton = new JButton();
        exitButton = new JButton();
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                drawSquare();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                myCanvas.setImage(myCreator.makeClear());
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                info();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        try
        {
            Image exitImg = ImageIO.read(getClass().getResource("exit.png"));
            Image helpImg = ImageIO.read(getClass().getResource("help.png"));
            Image squareImage = ImageIO.read(getClass().getResource("gsquare.png"));
            Image clearImg = ImageIO.read(getClass().getResource("clear.png"));
            exitButton.setIcon(new ImageIcon(exitImg));
            helpButton.setIcon(new ImageIcon(helpImg));
            squareButton.setIcon(new ImageIcon(squareImage));
            clearButton.setIcon(new ImageIcon(clearImg));
        } catch(IOException ioe)
        {
            System.exit(1);
        }
        myToolBar.add(squareButton);
        myToolBar.add(clearButton);
        myToolBar.add(helpButton);
        myToolBar.add(exitButton);
        myToolBar.setFloatable(false);
        this.add(myToolBar, BorderLayout.NORTH);
    }

    /** Get info about developer */
    public void info()
    {
        JOptionPane.showMessageDialog(this, INFO, TITLEINFO, JOptionPane.INFORMATION_MESSAGE);
    }

    /** Draw square */
    public void drawSquare()
    {
        String lenString = "";
        while (true)
        {
            lenString = JOptionPane.showInputDialog(null, null, ENTERSIDE, JOptionPane.QUESTION_MESSAGE);
            if(null == lenString)
            {
                break;
            }
            else if(lenString.equals(""))
            {
                JOptionPane.showMessageDialog(null, BADSIZE, null, JOptionPane.OK_OPTION);
            }
            else
            {
                break;
            }
        }
        if(null != lenString)
        {
            Integer len = null;
            try
            {
                len = Integer.parseInt(lenString);
            }
            catch (NumberFormatException nfe)
            {
                nfe.printStackTrace();
            }
            if(null != len)
            {
                myCanvas.setImage(myCreator.makeSquare(len));
            }
        }
    }
}