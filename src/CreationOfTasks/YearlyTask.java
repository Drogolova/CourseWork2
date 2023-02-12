package CreationOfTasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class YearlyTask extends Task {

    public YearlyTask(String title, Type type, String description, LocalDateTime dateTime) {

        super(title, type, description, dateTime);
    }

    public boolean appearsIn(LocalDate date) {
        return date.isAfter(ChronoLocalDate.from(getDateTime())) && date.getDayOfYear() == getDateTime().getDayOfYear();
    }
}
