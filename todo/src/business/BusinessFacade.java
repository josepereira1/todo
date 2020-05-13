package business;

import data.IDataFacade;

import java.util.Collection;

public class BusinessFacade {

    private IDataFacade data;
    private IAbstractFactory factory;

    public Collection<ITodo> getAllTodos(){
        return data.values();
    }

    public void addTodo(String content) throws TodoExistsException {
        ITodo todo = factory.createTodo();
        data.addTodo(todo);
    }

    public void removeTodo(int id) throws TodoNotExistsException {
        data.remove(id);
    }

    public void updateInfoTodo(ITodo todo) throws TodoNotExistsException {
        data.update(todo);
    }

    public void markTodoAsDone(int id) throws TodoNotExistsException {
        data.markTodoAsDone(id);
    }
}
