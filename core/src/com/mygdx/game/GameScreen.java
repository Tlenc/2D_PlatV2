package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.Map;
import com.mygdx.game.MapRenderer;

public class GameScreen extends AbstractScreen {

    Map map;
    MapRenderer mapRenderer;

    public GameScreen (Game game) {
        super(game);
    }

    @Override
    public void show () {
        map = new Map();
        mapRenderer = new MapRenderer(map);
    }

    @Override
    public void render (float delta) {

        delta = Math.min(0.06f, Gdx.graphics.getDeltaTime());
        map.update(delta);
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mapRenderer.render(delta);

        if (map.Player.bounds.overlaps(map.endDoor.bounds)) {

            //pakeistas ekranas i LevelComplete
      //      game.setScreen(new GameOverScreen(game));
            game.setScreen(new LevelComplete(game));
        }

        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            game.setScreen( MainMenu.getInstance(game));
        }
    }

    @Override
    public void hide () {
        Gdx.app.debug("Platformer", "dispose game screen");

    }
}