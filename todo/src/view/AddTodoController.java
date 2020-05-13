package view;

import business.BusinessFacade;
import business.TodoExistsException;

public class AddTodoController implements Runnable {

    private BusinessFacade model;
    private AddTodoView view;

    public AddTodoController(BusinessFacade model){
        this.model = model;
        view = new AddTodoView();
    }

    @Override
    public void run() {
        view.displayAddMenu();
        if(view.getContent().equals("0")) new MainMenuController(model);
        try {
            model.addTodo(view.getContent());
        } catch (TodoExistsException e) {
            view.displayAddMenu();
        }
    }
}
