import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatable{

    public DailyTask(String title, String description, TypeOfTask type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearTask(LocalDate date) {
        return super.getDateTime().toLocalDate().isBefore(date);
    }

    @Override
    public String toString() {
        return super.toString() + ", повторяемость: ежедневная.";
    }
}
