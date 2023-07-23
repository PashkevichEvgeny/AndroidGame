package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.consolgame.Main;
import com.mygdx.game.consolgame.model.BaseHero;
import com.mygdx.game.consolgame.model.heroes.Archer;
import com.mygdx.game.consolgame.model.heroes.Crossbowman;
import com.mygdx.game.consolgame.model.heroes.Monk;
import com.mygdx.game.consolgame.model.heroes.Peasant;
import com.mygdx.game.consolgame.model.heroes.Robber;
import com.mygdx.game.consolgame.model.heroes.Sorcerer;
import com.mygdx.game.consolgame.model.heroes.Spearman;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	Main game;
	SpriteBatch batch;
	Texture background;
	Music music;
	BitmapFont font;
	Texture  crossbowman;
	Texture  mage;
	Texture  monk;
	Texture  peasant;
	Texture  rouge;
	Texture  sniper;
	Texture  spearman;
	boolean play, clk, goodAllDead, evilAllDead;

	@Override
	public void create () {
		play = clk = true;
	    game = new Main();
		game.main();
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.CYAN);
		background = new Texture("backgrounds/" + Backgrounds.values()[new Random().nextInt(Backgrounds.values().length)] + ".png");
		crossbowman = new Texture("skins/CrossBowMan.png");
		mage =        new Texture("skins/Mage.png");
		monk =        new Texture("skins/Monk.png");
		peasant =     new Texture("skins/Peasant.png");
		rouge =       new Texture("skins/Rouge.png");
		sniper =      new Texture("skins/Sniper.png");
		spearman =    new Texture("skins/SpearMan.png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/theme.mp3"));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(background, 0, 0 ,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		music.setLooping(true);

		int side;
		int kx = Gdx.graphics.getWidth() / 12;
		int ky = Gdx.graphics.getHeight() / 12;
		for (BaseHero hero: game.allTeam) {
			if (hero.state.equals(BaseHero.State.Dead)) continue;
			side = (game.teamGood.contains(hero)) ? 1 : -1;
			if (hero instanceof Crossbowman) batch.draw(crossbowman, hero.getPosition().getX() * kx, hero.getPosition().getY() * ky, 46 * side, 92);
			if (hero instanceof Sorcerer) batch.draw(mage,           hero.getPosition().getX() * kx, hero.getPosition().getY() * ky, 46 * side, 92);
			if (hero instanceof Monk) batch.draw(monk,               hero.getPosition().getX() * kx, hero.getPosition().getY() * ky, 46 * side, 92);
			if (hero instanceof Peasant) batch.draw(peasant,         hero.getPosition().getX() * kx, hero.getPosition().getY() * ky, 46 * side, 92);
			if (hero instanceof Robber) batch.draw(rouge,            hero.getPosition().getX() * kx, hero.getPosition().getY() * ky, 46 * side, 92);
			if (hero instanceof Archer) batch.draw(sniper,           hero.getPosition().getX() * kx, hero.getPosition().getY() * ky, 46 * side, 92);
			if (hero instanceof Spearman) batch.draw(spearman,       hero.getPosition().getX() * kx, hero.getPosition().getY() * ky, 46 * side, 100);
            if (goodAllDead) font.draw(batch, "Evil wins\nGame Over", kx * 5, ky * 6);
            if (evilAllDead) font.draw(batch, "Good wins\nGame Over", kx * 5, ky * 6);
		}
		batch.end();
		if(Gdx.input.isTouched() && play && clk) {
			music.play();
			clk = false;
			game.run();
			goodAllDead = evilAllDead = true;
			for (BaseHero hero: game.teamGood) {
				if (!hero.state.equals(BaseHero.State.Dead)) {
					goodAllDead = false;
					break;
				}
			}
			for (BaseHero hero: game.teamEvil) {
				if (!hero.state.equals(BaseHero.State.Dead)) {
					evilAllDead = false;
					break;
				}
			}
			if (goodAllDead) {
				Gdx.graphics.setTitle("Evil wins");
				music.stop();
				play = false;
			}
			if (evilAllDead) {
				Gdx.graphics.setTitle("Good wins");
				music.stop();
				play = false;
			}
		}
		if (!Gdx.input.isTouched()) clk = true;
	}

	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		crossbowman.dispose();
		mage.dispose();
		monk.dispose();
		peasant.dispose();
		rouge.dispose();
		sniper.dispose();
		spearman.dispose();
		music.dispose();
		font.dispose();
	}
}
