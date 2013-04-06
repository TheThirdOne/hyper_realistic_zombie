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
	private static final String[] animationAddress = {"legs","arms","ball"};
 	public static Animation[] animations = new Animation[3];
	public static final int legs = 0;
	public static final int arms = 1;
	public static final int ball = 2;
	/**
	 * gets the animation if its loaded, if not it loads and then gives it
	 * @param reference the value in the array for the correct animation. use the constants
	 * @return the animation
	 */
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
