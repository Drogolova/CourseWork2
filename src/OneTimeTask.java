import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{

    public OneTimeTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateTime().toLocalDate().compareTo(date) == 0;
    }


}
