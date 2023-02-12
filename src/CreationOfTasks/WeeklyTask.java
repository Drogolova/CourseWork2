package CreationOfTasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, String description, LocalDateTime dateTime) {

        super(title, type, description, dateTime);
    }

    public boolean appearsIn(LocalDate date) {
        return date.isAfter(ChronoLocalDate.from(getDateTime())) && date.getDayOfWeek().equals(getDateTime().getDayOfWeek());
    }
}
