package shelter;

public class Animal {

        //1. fields
        public String name;
        public int age;
        public String caretaker;

        //2. constructor
        public Animal (String name, int age, String caretaker){
            this.name = name;
            this.age = age;
            this.caretaker = caretaker;
        }

        //3. getters
        public String getName(){
            return name;
        }

        public int getAge(){
            return age;
        }

        public String getCaretaker(){
            return caretaker;
        }

        //4. setters

        public void setName(String name){
            this.name = name;
        }

        public void setAge(int age){
            this.age = age;
        }

        public void setCaretaker(String caretaker){

            this.caretaker = caretaker;
        }

        //5. override toString() method in the following format: "{name} {age} ({caretaker})"
        @Override
        public String toString(){
            return String.format("$s $d ($s)", name, age, caretaker);
        }

}
