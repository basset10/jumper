package com.basset.jumper;

import com.osreboot.ridhvl.display.collection.HvlDisplayModeDefault;
import com.osreboot.ridhvl.painter.painter2d.HvlFontPainter2D;
import com.osreboot.ridhvl.template.HvlTemplateInteg2D;


public class Main extends HvlTemplateInteg2D {
	
	public static float globalTimer = 0;

	static final int SCREEN_TITLE = 0;
	static final int SCREEN_GAME = 1;
	static final int SCREEN_PAUSE = 2;
	static final int SCREEN_INSTRUCTIONS = 3;
	static final int SCREEN_WIN = 4;

	static HvlFontPainter2D font;
	static int screen = 0;
	
	
	
	

	public static void main (String args[]){
		new Main();
	}
	
	Platform[] platforms;

	public Main() {
		super(144, 1280, 720, "Game", new HvlDisplayModeDefault());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		
		getTextureLoader().loadResource("HyprglooPresents");
		getTextureLoader().loadResource("Font");
		getTextureLoader().loadResource("Credit");
		getSoundLoader().loadResource("JumperTitleFinal");

		font = new HvlFontPainter2D(getTexture(1), HvlFontPainter2D.Preset.FP_INOFFICIAL);
		font.setCharSpacing(16);
		
		  
	}

	@Override
	public void update(float delta) {
		
		globalTimer = globalTimer + delta;

		
		if(screen == SCREEN_TITLE) {
			TitleScreen.update(delta);
		}else if(screen == SCREEN_GAME) {
			GameScreen.update(delta);
		}
		
		
		
	
	}
	
	

	
	
}
