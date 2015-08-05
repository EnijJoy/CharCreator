package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class GuiView extends Application {

    private Button button;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("CharCreator v1.0");

        button = new Button();
        button.setText("Generate Symbol");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
