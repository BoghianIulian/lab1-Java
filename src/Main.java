// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean isPrime(int number) {
        int nrDiv = 0;
        for (int i = 2; i <= number / 2; i++)
            if (number % i == 0)
                nrDiv++;
        if (nrDiv == 0)
            return true;
        return false;
    }

    private static List<Integer> readConsole() {
        List<Integer> numere = new ArrayList<Integer>();
        Scanner cons = new Scanner(System.in);
        System.out.println("Introduceti numere intregi. Stop pentru oprire.");

        while (cons.hasNext()) {
            String token = cons.next();

            if ("stop".equals(token)) {
                break;
            }

            try {
                numere.add(Integer.parseInt(token));
            } catch (NumberFormatException nfe) {

            }
        }
        return numere;
    }

    public static List<Integer> transformToInt(String[] params) {
        List<Integer> integerList = new ArrayList<>();
        for (String param : params) {
            try {
                integerList.add(Integer.parseInt(param)); //adaugam doar elementele intregi din linia de comanda
            } catch (NumberFormatException nfe) {

            }
        }
        return integerList;
    }

    public static List<Integer> primeNumbers(List<Integer> numbers) {
        List<Integer> newList = new ArrayList<>();
        for (int i : numbers) {
            if (isPrime(i))
                newList.add(i);
        }
        return newList;
    }


    public static void main(String[] args) {
        System.out.println("Avem " + args.length + " parametrii in linia de comanda");
        List<Integer> list, primeNumbersList;
        if (args.length > 0)
            list = transformToInt(args);
        else
            list = readConsole();
        primeNumbersList = primeNumbers(list);
        for (int i : primeNumbersList)
            System.out.println(i);
    }

}