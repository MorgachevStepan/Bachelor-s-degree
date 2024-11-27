package com.stepanew.technicservice.exception;

import java.text.MessageFormat;
import java.util.function.Supplier;

public class TechnicNotFoundException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Техники с id = {0} нет";

    public TechnicNotFoundException(String message) {
        super(message);
    }

    public TechnicNotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public static Supplier<TechnicNotFoundException> technicNotFoundException(String message, Object... args) {
        return () -> new TechnicNotFoundException(message, args);
    }

    public static Supplier<TechnicNotFoundException> technicNotFoundException(String message) {
        return () -> new TechnicNotFoundException(message);
    }

    public static Supplier<TechnicNotFoundException> technicNotFoundException(Long technicId) {
        return () -> new TechnicNotFoundException(DEFAULT_MESSAGE, technicId);
    }

}
