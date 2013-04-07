package com.benjaminlanders.zombie.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	AnimationUnit[] frameUpdater = new AnimationUnit[6];
	GraphicEntity entity;
	BitmapFont font = new BitmapFont();
	public MainRenderer(SpriteBatch batch, MainGame reference)
	{
		super(batch, reference);
		frameUpdater[0] = new AnimationUnit(0,Animation.NORMAL,Assets.legsAnim,0,0,true);
		frameUpdater[1] = new AnimationUnit(0,Animation.NORMAL,Assets.armsAnim,0,3,true);
		frameUpdater[2] = new AnimationUnit(0,Animation.NORMAL,Assets.gunAnim,3,4f,false);
		frameUpdater[3] = new AnimationUnit(0,Animation.NORMAL,Assets.fireAnim,3.6f,4,false);
		frameUpdater[4] = new AnimationUnit(0,Animation.REVERSED,Assets.gunAnim,4,5.6f,false);
		frameUpdater[5] = new AnimationUnit(0,Animation.NORMAL,Assets.armsAnim,5.6f,0,true);
		entity = new GraphicEntity(frameUpdater);
		reference.animator.addAnimation(frameUpdater[0]);
		reference.animator.addAnimation(frameUpdater[1]);
		reference.animator.addAnimation(frameUpdater[2]);
		reference.animator.addAnimation(frameUpdater[3]);
		reference.animator.addAnimation(frameUpdater[4]);
		reference.animator.addAnimation(frameUpdater[5]);
	}

	@Override
	public void render(float delta) 
	{
        stateTime += delta;                     
        currentFrame = Assets.animations[Assets.legsAnim].getKeyFrame(stateTime, true); 
		batch.begin();
		reference.animator.render(stateTime);
		entity.render(batch);
		font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), 400, 300);
        batch.end();
	}

	@Override
	public boolean isFinished() 
	{
		
		return false;
	}

}
