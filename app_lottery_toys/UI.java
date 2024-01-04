package app_lottery_toys;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Counter_id counter;
    private Store store;
    private Lottery lottery;
    private ArrayList<Toy> toys;

    public void show_Store(ArrayList<Toy> toys) {

        System.out.printf("%-5s%-15s%-10s%-22s\n", "id", "Name", "Quantity", "Frequency");
        for (Toy toy : toys)
            System.out.printf("%-5d%-15s%-10d%-22f\n", toy.get_id(), toy.get_name(), toy.get_Quantity(),
                    toy.get_Frequency());
    }

    public void user_Menu(Store store, Counter_id counter, ArrayList<Toy> toys) {
        boolean flag = true;
        while (flag) {
            System.out.println("\n      Выберите пункт меню\n" +
                    "1 - показать список игрушек в магазине\n" +
                    "2 - НАЧАТЬ ЛОТЕРЕЮ\n" +
                    "3 - изменить чатоту выпадения игрушки по id\n" +
                    "4 - добавить игрушку в магазин\n" +
                    "5 - удалить игрушку из магазина\n" +
                    "6 - изменить параметры игрушки\n" +
                    "7 - ВЫХОД");

            Scanner in = new Scanner(System.in);

            String user_input = in.next();
            if (user_input.contains("1")) {
                System.out.println("\n Список игрушек в магазине:");
                show_Store(store.get_Toys());
            } else if (user_input.contains("2")) {
                Lottery lottery = new Lottery(store.get_Toys());
                lottery.random_SelectionOfPrizes(store.get_Toys());
                Toy prizeToy = lottery.get_PrizeToy();
                if (prizeToy != null) {
                    System.out.println("\n Выигрышная игрушка: " + prizeToy.get_name() + "\n");
                }
            } else if (user_input.contains("3")) {
                System.out.println("Введите id: ");
                int id = Integer.parseInt(in.next());
                System.out.println("Введите новую частоту выподания: ");
                double newFrequency = Double.parseDouble(in.next());
                if (newFrequency > 0 && newFrequency < 100) {
                    if (!store.change_ToyFrequency(id, newFrequency)) {
                        System.out.println("id не найден");
                    } else {
                        System.out.println("Частата выподания изменина.");
                    }
                } else {
                    System.out.println("Частота выподания должна находиться в диапазоне от 0 до 100\n");
                }
            } else if (user_input.contains("4")) {
                System.out.println("Введите название игрушки: ");
                String name = in.next();
                System.out.println("Введите количество игрушек: ");
                int quantity = Integer.parseInt(in.next());
                boolean flag1 = true;
                System.out.println("Введите частоту выподания игрушки: ");
                double frequency = Double.parseDouble(in.next());
                while (flag1) {
                    if (frequency > 0 && frequency < 100) {
                        flag1 = false;
                    } else {
                        System.err.println("Частота выподания должна находиться в диапазоне от 0 до 100: ");
                        frequency = Double.parseDouble(in.next());
                    }
                }
                store.add_Toy(new Toy(counter.get_id(), name, quantity, frequency));
                System.out.println("Игрушка добавлена! ");

            } else if (user_input.contains("5")) {
                System.out.println("Введите название игрушки для удаления: ");
                String name = in.next();
                store.delete_ToyFromStore(toys, name);
                System.out.println("Игрушка удалена! ");
            } else if (user_input.contains("6")) {
                System.out.println("Введите название игрушки для изменения её параметров: ");
                String name = in.next();
                System.out.println("Введите количество игрушек: ");
                int quantity = Integer.parseInt(in.next());
                boolean flag2 = true;
                System.out.println("Введите частоту выподания игрушки: ");
                double frequency = Double.parseDouble(in.next());
                while (flag2) {
                    if (frequency > 0 && frequency < 100) {
                        flag2 = false;
                    } else {
                        System.out.println("Частота выподания должна находиться в диапазоне от 0 до 100: ");
                        frequency = Double.parseDouble(in.next());
                    }
                }
                if (store.change_Toy(name, quantity, frequency)) {
                    System.out.println("Параметры игрушки" + name + " изменены!");
                } else {
                    System.out.println(name + "Игрушки с таким названием нет!");
                }
            } else {
                flag = false;
            }

        }
    }
}
