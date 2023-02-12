package CreationOfTasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;


public class DailyTask extends Task {
    private LocalDate periodic;

    public DailyTask(String title, Type type, String description, LocalDateTime dateTime) {

        super(title, type, description, dateTime);

        periodic = dateTime.toLocalDate().plusDays(1);
    }

    public boolean appearsIn(LocalDate date) {
        return date.isAfter(ChronoLocalDate.from(getDateTime()));
    }
}
