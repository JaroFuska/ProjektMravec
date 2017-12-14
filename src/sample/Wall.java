package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall extends Tile {

    public Wall(int x, int y, double size) {
        super(x, y, size, new ImageView(new Image("/pics/wall.png", size, size, false, true)));
    }

    public Wall() {
    }
}
