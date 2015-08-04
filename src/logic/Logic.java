package logic;

public class Logic implements InputNumberOfChar, OutputNumberOfChar {

    private char symbolUTF_8 = 0;

    private int NUMBER_OF_CHAR = 0;

    public void convetNumberInChar() {
        char save = (char) getNumberOfChar();
        this.symbolUTF_8 = save;
    }

    @Override
    public void InputNumberofChar() {
        this.NUMBER_OF_CHAR = scanner.nextInt();
    }

    @Override
    public int getNumberOfChar() {
        InputNumberofChar();
        return NUMBER_OF_CHAR;
    }

    @Override
    public void printResult() {
        System.out.println(symbolUTF_8);
    }

    public static void main(String[] args) {

        Logic logic = new Logic();
        logic.convetNumberInChar();
        logic.printResult();


    }

}
