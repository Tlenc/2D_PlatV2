package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class TextScrollPane {

    private Table table;
    private Label label;

    public TextScrollPane(float width, float height){

        BitmapFont font = new BitmapFont();

        table = new Table();
        table.setWidth(width);

        table.setHeight(height);
        table.setBackground(new NinePatchDrawable(getNinePatch(("C:\\Users\\Parduotuves\\IdeaProjects\\2D_PlatV2_3\\core\\assets\\ng.9.png"))));

        label = new Label("Bla bla bla bla", new Label.LabelStyle(font, Color.WHITE) );
        label.setWrap(true);

        table.add(label).expand().top().left();

    }

    public Label getLabel() {
        return label;
    }

    public Table getTable() {
        return table;
    }

    private NinePatch getNinePatch(String fname) {

        // Get the image
        final Texture t = new Texture(Gdx.files.internal(fname));

        // create a new texture region, otherwise black pixels will show up too, we are simply cropping the image
        // last 4 numbers respresent the length of how much each corner can draw,
        // for example if your image is 50px and you set the numbers 50, your whole image will be drawn in each corner
        // so what number should be good?, well a little less than half would be nice
        return new NinePatch( new TextureRegion(t, 1, 1 , t.getWidth() - 2, t.getHeight() - 2), 10, 10, 10, 10);
    }

}