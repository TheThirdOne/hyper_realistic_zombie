package com.benjaminlanders.zombie.helper;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.benjaminlanders.zombie.MainGame;

/**
 * Stores all the loaded assets in a usable way
 * @author Benjamin Landers
 */
public class Assets
{
	public static MainGame application;
	public static final String[] animationAddress = {"legs","arms"};
 	public static Animation[] animations = new Animation[2];
	public static final int legs = 0;
	public static final int arms = 1;
	
	public static Animation getAnimation(int reference)
	{
		if(animations.length < reference)
			return null;
		if(animations[reference]==null)
		{
			animations[reference] = Loader.loadAnimation(animationAddress[reference]);
		}
		return animations[reference];
	}

}
