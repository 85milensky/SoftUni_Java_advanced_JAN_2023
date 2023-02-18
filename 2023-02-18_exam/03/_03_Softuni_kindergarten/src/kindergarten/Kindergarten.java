package kindergarten;

import java.util.*;

public class Kindergarten {
    //1. Fields
    //•	name: String
    private String name;
    //•	capacity: int
    private int capacity;
    //•	registry: List<Child>
    private List<Child> registry;
//2. Constructor should receive name and capacity, also it should initialize the registry with a new instance of the collection.
    public Kindergarten(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }
//3. Getters
    //•	Getter getChildrenCount - Returns the number of all children registered.
    public int getChildrenCount(){
        return registry.size();
    }
    //•	Method getChild(String firstName) - Returns the child with the given first name.
    public Child getChild(String firstName){
        Child child = this.registry.stream()
                .filter(r->r.getFirstName().equals(firstName))
                .findFirst().orElse(null);
        return child;
    }
    //•	Method registryReport() – Orders the children by
    // age ascending, then by
    // last name ascending, then by
    // first name ascending, and returns a String in the following format:
    //o	"Registered children in {kindergartenName}:
    //--
    //{child1}
    //--
    //{child2}
    //--
    //(…)
    //--
    //{childn}"
    public String registryReport(){
        Comparator byAge = Comparator.comparing(Child::getAge);
        Comparator byLastName = Comparator.comparing(Child::getLastName);
        Comparator byFirstName = Comparator.comparing(Child::getFirstName);

        Collections.sort(registry, byFirstName);
        //Collections.sort(registry, byLastName);
        Collections.sort(registry, byAge);



        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:", name));
        sb.append(System.lineSeparator());
        registry.forEach(child -> {
        sb.append(child.toString());
        sb.append(System.lineSeparator());
        });

        return sb.toString();
    }


//4. Setters
    //•	Method addChild(Child child) - Adds a child to the registry if there is room for it and returns true.
    //  If there is no room for another child, returns false.
    public boolean addChild(Child child){
        boolean roomAvailable = this.capacity > this.registry.size();

        if (roomAvailable) this.registry.add(child);
        return roomAvailable;
    }
    //•	Method removeChild(String firstName) - removes a child by a given firstName.
    // If removal is successful, returns true, otherwise, returns false.
    public boolean removeChild(String firstName){
        Child child = this.registry.stream()
                .filter(r->r.getFirstName().equals(firstName))
                .findFirst().orElse(null);
        return this.registry.remove(child);
    }

}
