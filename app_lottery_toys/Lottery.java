package app_lottery_toys;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Lottery {
    private ArrayList<Toy> prizes;
    private ArrayList<Toy> toys;
    private String prizeFilePath;

    UI ui = new UI();

    public Lottery(ArrayList<Toy> toys) {
        this.prizes = new ArrayList<Toy>();
        this.toys = toys;
        prizeFilePath = FileClear.filename;
    }

    public ArrayList<Toy> get_Prizes() {
        return prizes;
    }

    public String get_PrizeFilePath() {
        return prizeFilePath;
    }

    public void random_SelectionOfPrizes(ArrayList<Toy> toys) {
        prizes.clear();

        for (Toy toy : toys) {
            double random = Math.random() * 100;

            if (random < toy.get_Frequency()) {
                prizes.add(toy);
            }
        }
        System.out.println("\nprizes:");
        ui.show_Store(prizes);
    }

    public Toy get_PrizeToy() {
        if (!prizes.isEmpty()) {

            Toy prizeToy = prizes.remove(0);

            prizeToy.set_Quantity(prizeToy.get_Quantity() - 1);

            try {
                FileWriter writer = new FileWriter(prizeFilePath, true);
                writer.write(prizeToy.get_name() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to the Toy file");
            }
            return prizeToy;
        } else {
            System.out.println("All the toys are over");
            return null;
        }

    }

}
