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
	int blinkCount = 0;
	float x1, y1, x2, y2, x3, y3;
	float dx1, dy1, dx2, dy2, dx3, dy3;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		x1 = 900;
		y1 = 800;
		dx1 = 5;
		dy1 = -8;
		x2 = 700;
		y2 = 800;
		dx2 = 12;
		dy2 = -6;
		x3 = 300;
		y3 = 500;
		dx3 = -7;
		dy3 = 18;
	}

	@Override
	public void render () {
		// draw background image
		FileHandle backgroundFileHandle = Gdx.files.internal("Night.png");
		Texture backgroundTexture = new Texture(backgroundFileHandle);
		Sprite backgroundSprite = new Sprite(backgroundTexture, 0, 0, 1920, 1080);
		batch.begin();
		batch.draw(backgroundSprite, 0, 0);
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
		// two eyes, if blinkCount = 5, blink, and assign 0 to blink Count
		if (blinkCount != 15) {
			shape.circle(1280, 850, 15);
			shape.circle(1280, 950, 15);
			blinkCount++;
		}else {
			blinkCount = 0;
		}
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

		// draw butterflies and move
		x1 += dx1;
		y1 += dy1;
		if (x1 > backgroundSprite.getWidth() || x1 < 0){
			dx1 = -dx1;
		}
		if (y1 > backgroundSprite.getHeight() || y1 < 0){
			dy1 = -dy1;
		}
		FileHandle middleButterflyFileHandle = Gdx.files.internal("MiddleButterfly.png");
		Texture middleButterflyTexture = new Texture(middleButterflyFileHandle);
		x2 += dx2;
		y2 += dy2;
		if (x2 > backgroundSprite.getWidth() || x2 < 0){
			dx2 = -dx2;
		}
		if (y2 > backgroundSprite.getHeight() || y2 < 0){
			dy2 = -dy2;
		}
		x3 += dx3;
		y3 += dy3;
		if (x3 > backgroundSprite.getWidth() || x3 < 0){
			dx3 = -dx3;
		}
		if (y3 > backgroundSprite.getHeight() || y3 < 0){
			dy3 = -dy3;
		}
		FileHandle bigButterflyFileHandle = Gdx.files.internal("BigButterfly.png");
		Texture bigButterflyTexture = new Texture(bigButterflyFileHandle);
		batch.begin();
		batch.draw(middleButterflyTexture, x1, y1);
		batch.draw(middleButterflyTexture, x2, y2);
		batch.draw(bigButterflyTexture, x3, y3);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shape.dispose();
	}
}
