package data;

import business.ITodo;
import business.TodoExistsException;
import business.TodoNotExistsException;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TodoDAO implements Serializable {
    private final static String FILENAME = "data.db";
    private Map<Integer, ITodo> todos;
    private int lastId;

    public TodoDAO(){
        todos = new HashMap<>();
    }

    public void addTodo(ITodo todo) throws TodoExistsException {
        if(!todos.containsValue(todo)) {
            todo.setId(lastId + 1);
            lastId++;
            this.todos.put(todo.getId(), todo);
        }else{
            throw new TodoExistsException(String.valueOf(todo.getId()));
        }
    }

    public void remove(int id) throws TodoNotExistsException {
        if(todos.containsKey(id)) {
            todos.remove(id);
        }else {
            throw new TodoNotExistsException(String.valueOf(id));
        }
    }

    public void update(ITodo todo) throws TodoNotExistsException {
        if(todos.containsKey(todo.getId())){
            todos.remove(todo.getId(), todo);
            todos.put(todo.getId(), todo);
        }else throw new TodoNotExistsException(String.valueOf(todo.getId()));
    }

    public void markTodoAsDone(int id) throws TodoNotExistsException {
        if(todos.containsKey(id)) {
            todos.get(id).setState(true);
        }else {
            throw new TodoNotExistsException(String.valueOf(id));
        }
    }

    public Collection<ITodo> values(){
        return todos.values();
    }

    public static String getFILENAME() {
        return FILENAME;
    }

    public Map<Integer, ITodo> getTodos() {
        return todos;
    }

    public void setTodos(Map<Integer, ITodo> todos) {
        this.todos = todos;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public void save(){
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(FILENAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(FILENAME);
        } catch (FileNotFoundException e) {
            this.todos = new HashMap<>();
            this.lastId = 0;
            e.printStackTrace();
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(fileIn);
            //  puxar dados para RAM
            TodoDAO tmp = (TodoDAO) in.readObject();
            this.todos = tmp.getTodos();
            this.lastId = tmp.getLastId();

            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "TodoDAO{" +
                "todos=" + todos +
                ", lastId=" + lastId +
                '}';
    }
}
