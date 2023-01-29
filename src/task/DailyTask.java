package task;

import exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {


    public DailyTask(String title, Type type, String description, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public LocalDateTime getTaskNextTime(LocalDateTime dateTime) {
        return dateTime.plusDays(1);
    }
}
