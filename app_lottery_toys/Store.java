package app_lottery_toys;

import java.util.ArrayList;

public class Store {
    private ArrayList<Toy> toys;

    public Store() {
        toys = new ArrayList<Toy>();
    }
    
    public void add_Toy(Toy toy) {
        toys.add(toy);
    }

    public ArrayList<Toy> get_Toys() {
        return toys;
    }

    public boolean change_ToyFrequency(int toyId, double newFrequency) {
        int i = 0;
        for (Toy toy : toys) {
            if (toy.get_id() == toyId) {
                toy.set_Frequency(newFrequency);
                i ++;
            }
        }
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void delete_ToyFromStore(ArrayList<Toy> toys, String name) {
        int i = 0;
        for (Toy t : toys) {
            if (t.get_name().contains(name)) {
                toys.remove(t);
                i ++;
                break;
            }
        }
        if (i > 0 ) {
            System.out.println("the toy " + name + " was successfully removed");
        } else {
            System.out.println("the toy " + name + " does not exist");
        }

    }

    public boolean change_Toy(String name, int quantity, double frequency) {
        boolean flag = false;
        for (Toy t : toys) {
            if (t.get_name().contains(name)) {
                t.set_name(name);
                t.set_Quantity(quantity);
                t.set_Frequency(frequency);
                flag = true;
            }
        } 
        return flag;
    }
}
