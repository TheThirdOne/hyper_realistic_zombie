package com.benjaminlanders.zombie.view;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.benjaminlanders.zombie.helper.Assets;

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
	/**
	 * 
	 * @param stateTime
	 */
	public void render(float stateTime)
	{
		trash.clear();
		if(units.isEmpty())
			return;
		for(AnimationUnit unit: units)
		{
			if(unit.timeEnded == 0 || unit.timeEnded > stateTime)
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
				unit.frame = Assets.getTexture(Assets.nullimage);
				trash.add(unit);
			}
		}
		units.removeAll(trash);
	}


}
