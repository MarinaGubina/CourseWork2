import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task implements Repeatable{

    public SingleTask(String title, String description, TypeOfTask type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearTask(LocalDate date) {
        return super.getDateTime().toLocalDate().isEqual(date);
    }

    @Override
    public String toString() {
        return super.toString() + ", повторяемость: однократная.";
    }
}
