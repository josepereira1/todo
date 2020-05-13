package business;

public class TodoNotExistsException extends Exception {
    public TodoNotExistsException(){
        super();
    }

    public TodoNotExistsException(String msg){
        super(msg);
    }
}
