package com.benjaminlanders.zombie.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.zombie.view.Renderer;
import com.benjaminlanders.zombie.MainGame;

public class SplashScreen extends Renderer
{
	Texture splash;
	float timeElapsed = 0;
	public static final float END_TIME=5;

	public SplashScreen(SpriteBatch batch, MainGame reference,Texture splash)
	{
		super(batch, reference);
		this.splash = splash;
		
	}

	public void render(float delta)
	{
		timeElapsed += delta;
		batch.begin();
		batch.draw(splash, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}
	public boolean isFinished()
	{
		return timeElapsed > END_TIME;
	}


}
