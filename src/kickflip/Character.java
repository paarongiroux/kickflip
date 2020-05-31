package kickflip;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Character
{
    int x;
    int y;
    int ySpeed;
    int xSpeed;
    int floor;
    int i = 0;
    double time = 0;
    Image sprite;
    ImageIcon displayedImage;
    ImageIcon[] imageArray;
    ImageIcon sp1;
    ImageIcon sp2;
    ImageIcon sp3;
    ImageIcon sp4;
    ImageIcon sp5;
    boolean jumped;
    
    double dyspeed = 0;
    final double GRAVITY = .6;

    public Character(int x, int y, int floor)
    {
        jumped = false;
        this.x = x;
        this.y = y;
        this.floor = floor;
        ySpeed = 0;
        xSpeed = 0;
        
        sp1 = new ImageIcon(this.getClass().getResource("Skater.png"));
        sp2 = new ImageIcon(this.getClass().getResource("ollie1.png"));
        sp3 = new ImageIcon(this.getClass().getResource("ollie2.png"));
        sp4 = new ImageIcon(this.getClass().getResource("ollie3.png"));
        sp5 = new ImageIcon(this.getClass().getResource("ollie4.png"));
        
        imageArray = new ImageIcon[] {sp1,sp2,sp3,sp4,sp5};
        
        displayedImage = sp1;
    }
    
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    
    public ImageIcon getImage()
    {
        return displayedImage;
    }
    
    
    public void jump()
    {
        
        if (!jumped) 
        {
            displayedImage = sp2;
            jumped = true;
            floor = y;
            y -= 5;
            ySpeed = -15;
            dyspeed = -15;
        }
    }
    
    public void setXSpeed(int speed)
    {
        xSpeed = speed;
    }
    
    public void setYSpeed(int speed)
    {
        ySpeed = speed;
    }
    
    public void move()
    {
        if (y < floor && jumped)
        {
            System.out.println(ySpeed);
            if (ySpeed == -13)
            {
                displayedImage = sp3;
            }
            if (ySpeed == -12)
            {
                displayedImage = sp4;
            }
            if (ySpeed == 0)
            {
                displayedImage = sp5;
            }
            if (ySpeed == 10)
            {
                displayedImage = sp1;
            }
            y += ySpeed;
            dyspeed += GRAVITY;
            ySpeed = (int)dyspeed;
            if (y >= floor)
            { 
                ySpeed = 0;
                dyspeed = 0;
                y = floor;
                jumped = false;
            }
        }
        
        if (!jumped)
        {
            displayedImage = sp1;
            if(y > 400 && y < 600)
            {
                y += ySpeed;
            }
            if (y <= 400)
            { 
                y = 401;
            }
            if (y >= 600)
            {
                y = 599;
            }
        }
        x += xSpeed;
        
        
        
        
    }
    
}
