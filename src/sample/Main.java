package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private final double BLOCK_SIZE = 80;
    private Pane root;
    private Ant ant;
    private Level testLevel;
    private Controller c;

    private Parent createContent(){
        root = new Pane();
        root.setPrefSize(800, 600);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

        return root;
    }

    public Pane getRoot() {
        return root;
    }

    private void onUpdate(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        c = new Controller();
        c.setMain(this);
        c.setSize(BLOCK_SIZE);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mravec");
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(c.getKeyListener());
        primaryStage.setScene(scene);
        File file = new File("levels/test.txt");
//        File file = new File("levels/t2.txt");
//        createTestLevel();
        readLevel(file);
        primaryStage.show();
    }

    public void createTestLevel(){ //temp
        Tile newTile;
        testLevel = new Level(6, 6);
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if (i == 0 || i == 5 || j == 0 || j == 5){
                    newTile = new Wall(i, j, BLOCK_SIZE);
                    testLevel.setTile(newTile, i, j);
                }
                else{
                    newTile = new Empty(i, j, BLOCK_SIZE);
                    testLevel.setTile(newTile, i, j);
                }
                newTile.getView().setTranslateX((double) i*BLOCK_SIZE);
                newTile.getView().setTranslateY((double) j*BLOCK_SIZE);
                root.getChildren().add(newTile.getView());
            }
        }
    }

    public void readLevel(File file) throws IOException {
        c.initMap(file);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
