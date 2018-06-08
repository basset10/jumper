package com.basset.jumper;

import static com.osreboot.ridhvl.painter.painter2d.HvlPainter2D.hvlDrawQuadc;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl.HvlMath;
import com.osreboot.ridhvl.painter.HvlCursor;

public class TitleScreen {
	
	//ACTUAL TITLE SCREEN = INTROSTATE 7
	
	final static float LOGOX = 900.0f;
	final static float LOGOY = 600.0f;

	final static float BUTTONX = 1280.0f/2.0f;
	final static float BUTTON1_Y = 720.0f/1.65f;
	final static float BUTTON2_Y = 720.0f/1.65f + 100;
	final static float BUTTON3_Y = 720.0f/1.65f + 200;
	final static float BUTTON_HEIGHT = 80.0f;
	final static float BUTTON_WIDTH = 325.0f;

	public static int introState = 1;

	private static float opacityCredit1 = 0f;
	private static float opacityCredit2 = 0f; 
	private static float tempTimer = 0f;
	private static boolean tempTimerActive = false;
	public static boolean musicStarted = false;



	static void update(float delta) {
		
		
		
		
		if(introState <= 6) {
		Main.font.drawWordc("Space to Skip", 100, 700, Color.white, 0.1f); 
		}


		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			opacityCredit1 = 0f;
			opacityCredit2 = 0f;
			introState = 7;
		}
		
		if(tempTimer != 0) {
			tempTimerActive = true;
		}else if(tempTimer == 0) {
			tempTimerActive = false;
		}




		
		


		if(Keyboard.isKeyDown(Keyboard.KEY_C)){
			Main.screen = Main.SCREEN_GAME;
		}

		//HYPRGLOO presents
		hvlDrawQuadc(1280/2, 720/2, LOGOX, LOGOY, Main.getTexture(0), new Color(1f, 1f, 1f, opacityCredit1));

		//A game by Basset
		hvlDrawQuadc(1280/2, 720/2, LOGOX, LOGOY, Main.getTexture(2), new Color(0.1f, 0.1f, 1.0f, opacityCredit2));


		if(introState == 1) {
			opacityCredit1 = HvlMath.stepTowards(opacityCredit1, 0.005f, 1f);
		}

		if(opacityCredit1 == 1f && introState == 1) {
			introState = 2;
		}


		if(!tempTimerActive && introState == 2) {
			getTimer();
		}

		if(Main.globalTimer >= tempTimer + 1 && introState == 2) {

			introState = 3;

		}

		if(introState == 3) {
			opacityCredit1 = HvlMath.stepTowards(opacityCredit1, 0.005f, 0f);
			clearTimer();
		}

		if(opacityCredit1 == 0f && introState == 3) {

			introState = 4;

		}

		if(introState == 4) {
			opacityCredit2 = HvlMath.stepTowards(opacityCredit2, 0.005f, 1f);
		}

		if(opacityCredit2 == 1f && introState == 4) {
			introState = 5;
		}


		if(!tempTimerActive && introState == 5) {
			getTimer();
		}

		if(Main.globalTimer >= tempTimer + 1 && introState == 5) {

			introState = 6;

		}

		if(introState == 6) {
			opacityCredit2 = HvlMath.stepTowards(opacityCredit2, 0.005f, 0f);
			clearTimer();
		}

		if(opacityCredit2 == 0f && introState == 6) {

			introState = 7;

		}
























if(introState == 7) {
	
	if(!musicStarted) {
	Main.getSound(0).playAsMusic(1f, 2f, true);
	musicStarted = true;
	}
	
		if(HvlCursor.getCursorX() > BUTTONX - (BUTTON_WIDTH/2) && HvlCursor.getCursorX() < BUTTONX + (BUTTON_WIDTH/2) &&
				HvlCursor.getCursorY() > BUTTON1_Y - (BUTTON_HEIGHT/2) && HvlCursor.getCursorY() < BUTTON1_Y + (BUTTON_HEIGHT/2)) {
			hvlDrawQuadc(BUTTONX, BUTTON1_Y, BUTTON_WIDTH, BUTTON_HEIGHT, Color.gray);
			if(Mouse.isButtonDown(0)){
				Main.screen = Main.SCREEN_GAME;
				musicStarted = false;
			}
		}else{
			hvlDrawQuadc(BUTTONX, BUTTON1_Y, BUTTON_WIDTH, BUTTON_HEIGHT, Color.white);
		}

		if(HvlCursor.getCursorX() > BUTTONX - (BUTTON_WIDTH/2) && HvlCursor.getCursorX() < BUTTONX + (BUTTON_WIDTH/2) &&
				HvlCursor.getCursorY() > BUTTON2_Y - (BUTTON_HEIGHT/2) && HvlCursor.getCursorY() < BUTTON2_Y + (BUTTON_HEIGHT/2)) {
			hvlDrawQuadc(BUTTONX, BUTTON2_Y, BUTTON_WIDTH, BUTTON_HEIGHT, Color.gray);
			if(Mouse.isButtonDown(0)){
				Main.screen = Main.SCREEN_INSTRUCTIONS;
			}
		}else{
			hvlDrawQuadc(BUTTONX, BUTTON2_Y, BUTTON_WIDTH, BUTTON_HEIGHT, Color.white);
		}

		if(HvlCursor.getCursorX() > BUTTONX - (BUTTON_WIDTH/2) && HvlCursor.getCursorX() < BUTTONX + (BUTTON_WIDTH/2) &&
				HvlCursor.getCursorY() > BUTTON3_Y - (BUTTON_HEIGHT/2) && HvlCursor.getCursorY() < BUTTON3_Y + (BUTTON_HEIGHT/2)) {
			hvlDrawQuadc(BUTTONX, BUTTON3_Y, BUTTON_WIDTH, BUTTON_HEIGHT, Color.gray);
			if(Mouse.isButtonDown(0)){
				System.exit(0);
			}
		}else{
			hvlDrawQuadc(BUTTONX, BUTTON3_Y, BUTTON_WIDTH, BUTTON_HEIGHT, Color.white);
		}

		
		
		Main.font.drawWordc("JUMPER", BUTTONX, 265 + ((float)Math.sin(Main.getNewestInstance().getTimer().getTotalTime())*10), Color.white, 1.0f);
		Main.font.drawWordc("Start Game", BUTTONX, BUTTON1_Y, Color.black, 0.25f); 
		Main.font.drawWordc("Settings", BUTTONX, BUTTON2_Y, Color.black, 0.25f);
		Main.font.drawWordc("Quit Game", BUTTONX, BUTTON3_Y, Color.black, 0.25f);
		
		
}
		 

	}

	public static void getTimer() {

		tempTimer = Main.globalTimer;

	}

	public static void clearTimer() {
		tempTimer = 0;
	}

}


