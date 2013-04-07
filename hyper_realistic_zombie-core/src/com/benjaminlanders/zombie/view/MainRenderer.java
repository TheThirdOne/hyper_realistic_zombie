package com.benjaminlanders.zombie.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.zombie.MainGame;
import com.benjaminlanders.zombie.helper.Assets;
import com.benjaminlanders.zombie.helper.Graphics;

public class MainRenderer extends Renderer
{
	TextureRegion currentFrame;
	float stateTime = 0;
	public MainRenderer(SpriteBatch batch, MainGame reference)
	{
		super(batch, reference);
	}

	@Override
	public void render(float delta) 
	{
        stateTime += delta;                     
        currentFrame = Assets.animations[Assets.legs].getKeyFrame(stateTime, true); 
		batch.begin();
        Graphics.draw(batch,currentFrame,100,100,133,127,.5f,0);
        if(stateTime <10)
        {
        	currentFrame = Assets.animations[Assets.arms].getKeyFrame(stateTime, true);  
        }else{
        currentFrame = Assets.animations[Assets.gun].getKeyFrame(stateTime-10, false);  
        }
        Graphics.draw(batch,currentFrame,100,100,133,127,.5f,0);
        batch.end();
	}

	@Override
	public boolean isFinished() 
	{
		
		return false;
	}

}
