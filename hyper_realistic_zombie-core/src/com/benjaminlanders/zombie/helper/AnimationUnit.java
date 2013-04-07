package com.benjaminlanders.zombie.helper;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationUnit
{
	public AnimationUnit(int id, int type, int reference, float timeStarted,float timeEnded, boolean looping)
	{
		this.id = id;
		this.type = type;
		this.reference = reference;
		this.timeStarted = timeStarted;
		this.timeEnded = timeEnded;
		this.looping = looping;
	}
	public int id;
	public int type;
	public int reference;
	public float timeStarted;
	public boolean looping;
	public float timeEnded;
	public TextureRegion frame;
	
}
