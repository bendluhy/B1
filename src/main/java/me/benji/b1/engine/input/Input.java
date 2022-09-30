package me.benji.b1.engine.input;

import java.awt.event.KeyEvent;

public class Input implements IKeyboard{
    private KeyboardListener keyboard;
    public Input(KeyboardListener keyboard)
    {
        this.keyboard = keyboard;
    }

    @Override
    public boolean requestingKeydown(int keyCode) {
        return keyboard.isPressed(keyCode);
    }

    @Override
    public boolean requestingKeyup(int keyCode) {
        return keyboard.isPressed(keyCode);
    }


}
