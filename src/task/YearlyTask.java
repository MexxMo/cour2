package task;

import exception.IncorrectArgumentException;

import java.time.LocalDateTime;

public class YearlyTask extends Task {


    public YearlyTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public LocalDateTime getTaskNextTime(LocalDateTime dateTime) {
        return dateTime.plusYears(1);
    }
}
