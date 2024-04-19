package model.prize;

import manager.GameEngine;
import model.hero.Egario;
import model.hero.EgarioForm;
import view.Animation;
import view.ImageLoader;

import java.awt.image.BufferedImage;

public class FireFlower extends BoostItem {

    public FireFlower(double x, double y, BufferedImage style) {
        super(x, y, style);
        setPoint(150);
    }

    @Override
    public void onTouch(Egario mario, GameEngine engine) {
        mario.acquirePoints(getPoint());

        ImageLoader imageLoader = new ImageLoader();

        if(!mario.getMarioForm().isFire()){
            BufferedImage[] leftFrames = imageLoader.getLeftFrames(EgarioForm.FIRE);
            BufferedImage[] rightFrames = imageLoader.getRightFrames(EgarioForm.FIRE);

            Animation animation = new Animation(leftFrames, rightFrames);
            EgarioForm newForm = new EgarioForm(animation, true, true);
            mario.setMarioForm(newForm);
            mario.setDimension(48, 96);

            engine.playFireFlower();
        }
    }

    @Override
    public void updateLocation(){}

}
