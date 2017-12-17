package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Controller {
    private Level level;
    private double size;
    private Main main;
    private Ant ant;
    private static final PopupWindow popupWindow;

    public Controller() {

    }

    static {
        popupWindow = new PopupWindow();
    }

    public void setSize(double size) {
        this.size = size;
    }


    public void initMap(File mapFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(mapFile.getAbsolutePath()));
        String firstLine = br.readLine();
        int rows = Integer.parseInt(firstLine.split(" ")[0]);
        int cols = Integer.parseInt(firstLine.split(" ")[1]);
        main.getRoot().setPrefSize(cols * size, rows * size);
        ArrayList<ArrayList<Tile>> tiles = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            tiles.add(new ArrayList<>());
            String line = br.readLine();
            int j = 0;
            for (char ch : line.toCharArray()
                 ) {
                Tile t;
                switch (ch) {
                    case 'W':
                        t = new Wall(j, i, size);
                        break;
                    case '.':
                        t = new Empty(j, i, size);
                        break;
                    case 'D':
                        t = new Door(j, i, size);
                        break;
                    case 'M':
                        t = new Empty(j, i, size);
                        ant = new Ant(j, i, size);
                        main.getRoot().getChildren().add(ant.getView());
                        break;
                    //TODO add items (probably defined with numbers or other specific characters)
                    default:
                        t = new Empty(j, i, size);
                        break;
                }
                tiles.get(i).add(t);
                main.getRoot().getChildren().add(t.getView());
                j++;
            }
        }
        br.close();
        level = new Level(tiles);
        ant.getView().toFront();
    }

    public EventHandler getKeyListener() {
//        EventHandler keyHandler = new EventHandler(<KeyEvent>())
        final EventHandler<KeyEvent> keyEventHandler =
                new EventHandler<KeyEvent>() {
                    public void handle(final KeyEvent keyEvent) {
                        if (keyEvent.getCode() == KeyCode.UP) {
                            ant.setDirection(4);
                            ant.update();
                            keyEvent.consume();
                        }
                        if (keyEvent.getCode() == KeyCode.DOWN) {
                            ant.setDirection(2);
                            ant.update();
                            keyEvent.consume();
                        }
                        if (keyEvent.getCode() == KeyCode.LEFT) {
                            ant.setDirection(3);
                            ant.update();
                            keyEvent.consume();
                        }
                        if (keyEvent.getCode() == KeyCode.RIGHT) {
                            ant.setDirection(1);
                            ant.update();
                            keyEvent.consume();
                        }
                        if(collisionDetection()){
                            if (ant.getDirection() == 1){
                                ant.setDirection(3);
                                ant.update();
                            }
                            else if (ant.getDirection() == 2){
                                ant.setDirection(4);
                                ant.update();
                            }
                            else if (ant.getDirection() == 3){
                                ant.setDirection(1);
                                ant.update();
                            }
                            else if (ant.getDirection() == 4){
                                ant.setDirection(2);
                                ant.update();
                            }
                        }
                    }
                };
        return keyEventHandler;
    }

    public boolean collisionDetection(){
        Rectangle r = new Rectangle((int)(ant.view.getTranslateX()), (int)(ant.view.getTranslateY()),
                (int)ant.getSize(), (int)ant.getSize());
        for (ArrayList<Tile> tileList:level.getTiles()) {
            for (Tile tile:tileList){
                if(r.intersects(tile.getX()*tile.getSize(), tile.getY()*tile.getSize(), tile.getSize(), tile.getSize())){
                    if(tile instanceof Door){
                        System.out.println("dvere");
                        popupWindow.display();
                        return false;
                    }
                    if(tile instanceof Wall){
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
