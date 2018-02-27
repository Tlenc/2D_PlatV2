package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class LevelComplete extends AbstractScreen {
    private Stage stage;
    private Skin skin;
    TextureRegion intro;
    SpriteBatch batch;
    float time = 0;

    public LevelComplete(Game game) {
        super(game);
        Timer.StopTimer();
    }


    public void getTime() {
        Timer.getEndTIme();

    }

    @Override
    public void show (){

        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("C:\\Users\\Parduotuves\\IdeaProjects\\2D_PlatV2_3\\core\\assets\\uiskin.json"));
        stage = new Stage();


        Label lvlSelectLabel = new Label("YOUR SCORE" +Timer.getEndTIme(), skin, "default");
       // Label lvlScore = new Label("YOUR SCORE"+Timer.getEndTIme(), skin, "default");
        lvlSelectLabel.setColor(Color.GRAY);
        lvlSelectLabel.setPosition(425, 350);
        stage.addActor(lvlSelectLabel);
        //stage.addActor(lvlScore);


    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        stage.draw();
        batch.end();



    }
}
