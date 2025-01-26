package stringbuild.stringbuffer;

public class StringBuilderApp {


    public static void main(String[] args) {

        String name = "fahri" ;

        name = name + " " + "akbar" ;
        name = name + " " + "putra" ;


        System.out.println(name);



        //lebih baik mengunakan string builer agar tidak menumpuk pada memori
        //karena di java tidak bisa merubah string awal java hanya bisa membuat string dengan
        //bentuk baru yang ingin di tambah atau di kurangi , jika tidak mengunakan string buffer atau builder
        //seperti yang sudah di jelaskan akan tidak berjalan efisien pada memori usage


        StringBuilder builer = new StringBuilder();

        builer.append("fahri");
        builer.append(" ");
        builer.append("akbar");
        builer.append(" ");
        builer.append("putra");

        String nameBuiler = builer.toString();
        System.out.println(nameBuiler);


    }

}
