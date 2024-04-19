package model.prize;

import manager.GameEngine;
import model.hero.Egario;
import model.hero.EgarioForm;
import view.Animation;
import view.ImageLoader;

import java.awt.image.BufferedImage;

public class SuperMushroom extends BoostItem{

    public SuperMushroom(double x, double y, BufferedImage style) {
        super(x, y, style);
        setPoint(125);
    }

    @Override
    public void onTouch(Egario mario, GameEngine engine) {
        mario.acquirePoints(getPoint());

        ImageLoader imageLoader = new ImageLoader();

        if(!mario.getMarioForm().isSuper()){
            BufferedImage[] leftFrames = imageLoader.getLeftFrames(EgarioForm.SUPER);
            BufferedImage[] rightFrames = imageLoader.getRightFrames(EgarioForm.SUPER);

            Animation animation = new Animation(leftFrames, rightFrames);
            EgarioForm newForm = new EgarioForm(animation, true, false);
            mario.setMarioForm(newForm);
            mario.setDimension(48, 96);

            engine.playSuperMushroom();
        }
    }
}
