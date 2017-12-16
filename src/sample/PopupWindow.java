package sample;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class PopupWindow {

    public void display() {
        Stage window = new Stage();
        window.setTitle("Úloha dokončená");
        window.setMinWidth(250);
        Label label = new Label();
        label.setText("Gratulujem úroveň bola úspešne dokončená");
        Button closeButton = new Button("Ďalšia úroveň");
        closeButton.setOnAction(e -> close(window));
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    public void close(Stage window){
        window.close();
    }

}