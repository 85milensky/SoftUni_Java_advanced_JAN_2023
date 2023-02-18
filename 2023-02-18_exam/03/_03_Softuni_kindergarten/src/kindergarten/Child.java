package kindergarten;

public class Child {
//1. Fields
    //•	firstName: String
    private String firstName;
    //•	lastName: String
    private String lastName;
    //•	age: int
    private int age;
    //•	parentName: String
    private String parentName;
    //•	contactNumber: String
    private String contactNumber;
//2. Constructor
 // should receive firstName, lastName, age, parentName and contactNumber
    public Child (String firstName, String lastName, int age, String parentName, String contractNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.parentName = parentName;
        this.contactNumber = contractNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getContactNumberactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contractNumber) {
        this.contactNumber = contractNumber;
    }
//3. Getters
    //    //•	firstName: String
    //    //•	lastName: String
    //    //•	age: int
    //    //•	parentName: String
    //    //•	contactNumber: String

//4. Setters
    //    //•	firstName: String
    //    //•	lastName: String
    //    //•	age: int
    //    //•	parentName: String
    //    //•	contactNumber: String
//5. Override toString method
    //in the following format:
    //"Child: {firstName} {lastName}, Age: {age}, Contact info: {parentName} - {contactNumber}"
    @Override
    public String toString(){
        return String.format("Child: %s %s, Age: %d, Contact info: %s - %s",
                firstName, lastName, age, parentName, contactNumber);
    }
}
