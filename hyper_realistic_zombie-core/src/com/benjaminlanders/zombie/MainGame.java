package com.benjaminlanders.zombie;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.zombie.helper.Assets;
import com.benjaminlanders.zombie.view.Animator;
import com.benjaminlanders.zombie.view.MainRenderer;
import com.benjaminlanders.zombie.view.Renderer;
import com.benjaminlanders.zombie.view.SplashScreen;

public class MainGame implements ApplicationListener 
{
	public static int width,height;
	private boolean wasPaused= false;
	private Renderer renderer;
	private SpriteBatch batch;
	float stateTime;
	float threshold=2;
	public Sound gun;
	public Animator animator = new Animator();
	public MainGame()
	{
	
	}
	
	@Override
	public void create() 
	{		
		height = Gdx.graphics.getHeight();
		width = Gdx.graphics.getWidth();
		batch = new SpriteBatch();
		renderer = new SplashScreen(batch,this,new Texture(Gdx.files.internal("data/libgdx.png")));
		Assets.getAnimation(Assets.legsAnim);
		Assets.getAnimation(Assets.armsAnim);
		Assets.getAnimation(Assets.gunAnim);
        stateTime = 0f;  
        gun = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot1.wav"));    
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
