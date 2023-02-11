package CreationOfTasks;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class DailyTask extends Task {
    private LocalDate periodic;

    public DailyTask(String title, Type type, String description, LocalDateTime dateTime) {

        super(title, type, description, dateTime);

        periodic = dateTime.toLocalDate().plusDays(1);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
       return getPeriodic(date).isEqual(date);
    }

    public LocalDate getPeriodic(LocalDate date) {
        LocalDate periodic = getDateTime().toLocalDate();
        for(int i = 0; periodic.compareTo(date) <= 0; i++) {
            periodic = periodic.plusDays(1);
        }
        return periodic;
    }
}
