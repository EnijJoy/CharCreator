package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class GuiView extends Application {

    private String NAME_PROGRAM = "CharCreator v1.0";
    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle(NAME_PROGRAM);


        //File menu
        Menu fileMenu = new Menu("_File");

        //File menu items
        MenuItem saveFile = new MenuItem("_Save...");   //прикрутить логику сохранения. Если поля ввода информации не заполнены, функция save неюзабельна
        saveFile.setOnAction(e -> {                     // saveFile.setDisable(true);
            System.out.println("File saved in .txt");
        });
        fileMenu.getItems().add(saveFile);

        MenuItem openFile = new MenuItem("_Open...");   //прикрутить логику открытия txt
        openFile.setOnAction(e -> {
            System.out.println("Open file from .txt");
        });
        fileMenu.getItems().add(openFile);

        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());

        MenuItem exitFile = new MenuItem("Exit");
        exitFile.setOnAction(e -> {
            window.close();
        });
        fileMenu.getItems().add(exitFile);


        //Mode menu
        Menu modeMenu = new Menu("_Mode");

        //Mode menu items
        modeMenu.getItems().add(new MenuItem("_CharCreator"));
        modeMenu.getItems().add(new SeparatorMenuItem());
        modeMenu.getItems().add(new MenuItem("_Encryption"));
        modeMenu.getItems().add(new SeparatorMenuItem());
        modeMenu.getItems().add(new MenuItem("_Decipher"));

        //Help menu
        Menu helpMenu = new Menu("Help");

        //Help menu items
        helpMenu.getItems().add(new MenuItem("About..."));
        helpMenu.getItems().add(new MenuItem("Developing..."));

        //Add MenuBar with Menu's
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, modeMenu, helpMenu);


        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 300, 200);

        window.setScene(scene);
        window.show();
    }


}




