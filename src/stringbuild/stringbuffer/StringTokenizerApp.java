package stringbuild.stringbuffer;

import java.util.StringTokenizer;

public class StringTokenizerApp {

    public static void main(String[] args) {

            String name  = "fahrizakbarzputra" ;

            StringTokenizer st = new StringTokenizer(name,"z") ;


            while (st.hasMoreTokens()) {
                System.out.println(st.nextToken());
            }


            /*
            ex out ->fahri
                     akbar
                     putra
             */

        /*
        fungsi dari st.hasMoreTokens()
        adalah akan mereturn nilai bolean , selama masih ada Strign token yang masih bisa di potong
        maka nilai true dan while akan terus berjalan sampai nilai token false baru while berhenti
         */


    }
}
