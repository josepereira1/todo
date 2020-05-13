package data;

import business.ITodo;
import business.TodoExistsException;
import business.TodoNotExistsException;

import java.util.Collection;

public interface IDataFacade {
    void addTodo(ITodo todo) throws TodoExistsException;
    void remove(int id) throws TodoNotExistsException;
    void update(ITodo todo) throws TodoNotExistsException;
    void markTodoAsDone(int id) throws TodoNotExistsException;
    Collection<ITodo> values();
}
