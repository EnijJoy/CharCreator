package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class UICharCreator extends Application {      // ГЛАЗА РЕЖЕТ ОТ ОБИЛИЯ ОДИНАКОВОГО КОДА!!! УРОСТИТЬ!

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

        MenuItem openFile = new MenuItem("_Open...");   //прикрутить логику открытия txt
        openFile.setOnAction(e -> {
            System.out.println("Open file from .txt");
        });

        MenuItem settingsFile = new MenuItem("Settings...");
        settingsFile.setOnAction(e -> {
            System.out.println("Oooooops");///открываем настройки и чо-то делаем
        });

        MenuItem exitFile = new MenuItem("Exit");
        exitFile.setOnAction(e -> {
            window.close();
        });

        fileMenu.getItems().addAll(saveFile, openFile, new SeparatorMenuItem(), settingsFile, new SeparatorMenuItem(), exitFile);


        //Mode menu
        Menu modeMenu = new Menu("_Mode");
        ToggleGroup modeToggle = new ToggleGroup();

        //Mode menu items
        RadioMenuItem charMode = new RadioMenuItem("_CharCreator");
        charMode.setToggleGroup(modeToggle);
        charMode.setSelected(true);
        charMode.setOnAction(e -> {
            if (charMode.isSelected())
                System.out.println("CharCreator()");//вызов CharCreator() (конвертим int в char)
        });

        RadioMenuItem cryptMode = new RadioMenuItem("_Encryption");
        cryptMode.setToggleGroup(modeToggle);
        cryptMode.setOnAction(e -> {
            if (cryptMode.isSelected())
                System.out.println("Encryption()");//вызов Encryption() (придумать алгоритм шифрования с символами)
        });

        RadioMenuItem decipherMode = new RadioMenuItem("_Decipher");
        decipherMode.setToggleGroup(modeToggle);
        decipherMode.setOnAction(e -> {
            if (decipherMode.isSelected())
                System.out.println("Decipher()");//вызов Decipher() (Алгоритм расшифровки)
        });

        modeMenu.getItems().addAll(charMode, new SeparatorMenuItem(), cryptMode, new SeparatorMenuItem(), decipherMode);


        //Help menu
        Menu helpMenu = new Menu("Help");

        //Help menu items
        MenuItem aboutHelp = new MenuItem("About...");
        aboutHelp.setOnAction(e -> {
            System.out.println("About program");//о программе
        });

        MenuItem developHelp = new MenuItem("Developing...");
        developHelp.setOnAction(e -> {
            System.out.println("Developing");//раздел "в разработке"
        });

        helpMenu.getItems().addAll(aboutHelp, developHelp);

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




