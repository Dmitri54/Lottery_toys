package app_lottery_toys;
 
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LotteryToys {
    public static void main(String[] args) throws FileNotFoundException {

        FileClear.file_Clear();

        Store store = new Store();
        Counter_id counter = new Counter_id(0);

        UI ui = new UI();

        Toy airplane = new Toy(counter.get_id(), "Airplane", 10, 15);
        Toy truck = new Toy(counter.get_id(), "Truck", 100, 35);
        Toy ball = new Toy(counter.get_id(), "Ball", 200, 45);
        Toy doll = new Toy(counter.get_id(), "Doll", 200, 45);
        Toy rubikCube = new Toy(counter.get_id(), "Rubik Cube", 200, 65);
        Toy soupBubbles = new Toy(counter.get_id(), "Soup Bubbles", 20, 20);

        store.add_Toy(airplane);
        store.add_Toy(truck);
        store.add_Toy(ball);
        store.add_Toy(doll);
        store.add_Toy(rubikCube);
        store.add_Toy(soupBubbles);

        ui.user_Menu(store, counter, store.get_Toys());

    }
    
}
