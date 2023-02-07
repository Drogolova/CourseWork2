import java.time.LocalDate;

public class MonthlyTask extends Task{

    public MonthlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return (getDateTime().toLocalDate().compareTo(date) >= 0) && getDateTime().toLocalDate().getDayOfMonth() == date.getDayOfMonth();
    }
}
