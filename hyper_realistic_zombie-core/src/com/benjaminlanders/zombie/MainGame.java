package com.benjaminlanders.zombie;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.zombie.helper.Assets;
import com.benjaminlanders.zombie.view.MainRenderer;
import com.benjaminlanders.zombie.view.Renderer;
import com.benjaminlanders.zombie.view.SplashScreen;

public class MainGame implements ApplicationListener 
{
	private boolean wasPaused= false;
	private Renderer renderer;
	private SpriteBatch batch;
	float stateTime;
	float threshold=2;
	Sound gun;
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
		Assets.getAnimation(Assets.gun);
        stateTime = 0f;  
        gun = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot1.wav"));
        gun.play();
        
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
		if(!wasPaused)
		{
			stateTime += Gdx.graphics.getDeltaTime();
			wasPaused = false;
		}
		if(stateTime > threshold)
		{
			gun.play();
			threshold += 5f;
		}
        if(renderer.isFinished())
        {
        	renderer = new MainRenderer(batch,this);
        }
		if(wasPaused)
		{
			stateTime += Gdx.graphics.getDeltaTime();
			renderer.render(.01f);
			wasPaused = false;		
		}else
		{
			renderer.render(Gdx.graphics.getDeltaTime());
		}
        
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
		wasPaused = true;
	}
}
