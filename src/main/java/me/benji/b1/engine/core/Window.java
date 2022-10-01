package me.benji.b1.engine.core;

import me.benji.b1.engine.input.KeyboardListener;
import me.benji.b1.engine.input.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {
    private Canvas canvas;
    private Graphics graphics;
    private BufferStrategy bufferStrategy;
    public Window(int width, int height, String title)
    {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setFocusable(false);
        add(canvas);
        pack();
        canvas.createBufferStrategy(3);
        addMouseListener(new Mouse());
        setLocationRelativeTo(null);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public Graphics getG()
    {
        bufferStrategy = canvas.getBufferStrategy();
        graphics = bufferStrategy.getDrawGraphics();
        return graphics;
    }
    public void destroyGraphics()
    {
        graphics.dispose();
        bufferStrategy.show();
    }
    public Canvas getCanvas()
    {
        return canvas;
    }
}
