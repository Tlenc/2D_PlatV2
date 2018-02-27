package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class IntroScreen extends AbstractScreen {
    private Stage stage;
    private Skin skin;
    TextureRegion intro;
    SpriteBatch batch;
    float time = 0;

    public IntroScreen(Game game) {
        super(game);
    }

    /* @Override
     public void show () {
         intro = new TextureRegion(new Texture(Gdx.files.internal("C:\\Users\\Ryver\\Desktop\\Plat_2D\\core\\assets\\intro.png")), 0, 0, 480, 320);
         batch = new SpriteBatch();
         batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);
     }
 */
    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("C:\\Users\\Parduotuves\\IdeaProjects\\2D_PlatV2_3\\core\\assets\\uiskin.json"));
        stage = new Stage();


        final TextField txtUsername = new TextField("Enter your name", skin, "default");
        txtUsername.setWidth(300f);
        txtUsername.setHeight(30f);
        // txtUsername.setMessageText("Your Nickname");
        txtUsername.setPosition(330, 340);
        stage.addActor(txtUsername);
        //final String testUser = txtUsername.getText();

        //System.out.println(testUser);


        final TextButton button = new TextButton("Play", skin, "default");
        final TextButton button2 = new TextButton("Options", skin, "default");
        final TextButton button3 = new TextButton("Exit", skin, "default");

        button.setWidth(200f);
        button.setHeight(20f);
        button.setPosition(Gdx.graphics.getWidth() / 2 - 100f, Gdx.graphics.getHeight() / 2 - 10f);
        button2.setWidth(200f);
        button2.setHeight(20f);
        button2.setPosition(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 40);
        button3.setWidth(200f);
        button3.setHeight(20f);
        button3.setPosition(Gdx.graphics.getWidth() / 2 - 100f, Gdx.graphics.getHeight() / 2 - 70f);


        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                game.setScreen(new LevelSelectScreen(game));
                final String testUser = txtUsername.getText();
                System.out.println(testUser);

            }
        });

        button2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Menu(game));
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

    /* @Override
     public void render (float delta) {
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         batch.begin();
         batch.draw(intro, 0, 0);
         batch.end();

         time += delta;
         if (time > 1) {
             if (Gdx.input.isKeyPressed(Keys.ANY_KEY) || Gdx.input.justTouched()) {
                 game.setScreen(new GameScreen(game));
             }
         }
     }
 */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        stage.draw();
        batch.end();
    }
    /*@Override
    public void hide () {
        Gdx.app.debug("Cubocy", "dispose intro");
        batch.dispose();
        intro.getTexture().dispose();
    }
*/
}

