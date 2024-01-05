package app_lottery_toys;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Counter_id counter;
    private Store store;
    private Lottery lottery;
    private ArrayList<Toy> toys;

    public void show_Store(ArrayList<Toy> toys) {

        System.out.printf("%-5s%-15s%-10s%-22s\n", "id", "Name", "Quantity", " Frequency");
        for (Toy toy : toys)
            System.out.printf("%-5d%-15s%-10d%-22f\n", toy.get_id(), toy.get_name(), toy.get_Quantity(),
                    toy.get_Frequency());
    }

    public void user_Menu(Store store, Counter_id counter, ArrayList<Toy> toys) {
        boolean flag = true;
        while (flag) {
            System.out.println("\n      Select the menu item\n" +
                    "1 - show the list of toys in the store\n" +
                    "2 - START LORRETY\n" +
                    "3 - change the frequency of toy by ID\n" +
                    "4 - add toy in store\n" +
                    "5 - delete toy in store\n" +
                    "6 - change parameters of toy in store\n" +
                    "7 - EXIT");
            System.out.println();
            Scanner in = new Scanner(System.in);

            String user_input = in.next();
            if (user_input.contains("1")) {
                System.out.println("\n toys in the store:");
                show_Store(store.get_Toys());
            } else if (user_input.contains("2")) {
                Lottery lottery = new Lottery(store.get_Toys());
                lottery.random_SelectionOfPrizes(store.get_Toys());
                Toy prizeToy = lottery.get_PrizeToy();
                if (prizeToy != null) {
                    System.out.println("\n Winning toy: " + prizeToy.get_name() + "\n");
                }
            } else if (user_input.contains("3")) {
                System.out.println("Input id: ");
                int id = Integer.parseInt(in.next());
                System.out.println("Input new frequency: ");
                double newFrequency = Double.parseDouble(in.next());
                if (newFrequency > 0 && newFrequency < 100) {
                    if (!store.change_ToyFrequency(id, newFrequency)) {
                        System.out.println("id does not exist!");
                    } else {
                        System.out.println("Change new frequency successfully!");
                    }
                } else {
                    System.out.println("New frequency must be in the range from 0 to 100\n");
                }
            } else if (user_input.contains("4")) {
                System.out.println("Input new name of toy: ");
                String name = in.next();
                System.out.println("Input new quantity of toy: ");
                int quantity = Integer.parseInt(in.next());
                boolean flag1 = true;
                System.out.println("Input new frequency of toy: ");
                double frequency = Double.parseDouble(in.next());
                while (flag1) {
                    if (frequency > 0 && frequency < 100) {
                        flag1 = false;
                    } else {
                        System.err.println("Input frequency of toy in range from 0 to 100: ");
                        frequency = Double.parseDouble(in.next());
                    }
                }
                store.add_Toy(new Toy(counter.get_id(), name, quantity, frequency));
                System.out.println("New toy is added! ");

            } else if (user_input.contains("5")) {
                System.out.println("Input name of toy to delete: ");
                String name = in.next();
                store.delete_ToyFromStore(toys, name);
                System.out.println("The toy is delete! ");
            } else if (user_input.contains("6")) {
                System.out.println("Input name of toy to change its parameters: ");
                String name = in.next();
                System.out.println("Input quantity of toy: ");
                int quantity = Integer.parseInt(in.next());
                boolean flag2 = true;
                System.out.println("Input frequency of toy: ");
                double frequency = Double.parseDouble(in.next());
                while (flag2) {
                    if (frequency > 0 && frequency < 100) {
                        flag2 = false;
                    } else {
                        System.out.println("Input frequency of toy in range from 0 to 100: ");
                        frequency = Double.parseDouble(in.next());
                    }
                }
                if (store.change_Toy(name, quantity, frequency)) {
                    System.out.println("Parameters of toy " + name + " changed!");
                } else {
                    System.out.println(name + "does not exists in store!");
                }
            } else {
                flag = false;
            }

        }
    }
}
