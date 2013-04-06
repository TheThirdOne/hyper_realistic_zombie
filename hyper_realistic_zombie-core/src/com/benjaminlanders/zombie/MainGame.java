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
	float stateTime;
	public MainGame()
	{
	
	}
	
	@Override
	public void create() 
	{		
		
		batch = new SpriteBatch();
		renderer = new SplashScreen(batch,this,new Texture(Gdx.files.internal("data/libgdx.png")));
		Assets.getAnimation(Assets.legs);
		Assets.getAnimation(Assets.arms);
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
        if(renderer.isFinished())
        {
        	renderer = new MainRenderer(batch,this);
        }
        renderer.render(Gdx.graphics.getDeltaTime());
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
