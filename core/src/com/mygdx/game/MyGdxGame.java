package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shape;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
	}

	@Override
	public void render () {
		shape.begin(ShapeRenderer.ShapeType.Line);
		shape.setColor(1, 1, 0, 1);
		shape.line(5,100,250,300);
		shape.arc(300,100, 300, 45, 45);
		shape.rect(600, 100, 300, 300);
		shape.circle(1200,250,150);
		shape.ellipse(1400, 100, 200, 300);
		shape.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
