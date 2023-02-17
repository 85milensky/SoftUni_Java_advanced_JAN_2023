package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    //1.functions:
    private List<Animal> data; // data (a List, which stores the Animals)
    private int capacity;

    //2.constructor //should receive capacity, also it should initialize the data with a new instance of the collection
    public Shelter(int capacity){
       this.capacity = capacity;
       this.data = new ArrayList<>();
       }

        //3.getters
        public List<Animal> getData(){
            return data;
        }
        public int getCapacity(){
            return capacity;
        }

            //01 Method getAnimal(String name, String caretaker) – returns the animal with the given name and caretaker or
                // null if no such animal exists.
        public Animal getAnimal(String name, String caretaker){

            return this.data.stream().filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)).findAny().orElse(null);
        }

        //02 Method getOldestAnimal() – returns the oldest shelter.Animal.
   public Animal getOldestAnimal(){

        return this.data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
        }

    public int getCount(){
            return data.size();
    }


            //04 getStatistics() – returns a String in the following format:
                //The shelter has the following animals:
                //{name} {caretaker}
                //{name} {caretaker}
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:");
        sb.append(System.lineSeparator());
        data.forEach(animal -> sb.append(String.format("%s %s%n", animal.getName(), animal.getCaretaker())));
            return sb.toString();
    }
        //4.setters

    //Method add(shelter.Animal animal) – adds an entity to the data if there is an empty cell for the animal.
    public void add(Animal animal){
        boolean spaceAvailable = capacity > this.data.size();
        if(spaceAvailable){
            this.data.add(animal);
        }

    }

    //Method remove(String name) – removes the animal by given name, if such exists, and returns boolean.

    public boolean remove(String name){
        return data.removeIf(animal -> animal.getName().equals(name));
    }
}
