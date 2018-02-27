package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LevelSelectScreen extends AbstractScreen {

    private Stage stage;
    private Skin skin;
    TextureRegion intro;
    SpriteBatch batch;
    float time = 0;

    public LevelSelectScreen(Game game) {
        super(game);
    }



    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("C:\\Users\\Parduotuves\\IdeaProjects\\2D_PlatV2_3\\core\\assets\\uiskin.json"));
        stage = new Stage();

        Label lvlSelectLabel = new Label("SELECT YOUR LEVEL", skin, "default");
        lvlSelectLabel.setColor(Color.GRAY);
        lvlSelectLabel.setPosition(425, 350);
        stage.addActor(lvlSelectLabel);

        final TextButton button = new TextButton("1", skin, "default");
        final TextButton button2 = new TextButton("2", skin, "default");
        final TextButton button3 = new TextButton("3", skin, "default");
        final TextButton button4 = new TextButton("4", skin, "default");
        final TextButton button5 = new TextButton("5", skin, "default");

        button.setWidth(30f);
        button.setHeight(30f);
        button.setPosition(Gdx.graphics.getWidth() /2 - 90f, Gdx.graphics.getHeight()/2 - 10f);
        button2.setWidth(30f);
        button2.setHeight(30f);
        button2.setPosition(Gdx.graphics.getWidth() /2 - 45, Gdx.graphics.getHeight()/2 - 10);
        button3.setWidth(30f);
        button3.setHeight(30f);
        button3.setPosition(Gdx.graphics.getWidth() /2, Gdx.graphics.getHeight()/2 - 10f);
        button4.setWidth(30f);
        button4.setHeight(30f);
        button4.setPosition(Gdx.graphics.getWidth() /2 +45f, Gdx.graphics.getHeight()/2 - 10f);
        button5.setWidth(30f);
        button5.setHeight(30f);
        button5.setPosition(Gdx.graphics.getWidth() /2 +90f, Gdx.graphics.getHeight()/2 - 10f);



        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new GameScreen(game));
            }
        });

        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
               System.out.println("Level 2 does not exist, YET");
            }
        });

        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.out.println("Level 3 does not exist, YET");
            }
        });

        button4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.out.println("Level 4 does not exist, YET");
            }
        });

        button5.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.out.println("Level 5 does not exist, YET");
            }
        });

        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(button5);

        Gdx.input.setInputProcessor(stage);
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



