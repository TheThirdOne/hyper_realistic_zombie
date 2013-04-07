package com.benjaminlanders.zombie.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.zombie.MainGame;

/**
 * Helper for graphics
 * @author Benjamin Landers
 */
public class Graphics 
{
	/**
	 * Draws a TextureRegion to a SpriteBatch with scale and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scale the scale 1 = same as region, 2 = twice size
	 * @param rotation the rotation in degrees
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,float scale, float rotation)
	{
		y *= MainGame.height;
		x *= MainGame.width;
		batch.draw(region,- region.getRegionWidth()/2 + x, -region.getRegionHeight()/2+y, region.getRegionWidth()/2, region.getRegionHeight()/2,
				region.getRegionWidth(),  region.getRegionHeight(), scale*MainGame.width*.005f, scale*MainGame.width*.005f, rotation);
	}
	/**
	 * Draws a TextureRegion to a SpriteBatch with separate scaling and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scaleX the X scale 
	 * @param scaleY the Y scale 
	 * @param rotation the rotation in degrees
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,float scaleX, float scaleY, float rotation)
	{
		batch.draw(region,- region.getRegionWidth()/2 + x, -region.getRegionHeight()/2+y, region.getRegionWidth()/2,region.getRegionHeight()/2, region.getRegionWidth(),  region.getRegionHeight(), scaleX, scaleY, rotation);
	}
	/**
	 * Draws a TextureRegion to a SpriteBatch with scale, center setting and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scale the scale 
	 * @param rotation the rotation in degrees
	 * @param xSrc the x value of the center the TextureRegion
	 * @param ySrc the y value of the center the TextureRegion
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,int xSrc, int ySrc,float scale, float rotation)
	{
		batch.draw(region,- xSrc+x, -ySrc+y, xSrc, ySrc, region.getRegionWidth(),  region.getRegionHeight(), scale, scale, rotation);
	}
	/**
	 * Draws a TextureRegion to a SpriteBatch with separate scaling, center setting and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scaleX the X scale 
	 * @param scaleY the Y scale 
	 * @param rotation the rotation in degrees
	 * @param xSrc the x value of the center the TextureRegion
	 * @param ySrc the y value of the center the TextureRegion
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,int xSrc, int ySrc,float scaleX, float scaleY, float rotation)
	{
		batch.draw(region,- xSrc+x, -ySrc+y, xSrc, ySrc, region.getRegionWidth(),  region.getRegionHeight(), scaleX, scaleY, rotation);
	}

}
