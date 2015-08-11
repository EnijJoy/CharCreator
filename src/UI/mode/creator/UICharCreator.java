package UI.mode.creator;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import logic.mode.creator.CharCreator;


public class UICharCreator {

    private GridPane charView;

    private Label number;

    private TextField inputNumber;

    private Label symbol;

    private TextField outSymbol;

    private Button generateButton;

    private final int Vgap = 8;

    private final int Hgap = 10;

    private final String nameNumberLabel = "Number: ";

    private final String nameSymbolLabel = "Symbol UTF-8: ";

    private final String nameGenerateButton = "Generate Symbol";

    private final int charSceneWidth = 300;

    private final int charSceneHeight = 180;

    public int getCharSceneWidth() {
        return charSceneWidth;
    }

    public int getCharSceneHeight() {
        return charSceneHeight;
    }

    public GridPane getCharView() {

        charView = new GridPane();
        charView.setPadding(new Insets(10, 10, 10, 10));
        charView.setVgap(Vgap);
        charView.setHgap(Hgap);

        number = new Label(nameNumberLabel);
        GridPane.setConstraints(number, 0, 0);

        inputNumber = new TextField();
        GridPane.setConstraints(inputNumber, 1, 0);

        symbol = new Label(nameSymbolLabel);
        GridPane.setConstraints(symbol, 0, 1);

        outSymbol = new TextField();
        GridPane.setConstraints(outSymbol, 1, 1);

        generateButton = new Button(nameGenerateButton);
        GridPane.setConstraints(generateButton, 1, 2);
        generateButton.setOnAction(e -> {
            CharCreator charCreator = new CharCreator();
            charCreator.inputInt(inputNumber, inputNumber.getText());
            charCreator.charPrint(outSymbol, outSymbol.getText());
        });

        charView.getChildren().addAll(number, inputNumber, symbol, outSymbol, generateButton);

        return charView;
    }

}




