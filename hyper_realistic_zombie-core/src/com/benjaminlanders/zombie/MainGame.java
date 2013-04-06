package com.benjaminlanders.zombie;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.zombie.helper.Graphics;
import com.benjaminlanders.zombie.helper.Loader;

public class MainGame implements ApplicationListener 
{
	private SpriteBatch batch;
	Animation animation;
	float stateTime;
	TextureRegion currentFrame;
	
	@Override
	public void create() {		
		
		batch = new SpriteBatch();
		
		animation = Loader.loadAnimation("data/test2.png", 2, 2, .5f);
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
        currentFrame = animation.getKeyFrame(stateTime, true);      
        batch.begin();
        Graphics.draw(batch,currentFrame,50,50,133,127,.5f,360*stateTime);
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
