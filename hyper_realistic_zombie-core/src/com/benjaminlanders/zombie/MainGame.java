package com.benjaminlanders.zombie;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.zombie.helper.Assets;
import com.benjaminlanders.zombie.helper.Graphics;
import com.benjaminlanders.zombie.view.MainRenderer;
import com.benjaminlanders.zombie.view.Renderer;
import com.benjaminlanders.zombie.view.SplashScreen;

public class MainGame implements ApplicationListener 
{
	private Renderer renderer;
	private SpriteBatch batch;
	Animation legs,arms;
	float stateTime;
	TextureRegion currentFrame;
	public MainGame()
	{
	
	}
	
	@Override
	public void create() 
	{		
		
		batch = new SpriteBatch();
		renderer = new SplashScreen(batch,this,new Texture(Gdx.files.internal("data/libgdx.png")));
		legs = Assets.getAnimation(Assets.legs);
		arms = Assets.getAnimation(Assets.ball);
        stateTime = 0f;           
	}

	@Override
	public void dispose() 
	{
		batch.dispose();
	}

	@Override
	public void render()
	{		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();                      
        currentFrame = legs.getKeyFrame(stateTime, true); 
        if(((SplashScreen) renderer).isFinsished())
        {
        	renderer = new MainRenderer(batch,this);
        }
        renderer.render(Gdx.graphics.getDeltaTime());
       /* batch.begin();
        Graphics.draw(batch,currentFrame,100,100,133,127,.5f,0);
        currentFrame = arms.getKeyFrame(stateTime, true);  
        Graphics.draw(batch,currentFrame,100,100,133,127,.5f,0);
        batch.end();*/
	}

	@Override
	public void resize(int width, int height)
	{
		
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
