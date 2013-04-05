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

public class MainGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	Animation animation;
	float stateTime;
	TextureRegion[] frames = new TextureRegion[4];
	TextureRegion currentFrame;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/test.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion[][] temp = TextureRegion.split(texture, 64, 64);
		int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                    frames[index++] = temp[i][j];
            }
        }
        animation = new Animation(0.25f, frames);             
        stateTime = 0f;           
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();                      
        currentFrame = animation.getKeyFrame(stateTime, true);      
        batch.begin();
        batch.draw(currentFrame, 50, 50);
        batch.draw(currentFrame, 50, 50,32,32, 64, 64, 4, 4, 45);
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
