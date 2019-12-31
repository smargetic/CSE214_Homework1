class PersonAlreadyExistsException extends Exception {
    public PersonAlreadyExistsException(){
        super("This person already exists.");
    }
    public PersonAlreadyExistsException(String message){
        super(message);
    }
}