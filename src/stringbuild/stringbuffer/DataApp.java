package stringbuild.stringbuffer;

import java.awt.image.DataBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataApp {
    public static void main(String[] args) {



        Date date = new Date(631152000);
        System.out.println(date);


        /*
        ex out -> Thu Jan 08 14:19:12 ICT 1970
         */


        Calendar calendar = Calendar.getInstance();


        /*
            .add <untuk menambah dari getInstalne (waktu sekarang)>
            .set <untuk merubah ke waktu yang di inginkan (nilai .getInstance kan di rubah total)>
         */

        calendar.set(Calendar.YEAR, 2020);
        calendar.add(Calendar.MONTH, 2);
        calendar.set(Calendar.HOUR, 10);



        Date resultDate = calendar.getTime();
        System.out.println(resultDate);
        int miliSecDate =calendar.get(Calendar.MILLISECOND);
        System.out.println(miliSecDate);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(resultDate));

    }




}
