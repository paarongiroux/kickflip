package kickflip;

public class BackgroundObject
{
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public BackgroundObject ( int x, int y, int xSpeed, int ySpeed )
    {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setX( int x)
    {
        this.x = x;
    }

    public void updateLocation()
    {
        x += xSpeed;
        y += ySpeed;
    }
}
