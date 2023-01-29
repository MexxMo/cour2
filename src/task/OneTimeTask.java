package task;

import exception.IncorrectArgumentException;


import java.time.LocalDateTime;

public class OneTimeTask extends Task {


    public OneTimeTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public LocalDateTime getTaskNextTime(LocalDateTime dateTime) {
        return null;
    }
}
