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
	/** 
	 * all rendering should go in here
	 * @param delta time elapsed in seconds from last call
	 */
	public abstract void render(float delta);
	
	/**
	 * 
	 * @return if the renderer is done with its job
	 */
	public abstract boolean isFinished();
}
