package data;

import business.ITodo;
import business.TodoExistsException;
import business.TodoNotExistsException;

import java.util.Collection;

public class DataFacade implements IDataFacade{
    private TodoDAO todoDAO;

    public DataFacade(){
        todoDAO = new TodoDAO();
    }

    @Override
    public void addTodo(ITodo todo) throws TodoExistsException {
        todoDAO.addTodo(todo);
    }

    @Override
    public void remove(int id) throws TodoNotExistsException {
        todoDAO.remove(id);
    }

    @Override
    public void update(ITodo todo) throws TodoNotExistsException {
        todoDAO.update(todo);
    }

    @Override
    public void markTodoAsDone(int id) throws TodoNotExistsException {
        todoDAO.markAsDone(id);
    }

    @Override
    public Collection<ITodo> values() {
        return todoDAO.values();
    }

    @Override
    public String toString() {
        return "DataFacade{" +
                "todoDAO=" + todoDAO +
                '}';
    }
}
