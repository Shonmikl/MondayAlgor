package _2023_06_14;

public class Bit {
    public static void printBinary(int b) {
        System.out.println("0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1));
    }

    public static String binaryStr(int b) {
        return "0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1);
    }

    public static void main(String[] args) {
//        int i = 0b00110011;
//        int h = 0x000007E7;
//        System.out.println(h);

        int i = 0b00001000; //8

        System.out.println("Сдвиг вправо: " + (i >> 1));
        System.out.println("Сдвиг влево: "  + (i << 1));

        System.out.println("**********************************");
        int a = 0b0001001;
        int b = 0b0001010;

        System.out.println("Побитовое 'AND' -- &");
        printBinary(a);
        printBinary(b);
        printBinary(a & b);
//        System.out.println("50 & 51 = " + (50 & 51));
        System.out.println("----------------------------------------");

        System.out.println("Побитовое 'OR' -- |");
        printBinary(a);
        printBinary(b);
        printBinary(a | b);
//        System.out.println("50 | 51 = " + (50 | 51));
        System.out.println("----------------------------------------");

        System.out.println("Побитовое исключающее или 'XOR' -- ^");
        printBinary(a);
        printBinary(b);
        printBinary(a ^ b);
        System.out.println("----------------------------------------");

        System.out.println("Инверсия -- ~");
        printBinary(a);
        printBinary(~a);
        System.out.println("----------------------------------------");


        int u = 0b0100000;
        System.out.println("Беззнаковый побитовый сдвиг вправо -- >>> " + u );
        System.out.println(u >>> 1);
    }
}