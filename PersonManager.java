import java.io.PrintWriter;
import java.io.IOException;

public class PersonManager {

    public static void saveToFile(String fileName, Person[] people) throws IOException {
        String output = "";
        for(int i=0; i<people.length; i++) {
            output += people[i].toString();
        }

        PrintWriter out = new PrintWriter(fileName);
        out.println(output);
    }

    public static void main(String[] args) throws PersonAlreadyExistsException, personDoesNotExistException, IOException, FileNotFoundException{
        PersonDataManager manager = new PersonDataManager();
        Person[] people;

        while(true){
            System.out.println("Please select an option:\nMenu:");
            System.out.println("(I)-Import from File\n(A)-Add Person");
            System.out.println("(R)-Remove Person\n(G)-Get Information on Person");
            System.out.println("(P)-Print Table\n(S)-Save to File\n(Q)-Quit");
            String input = PersonDataManager.stdin.nextLine().trim();
            switch(input){
                case "i":
                case "I":
                    System.out.println("Please enter a location: ");
                    String location = PersonDataManager.stdin.nextLine().trim();

                    try {
                        manager.buildFromFile(location);
                                //.getPeople();
                    } catch (Exception FileNotFoundException){
                        throw new FileNotFoundException();
                    }
                    break;
                case "a":
                case "A":
                    System.out.println("Please enter the name of the person:");
                    String name = PersonDataManager.stdin.nextLine().trim();

                    System.out.println("Please enter the age:");
                    String tempAge = PersonDataManager.stdin.nextLine().trim();
                    int age = Integer.parseInt(tempAge);

                    System.out.println("Please enter the gender (M or F):");
                    String gender = PersonDataManager.stdin.nextLine().trim();

                    System.out.println("Please enter the height (in inches):");
                    String heightTemp = PersonDataManager.stdin.nextLine().trim();
                    double height = Double.parseDouble(heightTemp);

                    System.out.println("Please enter the weight(in lbs):");
                    String weightTemp = PersonDataManager.stdin.nextLine().trim();
                    double weight = Double.parseDouble(weightTemp);

                    //I assign the input values in as a new person
                    Person newPerson = new Person(name, age, gender, height, weight);

                    //I call the addPerson method and add this person to the original list
                    manager.addPerson(newPerson);

                    System.out.println(name + " has been added to the list!");
                    break;
                case "r":
                case "R":
                    System.out.println("Please enter the name of the person:");
                    name = PersonDataManager.stdin.nextLine().trim();

                    manager.removePerson(name);

                    System.out.println(name + " has been removed!");
                    break;
                case "g":
                case "G":
                    System.out.println("Please enter the name of the person:");
                    name = PersonDataManager.stdin.nextLine().trim();

                    manager.getPerson(name);

                    break;
                case "p":
                case "P":
                    manager.printTable();
                    break;
                case "s":
                case "S":
                    System.out.println("Please select a name for the file:");
                    String newLocation = PersonDataManager.stdin.nextLine().trim();

                    saveToFile(newLocation, manager.getPeople());

                    System.out.println("A file named " + newLocation + " has been created!");
                    break;
                case "q":
                case "Q":
                    System.out.println("Sorry to see you go!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("That is not an option, please try again.");
            }
        }

    }
}
