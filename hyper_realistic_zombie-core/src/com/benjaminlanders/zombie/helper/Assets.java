package com.benjaminlanders.zombie.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.zombie.MainGame;

/**
 * Stores all the loaded assets in a usable way
 * @author Benjamin Landers
 */
public class Assets
{
	public static MainGame application;
	private static final String[] animationAddress = {"legs","arms","ball","gun","fire"};
 	public static Animation[] animations = new Animation[5];
	public static final int legsAnim = 0;
	public static final int armsAnim = 1;
	public static final int ballAnim = 2;
	public static final int gunAnim =  3;
	public static final int fireAnim = 4;
	
	private static final String[] imageAddress = {"nullimage"};
	public static TextureRegion[] images = new TextureRegion[1];
	public static final int nullimage = 0;
	
	/**
	 * gets the image if its loaded, if not it loads and then gives it
	 * @param reference the value in the array for the correct image. use the constants
	 * @return the image
	 */
	public static TextureRegion getImage(int reference)
	{
		if(images.length < reference)
			return null;
		if(images[reference]==null)
		{
			images[reference] = new TextureRegion(new Texture(Gdx.files.internal("images/"+imageAddress[reference]+".png")));
		}
		return images[reference];
	}
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
