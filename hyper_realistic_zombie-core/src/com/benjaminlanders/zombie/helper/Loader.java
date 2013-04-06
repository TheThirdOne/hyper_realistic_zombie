package com.benjaminlanders.zombie.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * provides loading functions to ease programming and increase readability
 * @author Benjamin Landers
 */
public class Loader
{
	/**
	 * A function to load animations from a file. It starts left to right then down one.
	 * @param address A string that refers to the location of the file
	 * @param columns the number of columns
	 * @param rows the number of rows
	 * @param timePerFrame A float that is the time 1 frame will be one the screen in seconds
	 * @return the finished animation
	 */
	public static Animation loadAnimation(String address, int columns, int rows, float timePerFrame)
	{
		Texture texture = new Texture(Gdx.files.internal(address));
		TextureRegion[][] temp = TextureRegion.split(texture,texture.getWidth()/columns, texture.getHeight()/rows);
		TextureRegion[] frames = new TextureRegion[columns*rows];
		int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                    frames[index++] = temp[i][j];
            }
        }
		return  new Animation(timePerFrame, frames);
		
	}
}
