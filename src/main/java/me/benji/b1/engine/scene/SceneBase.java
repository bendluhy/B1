package me.benji.b1.engine.scene;

import me.benji.b1.engine.input.KeyboardListener;

import java.awt.*;

public class SceneBase {

    private SceneManager mng;
    public void render(Graphics g)
    {
        System.out.println("Render function not overriden");
    }
    public void setSceneMNG(SceneManager mng)
    {
        this.mng = mng;
    }
    public void update(KeyboardListener key)
    {
        System.out.println("Update function not overriden");
    }
}
