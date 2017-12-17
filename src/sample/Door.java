package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Door extends Tile {


    public Door(int x, int y, double size) {
        super(x, y, size, new ImageView(new Image("file:pics/door.png", size, size, false, true)));
    }

    public Door() {
    }
}
