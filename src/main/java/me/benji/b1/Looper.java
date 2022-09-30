package me.benji.b1;

import me.benji.b1.engine.core.Window;
import me.benji.b1.engine.input.KeyboardListener;
import me.benji.b1.engine.scene.SceneBase;
import me.benji.b1.engine.scene.SceneManager;
import me.benji.b1.scenes.MainMenu;

import java.awt.*;

public class Looper implements Runnable {
    public Window win;
    public SceneManager scenemng;
    public KeyboardListener key;
    public boolean running;
    private final double updateRate = 1.0d/248.0d;
    long nextStatTime;
    private int fps,ups;

    @Override
    public void run() {
        win = new Window(1920,1080,"B1");
        SceneBase menu = new MainMenu();
        key = new KeyboardListener();
        scenemng = new SceneManager(menu);
        menu.setSceneMNG(scenemng);
        win.addKeyListener(key);
        loop();


    }

    public void loop()
    {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;
        while (running)
        {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;
            if(accumulator >= updateRate) {
                while (accumulator >= updateRate) {
                    scenemng.updateCurrentScene(key);
                    ups++;
                    accumulator -= updateRate;
                }
                render();

            }
            printDebugStats();

        }

    }

    private void printDebugStats() {
        if(System.currentTimeMillis() > nextStatTime)
        {
            System.out.printf("FPS %d, UPS: %d%n", fps, ups);
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;

        }
    }


    void render()
    {
        Graphics graphics = win.getG();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,win.getCanvas().getWidth(),win.getCanvas().getHeight());
        scenemng.renderCurrentScene(graphics);
        win.destroyGraphics();
        fps++;
    }
}