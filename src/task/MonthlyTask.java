package task;

import exception.IncorrectArgumentException;


import java.time.LocalDateTime;

public class MonthlyTask extends Task {


    public MonthlyTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public LocalDateTime getTaskNextTime(LocalDateTime dateTime) {
        return dateTime.plusMonths(1);
    }
}
