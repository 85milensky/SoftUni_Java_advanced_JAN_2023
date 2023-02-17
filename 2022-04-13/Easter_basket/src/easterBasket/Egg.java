package easterBasket;

public class Egg {
//01. Properties
//•	color: String
    private String color;
//•	strength: int
    private int strength;
//•	shape: String
    private String shape;

//02.Constructor receive color, strength and shape.
    public Egg(String color, int strength, String shape){
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }
//03.Getters - all
    public String getColor(){
        return color;
    }

    public int getStrength(){
        return  strength;
    }

    public String getShape(){
        return shape;
    }
//04.Setters - all
    public void setColor(String color){
        this.color = color;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public void setShape(String shape){
        this.shape = shape;
    }

//05. Override toString in the following format:
//"{color} egg, with {strength} strength and {shape} shape."
    @Override
    public String toString(){
        return String.format("%s egg, with %d strength and %s shape.", this.color, this.strength, this.shape);
    }

}
