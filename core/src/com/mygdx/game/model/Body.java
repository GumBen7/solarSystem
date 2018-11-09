package com.mygdx.game.model;

import com.mygdx.game.view.SimpleActor;

public class Body {
    private int x, y;
    private int size;
    private Body parent;
    private int orbit;

    private double angle;
    private double speed;


//    public static int ORBIT_STEP_MARGIN = 50;

    public Body(int s, int x0, int y0) {
        x = x0;
        y = y0;
        size = s;
        parent = null;
    }

    public Body(Body p, int s, int orb, double a, double sp){
        parent = p;
        orbit = orb;
        double rad = Math.toRadians(a);
        x = (int) (parent.getX() + orbit * Math.cos(rad));
        y = (int) (parent.getY() + orbit * Math.sin(rad));
        size = s;
        angle = a;
        speed = sp;

    }

    public void move(){
        angle += speed;
        if (angle >= 360.){
            angle -= 360.;
        }
        double rad = Math.toRadians(angle);
        x = (int) (this.parent.getX() + orbit * Math.cos(rad));
        y = (int) (this.parent.getY() + orbit * Math.sin(rad));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }
}
