package _2023_06_14;

public class Tesk1 {
    private static int getOneCount(int i) {
            //  if (x > 2 || x < 10)
            //      128 64 32 16 4 2 1
            // int i =   0b01101100 --> 108
            // int i-1 = 0b01101011 --> 107
            // int i = 0b01101000 --> 104
            // int i = 0b01100111 --> 103
            // int i = 0b01100000 --> 96
            // int i = 0b01011111 --> 95
            // int i = 0b01000000 --> 64
            // int i = 0b00111111 --> 63
            // int i = 0b00000000 --> 0
            int result = 0;
        while (i != 0) {
            //i = 64 & 63
            i = i & (i - 1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
//        int i = 0b01100000;
//        int n = 108;
//        System.out.println(i);

        int x = 0x000007e7; //2023
        int w = 0x000007e8; //2024
        int e = 0x000000a0; //2016
        System.out.println(x & w);
    }
}