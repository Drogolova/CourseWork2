import java.time.LocalDate;

public class YearlyTask extends Task{

    public YearlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return (getDateTime().toLocalDate().compareTo(date) >= 0) && getDateTime().toLocalDate().getDayOfYear() == date.getDayOfYear();
    }
}
