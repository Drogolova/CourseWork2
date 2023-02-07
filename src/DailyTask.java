import java.time.LocalDate;

public class DailyTask extends Task{

    public DailyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
       return getDateTime().toLocalDate().compareTo(date) >= 0;
    }
}
