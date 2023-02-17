package softUni;

import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
    Student student = new Student();

    }
}

public class Student {
    //fields
    private String firstName;
    private String lastName;
    private String bestCourse;

    //constructor
    public Student(String firstName, String lastName, String bestCourse){
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestCourse = bestCourse;
    }

    //getters
    public String getFirstName(){
        return  firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getBestCourse(){
        return getBestCourse;
    }

    //toString - returns the object in the form of text
    @Override
    public String toString(){
        return "Student: " + firstName + " " + lastName + ", Best Course = " bestCourse;
    }
}

public class SoftUni{
    //fields
    private Integer capactiy;
    private Collection<Student> students;
    private List<Student> data; //holds all students in the hall

    //constructor

    SoftUni softUni = new SoftUni(){
        Collection <Student> students = SoftUni.this.students// students with new instance of the collection
        Integer capacity = capactity;

        //capacity
    }

    //getters

    public Integer getCapactiy(){
        return capactiy;
    }

    public Integer getCount(){
        return students.size();
    }

    public String[] getStudent(String firstName, String lastName){
        return Str firstName, lastName;
    }

    //getStatistics

    //setters / mutators

    public insertStudent(Student student){
        System.out.println("Added student " + student.getFirstName() + " " + student.getLastName());

    }



}
