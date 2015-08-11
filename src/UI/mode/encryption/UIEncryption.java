package UI.mode.encryption;


import UI.UIMenu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;


public class UIEncryption extends UIMenu {

    private GridPane cryptView;

    private TextArea inputMessage;

    private TextArea cryptMessage;

    private HBox buttonBox;

    private final int spaceHBox = 25;

    private final int cryptSceneWidth = 355;

    private final int cryptSceneHeight = 330;

    public int getCryptSceneWidth() {
        return cryptSceneWidth;
    }

    public int getCryptSceneHeight() {
        return cryptSceneHeight;
    }

            /////GridPane variables/////
    private final int Vgap = 8;

    private final int Hgap = 10;
            /////////////////////////////

            /////TextArea InputMessage variables/////
    private final int inputWidth = 300;

    private final int inputHeight = 150;

    private final String defaultInputMessage = "Input your message here";
            /////////////////////////////

            /////TextArea CryptMessage variables/////
    private final int cryptWidth = 300;

    private final int cryptHeight = 50;

    private final String promptOutputMessage = "Encrypt message";
            ////////////////////////////

            /////Button variables/////
    private Button saveButton;

    private Button cryptButton;

    private final String nameSaveButton = "Save";

    private final String nameCryptButton = "Encrypt";
            ////////////////////////////


    public GridPane getCryptView(){

        cryptView = new GridPane();
        cryptView.setPadding(new Insets(10, 10, 10, 10));
        cryptView.setVgap(Vgap);
        cryptView.setHgap(Hgap);

        inputMessage = new TextArea(defaultInputMessage);
        inputMessage.setPromptText(defaultInputMessage);
        GridPane.setConstraints(inputMessage, 1, 0);
        inputMessage.setMaxWidth(inputWidth);
        inputMessage.setMaxHeight(inputHeight);


        cryptMessage = new TextArea();
        cryptMessage.setPromptText(promptOutputMessage);
        GridPane.setConstraints(cryptMessage, 1, 1);
        cryptMessage.setMaxWidth(cryptWidth);
        cryptMessage.setMaxHeight(cryptHeight);


        cryptButton = new Button(nameCryptButton);
        cryptButton.setOnAction(e -> {

        });


        saveButton = new Button(nameSaveButton);
        saveButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show save file dialog
            File file = fileChooser.showSaveDialog(window);

            if(file != null){
                SaveFile(inputMessage.getText(), file);
            }
        });

        buttonBox = new HBox(spaceHBox);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        GridPane.setConstraints(buttonBox, 1, 2);
        buttonBox.getChildren().addAll(cryptButton, saveButton);

        cryptView.getChildren().addAll(inputMessage, cryptMessage, buttonBox);

        return cryptView;
    }
    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(UIEncryption.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

}
