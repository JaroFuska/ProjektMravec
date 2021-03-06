package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Ant extends Tile{

    private ArrayList<Item> items;
    private int direction;
    private double speed;
    private final double DEFAULT_SPEED = 5;
    private double size;

    public Ant(int x, int y, double size) {
        this.size = 0.8 * size;
        this.x = x;
        this.y = y;
        this.items = new ArrayList<>();
        this.direction = 0;
        this.view =  new ImageView(new Image("file:pics/ant.png", this.size, this.size, false, true));
        this.view.setTranslateX((double) x * size + 0.2 * size);
        this.view.setTranslateY((double) y * size + 0.2 * size);
        this.speed = DEFAULT_SPEED;
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSize() {
        return size;
    }

    public void update(){
        //TODO add colision detection, level ending and pickup items
        //RIGHT
        if (direction == 1){
            view.setTranslateX(view.getTranslateX() + speed);
        }
        //DOWN
        else if (direction == 2){
            view.setTranslateY(view.getTranslateY() + speed);
        }
        //LEFT
        else if (direction == 3){
            view.setTranslateX(view.getTranslateX() - speed);
        }
        //UP
        else if (direction == 4){
            view.setTranslateY(view.getTranslateY() - speed);
        }

    }


}
