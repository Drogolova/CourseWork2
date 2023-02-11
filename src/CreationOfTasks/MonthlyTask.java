package CreationOfTasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {

    public MonthlyTask(String title, Type type, String description, LocalDateTime dateTime) {
        super(title, type, description, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getPeriodic(date).isEqual(date);
    }

    public LocalDate getPeriodic(LocalDate date) {
        LocalDate periodic = getDateTime().toLocalDate();
        for (int i = 0; periodic.compareTo(date) <= 0; i++) {
            periodic = periodic.plusMonths(1);
        }
        return periodic;
    }
}
