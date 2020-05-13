package view;

import java.util.Scanner;

public class AddTodoView {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void displayAddMenu(){
        System.out.println("insert content of todo:");
        Scanner input = new Scanner(System.in);
        content = input.nextLine();
    }
}
