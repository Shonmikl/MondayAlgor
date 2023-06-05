package _2023_06_05.eratosphen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eratosfen {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(eratosfenPrimes(1000).toArray()));
    }

    //что бы проверить числа до 1000 например,
    //то достаточно проверить все числа до корня квадратного из 1000
    //
    public static List<Integer> eratosfenPrimes(int max) {
        //создадим массив булеан
       boolean[] isPrime = new boolean[max];
       //заполним тру
       Arrays.fill(isPrime, true);

       //начиная с 2
        for (int i = 2; i * i < max; i++) {
            //если число простое
            if (isPrime[i]) {
                //тогда пробегаем по всем числам и делаем шаг
                for (int j = 2 * i; j < max; j += i) {
                    //устанавливаем волс тк они точно не простые
                    isPrime[j] = false;
                }
            }
        }

        //остается выписать в списко все простые числа
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}