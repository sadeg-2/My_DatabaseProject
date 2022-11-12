package Java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;


public class Test extends Application {
    Integer i = 0 ;
    @Override
    public void start(Stage stage) throws Exception {
        Label l = new Label("Increment&Decrement");

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20,10,10,10));
        HBox h = new HBox(10);
        Button inc = new Button("inc");
        Button dec = new Button("dec");
        Button res = new Button("res");
        inc.setPrefSize(50,50);
        dec.setPrefSize(50,50);
        res.setPrefSize(50,50);
        h.setAlignment(Pos.CENTER);
        h.getChildren().addAll(inc,dec,res);
        TextField result = new TextField();
        result.setEditable(false);
        result.setText(i+"");
        pane.setBottom(h);
        pane.setCenter(result);
        pane.setTop(l);
        inc.setOnAction(e -> {
            i++;
            result.setText(i+"");
        });
        dec.setOnAction(e -> {
            i--;
            result.setText(i+"");

        });
        res.setOnAction(e -> {
            i = 0;
            result.setText(i+"");

        });


        Scene scene = new Scene(pane, 250, 200);
        stage.setTitle("Quiz :)");
        stage.setScene(scene);
        stage.show();
    }

}

