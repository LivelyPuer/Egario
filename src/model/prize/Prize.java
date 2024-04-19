package model.prize;

import manager.GameEngine;
import model.hero.Egario;

import java.awt.*;

public interface Prize {

    int getPoint();

    void reveal();

    Rectangle getBounds();

    void onTouch(Egario mario, GameEngine engine);

}
