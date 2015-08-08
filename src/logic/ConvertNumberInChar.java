package logic;

import javafx.scene.control.TextField;

public class ConvertNumberInChar {

    public static char symbolUTF_8 = 0;     // сделать переменные приватными, реализовать безопасную логику

    public static int NUMBER_OF_CHAR = 0;

    public static char ConvertNumberInChar() {
        char save = (char) NUMBER_OF_CHAR;
        return symbolUTF_8 = save;
    }

        //методы для преобразования int в char в полях TextField
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
