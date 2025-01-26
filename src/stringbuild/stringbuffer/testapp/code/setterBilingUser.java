package stringbuild.stringbuffer.testapp.code;

import java.util.Scanner;

public class setterBilingUser {

    billingUser billingUser = new billingUser();

    private static Scanner sc = new Scanner(System.in);

    public void menuAddedbilling() {
        System.out.println("Masukan Billing Yang Di Beli User \n");
        System.out.println("1. Billing Mingguan");
        System.out.println("2. Billing Bulanan");
        System.out.println("3. Billing Tahunan");
        System.out.println("4. Remove User");
        System.out.println("0. Exit");
    }

    public void commandAddedbilling() {
        menuAddedbilling();

        while (sc.hasNextInt()) {
            int inputMenu = sc.nextInt();

            switch (inputMenu) {
                case 1:
                    weeklyBilling(sc.nextInt());
                    break;
                case 2:
                    monthlyBilling(sc.nextInt());
                    break;
                case 3:
                    yearlyBilling(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Remove User belum diimplementasi.");
                    break;
                case 0:
                    priceFormater();
                    System.out.println("Exiting...");
                    return; // Keluar dari loop dan method
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
            menuAddedbilling();
        }
    }

    public void weeklyBilling(int jumlahMingguan) {
        int qtyPrice = 0;

        if (jumlahMingguan > 4) {
            System.out.println("Invalid Input, Please Use Menu NO 2");
        } else {
            qtyPrice = 140000 * jumlahMingguan;
        }

        billingUser.setUserCalendar(jumlahMingguan, 0, 0);

        System.out.println("Billing Mingguan: " + qtyPrice);

        // Tampilkan tanggal setelah perubahan
        priceFormater();
    }

    public void monthlyBilling(int jumlahBulan) {
        int qtyPrice = 0;

        if (jumlahBulan > 12) {
            System.out.println("Invalid Input, Please Use Menu NO 3");
        } else {
            qtyPrice = 360000 * jumlahBulan;
        }

        billingUser.setUserCalendar(0, jumlahBulan, 0);

        System.out.println("Billing Bulanan: " + qtyPrice);

        // Tampilkan tanggal setelah perubahan
        priceFormater();
    }

    public void yearlyBilling(int jumlahTahunan) {
        int qtyPrice = 3400000 * jumlahTahunan;

        billingUser.setUserCalendar(0, 0, jumlahTahunan);

        System.out.println("Billing Tahunan: " + qtyPrice);

        // Tampilkan tanggal setelah perubahan
        priceFormater();
    }

    public void priceFormater() {
        System.out.println("License Akan Aktif Mulai Dari -> " + billingUser.getDefaultCalendar() +
                " Akan Berakhir pada -> " + billingUser.getDefaultCalendarUser());
    }
}
