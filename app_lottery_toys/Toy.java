package app_lottery_toys;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double frequency;

    public Toy(int id, String name, int quantity, double frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;

    }

    public void set_id(int id) {
        this.id = id;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public int get_id() {
        return id;
    }

    public String get_name() {
        return name;
    } 

    public int get_Quantity() {
        return quantity;
    }

    public double get_Frequency() {
        return frequency;
    }

    public void set_Quantity(int quantity) {
        this.quantity = quantity;
    }

    public void set_Frequency(double frequency) {
        this.frequency = frequency;
    }
    
}
