package sample;

import java.util.ArrayList;

public class Level {

    private ArrayList<ArrayList<Tile>> tiles;
//  private ArrayList<> tiles;
    private double startX, startY;
    private int width, height;
//    private ArrayList<Item> obstacles;

    public Level() {
    }

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new ArrayList<>();
    }

    public Level(ArrayList<ArrayList<Tile>> tiles) {
        this.tiles = tiles;
    }

//    public ArrayList<Item> getObstacles() {
//        return obstacles;
//    }
//
//    public void setObstacles(ArrayList<Item> obstacles) {
//        this.obstacles = obstacles;
//    }
//
//    public ArrayList<ArrayList<Tile>> getTiles() {
//        return tiles;
//    }
//
//    public void setTiles(ArrayList<ArrayList<Tile>> tiles) {
//        this.tiles = tiles;
//    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setTile(Tile tile, int x, int y){
        tiles.get(x).set(y, tile);
    }

    public ArrayList<ArrayList<Tile>> getTiles() {
        return tiles;
    }


}
