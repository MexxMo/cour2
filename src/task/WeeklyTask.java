package task;

import exception.IncorrectArgumentException;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {


    public WeeklyTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public LocalDateTime getTaskNextTime(LocalDateTime dateTime) {
        return dateTime.plusWeeks(1);
    }
}
