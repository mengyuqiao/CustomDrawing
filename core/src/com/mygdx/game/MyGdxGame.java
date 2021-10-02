package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
		// draw background image
		FileHandle marioFileHandle = Gdx.files.internal("Night.png");
		Texture marioTexture = new Texture(marioFileHandle);
		Sprite mario = new Sprite(marioTexture, 0, 0, 1920, 1080);
		batch.begin();
		batch.draw(mario, 0, 0);
		batch.end();

		// draw a yellow bear
		shape.begin(ShapeRenderer.ShapeType.Filled);
		// yellow
		shape.setColor(1, 1, 0, 1);
		// body
		shape.ellipse(1300,800,300,200);
		// two ears
		shape.circle(1190, 850, 30);
		shape.circle(1190, 950, 30);
		// head
		shape.ellipse(1200,800,160, 200);
		// two legs
		shape.ellipse(1550,800, 250,90, (float) -2);
		shape.ellipse(1550,900, 250,90, (float) 2);
		// two arms
		shape.ellipse(1320,750, 200,90, (float) -20);
		shape.ellipse(1320,950, 200,90, (float) 20);
		// black
		shape.setColor(0,0,0,1);
		// two eyes
		shape.circle(1280, 850, 15);
		shape.circle(1280, 950, 15);
		// gray
		shape.setColor((float) 0.9,(float) 0.9,(float) 0.9,1);
		// face
		shape.ellipse(1300,860,60, 80);
		// stomach
		shape.ellipse(1365, 825,200,150);
		// black
		shape.setColor(0,0,0,1);
		// nose
		shape.circle(1310, 900, 10);
		// mouth
		shape.rectLine(1310, 900, 1330,880, 3);
		shape.rectLine(1310, 900, 1330,920,3);
		shape.rectLine(1330,880, 1320,870, 3);
		shape.rectLine(1330,920, 1320,930,3);
		shape.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
