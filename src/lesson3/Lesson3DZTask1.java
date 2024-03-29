package lesson3;

/**
 * Напишите программу, которая циклически сдвигает элементы массива вправо на одну позицию и печатает результат.
 * Цикличность означает, что последний элемент массива становится самым первым его элементом.
 */
public class Lesson3DZTask1 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //выводим в консоль исходный массив
        arrayPrint(array);

        //запоминаем последний элемент массива во временную переменную
        int tmp = array[array.length - 1];

        //сдвигаем все элементы массива на одну позицию вправо
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        //присваиваем первому элементу массива сохраненное значение последнего элемента
        array[0] = tmp;

        //выводим в консоль измененный массив
        arrayPrint(array);
    }

    //метод, выводящий в консоль целочисленный массив
    public static void arrayPrint(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

