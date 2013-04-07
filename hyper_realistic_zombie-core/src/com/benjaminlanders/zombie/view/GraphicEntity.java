package com.benjaminlanders.zombie.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.zombie.helper.Graphics;

/**
 * Used to group animations
 * @author Benjamin Landers
 */
public class GraphicEntity
{
	protected AnimationUnit[] units;
	public int[] xCenter, yCenter;
	
	public GraphicEntity(int size)
	{
		units = new AnimationUnit[size];
		xCenter = new int[size];
		yCenter = new int[size];
	}
	public GraphicEntity(AnimationUnit[] units)
	{
		this.units = units;
		xCenter = new int[units.length];
		yCenter = new int[units.length];
	}
	
	public void render(SpriteBatch batch)
	{
		for(AnimationUnit unit:units)
		{
			Graphics.draw(batch,unit.frame,.5f,.5f,.1f,0); 
		}
	}

}
