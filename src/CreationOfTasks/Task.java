package CreationOfTasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Task {

    private static int idGenerator = 1;
    private String title;
    private final Type type;
    private final int id;
    private LocalDateTime dateTime;
    private String description;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.LL.yyyy HH:mm:ss");
    public Task(String title, Type type, String description, LocalDateTime dateTime) {
        if (title == null) {
            throw new IncorrectArgumentException("title");
        }
        if (type == null) {
            throw new IncorrectArgumentException("type");
        }
        if (description == null) {
            throw new IncorrectArgumentException("description");
        }
        this.title = title;
        this.type = type;
        this.description = description;
        this.id = idGenerator++;
        this.dateTime = dateTime;

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

    public void setDateTime(int year) {

        this.dateTime = dateTime;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && title.equals(task.title) && type == task.type && dateTime.equals(task.dateTime) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return "Название: " + title +
                ", Тип: " + type +
                ", id: " + id +
                ", Дата создания: " + dateTime.format(formatter) +
                ", Описание: " + description;
    }

    public abstract boolean appearsIn(LocalDate date);
}
