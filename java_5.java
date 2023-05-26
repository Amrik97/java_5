//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//Добавить функции 1) Добавление номера
//2) Вывод всего
//Пример:
//Я ввожу: 1
//К: Введите фамилию
//Я: Иванов
//К: Введите номер
//Я: 1242353
//К: Введите 1) Добавление номера
//2) Вывод всего
//Я ввожу: 1
//К: Введите фамилию
//Я: Иванов
//К: Введите номер
//Я: 547568
//К: Введите 1) Добавление номера
//2) Вывод всего
//Я: 2
//Иванов: 1242353, 547568

import java.util.*;

public class task1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("Введите:\n1 - Добавление номера\n2 - Вывод всего");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Введите фамилию:");
                String name = scanner.nextLine();
                System.out.println("Введите номер:");
                String number = scanner.nextLine();
                if (phoneBook.containsKey(name)) {
                    ArrayList<String> numbers = phoneBook.get(name);
                    numbers.add(number);
                    phoneBook.put(name, numbers);
                } else {
                    ArrayList<String> numbers = new ArrayList<>();
                    numbers.add(number);
                    phoneBook.put(name, numbers);
                }
            } else if (choice == 2) {
                for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
                    String name = entry.getKey();
                    ArrayList<String> numbers = entry.getValue();
                    System.out.println(name + ": " + String.join(", ", numbers));
                }
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
    }
}