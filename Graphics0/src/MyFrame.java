import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame
{
    /** Title of the ftrame */
    private static final String TITLE = "Lab №0";

    /** Title of the info */
    private static final String TITLEINFO = "Info";

    /** Message with information about the developer */
    private static final String INFO = "Made by Andrey Alexandrov";

    /** String for button "File" */
    private static final String FILE = "File";

    /** String for button "Help" */
    private static final String HELP = "Help";

    /** String for button "Exit" */
    private static final String EXIT = "Exit";

    /** Width in pixels */
    private static final int WIDTH = 600;

    /** Height in pixels */
    private static final int HEIGHT = 400;

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

    /** Create a frame */
    public MyFrame()
    {
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        initMenuBar();
        initToolBar();
        initPanel();
        this.setResizable(false);
        this.setVisible(true);
    }

    /** Initiate panel */
    private void initPanel()
    {
        myPanel = new JPanel();
        myPanel.setSize(this.getSize());
        myPanel.setBackground(Color.white);
        this.add(myPanel);
    }

    /** Initiate menubar */
    private void initMenuBar()
    {
        myMenuBar = new JMenuBar();
        this.setJMenuBar(myMenuBar);
        JMenu file = new JMenu(FILE);
        JMenu help = new JMenu(HELP);
        myMenuBar.add(file);
        myMenuBar.add(help);
    }

    /** Initiate toolbar */
    private void initToolBar()
    {
        myToolBar = new JToolBar();
        helpButton = new JButton(HELP);
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                info();
            }
        });
        exitButton = new JButton(EXIT);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        myToolBar.add(helpButton);
        myToolBar.add(exitButton);
        this.add(myToolBar, BorderLayout.NORTH);
    }

    /** Get info about developer */
    public void info()
    {
        JOptionPane.showMessageDialog(null, INFO, TITLEINFO, JOptionPane.INFORMATION_MESSAGE);
    }
}