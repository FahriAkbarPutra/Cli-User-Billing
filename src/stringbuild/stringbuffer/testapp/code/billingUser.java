package stringbuild.stringbuffer.testapp.code;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class billingUser {

    /*
    default date adalah hari sekarang atau hari program di mana dia di eksekusi
    */
    Calendar calendar = Calendar.getInstance();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy/HH:mm:ss");
    private String defaultCalendar = dateFormat.format(calendar.getTime());

    public String getDefaultCalendar() {
        return defaultCalendar;
    }

    Calendar calendarUser = Calendar.getInstance();
    DateFormat dateFormatUser = new SimpleDateFormat("dd/MM/yyyy/HH:mm:ss");

    // Tidak gunakan variabel tetap untuk `defaultCalendarUser`
    public void setUserCalendar(int week, int month, int year) {
        this.calendarUser.add(Calendar.DAY_OF_WEEK, week);
        this.calendarUser.add(Calendar.MONTH, month);
        this.calendarUser.add(Calendar.YEAR, year);
    }

    // Dinamis: langsung ambil dari `calendarUser`
    public String getDefaultCalendarUser() {
        return dateFormatUser.format(calendarUser.getTime());
    }
}
