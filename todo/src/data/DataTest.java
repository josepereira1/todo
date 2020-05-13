package data;

import business.AbstractFactory;
import business.ITodo;
import business.TodoExistsException;
import business.TodoNotExistsException;

public class DataTest {
    public static void main(String[] args) {
        IDataFacade data = new DataFacade();
        AbstractFactory factory = new AbstractFactory();
        ITodo todo = factory.createTodo();
        try {
            data.addTodo(todo);
        } catch (TodoExistsException e) {
            e.printStackTrace();
        }

        System.out.println(data);

        todo.setContent("Isto é um todo!");

        try {
            data.update(todo);
        } catch (TodoNotExistsException e) {
            e.printStackTrace();
        }

        System.out.println(data);

        try {
            data.markTodoAsDone(todo.getId());
        } catch (TodoNotExistsException e) {
            e.printStackTrace();
        }

        System.out.println(data);
    }
}
