package stringbuild.stringbuffer;

import java.util.Scanner;
import java.util.StringJoiner;

public class NumberApp {


    public static void main(String[] args) {

        Integer value = 10 ;
        Long longValue =  value.longValue();
        Double doubleValue =  value.doubleValue();
        Short shortValue =  value.shortValue();




        String contoh = "100000";

        int intValue =  Integer.valueOf(contoh);
        System.out.println(intValue);

        Scanner sc = new Scanner(System.in);

        StringJoiner sj = new StringJoiner(",","<",">");
        String inputStrng = sc.nextLine();
        String containerInt = "" ;
        for (int i = 0; i < inputStrng.length(); i++) {
            char ch = inputStrng.charAt(i);
            if (ch >= '0' && ch <= '9') {
                containerInt = containerInt + ch;
                sj.add(String.valueOf(ch));
            }

        }

            int convertedInt = Integer.parseInt(containerInt);

        System.out.println(sj.toString());
        System.out.println(convertedInt);


        /*
        ex out -> <7,6,7,6,7>
                  76767
         */

    }
}
