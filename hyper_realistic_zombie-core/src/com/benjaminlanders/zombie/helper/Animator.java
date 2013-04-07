package com.benjaminlanders.zombie.helper;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Helper for animations
 * @author Benjamin Landers
 */
public class Animator
{
	private ArrayList<AnimationUnit> units = new ArrayList<AnimationUnit>();
	private ArrayList<AnimationUnit> trash = new ArrayList<AnimationUnit>();
	public void addAnimation(AnimationUnit unit)
	{
		units.add(unit);
	}
	public void render(SpriteBatch batch, float stateTime)
	{
		trash.clear();
		if(units.isEmpty())
			return;
		for(AnimationUnit unit: units)
		{
			if(unit.looping || unit.timeEnded > stateTime)
			{
				if(unit.timeStarted < stateTime)
				{
				Assets.getAnimation(unit.reference).setPlayMode(unit.type);
				unit.frame = Assets.getAnimation(unit.reference).getKeyFrame(stateTime - unit.timeStarted, unit.looping);
				Assets.getAnimation(unit.reference).setPlayMode(Animation.NORMAL);
				}else
				{
					unit.frame = Assets.getTexture(Assets.nullimage);
				}
			}else
			{
				
				trash.add(unit);
			}
		}
		units.removeAll(trash);
	}


}
