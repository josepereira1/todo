package view;

import java.util.Scanner;

public class MainMenuView {
    private String option = "";

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void displayMenu(){
        System.out.println("1-List all todos;");
        System.out.println("2-Add new todo;");
        System.out.println("3-Update todo;");
        System.out.println("4-Remove todo;");
        System.out.println("5-Mark as done todo;");
        System.out.println("0-Exit;");
        Scanner input = new Scanner(System.in);
        option = input.nextLine();
    }


}
