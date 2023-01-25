package Tasks;


import java.time.LocalDateTime;

public class Task {

    private static int idGenerator = 0;
    private String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, int id, LocalDateTime dateTime, String description) {

        this.title = title;
        this.type = type;
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
