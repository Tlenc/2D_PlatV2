package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class RegisterScreen extends AbstractScreen{



    private Stage stage;
    private Skin skin;
    SpriteBatch batch;

    public RegisterScreen(Game game) {
        super(game);
    }



    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("C:\\Users\\Parduotuves\\IdeaProjects\\2D_PlatV2_3\\core\\assets\\uiskin.json"));
        stage = new Stage();


        Label loginLabel = new Label("Register a new user", skin, "default");
        loginLabel.setColor(Color.GRAY);
        loginLabel.setPosition(385, 435);
        stage.addActor(loginLabel);


        TextField txtCreateUsername = new TextField("Enter Username", skin, "default");
        txtCreateUsername.setWidth(300f);
        txtCreateUsername.setHeight(30f);
        txtCreateUsername.setMessageText("New Nickname");
        txtCreateUsername.setPosition(330, 390);
        stage.addActor(txtCreateUsername);
        String testCreateUser = txtCreateUsername.getText();
        System.out.println(testCreateUser);

        TextField txtNewPassword = new TextField("Enter Your Password", skin, "default");
        txtNewPassword.setWidth(300f);
        txtNewPassword.setHeight(30f);
        txtNewPassword.setMessageText("Your Password");
        txtNewPassword.setPosition(330, 350);
        stage.addActor(txtNewPassword);
        String testNewPassword = txtNewPassword.getText();
        System.out.println(testNewPassword);

        TextField txtRepeatNewPassword = new TextField("Repeat Your Password", skin, "default");
        txtRepeatNewPassword.setWidth(300f);
        txtRepeatNewPassword.setHeight(30f);
        txtRepeatNewPassword.setMessageText("Your Password");
        txtRepeatNewPassword.setPosition(330, 310);
        stage.addActor(txtRepeatNewPassword);
        String testRepeatNewPassword = txtNewPassword.getText();
        System.out.println(testRepeatNewPassword);


        final TextButton button = new TextButton("Register", skin, "default");
        final TextButton button2 = new TextButton("Go back to login", skin, "default");


        button.setWidth(140f);
        button.setHeight(20f);
        button.setPosition(Gdx.graphics.getWidth() / 2 - 70f, Gdx.graphics.getHeight() / 2 - 45f);
        button2.setWidth(140f);
        button2.setHeight(20f);
        button2.setPosition(Gdx.graphics.getWidth() / 2 - 70f, Gdx.graphics.getHeight() / 2 - 80f);


        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("New user created");
                game.setScreen(new IntroScreen(game));
            }
        });

        button2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LoginScreen(game));
            }
        });


        stage.addActor(button);
        stage.addActor(button2);


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
