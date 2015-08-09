package UI;

import javafx.application.Application;
import javafx.stage.Stage;

public class UIMain extends Application {

    private Stage window;

    private final String nameProgram = "CharCreator v1.0";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle(nameProgram);


        window.setScene(UIMenu.menuScene);
        window.show();

    }
}
