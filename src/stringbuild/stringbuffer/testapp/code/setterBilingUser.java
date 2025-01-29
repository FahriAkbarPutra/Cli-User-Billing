package stringbuild.stringbuffer.testapp.code;

import java.util.Base64;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class setterBilingUser {

    billingUser billingUser = new billingUser();

    private static Scanner sc = new Scanner(System.in);

    public void menuAddedbilling() {
        System.out.println("Masukan Billing Yang Di Beli User \n");
        System.out.println("1. Billing Mingguan");
        System.out.println("2. Billing Bulanan");
        System.out.println("3. Billing Tahunan");
        System.out.println("4. Add User");
        System.out.println("5. Remove User");
        System.out.println("6. List User");
        System.out.println("0. Exit");
        System.out.print("\nPilih Menu : ");
    }

    public void commandAddedbilling() {
        menuAddedbilling();

        while (sc.hasNextInt()) {
            int inputMenu = sc.nextInt();
                sc.nextLine();

            switch (inputMenu) {
                case 1:
                    ShowAddUser();
                    weeklyBilling();
                    break;
                case 2:
                    ShowAddUser();
                    monthlyBilling();
                    break;
                case 3:
                    ShowAddUser();
                    yearlyBilling();
                    break;
                case 4:
                    addUser();
                    break;
                case 5:
                    RemoveUser();
                    break;
                case 6:
                    ShowAddUser();
                    break;
                case 0:
                    priceFormater();
                    System.out.println("Exiting...");
                    return; // Keluar dari loop dan method
/*                case 10:
                    UpdateUser();*/
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
            menuAddedbilling();
        }
    }

    public void weeklyBilling() {

        System.out.print("Pilih Username: ");
        int selectUser = sc.nextInt();

        var isValid = checkerBillingUser(selectUser);

        if (isValid) {
            UserSelector(selectUser);

            System.out.print("Masukan Billing Mingguan : ");
            int jumlahMingguan = sc.nextInt() ;


            int qtyPrice = 0;

            if (jumlahMingguan > 4) {
                System.out.println("Invalid Input, Please Use Menu NO 2");
            } else {
                qtyPrice = 140000 * jumlahMingguan;
            }

            billingUser.setUserCalendar(jumlahMingguan, 0, 0);

            UserFormatter(selectUser,qtyPrice,"Weekly");

            System.out.println("Billing Mingguan: " + qtyPrice);

            //menambahkan spasi biar rapi
            System.out.println();

            //Tampilkan tanggal setelah perubahan
            //priceFormater();
        }else{
            delayPromt(2000,selectUser);
        }



    }

    public void monthlyBilling() {


        System.out.print("Pilih Username: ");
        int selectUser = sc.nextInt();




/*         fungsi checker agar data tidak di isi kedua kalinya
        System.out.println(checkerBillingUser(selectUser));*/

        var isValid = checkerBillingUser(selectUser);

        if (isValid) {
            UserSelector(selectUser);
            System.out.print("Masukan Billing Bulanan : ");
            int jumlahBulanan = sc.nextInt() ;

            int qtyPrice = 0;

            if (jumlahBulanan > 12) {
                System.out.println("Invalid Input, Please Use Menu NO 3");
            } else {
                qtyPrice = 360000 * jumlahBulanan;
            }

            billingUser.setUserCalendar(0, jumlahBulanan, 0);

            UserFormatter(selectUser,qtyPrice,"Monthly");

            System.out.println("Billing Bulanan: " + qtyPrice);

            //menambahkan spasi biar rapi
            System.out.println();

            // Tampilkan tanggal setelah perubahan
            priceFormater();
        }else {
                delayPromt(2000,selectUser);
        }

    }

    public void yearlyBilling() {


        System.out.print("Pilih Username: ");
        int selectUser = sc.nextInt();

        var isValid = checkerBillingUser(selectUser);

        if (isValid) {


            UserSelector(selectUser);

            System.out.print("Masukan Billing Tahunan : ");
            int jumlahTahunan = sc.nextInt() ;



            int qtyPrice = 3400000 * jumlahTahunan;

            billingUser.setUserCalendar(0, 0, jumlahTahunan);

            System.out.println("Billing Tahunan: " + qtyPrice);

            UserFormatter(selectUser,qtyPrice,"Yearly");

            //menambahkan spasi biar rapi
            System.out.println();

            // Tampilkan tanggal setelah perubahan
            priceFormater();
        }else{
            delayPromt(2000,selectUser);
        }

    }

    public  String priceFormater() {
        return " Di Mulai Dari -> "+billingUser.getDefaultCalendar() + " Akan Berakhir pada -> " + billingUser.getDefaultCalendarUser();
    }

    private  int manyUserSetter = 10 ;
    private String[] user = new String[manyUserSetter];

    public String addUser() {
        System.out.println("Generate User");
        System.out.print("Enter Phrase : ");
        String phrase = sc.nextLine();
        String uniqeCode = Base64.getEncoder().encodeToString(phrase.getBytes());

        System.out.println("Uniqe Code : " + uniqeCode);
        System.out.println();
        addUser(uniqeCode);

        return uniqeCode;

    }

    public void addUser(String input) {

        boolean penuh = true;

        for (int i = 0; i < user.length; i++) {
            if (user[i] == null) {
                // tidak menambahkan index arrar user
                penuh = false;
                break;
            }
        }

        // jika penuh maka resize ukurukan array

        if (penuh) {
            var tempArray = user; // ini adalah berbentuk array
            user = new String[user.length * 2];

            for (int i = 0; i < tempArray.length; i++) {
                user[i] = tempArray[i];
            }
        }

        for (int i = 0; i < user.length; i++) {
            if (user[i] == null) {
                user[i] = input;
                break;
            }
        }

    }

    public boolean checkerBillingUser(int inputIndexAray){
        inputIndexAray = inputIndexAray - 1 ;

        int counter = 0 ;

            if(user[inputIndexAray].contains("Di Mulai Dari")){
                return false ;
            }else {
                return true ;
            }



    }

/*    public void addUser(String inputUser) {
        // Cari slot kosong dalam array untuk menambahkan user baru

        for (int i = 1; i <= user.length; i++) {
            if (user[i] == null) { // Hanya tambahkan pada slot kosong
                user[i] = inputUser;
                user[i] = i +". "+ user[i] ;
                break;
            }
        }



    }*/

    public void ShowAddUser() {
        // Tampilkan semua user yang sudah terdaftar

        System.out.println("\nDaftar User : ");
        for (var i = 0; i < user.length; i++) {
            String list = user[i];
            int no = i + 1;

            if (list != null) {
                System.out.println(no + ". " + list);
            }
        }

        System.out.println();
    }


    public void UserSelector(int selecUser ){


            selecUser = (selecUser-1) ;

        if (selecUser < 0 || selecUser > user.length) {
            System.out.println("Invalid Select User");
        }

        System.out.println("User Selected = " + user[selecUser]);



    }

    public void UserFormatter(int selecUser , int hargaPaket , String jenisPaket) {
        selecUser = (selecUser-1) ;
        user[selecUser] += priceFormater() + " Harga Total : "+hargaPaket +" Jenis Paket : "+ jenisPaket;
    }




    public boolean RemoveUser() {
        ShowAddUser();
        System.out.print("Pilih Username: ");
        int number = sc.nextInt();
        sc.nextLine(); // Membersihkan newline dari buffer

        if (number < 1 || number > user.length || user[number - 1] == null) {
            System.out.println("Invalid selection");
            return false;
        }

        System.out.println("User Selected = " + user[number - 1]);

        // Geser elemen ke kiri untuk mengisi celah yang ditinggalkan oleh user yang dihapus
        for (int i = number - 1; i < user.length - 1; i++) {
            user[i] = user[i + 1];
        }

        // Hapus elemen terakhir karena telah digeser
        user[user.length - 1] = null;

        System.out.println("User removed successfully.");
        return true;
    }


    public void delayPromt(int milis , int indexArray) {
        indexArray = indexArray - 1 ;

        System.out.println();

        System.out.println("Data Sudah pernah Di Isi Dan Berakhir Pada : " + user[indexArray].substring(user[indexArray].lastIndexOf("->")+3,user[indexArray].length()) + "\n");


        try {
            Thread.sleep(3000); // Delay selama 3 detik
        } catch (InterruptedException e) {
            e.printStackTrace(); // Menangani kemungkinan InterruptedException
        }


    }





/*   public void RemoveUser() {
        ShowAddUser();
        System.out.print("Pilih Username: ");
        int selectUser = sc.nextInt();
        UserSelector(selectUser);

        if (user[selectUser] != null) {
          user[selectUser] = null;
           if (user[selectUser] == null) {


                System.out.println("Succesfully removed User");
           }else{
                System.out.println("User : " + user[selectUser]);
         }

       }


    }*/



/*
    public void UpdateUser() {
        System.out.print("Update User : ");

        for (int i = 0; i < user.length; i++) {
            if (user[i] != null) { // Tampilkan hanya elemen yang bukan null
                int dotIndex = user[i].indexOf('.'); // Cari posisi '.'
                    if (user[i].sub)
                }
            }
        }


    }
*/


}
