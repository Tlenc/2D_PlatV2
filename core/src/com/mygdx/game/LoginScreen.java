package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;


public class LoginScreen extends AbstractScreen {

    private Stage stage;
    private Skin skin;
    SpriteBatch batch;


    public LoginScreen(Game game) {
        super(game);


    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("C:\\Users\\Parduotuves\\IdeaProjects\\2D_PlatV2_3\\core\\assets\\uiskin.json"));
        stage = new Stage();


        Label loginLabel = new Label("Please Login:", skin, "default");
        loginLabel.setColor(Color.GRAY);
        loginLabel.setPosition(425, 435);
        stage.addActor(loginLabel);


        TextField txtUsername = new TextField("Username", skin, "default");
        txtUsername.setWidth(300f);
        txtUsername.setHeight(30f);
        txtUsername.setMessageText("Your Nickname");
        txtUsername.setPosition(330, 390);
        stage.addActor(txtUsername);
        String testUser = txtUsername.getText();
        System.out.println(testUser);

        TextField txtPassword = new TextField("Password", skin, "default");
        txtPassword.setWidth(300f);
        txtPassword.setHeight(30f);
        txtPassword.setMessageText("Your Password");
        txtPassword.setPosition(330, 350);
        stage.addActor(txtPassword);
        String testPass = txtPassword.getText();
        System.out.println(testPass);


        final TextButton button = new TextButton("Login", skin, "default");
        final TextButton button2 = new TextButton("Register", skin, "default");
        final TextButton button3 = new TextButton("Exit Game", skin, "default");

        button.setWidth(140f);
        button.setHeight(20f);
        button.setPosition(Gdx.graphics.getWidth() / 2 - 150f, Gdx.graphics.getHeight() / 2 - 5f);
        button2.setWidth(140f);
        button2.setHeight(20f);
        button2.setPosition(Gdx.graphics.getWidth() / 2 - -10, Gdx.graphics.getHeight() / 2 - 5f);
        button3.setWidth(140f);
        button3.setHeight(20f);
        button3.setPosition(Gdx.graphics.getWidth() / 2 - 70f, Gdx.graphics.getHeight() / 2 - 40f);


        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new IntroScreen(game));
            }
        });

        button2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new RegisterScreen(game));
            }
        });

        button3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();

            }
        });

        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);

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
