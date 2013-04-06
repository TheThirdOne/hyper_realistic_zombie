package com.benjaminlanders.zombie;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.zombie.helper.Graphics;
import com.benjaminlanders.zombie.helper.Loader;

public class MainGame implements ApplicationListener 
{
	private SpriteBatch batch;
	Animation legs,arms;
	float stateTime;
	TextureRegion currentFrame;
	
	@Override
	public void create() {		
		
		batch = new SpriteBatch();
		
		legs = Loader.loadAnimation("animations/legs.png", 2, 2, .5f);
		arms = Loader.loadAnimation("animations/arms.png", 2, 1, .2f);
        stateTime = 0f;           
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();                      
        currentFrame = legs.getKeyFrame(stateTime, true);  
        
        batch.begin();
        Graphics.draw(batch,currentFrame,100,100,133,127,.5f,0);
        currentFrame = arms.getKeyFrame(stateTime, true);  
        Graphics.draw(batch,currentFrame,100,100,133,127,.5f,0);
        batch.end();
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
}
