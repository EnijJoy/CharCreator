package logic.mode.encryption;



import javafx.scene.control.TextArea;


public class Encryption {

    private char charInputText[];

    private String CRYPT_MESSAGE;

    public void Encrypt(TextArea input, String message) {

        charInputText = message.toCharArray();

        for (int i = 0; i < charInputText.length; i++) {

            int a = charInputText[i] + 10240;
            charInputText[i] = (char) a;

        }
        this.CRYPT_MESSAGE = String.valueOf(charInputText);
    }
    public boolean cryptPrint(TextArea out, String message) {
            try {
                out.setText(CRYPT_MESSAGE);
                return true;
            } catch (NumberFormatException e) {                                  // Доработать exception (создать свой)
                System.out.println("Error: Input a number in first TextField");  // Если ввод во второе поле, кинуть exception
                return false;
            }
    }

}





