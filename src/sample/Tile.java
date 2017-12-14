package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile {

    protected int x, y;
    protected Node view;

    public Tile() {
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y, double size, Node view) {
        this.x = x;
        this.y = y;
        view.setTranslateX((double) x * size);
        view.setTranslateY((double) y * size);
        this.view = view;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Node getView() {
        return view;
    }

    public boolean isColliding(Tile other){
        return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
    }

}
