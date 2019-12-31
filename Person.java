

public class Person {
    private int age;
    private double height, weight;
    private String name, gender;

    public Person(String name, int age, String gender, double height, double weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    // getters & setter
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender = gender;

    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getWeight(){
        return this.weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    public boolean nameEquals(String pname){
        if(this.name.equals(pname)){
            return true;
        }
        return false;
    }

    public String toString() {
        return (this.name + "\t" + this.age + "\t" + this.gender + "\t" + this.height + "\t" + this.weight);
    }

    public boolean equals(Person p) {
        if(!this.name.equals(p.name)) {
            return false;
        } else if(!this.gender.equals(p.gender)) {
            return false;
        } else if(this.age != p.age) {
            return false;
        } else if(this.height != p.height) {
            return false;
        } else if(this.weight != p.weight) {
            return false;
        }
        return true;
    }
}

