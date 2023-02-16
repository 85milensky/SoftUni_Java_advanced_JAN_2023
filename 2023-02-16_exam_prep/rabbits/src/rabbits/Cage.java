package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

//1. Fields
    private List<Rabbit> data;
    private String name;
    private int capacity;

//2. Constructor
    public Cage(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

//3. Getters
    public String getName(){
        this.name = name;
        return name;
    }

    public int getCapacity(){
        this.capacity = capacity;
        return capacity;
    }

    //count() - returns the number of rabbits
    public int count(){
        return data.size();
    }

    //report() - returns a String in the following format, including only not sold rabbits:
    //o	"Rabbits available at {cageName}:
    //{Rabbit 1}
    //{Rabbit 2}
    //(…)"
    public String report(){
        List<Rabbit> rabbits = this.data.stream().filter(Rabbit::isAvailable).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at "+ getName()));
        rabbits.forEach(r -> {
            sb.append(System.lineSeparator());
            sb.append(r.toString());
        });
        return  sb.toString();
    }

//4. Setters
    public void add(Rabbit rabbit){//adds an entity to the data if there is room for it
        boolean spaceAvailable = this.capacity > this.data.size();

        if(spaceAvailable){
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name){//removes a rabbit by given name, if such exists, and returns boolean
        Rabbit rabbit = this.data.stream()
                        .filter(r -> r.getName().equals(name))
                        .findFirst()
                        .orElse(null);

        return this.data.remove(rabbit);
    }


    public void removeSpecies(String species){//removeSpecies(String species) method - removes all rabbits by given species
        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
        //2nd variant:
        /*List<Rabbit> rabbits = this.data.stream()
                                .filter(rabbit -> rabbit.getSpecies().equals(species))
                                .collect(Collectors.toList());
        rabbits.forEach(r -> this.data.remove(r));*/
    }

//sellRabbit(String name) method - sell (set its available property to false without removing it from the collection)
//the first rabbit with the given name, also return the rabbit
    public Rabbit sellRabbit(String name){
        Rabbit rabbit = this.data.stream().filter(r -> r.getName().equals(name))
                            .findFirst()
                            .orElseThrow();
        rabbit.setAvailable(false);
        return rabbit;
    }


//sellRabbitBySpecies(String species) method - sells and returns all rabbits from that species as a List
    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> rabbits =this.data.stream().filter(r -> r.getSpecies().equals(species)).collect(Collectors.toList());

        rabbits.forEach(r -> r.setAvailable(false));
        return rabbits;
    }
}
