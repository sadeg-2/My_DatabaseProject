/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * @author jit
 */
public class Q14_1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane g = new GridPane();
        g.setMaxHeight(200);
        g.setMaxWidth(200);
        ImageView a1 = new ImageView(new Image("homework/image/a1.jpg"));
        a1.setFitHeight(100);
        a1.setFitWidth(100);
        ImageView a2 = new ImageView(new Image("homework/image/a2.jpg"));
        a1.setFitHeight(100);
        a1.setFitWidth(100);
        ImageView a3 = new ImageView(new Image("homework/image/a3.jpg"));
        a1.setFitHeight(100);
        a1.setFitWidth(100);
        ImageView a4 = new ImageView(new Image("homework/image/a4.jpg"));
        a1.setFitHeight(100);
        a1.setFitWidth(100);
        g.add(a1, 0, 0);
        g.add(a2, 0, 1);
        g.add(a3, 1, 0);
        g.add(a4, 1, 1);


        Scene scene = new Scene(g);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}