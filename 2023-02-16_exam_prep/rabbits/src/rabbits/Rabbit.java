package rabbits;

public class Rabbit {

//1. Fields
    private String name;
    private String species;
    private boolean available; //true by default
//2. Constructor
    public Rabbit(String name, String species){
        this.name = name;
        this.species = species;
        this.available = true;
    }
//3. Getters
    public String getName(){
        this.name = name;
        return name;
    }
    public String getSpecies(){
        this.species = species;
        return species;
    }
    public boolean isAvailable(){
     return  available;
    }
//4. Setters
    public void setAvailable(boolean available){
        this.available = available;
    }
//5. Override toString method Rabbit ({species}): {name}
    @Override
    public String toString(){
        return String.format("Rabbit (%s): %s", species, name);
    }
}
