package logic.mode.encryption;



public class Encryption {


    public static void main(String[] args) {


        /*String String = "ASdsdaas";
        char[] charS = String.toCharArray();*/
        String s = "Я люблю пончики!";
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            int m = (int) a[i];
            int i1 = m << 20;
            char c = (char) i1;
            System.out.println(c);
        }

    }

}




