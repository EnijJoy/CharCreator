package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UIMenu extends Application {       // ГЛАЗА РЕЖЕТ ОТ ОБИЛИЯ ОДИНАКОВОГО КОДА!!! УРОСТИТЬ!



    BorderPane layoutMenu;
    static Scene menuScene;

    private final int widthMenuScene = 300;

    private final int heightMenuScene = 125;


        ///////////////////Menu variables/////////////////////////
        private final String nameFileMenu = "_File";

    private final String nameFileMenuItems_Save = "_Save...";

    private final String nameFileMenuItems_Open = "_Open...";

    private final String nameFileMenuItems_Settings = "Settings...";

    private final String nameFileMenuItems_Exit = "Exit";

        private final String nameModeMenu = "_Mode";

    private final String nameModeMenuItems_Char = "_CharCreator";

    private final String nameModeMenuItems_Crypt = "_Encryption";

    private final String nameModeMenuItems_Decip = "_Decipher";

        private final String nameHelpMenu = "Help";

    private final String nameHelpMenuItems_About = "About...";

    private final String nameHelpMenuItems_Dev = "Developing...";
    ///////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;


        //File menu
        Menu fileMenu = new Menu(nameFileMenu);

        //File menu items
        MenuItem saveFile = new MenuItem(nameFileMenuItems_Save);   //прикрутить логику сохранения. Если поля ввода информации не заполнены, функция save неюзабельна
        saveFile.setOnAction(e -> {                     // saveFile.setDisable(true);
            System.out.println("File saved in .txt");
        });

        MenuItem openFile = new MenuItem(nameFileMenuItems_Open);   //прикрутить логику открытия txt
        openFile.setOnAction(e -> {
            System.out.println("Open file from .txt");
        });

        MenuItem settingsFile = new MenuItem(nameFileMenuItems_Settings);
        settingsFile.setOnAction(e -> {
            System.out.println("Oooooops");///открываем настройки и чо-то делаем
        });

        MenuItem exitFile = new MenuItem(nameFileMenuItems_Exit);
        exitFile.setOnAction(e -> {
            window.close();
        });

        fileMenu.getItems().addAll(saveFile, openFile, new SeparatorMenuItem(), settingsFile, new SeparatorMenuItem(), exitFile);


        //Mode menu
        Menu modeMenu = new Menu(nameModeMenu);
        ToggleGroup modeToggle = new ToggleGroup();

        //Mode menu items
        RadioMenuItem charMode = new RadioMenuItem(nameModeMenuItems_Char);
        charMode.setToggleGroup(modeToggle);
        charMode.setSelected(true);
        charMode.setOnAction(e -> {
            if (charMode.isSelected())
                System.out.println("CharCreator()");//вызов CharCreator() (конвертим int в char)
        });

        RadioMenuItem cryptMode = new RadioMenuItem(nameModeMenuItems_Crypt);
        cryptMode.setToggleGroup(modeToggle);
        cryptMode.setOnAction(e -> {
            if (cryptMode.isSelected())
                //window.setScene(cryptScene);
                System.out.println("Encryption()");//вызов Encryption() (придумать алгоритм шифрования с символами)
        });

        RadioMenuItem decipherMode = new RadioMenuItem(nameModeMenuItems_Decip);
        decipherMode.setToggleGroup(modeToggle);
        decipherMode.setOnAction(e -> {
            if (decipherMode.isSelected())
                //window.setScene(decipherScene);
                System.out.println("Decipher()");//вызов Decipher() (Алгоритм расшифровки)
        });

        modeMenu.getItems().addAll(charMode, new SeparatorMenuItem(), cryptMode, new SeparatorMenuItem(), decipherMode);


        //Help menu
        Menu helpMenu = new Menu(nameHelpMenu);

        //Help menu items
        MenuItem aboutHelp = new MenuItem(nameHelpMenuItems_About);
        aboutHelp.setOnAction(e -> {
            System.out.println("About program");//о программе
        });

        MenuItem developHelp = new MenuItem(nameHelpMenuItems_Dev);
        developHelp.setOnAction(e -> {
            System.out.println("Developing");//раздел "в разработке"
        });

        helpMenu.getItems().addAll(aboutHelp, developHelp);

        //Add MenuBar with Menu's
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, modeMenu, helpMenu);


        layoutMenu = new BorderPane();
        layoutMenu.setTop(menuBar);

        menuScene = new Scene(layoutMenu, widthMenuScene, heightMenuScene);

        window.setScene(menuScene);
        window.show();

    }
}
