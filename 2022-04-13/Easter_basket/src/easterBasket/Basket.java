package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
//1. Fields
    //has data (a List which stores the entity Egg)
    private List<Egg> data;
    //•	material: String
    private String material;
    //•	capacity: int
    private int capacity;
//2. Constructor should receive material and capacity, also it should initialize the data with a new instance of the collection.
    public Basket(String material, int capacity){
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
//3. Getters
    //Method getCount() – returns the number of eggs
    public int getCount(){
        return data.size();
    }

    //•	Method getStrongestEgg()– returns the strongest egg
    public Egg getStrongestEgg(){
        Egg strongestEgg = data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
                return strongestEgg;
    }
    //•	Method getEgg(string color) – returns the egg with the given color
    public Egg getEgg(String color){
        Egg eggSelectedBycolor = data.stream().filter(eggs -> eggs.getColor().equals(color)).findAny().orElse(null);
        return eggSelectedBycolor;
    }
    //Method report() – returns a string in the following format (print the eggs in order of appearance):
    //"{material} basket contains:
    //{Egg1}
    //{Egg2}
    //(…)"
   public String report(){
        StringBuilder report = new StringBuilder();
        report.append(String.format("%s basket contains: ", material));
        data.forEach(egg -> {
            report.append(System.lineSeparator());
            report.append(egg.toString());
        });
        return report.toString();
    }
//4. Setters
    //Method addEgg(Egg egg) – adds an entity to the data if there is room for it
    public void addEgg(Egg egg) {
        boolean thereIsRoom = this.capacity > data.size();

        if (thereIsRoom) {
            data.add(egg);
        }
    }
    //•	Method removeEgg(string color) – removes an egg by given color, if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeEgg(String color){
        Egg eggToRemove = this.data.stream().filter(egg -> egg.getColor().equals(color)).findFirst().orElse(null);
        return this.data.remove(eggToRemove);
    }
}
