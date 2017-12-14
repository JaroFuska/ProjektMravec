package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Empty extends Tile {

    public Empty(int x, int y, double size) {
        super(x, y, size, new Rectangle(size, size, Color.GRAY));
    }

    public Empty() {
    }
}
