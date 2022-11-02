import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable{

    public MonthlyTask(String title, String description, TypeOfTask type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearTask(LocalDate date) {
        LocalDateTime localDateTime = super.getDateTime();
        while (localDateTime.toLocalDate().isBefore(date)&&
                !localDateTime.toLocalDate().isEqual(date)){
            localDateTime = localDateTime.plusMonths(1);
        }
        return localDateTime.toLocalDate().isEqual(date);
    }

    @Override
    public String toString() {
        return super.toString() + ", повторяемость: ежемесячная.";
    }
}
