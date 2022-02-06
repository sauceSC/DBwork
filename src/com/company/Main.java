package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        DB db = new DB();

        System.out.println("Добро пожаловать в систему! Что вы хотите сделать?: " + "\n" +
                "1 - Поиск по бренду телефона" + "\n" +
                "2 - Показать всё, что находится на складе" + "\n" +
                "3 - Сделать скидку на телефоны" + "\n" +
                "4 - Добавить на склад телефонов" + "\n" +
                "0 - Завершить работу" + "\n");

        int ask = scanner.nextInt();
            switch (ask) {
                case(1):
                    db.manufacturer = scanner1.nextLine();
                    System.out.println(db.getPhonesByManufacturer());
                    break;
                case (2):
                    System.out.println(db.getPhones());
                    break;
                case (4) :
                    db.id = scanner.nextInt();
                    db.manufacturer = scanner1.nextLine();
                    db.model = scanner1.nextLine();
                    db.price = scanner.nextInt();
                    db.count = scanner.nextInt();
                    db.addPhone();
                    db.getPhones();
                default:
                    System.out.println("Вы ввели фигню, давайте еще раз.");
                    break;
            }
    }
}
