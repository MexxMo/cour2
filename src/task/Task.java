package task;

import exception.IncorrectArgumentException;


import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task implements Repeatable {

    private static int idGenerator = 1;
    private String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;

    public Task(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        this.id = idGenerator++;
        setTitle(title);
        this.type = type;
        this.dateTime = dateTime;
        setDescription(description);
    }


    public String getTitle() {
        return title;
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

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title == null || title.isEmpty() || title.isBlank()) {
            throw new IncorrectArgumentException("Введите название задачи");
        } else {
            this.title = title;
        }
    }


    public void setDescription(String description) throws IncorrectArgumentException {
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new IncorrectArgumentException("Введите название описание задачи");
        } else {
            this.description = description;
        }
    }

    @Override
    public String toString() {
        return "id- " + id +",\n"+
                "Название- " + title +",\n"+
                "Тип задачи- " + type +",\n"+
                "Время- " + dateTime +",\n"+
                "Описание- " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(type, task.type) && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }


}

