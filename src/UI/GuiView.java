package UI;

import javafx.application.Application;                              //создать вкладки (file, help, options).
import javafx.geometry.Insets;                                      //реализовать неизменняемый размер окна
import javafx.scene.Scene;                                          //кидать exception в отдельные окна!
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.ConvertNumberInChar;


public class GuiView extends Application {

    Stage window;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("CharCreator v1.0");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(20);

        Label intLabel = new Label("Номер:");
        GridPane.setConstraints(intLabel, 0, 0);

        TextField intInput = new TextField();
        GridPane.setConstraints(intInput, 1, 0);

        Label charLabel = new Label("Символ UTF-8:");
        GridPane.setConstraints(charLabel, 0, 1);

        TextField charOut = new TextField();
        GridPane.setConstraints(charOut, 1, 1);

        Button generateButton = new Button("Generate Symbol");
        GridPane.setConstraints(generateButton, 1, 2);

        generateButton.setOnAction(e -> {
            isInt(intInput, intInput.getText());
            charPrint(charOut, charOut.getText());

        });
        grid.getChildren().addAll(intLabel, intInput, charLabel, charOut, generateButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);

        window.show();
    }


    private boolean isInt(TextField input, String message) {
        try {

            int number = Integer.parseInt(input.getText());
            ConvertNumberInChar.NUMBER_OF_CHAR = number;
            ConvertNumberInChar.ConvertNumberInChar();
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + " is not a number");
            return false;
        }
    }

    private boolean charPrint(TextField out, String message) {
        try {
            StringBuilder s = new StringBuilder().append(ConvertNumberInChar.symbolUTF_8);
            out.setText(String.valueOf(s));
            return true;
        } catch (NumberFormatException e) {                                  // Доработать exception (создать свой)
            System.out.println("Error: Input a number in first TextField");  // Если ввод во второе поле, кинуть exception
            return false;
        }
    }
}




