import java.util.*;
import java.io.File;


public class PersonDataManager extends FileNotFoundException{
    private Person[] people;
    private int length;
    public static Scanner stdin = new Scanner(System.in);

    public static PersonDataManager buildFromFile(String location) throws IllegalArgumentException, PersonAlreadyExistsException, FileNotFoundException {
        PersonDataManager pdm = new PersonDataManager();

        try {
            stdin = new Scanner(new File(location));
            stdin.nextLine();

            while (stdin.hasNextLine()) {

                String temp = stdin.nextLine().trim();
                String[] data = temp.split(",");

                String name = data[0].trim();
                name = name.substring(1,name.length()-1);
               // name = name.replaceAll("\"", "");
                String gender = data[1].trim();
                gender = gender.substring(1,2);
                System.out.print("\nGENDER: " + gender);
               // gender = gender.replaceAll("\"", "");
                int age = Integer.parseInt(data[2].trim());
                double height = Double.parseDouble(data[3].trim());
                double weight = Double.parseDouble(data[4].trim());

                Person p = new Person(name, age, gender, height, weight);

                try {
                    pdm.addPerson(p);
                } catch (Exception PersonAlreadyExistsException) {
                    throw new PersonAlreadyExistsException();
                }

            }

        } catch (Exception FileNotFoundException) {
        } finally {
            stdin = new Scanner(System.in);
        }
        //stdin = new Scanner(System.in);
        System.out.println("PDM length: " + pdm.people.length);
        pdm.length=pdm.people.length;
        return pdm;
    }


    public void addPerson(Person newPerson) throws PersonAlreadyExistsException {
        // There is no people. And I should give it a place to go to
        System.out.println("Size of people: " + people.length);
        if(people == null){
            this.people = new Person[1];
            this.people[0] = newPerson;
        } else {
            //I check if the person already exist
            for(int i=0; i<this.people.length; i++) {
                if(this.people[i].equals(newPerson)) {
                    throw new PersonAlreadyExistsException();
                }
            }

            // If the person does not exist, increase the size of your array
            Person[] temp = new Person[this.people.length+1];
            // Copy over the values from old array (people) to new array (temp)
            this.length = this.people.length;
            for(int i=0; i<this.people.length; i++) {
                temp[i] = this.people[i];
            //    this.length = this.people.length;
            }
       //     this.length = this.people.length;
            // Add in the new person
            temp[this.people.length] = newPerson;
            this.people = temp;
          //  System.out.println("THIS IS LENGTH: " + this.length);
        }
    }

    public void getPerson(String name) throws personDoesNotExistException {
        System.out.println("Size of people: " + people.length);
        int count = 0;
        if (people == null) {
            //I check if the original array has anything in it and tell the data if there isn't
            System.out.println("You have not inputted any data yet. The person is not there.");
        } else {
            for (int i = 0; i < this.people.length; i++) {
               //if the name provided matches a name in the array, I print out the information
                if ((people[i].nameEquals(name))==true) {
                    count = 1;
                    int age = this.people[i].getAge();
                    String gender = this.people[i].getGender();
                    Double height = this.people[i].getHeight();
                    Double weight = this.people[i].getWeight();
                    if (gender.equals("M")) {
                        gender = "male";
                    } else {
                        gender = "female";
                    }
                    System.out.println(name + " is a " + age + " year old " + gender + " who is " + height + " inches and weighs " + weight + " pounds");
                }
            }
            if (count == 0) {
                //If none of the names match, I throw an error
                throw new personDoesNotExistException();
            }
        }
    }

    public void removePerson(String name) throws personDoesNotExistException {
        System.out.println("Size of people: " + people.length);

        int count = 0;
        if (people == null) {
            System.out.println("You have not inputted any data yet. The person you wish to remove is not there");
        } else {
            for (int i = 0; i < this.people.length; i++) {
                if (people[i].nameEquals(name) == true) {
                    count = 1;
                    //if the names equal I will create a new array with a smaller index value
                    Person[] temp = new Person[this.people.length - 1];
                    //I will copy the original array up until the person I want to exclude
                    for (int j = 0; j < i; j++) {
                        temp[j] = people[j];
                    }
                    //I will copy the values past the person I want to remove into the temp array
                    for (int j = i; j < this.people.length - 1; j++) {
                        int m = j + 1;
                        temp[j] = people[m];
                    }
                }
            }
            if (count == 0) {
                // if none of the names match, I throw an error
                throw new personDoesNotExistException();
            }
        }
    }


//    public void printTable(){
//        System.out.println("\tName\t|\tAge\t|\tGender\t|\tHeight\t|\tWeight");
//        System.out.println("=================================================================");
//        for (int i = 0; i<this.people.length;i++) {
//           // System.out.println("It has gotten this far");
//            System.out.println(this.people[i].toString());
//        }
//    }
    public void printTable(){

        System.out.println("This is the length: " + this.length);
        //        for(int i=0; i<this.people.length;i++){
//            System.out.println(this.people[i]);
//        }
    }


    public Person[] getPeople() {
        return this.people;
    }
}

