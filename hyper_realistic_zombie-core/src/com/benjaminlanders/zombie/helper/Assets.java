package com.benjaminlanders.zombie.helper;

import java.io.InputStream;

import com.badlogic.gdx.Gdx;
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
			String text = Gdx.app.getFiles().internal("animations/"+animationAddress[reference]+".txt").readString();
			String[] split = text.split(",");
			int[] values = new int[split.length];
			for(int i = 0; i< split.length;i++)
			{
				
				values[i] = Integer.parseInt(split[i]);
			}
			animations[reference] = Loader.loadAnimation("animations/"+animationAddress[reference]+".png",
					values[0],values[1], .01f*values[2]);
		}
		return animations[reference];
	}

}
