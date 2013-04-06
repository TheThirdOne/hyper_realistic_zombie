package com.benjaminlanders.zombie.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.zombie.MainGame;

/**
 * The base class for all rendering objects
 * @author Benjamin Landers
 */
public abstract class Renderer
{
	protected MainGame reference;
	protected SpriteBatch batch;
	/**
	 * Constructor that takes batch and a reference to the MainGame
	 * @param batch Thing that will be rendered onto
	 * @param reference a reference that can be used to get other needed resources
	 */
	public Renderer(SpriteBatch batch, MainGame reference)
	{
		this.batch = batch;
		this.reference = reference;
	}
	public abstract void render();
}
