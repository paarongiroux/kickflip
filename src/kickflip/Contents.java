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
    private int streetCounter;
    private Timer t;
    private Image music;
    private Image streets;
    private Image set;
    private Image background;
    private Image skater;
    private Image stairs;
    private ImageIcon sk;
    private ImageIcon m;
    private ImageIcon s;
    private ImageIcon bg;
    private ImageIcon st;
    private ImageIcon sta;
    private BackgroundObject streetsProps;
    private BackgroundObject streetsProps2;
    private BackgroundObject bgProps;
    private BackgroundObject setProps;
    private BackgroundObject stairProps;
    private Character player;
    
    public Contents()
    {
        streetCounter = 0;
        floor = 500;
        
        player = new Character(300, floor, floor);
        
        streetsProps = new BackgroundObject(0,0,-5,0);
        streetsProps2 = new BackgroundObject(streetsProps.getX() + 600, 0 , -5, 0);
        bgProps = new BackgroundObject (0,-100,-3,0);
        setProps = new BackgroundObject(0, 0, -1, 0);
        stairProps = new BackgroundObject(-500, -500, -5, 0);
        
        s = new ImageIcon(this.getClass().getResource("Set.png"));
        bg = new ImageIcon(this.getClass().getResource("Background.png"));
        st = new ImageIcon(this.getClass().getResource("Street.png"));
        m = new ImageIcon(this.getClass().getResource("Music.png"));
        sk = new ImageIcon(this.getClass().getResource("Skater.png"));
        sta = new ImageIcon(this.getClass().getResource("stairs.png"));
        
        set = s.getImage();
        background = bg.getImage();
        streets = st.getImage();
        music = m.getImage();
        skater = sk.getImage();
        stairs = sta.getImage();
        
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
        
        
        if (streetsProps.getY() > 0 && player.getX() >= stairProps.getX())
        {
            streetsProps.setY(streetsProps.getY() - 5);
            streetsProps2.setY(streetsProps2.getY() - 5);
            stairProps.setY(stairProps.getY() - 5);
        }
        
        skater = player.getImage().getImage();
        
        Graphics2D g2d = (Graphics2D) (Graphics) g;
        
        g2d.drawImage(set, setProps.getX(), setProps.getY(), this);
        g2d.drawImage(set, setProps.getX() + 600, setProps.getY(), this);
        
        g2d.drawImage(background, bgProps.getX(), bgProps.getY(), this);
        g2d.drawImage(background, bgProps.getX() + 600, bgProps.getY(), this);
        
        
        g2d.drawImage(streets, streetsProps.getX(), streetsProps.getY(), this);
        g2d.drawImage(streets, streetsProps2.getX(), streetsProps2.getY(), this);
        
       
        g2d.drawImage(music, 520, 20, this);
        
        if (stairProps.isOnScreen())
        {
            g2d.drawImage(stairs, stairProps.getX(), stairProps.getY(), this);
        }
        
        g2d.drawImage(player.getImage().getImage(), player.getX(), player.getY(), this);
        
        
        if(streetsProps.getX() < -600)
        {
            if( streetCounter == 5) 
            {
                streetCounter = 0;
                stairProps = new BackgroundObject(streetsProps2.getX() + 600, 520, -5, 0);
                streetsProps.setX(stairProps.getX() + 180);
                streetsProps.setY(streetsProps.getY() + 180);
                g2d.drawImage(stairs, stairProps.getX(), 425, this);
                
            }
            else {
                streetsProps.setX(0);
                streetsProps2.setX(600);
                streetCounter += 1;
            }
        }
        if (streetsProps2.getX() < -600) {
            streetsProps2.setX(streetsProps.getX() + 600);
            streetsProps2.setY(streetsProps.getY());
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
        streetsProps2.updateLocation();
        bgProps.updateLocation();
        setProps.updateLocation();
        stairProps.updateLocation();
        
        
        
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
