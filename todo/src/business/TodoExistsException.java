package business;

public class TodoExistsException extends Exception {
    public TodoExistsException(){
        super();
    }

    public TodoExistsException(String msg){
        super(msg);
    }
}
