package _2023_06_14;

public class Bit {
    public static void printBinary(int b) {
        System.out.println("0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1));
    }

    public static String binaryStr(int b) {
        return "0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1);
    }

    public static void main(String[] args) {
        int i = 0b00110011; //
        int h = 0x000007E7;
        System.out.println(h);
    }
}
