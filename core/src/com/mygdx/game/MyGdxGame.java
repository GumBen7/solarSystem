package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.model.bodies.Moon;
import com.mygdx.game.model.bodies.Planet;
import com.mygdx.game.model.bodies.Sun;
import com.mygdx.game.model.Body;
import com.mygdx.game.view.MainScreen;

import java.util.LinkedList;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
//	public Body sun, planet1, planet2, moon;
	public Array<Body> bodies;
//	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		bodies = new Array<Body>();
		Body sun = new Sun(100, 400, 350);
		Body planet1 = new Planet(sun, 60, 150, 90., 10.);
		Body planet2 = new Planet(sun, 60, 300, 0., 5.);
		Body moon = new Moon(planet1, 30, 70, 0., 15.);
		bodies.add(sun);
		bodies.add(planet1);
		bodies.add(planet2);
		bodies.add(moon);//*/

        this.setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
	    super.render();
	}

    @Override
    public void dispose() {
        batch.dispose();
    }
}
