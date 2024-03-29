package lesson19;
/*
Двое безумных учёных устроили соревнование, кто из них соберёт больше роботов за 100 ночей. Для этого каждую ночь каждый
из них отправляет своего прислужника на свалку фабрики роботов за деталями. Чтобы собрать одного робота им нужно:
Голова, Тело, Левая рука, Правая рука, Левая нога, Правая нога, CPU, RAM, HDD
В первую ночь на свалке находится 20 случайных деталей. Каждую последующую ночь фабрика выбрасывает на свалку от 1 до 4
случайных деталей. В то же самое время прислужники обоих учёных отправляются на свалку, и каждый собирает от 1 до 4
случайных деталей. Если на свалке деталей нет – прислужник уходит ни с чем.
Затем они возвращаются домой и отдают детали хозяевам. Учёные пытаются собрать как можно больше роботов из деталей,
которые они получили.
Написать программу, симулирующую этот процесс. Для симуляции принять, что каждая ночь наступает через 100мс.
Фабрика и два прислужника действуют в одно и то же время.
После 100 ночей (около 10 секунд) определить победителя соревнования.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Lesson19Task1 {
    public static Map<String, Integer> robots = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Dump dump = new Dump();
        Semaphore semaphore = new Semaphore(3);

        Thread factory = new Thread(new Factory(dump), "Фабрика");
        Thread servant1 = new Thread(new Servant(dump), "Слуга 1");
        Thread servant2 = new Thread(new Servant(dump), "Слуга 2");

        factory.start();
        Thread.sleep(100);
        servant1.start();
        servant2.start();
        factory.join();
        servant1.join();
        servant2.join();

        int countRobotsScientist1 = robots.get("Слуга 1");
        int countRobotsScientist2 = robots.get("Слуга 2");

        System.out.println("Первый ученый изготовил " + countRobotsScientist1 + " роботов");
        System.out.println("Второй ученый изготовил " + countRobotsScientist2 + " роботов");
        System.out.println("========================================");
        if (countRobotsScientist1 > countRobotsScientist2) {
            System.out.println("\u001B[31m" + "Победа присуждается первому ученому!" +  "\u001B[0m");
        } else if (countRobotsScientist1 < countRobotsScientist2) {
            System.out.println("Победа присуждается второму ученому! ");
        } else {
            System.out.println("Ничья!");
        }
    }
}
