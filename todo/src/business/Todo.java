package business;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Todo implements Serializable, ITodo {
    private int id;
    private LocalDateTime date;
    private String content;
    boolean state;  //  true = ativo & false = desativo

    public Todo(){
        date = LocalDateTime.now();
        state = false;
    }

    public Todo(int id, LocalDateTime date, String content, boolean state) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", state=" + state +
                '}';
    }
}
