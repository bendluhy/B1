package me.benji.b1.scenes;

import me.benji.b1.engine.input.KeyboardListener;
import me.benji.b1.engine.scene.SceneBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends SceneBase {
    private double x =0;
    private double y = 0;
    @Override
    public void update(KeyboardListener key)
    {
        if(key.isPressed(KeyEvent.VK_D))
        {
            x += 1;
        }
        if(key.isPressed(KeyEvent.VK_A))
        {
            x -= 1;
        }
        if(key.isPressed(KeyEvent.VK_S))
        {
            y += 1;
        }
        if(key.isPressed(KeyEvent.VK_W))
        {
            y -= 1;
        }

    }
    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y,50,50);
    }
}
