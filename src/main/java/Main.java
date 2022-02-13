import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int inputNumber(String text) {
        int attemps = 5;
        int i = 0;
        int num;

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(text);
            try {
                num = input.nextInt();
                if (num < 0) {
                    num = -num;
                }
                return num;
            } catch (java.util.InputMismatchException e) {
                i++;
                if (i != attemps) {
                    System.out.println("Осталось попыток: " + (attemps - i));
                    input.next();
                    continue;
                } else {
                    System.out.print("Не вышло (!");
                    System.exit(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr_size = inputNumber("Введите размер массива: ");
        //создадим
        IndexStorage indexStorage = new IndexStorage(arr_size);
        //заполним
        int one[] = new int[indexStorage.size()];
        for (int i = 0; i < one.length; i++) {
            one[i] = indexStorage.get(i);
        }
        System.out.println("Массив:      " + Arrays.toString(one));
        //перевернутый
        one = indexStorage.reverse();
        System.out.println("Перевернули: " + Arrays.toString(one));
        //наследник
        ArrayIndexStorage arrayIndexStorage = new ArrayIndexStorage(one);
        int num = inputNumber("Введите номер ячейки: ");
        System.out.println("Получили:    " + arrayIndexStorage.get(num));

        int two[] = arrayIndexStorage.reverse();
        System.out.println("Перевернули: " + Arrays.toString(two));

    }

}
