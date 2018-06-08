package com.basset.jumper;

import static com.osreboot.ridhvl.painter.painter2d.HvlPainter2D.hvlDrawQuadc;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl.HvlCoord2D;
import com.osreboot.ridhvl.HvlMath;

public class Platform {

	public static final float PLATFORM_SIZE_X = 100;
	public static final float PLATFORM_SIZE_Y = 20;


	private float xPos;
	private float yPos;

	public Platform(float xArg, float yArg) {

		xPos = xArg;
		yPos = yArg;
	}

	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xArg) {
		xPos = xArg;
	}

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yArg) {
		yPos = yArg;
	}

	public void drawPlatform() {
		
		hvlDrawQuadc(xPos, yPos,PLATFORM_SIZE_X, PLATFORM_SIZE_Y, Color.orange);
		
	}
	

}




