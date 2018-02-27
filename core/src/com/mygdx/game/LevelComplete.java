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

import java.io.*;

public class LevelComplete extends AbstractScreen {
    private Stage stage;
    private Skin skin;
    TextureRegion intro;
    SpriteBatch batch;
    float time = 0;

    public LevelComplete(Game game) {
        super(game);
     //   Timer.StopTimer();
    }




    @Override
    public void show (){

        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("core\\assets\\uiskin.json"));
        stage = new Stage();


        Label lvlSelectLabel = new Label("YOUR SCORE   " +Timer.getEndTIme(), skin, "default");
       // Label lvlScore = new Label("YOUR SCORE"+Timer.getEndTIme(), skin, "default");
        lvlSelectLabel.setColor(Color.GRAY);
        lvlSelectLabel.setPosition(425, 450);
        stage.addActor(lvlSelectLabel);
        //stage.addActor(lvlScore);


        final TextButton button0 = new TextButton("Submit Score", skin, "default");
        final TextButton button = new TextButton("Play Again", skin, "default");
        final TextButton button2 = new TextButton("Select Level", skin, "default");
        final TextButton button3 = new TextButton("Exit", skin, "default");

        button.setWidth(200f);
        button.setHeight(20f);
        button.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 10f);
        button2.setWidth(200f);
        button2.setHeight(20f);
        button2.setPosition(Gdx.graphics.getWidth() /2 - 100, Gdx.graphics.getHeight()/2 - 40);
        button3.setWidth(200f);
        button3.setHeight(20f);
        button3.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 70f);
        button0.setWidth(200f);
        button0.setHeight(20f);
        button0.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - -20f);



        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new GameScreen(game));

            }
        });

        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new LevelSelectScreen(game));

            }
        });

        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });

        button0.addListener(new ClickListener() {
                                @Override
                                public void clicked(InputEvent event, float x, float y) {
                                    System.out.println("Userio SCORE: " + Timer.getEndTIme());

                                    BufferedWriter bw = null;
                                    FileWriter fw = null;

                                    try {
                                        Long rezult = Timer.getEndTIme();

                                        String content = Long.toString(rezult);


                                        fw = new FileWriter("core\\assets\\duomenys.txt",true);
                                        bw = new BufferedWriter(fw);
                                        bw.write("" + content);

                                        System.out.println("Done");

                                    } catch (IOException e) {

                                        e.printStackTrace();

                                    } finally {

                                        try {

                                            if (bw != null)
                                                bw.close();

                                            if (fw != null)
                                                fw.close();

                                        } catch (IOException ex) {

                                            ex.printStackTrace();

                                        }

                                    }

                                }
                            });


        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button0);

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
