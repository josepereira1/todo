package view;

import business.BusinessFacade;

public class MainMenuController implements Runnable{
    private BusinessFacade model;
    private MainMenuView view;

    public MainMenuController(BusinessFacade model){
        this.model = model;
        view = new MainMenuView();
    }

    public void run(){
        view.displayMenu();
        switch (view.getOption()){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "0":
                break;
            default:
                break;
        }
    }
}
