package UI.mode.decipher;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;


public class UIDecipher {

    private GridPane decipherView;

    private TextArea decipherMessage;

    private TextArea cryptMessage;

    private HBox buttonBox;

    private final int spaceHBox = 25;

    private final int decipherSceneWidth = 355;

    private final int decipherSceneHeight = 330;

    public int getDecipherSceneWidth() {
        return decipherSceneWidth;
    }

    public int getDecipherSceneHeight() {
        return decipherSceneHeight;
    }

    /////GridPane variables/////
    private final int Vgap = 8;

    private final int Hgap = 10;
    /////////////////////////////

    /////TextArea DecipherMessage variables/////
    private final int decipherWidth = 300;

    private final int decipherHeight = 150;

    private final String defaultDecipherMessage = "Decipher message";
    /////////////////////////////

    /////TextArea CryptMessage variables/////
    private final int cryptWidth = 300;

    private final int cryptHeight = 50;

    private final String promptOutputMessage = "Input encrypt message here or click open";
    ////////////////////////////

    /////Button variables/////
    private Button openButton;

    private Button decipherButton;

    private final String nameOpenButton = "Open";

    private final String nameDecipherButton = "Decipher";
    ////////////////////////////


    public GridPane getDecipherView(){


        decipherView = new GridPane();
        decipherView.setPadding(new Insets(10, 10, 10, 10));
        decipherView.setVgap(Vgap);
        decipherView.setHgap(Hgap);

        cryptMessage = new TextArea(promptOutputMessage);
        cryptMessage.setPromptText(promptOutputMessage);
        GridPane.setConstraints(cryptMessage, 1, 1);
        cryptMessage.setMaxWidth(cryptWidth);
        cryptMessage.setMaxHeight(cryptHeight);

        decipherMessage = new TextArea();
        decipherMessage.setPromptText(defaultDecipherMessage);
        GridPane.setConstraints(decipherMessage, 1, 2);
        decipherMessage.setMaxWidth(decipherWidth);
        decipherMessage.setMaxHeight(decipherHeight);


        openButton = new Button(nameOpenButton);
        openButton.setOnAction(e -> {

        });

        decipherButton = new Button(nameDecipherButton);
        decipherButton.setOnAction(e -> {

        });


        buttonBox = new HBox(spaceHBox);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        GridPane.setConstraints(buttonBox, 1, 0);
        buttonBox.getChildren().addAll(openButton, decipherButton);

        decipherView.getChildren().addAll(cryptMessage, decipherMessage, buttonBox);

        return  decipherView;
    }

}
