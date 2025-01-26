package stringbuild.stringbuffer;

import java.math.BigInteger;

public class BigNumberApp {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("2000000000000000000");
        BigInteger b = new BigInteger("1000000000000000000");
        BigInteger c = a.add(b);
        System.out.println(c);
        c = a.subtract(b);
        System.out.println(c);
        c = a.multiply(b);
        System.out.println(c);
        c = a.divide(b);
        System.out.println(c);
        c = a.mod(b);


        /*
        ex out -> 3000000000000000000
                  1000000000000000000
                  2000000000000000000000000000000000000
                  2
         */
    }
}
