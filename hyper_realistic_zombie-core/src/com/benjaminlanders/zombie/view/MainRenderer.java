package com.benjaminlanders.zombie.view;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.zombie.MainGame;
import com.benjaminlanders.zombie.helper.Assets;
import com.benjaminlanders.zombie.helper.Graphics;
/**
 * Currently a test bed for graphics
 * @author Benjamin Landers
 */
public class MainRenderer extends Renderer
{
	TextureRegion currentFrame;
	float stateTime = 0;
	AnimationUnit frameUpdater = new AnimationUnit(0,Animation.NORMAL,Assets.legsAnim,0,0,true);
	AnimationUnit frameUpdater2 = new AnimationUnit(0,Animation.NORMAL,Assets.armsAnim,0,3,true);
	AnimationUnit frameUpdater3 = new AnimationUnit(0,Animation.NORMAL,Assets.gunAnim,3,4f,false);
	AnimationUnit frameUpdater4 = new AnimationUnit(0,Animation.NORMAL,Assets.fireAnim,3.6f,4,false);
	AnimationUnit frameUpdater5 = new AnimationUnit(0,Animation.REVERSED,Assets.gunAnim,4,5.6f,false);
	AnimationUnit frameUpdater6 = new AnimationUnit(0,Animation.NORMAL,Assets.armsAnim,5.6f,0,true);
	public MainRenderer(SpriteBatch batch, MainGame reference)
	{
		super(batch, reference);
		reference.animator.addAnimation(frameUpdater);
		reference.animator.addAnimation(frameUpdater2);
		reference.animator.addAnimation(frameUpdater3);
		reference.animator.addAnimation(frameUpdater4);
		reference.animator.addAnimation(frameUpdater5);
		reference.animator.addAnimation(frameUpdater6);
	}

	@Override
	public void render(float delta) 
	{
        stateTime += delta;                     
        currentFrame = Assets.animations[Assets.legsAnim].getKeyFrame(stateTime, true); 
		batch.begin();
		reference.animator.render(stateTime);
		Graphics.draw(batch,frameUpdater.frame,100,100,.5f,0);
		Graphics.draw(batch,frameUpdater2.frame,100,100,.5f,0);
		Graphics.draw(batch,frameUpdater3.frame,100,100,.5f,0);
		Graphics.draw(batch,frameUpdater4.frame,100,200,.5f,0);
		Graphics.draw(batch,frameUpdater5.frame,100,100,.5f,0);
		Graphics.draw(batch,frameUpdater6.frame,100,100,.5f,0);
        batch.end();
	}

	@Override
	public boolean isFinished() 
	{
		
		return false;
	}

}
