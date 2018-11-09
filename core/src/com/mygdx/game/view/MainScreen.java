package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.model.Body;
import com.mygdx.game.model.bodies.Moon;
import com.mygdx.game.model.bodies.Planet;
import com.mygdx.game.model.bodies.Sun;

import java.util.Iterator;
import java.util.LinkedList;

public class MainScreen implements Screen {
    final MyGdxGame game;

//    public LinkedList<Body> bodies;

    Texture sunImage;
    Texture planetImage;
    Texture moonImage;
    long timeStamp;


    public MainScreen(final MyGdxGame game){
        this.game = game;
        sunImage = new Texture("sun.png");
        planetImage = new Texture("planet.png");
        moonImage = new Texture("moon.png");
        timeStamp = TimeUtils.nanoTime();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        for (Body it: game.bodies){

            if (it.getClass() == Sun.class){
                game.batch.draw(sunImage, it.getX() - it.getSize()/2, it.getY() - it.getSize()/2, it.getSize(), it.getSize());
            }
            if (it.getClass() == Planet.class){
                game.batch.draw(planetImage, it.getX() - it.getSize()/2, it.getY() - it.getSize()/2, it.getSize(), it.getSize());
            }
            if (it.getClass() == Moon.class){
                game.batch.draw(moonImage, it.getX() - it.getSize()/2, it.getY() - it.getSize()/2, it.getSize(), it.getSize());
            }

        }
        game.batch.end();

        if (TimeUtils.nanoTime() - timeStamp > 100000000){
            for (Body it : game.bodies){
                if (it.getClass() != Sun.class){
                    it.move();
                }
            }
            timeStamp = TimeUtils.nanoTime();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
