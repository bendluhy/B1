package me.benji.b1.engine.scene;

import me.benji.b1.engine.input.KeyboardListener;

import java.awt.*;

public class SceneManager {
    public SceneBase currentScene;
    public KeyboardListener key;
    public SceneManager(SceneBase starting)
    {
        currentScene = starting;
    }

    public void setCurrentScene(SceneBase scene)
    {
        currentScene = scene;
    }
    public SceneBase getCurrentScene()
    {
        return currentScene;
    }

    public void updateCurrentScene(KeyboardListener key)
    {
        currentScene.update(key);
    }
    public void renderCurrentScene(Graphics g)
    {
        currentScene.render(g);
    }
}
