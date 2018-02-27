package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainMenu extends AbstractScreen {

    TextureRegion title;
    SpriteBatch batch;
    float time = 0;
    Music music;
    boolean arGroja = true;
    private static MainMenu _instance;

    public static MainMenu getInstance(Game game) {
        if (_instance == null) {
            _instance = new MainMenu(game);
        }
        return _instance;
    }

    public boolean getArGroja() {
        System.out.println("is geteris " + arGroja);
        return arGroja;
    }

    public void setArGroja(boolean value) {

        this.arGroja = value;
        System.out.println("is seteris " + arGroja);
        if (value) {
            music.play();
        } else {
            music.pause();
        }
    }

    public MainMenu(Game game) {
        super(game);
        music = Gdx.audio.newMusic(Gdx.files.internal("core/assets/avgnTutorial.mp3"));
        music.play();


        //  music.setVolume((float) 0.5);
    }

    @Override
    public void show() {
        title = new TextureRegion(new Texture(Gdx.files.internal("core/assets/platGameIntro.png")), 0, 0, 480, 320);
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(title, 0, 0);
        batch.end();
        //  time += delta;
        // if (time > 1) {
        if (Gdx.input.isKeyPressed(Keys.ANY_KEY) || Gdx.input.justTouched()) {
            // game.setScreen(new LoginScreen(game));
            game.setScreen(new IntroScreen(game));
        }
    }
    // }

    @Override
    public void hide() {
        Gdx.app.debug("Platformer", "dispose main menu");
        batch.dispose();
        title.getTexture().dispose();
    }
}