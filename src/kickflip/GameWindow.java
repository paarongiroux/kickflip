package kickflip;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame
{
    Contents game;
    public GameWindow()
    {
        game = new Contents();
        super.setTitle("Kickflip");
        super.setSize(600, 700);
        super.setLocation(100, 100);
        super.setResizable(false);
        super.add(game);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
}
