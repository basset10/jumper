package com.basset.jumper;

import static com.osreboot.ridhvl.painter.painter2d.HvlPainter2D.hvlDrawQuadc;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl.HvlMath;



public class GameScreen {


	static float xPos = 1280/4;
	static float yPos = 580;
	static float jumpSpeed = 3;
	static float jumpHeight = 530;
	static boolean jumpState = false;
	static boolean fallState = false;
	
	static float platformxPos = 1200;
	static float platformSpeed = 3;
	

	static void update(float delta) {

		hvlDrawQuadc(1280/2, 670, 1280, 150, Color.blue);

		hvlDrawQuadc(xPos, yPos, 15, 50, Color.gray);

		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && fallState == false && jumpState == false) {

			jumpState = true;

		}



		if(jumpState) {
			yPos = HvlMath.stepTowards(yPos, jumpSpeed, jumpHeight);
		}

		if(yPos == jumpHeight) {
			jumpState = false;
			fallState = true;

		}

		if(fallState) {
			yPos = HvlMath.stepTowards(yPos, jumpSpeed, 580);
		}

		if(yPos == 580) {
			jumpState = false;
			fallState = false;

		}

		//Starting platform



		//Platforms

		
		
		if(jumpState || fallState) {
			platformxPos = HvlMath.stepTowards(platformxPos, platformSpeed, -50);
		}
	}
	
	public static void drawPlatform(float xArg, float yArg, int textureIndex, boolean collision){
		
		Color color = Color.white;

		
	}
	
}
