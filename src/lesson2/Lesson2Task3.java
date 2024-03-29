package lesson2;

import java.util.Scanner;

/**
 * Написать программу, которая считывает год, введённый пользователем, и определяет, является ли этот год високосным.
 * Год считается високосным, если он делится без остатка на 4. Однако, если год также делится на 100,
 * то этот год не високосный, за исключением годов, делящихся на 400.
 * Например:
 * 1992 - високосный
 * 1900 - не високосный
 * 2000 - високосный
 */
public class Lesson2Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
            System.out.println("високосный");
        } else {
            System.out.println("не високосный");
        }

    }
}
