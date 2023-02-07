import java.time.LocalDate;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return (getDateTime().toLocalDate().compareTo(date) >= 0) && getDateTime().toLocalDate().getDayOfWeek().compareTo(date.getDayOfWeek()) == 0;

    }
}
