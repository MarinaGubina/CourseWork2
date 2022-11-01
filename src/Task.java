import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task {

    private final TypeOfTask type;
    private final Repeatable repeatable;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private int id;
    private static int count;

    public Task(String title, String description,TypeOfTask type,Repeatable repeatable, LocalDateTime dateTime) {
        setTitle(title);
        setDescription(description);
        this.type = type;
        this.repeatable = repeatable;
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

    public Repeatable getRepeatable() {
        return repeatable;
    }

    private boolean isNullOrEmpty(String val){
        return val.isBlank() && val == null;
    }

    public boolean appearTask(LocalDate date){
        LocalDateTime localDateTime = dateTime;
        switch (repeatable) {
            case SINGLE_Task:
                return dateTime.toLocalDate().isEqual(date);

            case DAILY_Task:
                return dateTime.toLocalDate().isBefore(date);

            case WEEKLY_Task:
                while (localDateTime.toLocalDate().isBefore(date)&&
                        !localDateTime.toLocalDate().isEqual(date)){
                    localDateTime = localDateTime.plusWeeks(1);
                }
                return localDateTime.toLocalDate().isEqual(date);
            case MONTHLY_Task:
                while (localDateTime.toLocalDate().isBefore(date)&&
                        !localDateTime.toLocalDate().isEqual(date)){
                    localDateTime = localDateTime.plusMonths(1);
                }
                return localDateTime.toLocalDate().isEqual(date);
            case YEARLY_TASK:
                while (localDateTime.toLocalDate().isBefore(date)&&
                        !localDateTime.toLocalDate().isEqual(date)){
                    localDateTime = localDateTime.plusYears(1);
                }
                return localDateTime.toLocalDate().isEqual(date);
        }
        return false;
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
        return  " { Задача: " + title + " , описание: " + description +
                ", тип:" + type.getTitle() +", повторяемость: " +
                repeatable.getStr() + ", дата и время: " + dateTime.toString() +" }";
    }
}
