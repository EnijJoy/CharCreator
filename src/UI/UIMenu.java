package UI;

import UI.creator.UICharCreator;
import UI.decipher.UIDecipher;
import UI.encryption.UIEncryption;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UIMenu extends Application {

            /////Important variables/////
    private Stage window;

    private Scene mainScene;

    private BorderPane mainLayout;

    private String nameProgram = "CharCreator v1.0";
            /////////////////////////////

            /////UIObject variables/////
    private UIEncryption encryption;

    private UIDecipher decipher;

    private UICharCreator charCreator;
            /////////////////////////////

            /////Menu variables/////
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
            /////////////////////////////


    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle(nameProgram);

        mainLayout = new BorderPane();

        charCreator = new UICharCreator();
        encryption = new UIEncryption();
        decipher = new UIDecipher();



        //File menu
        Menu fileMenu = new Menu(nameFileMenu);

        //File menu items
        MenuItem saveFile = new MenuItem(nameFileMenuItems_Save);   //прикрутить логику сохранения. Если поля ввода информации не заполнены, функция save неюзабельна
        saveFile.setOnAction(e -> {                     // saveFile.setDisable(true);
            System.out.println("File saved in .txt");
        });

        MenuItem openFile = new MenuItem(nameFileMenuItems_Open);   //прикрутить логику открытия txt
        openFile.setOnAction(e -> {//
            System.out.println("Open file from .txt");
        });

        MenuItem settingsFile = new MenuItem(nameFileMenuItems_Settings);
        settingsFile.setOnAction(e -> {
            System.out.println("Open settings");///открываем настройки и чо-то делаем
        });

        MenuItem exitFile = new MenuItem(nameFileMenuItems_Exit);
        exitFile.setOnAction(e -> window.close());

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
                   mainLayout.setCenter(charCreator.getCharView());
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


        mainLayout.setTop(menuBar);
        mainLayout.setCenter(charCreator.getCharView());

        mainScene = new Scene(mainLayout, 400, 250);
        window.setScene(mainScene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
