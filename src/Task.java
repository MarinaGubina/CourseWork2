import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task{

    private final TypeOfTask type;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private int id;
    private static int count;

    public Task(String title, String description, TypeOfTask type, LocalDateTime dateTime) {
        setTitle(title);
        setDescription(description);
        this.type = type;
        this.dateTime = dateTime;
        id = count++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(isNullOrEmpty(title)){
            throw new RuntimeException("Введите заголовок задачи");
        }
        else{
        this.title = title;}
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(isNullOrEmpty(description)){
            throw new RuntimeException("Введите описание задачи");
        }
        else {
        this.description = description;}
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public TypeOfTask getType() {
        return type;
    }

    private boolean isNullOrEmpty(String val){
        return val.isBlank() && val == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && type == task.type && title.equals(task.title) && description.equals(task.description) && dateTime.equals(task.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, description, dateTime, id);
    }

    @Override
    public String toString() {
        return  " Задача: " + title + " , описание: " + description +
                ", тип:" + type.getTitle() + ", дата и время: " + dateTime.toString();
    }

    public abstract boolean appearTask(LocalDate date);
}
