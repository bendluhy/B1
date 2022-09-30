package me.benji.b1.engine.input;

import java.awt.event.KeyEvent;

public interface IKeyboard {
    boolean requestingKeydown(int keyCode);
    boolean requestingKeyup(int keyCode);

}
