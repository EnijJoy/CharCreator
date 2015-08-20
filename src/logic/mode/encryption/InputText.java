package logic.mode.encryption;


import java.util.Random;

public class InputText {

    private int LAT_COUNT = 32;

    private int KIR_COUNT = 1040;

    private int[] intLatMassive = new int[96];

    private int[] intKirMassive = new int[64];

    private byte[] byteInputText;

    private int[] intInputText = new int[byteInputText.length];

    /*********************************************/

    public int[] getIntInputText(byte[] byteInputText){

        for (int i = 0; i < byteInputText.length; i++){

            intInputText[i] = (int) byteInputText[i];

        }

        return intInputText;
    }

    public int[] getIntKir(){

        for (int i = 0; i < intKirMassive.length; i++){

            intKirMassive[i] = KIR_COUNT++;

        }

        return intKirMassive;

    }

    public int[] getIntLat(){

        for (int i = 0; i < intLatMassive.length; i++){

            intLatMassive[i] = LAT_COUNT++;

        }

        return intLatMassive;

    }

}
