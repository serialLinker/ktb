package fr.wirth.test;

public class FailStrategy extends Strategy<Days, Long> {

    public FailStrategy() {
        registerAction(Days.MONDAY, 1L);
    }

    public Long getValue(Days day) {
        return getAction(day);
    }
}
