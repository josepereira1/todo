package business;

public class AbstractFactory implements IAbstractFactory{

    @Override
    public ITodo createTodo() {
        return new Todo();
    }
}
