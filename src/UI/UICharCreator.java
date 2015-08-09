package UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.CharCreator;


public class UICharCreator extends Application {

    static Scene charScene;

    private GridPane charLyout;

    private final int Vgap = 8;

    private final int Hgap = 10;

    private final int widthCharScene = 300;

    private final int heightCharScene = 125;

    private final String nameNumberLabel = "Number: ";

    private final String nameSymbolLabel = "Symbol UTF-8: ";

    private final String nameGenerateButton = "Generate Symbol";

    @Override
    public void start(Stage primaryStage) throws Exception {


        charLyout = new GridPane();
        charLyout.setPadding(new Insets(10, 10, 10, 10));
        charLyout.setVgap(Vgap);
        charLyout.setHgap(Hgap);

        Label number = new Label(nameNumberLabel);
        GridPane.setConstraints(number, 0, 0);

        TextField inputNumber = new TextField();
        GridPane.setConstraints(inputNumber, 1, 0);

        Label symbol = new Label(nameSymbolLabel);
        GridPane.setConstraints(symbol, 0, 1);

        TextField outSymbol = new TextField();
        GridPane.setConstraints(outSymbol, 1, 1);

        Button generateButton = new Button(nameGenerateButton);
        GridPane.setConstraints(generateButton, 1, 2);
        generateButton.setOnAction(e -> {
            CharCreator charCreator = new CharCreator();
            charCreator.inputInt(inputNumber, inputNumber.getText());
            charCreator.charPrint(outSymbol, outSymbol.getText());
        });

        charLyout.getChildren().addAll(number, inputNumber, symbol, outSymbol, generateButton);

        charScene = new Scene(charLyout, widthCharScene, heightCharScene);


    }
}




