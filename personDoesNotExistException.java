
class personDoesNotExistException extends Exception {
    public personDoesNotExistException() { super("This person does not exist.");}
    public personDoesNotExistException(String message) {super(message);}
}