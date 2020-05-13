package business;

import java.time.LocalDateTime;

public interface ITodo {
    int getId();

    void setId(int id);

    LocalDateTime getDate();

    void setDate(LocalDateTime date);

    String getContent();

    void setContent(String content);

    boolean isState();

    void setState(boolean state);

    @Override
    String toString() ;
}
