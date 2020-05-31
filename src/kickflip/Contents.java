package kickflip;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Contents extends JPanel implements ActionListener, KeyListener
{

    private int floor;
    private Timer t;
    private Image music;
    private Image streets;
    private Image set;
    private Image background;
    private Image skater;
    private ImageIcon sk;
    private ImageIcon m;
    private ImageIcon s;
    private ImageIcon bg;
    private ImageIcon st;
    private BackgroundObject streetsProps;
    private BackgroundObject bgProps;
    private BackgroundObject setProps;
    private Character player;
    
    public Contents()
    {
        floor = 500;
        
        player = new Character(300, floor, floor);
        
        streetsProps = new BackgroundObject(0,0,-5,0);
        bgProps = new BackgroundObject (0,-100,-3,0);
        setProps = new BackgroundObject(0, 0, -1, 0);
        
        s = new ImageIcon(this.getClass().getResource("Set.png"));
        bg = new ImageIcon(this.getClass().getResource("Background.png"));
        st = new ImageIcon(this.getClass().getResource("Street.png"));
        m = new ImageIcon(this.getClass().getResource("Music.png"));
        sk = new ImageIcon(this.getClass().getResource("Skater.png"));
        
        set = s.getImage();
        background = bg.getImage();
        streets = st.getImage();
        music = m.getImage();
        skater = sk.getImage();
        
        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        skater = player.getImage().getImage();
        
        Graphics2D g2d = (Graphics2D) (Graphics) g;
        
        g2d.drawImage(set, setProps.getX(), setProps.getY(), this);
        g2d.drawImage(set, setProps.getX() + 600, setProps.getY(), this);
        
        g2d.drawImage(background, bgProps.getX(), bgProps.getY(), this);
        g2d.drawImage(background, bgProps.getX() + 600, bgProps.getY(), this);
        
        
        g2d.drawImage(streets, streetsProps.getX(), streetsProps.getY(), this);
        g2d.drawImage(streets, streetsProps.getX() + 600, streetsProps.getY(), this);
        
       
        g2d.drawImage(music, 520, 20, this);
        
        g2d.drawImage(player.getImage().getImage(), player.getX(), player.getY(), this);
        
        if(streetsProps.getX() < -600)
        {
            streetsProps.setX(0);
        }
        
        if (bgProps.getX() < -600)
        {
            bgProps.setX(0);
        }
        
        if (setProps.getX() < -600)
        {
            setProps.setX(0);
        }
        
        streetsProps.updateLocation();
        bgProps.updateLocation();
        setProps.updateLocation();
        
        }
    
    @Override
    public void keyTyped ( KeyEvent e )
    {
        
        
    }

    @Override
    public void keyPressed ( KeyEvent e )
    {
        int keyCode = e.getKeyCode();
        
        if (keyCode == KeyEvent.VK_SPACE)
        {
            player.jump();   
        }
        
        if (keyCode == KeyEvent.VK_A)
        {
            player.setXSpeed(-3);
        }
        
        if (keyCode == KeyEvent.VK_D)
        {
            player.setXSpeed(3);
        }
        
        if (keyCode == KeyEvent.VK_S)
        {
            player.setYSpeed(3);
        }
        
        if (keyCode == KeyEvent.VK_W)
        {
            player.setYSpeed(-3);
        }
        
    }

    @Override
    public void keyReleased ( KeyEvent e )
    {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A)
        {
            player.setXSpeed(0);
        }
        
        if (keyCode == KeyEvent.VK_D)
        {
            player.setXSpeed(0);
        }
        
        if (keyCode == KeyEvent.VK_W)
        {
            player.setYSpeed(0);
        }
        
        if (keyCode == KeyEvent.VK_S)
        {
            player.setYSpeed(0);
        }
        
    }

    @Override
    public void actionPerformed ( ActionEvent e )
    {
        
        player.move();
        repaint();
        
    }

}
