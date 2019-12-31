public class FileNotFoundException extends Exception {
    public FileNotFoundException(){
        super("Sorry, file not found!");
    }
    public FileNotFoundException(String message){
        super(message);
    }
}
