package com.benjaminlanders.zombie.view;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.zombie.MainGame;
import com.benjaminlanders.zombie.helper.AnimationUnit;
import com.benjaminlanders.zombie.helper.Assets;
import com.benjaminlanders.zombie.helper.Graphics;

public class MainRenderer extends Renderer
{
	TextureRegion currentFrame;
	float stateTime = 0;
	AnimationUnit frameUpdater = new AnimationUnit(0,Animation.NORMAL,Assets.fireAnim,0,7,true);
	AnimationUnit frameUpdater2 = new AnimationUnit(0,Animation.REVERSED,Assets.fireAnim,4,7,true);
	public MainRenderer(SpriteBatch batch, MainGame reference)
	{
		super(batch, reference);
		reference.animator.addAnimation(frameUpdater);
		reference.animator.addAnimation(frameUpdater2);
	}

	@Override
	public void render(float delta) 
	{
        stateTime += delta;                     
        currentFrame = Assets.animations[Assets.legsAnim].getKeyFrame(stateTime, true); 
		batch.begin();
		reference.animator.render(batch,stateTime);
		Graphics.draw(batch,frameUpdater.frame,100,100,133,127,.5f,0);
		Graphics.draw(batch,frameUpdater2.frame,100,300,133,127,.5f,0);
       /* Graphics.draw(batch,currentFrame,100,100,133,127,.5f,0);
        if(stateTime <2.5f)
        {
        	currentFrame = Assets.animations[Assets.arms].getKeyFrame(stateTime, true);  
        }else{
        currentFrame = Assets.animations[Assets.gun].getKeyFrame(stateTime-2.5f, false);  
        if(stateTime > 5 )
        {
        	Assets.animations[Assets.gun].setPlayMode(Animation.REVERSED);
        	 currentFrame = Assets.animations[Assets.gun].getKeyFrame(stateTime-5, false);  
        	if(stateTime > 5.6f)
        		currentFrame = Assets.animations[Assets.arms].getKeyFrame(stateTime-5.6f, true);  
        }
        }
        Graphics.draw(batch,currentFrame,100,100,133,127,.5f,0);*/
        batch.end();
	}

	@Override
	public boolean isFinished() 
	{
		
		return false;
	}

}
