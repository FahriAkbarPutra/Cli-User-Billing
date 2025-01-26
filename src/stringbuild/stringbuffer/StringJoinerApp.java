package stringbuild.stringbuffer;

import java.util.StringJoiner;

public class StringJoinerApp {


    public static void main(String[] args) {

        StringJoiner sj = new StringJoiner(",","[","]");



        sj.add("fahri") ;
        sj.add("akbar") ;
        sj.add("putra") ;


            String value = sj.toString();
        System.out.printf(value);


        /*
        ex out -> [fahri,akbar,putra]
         */


    }

}
