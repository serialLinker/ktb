package fr.wirth.test.simple;

import fr.wirth.test.Days;
import fr.wirth.test.Strategy;

import java.util.function.Supplier;

public class ShowNumberStrategy extends Strategy<Days, Supplier<Integer>> {

    public ShowNumberStrategy() {
        registerAction(Days.MONDAY, () -> 1);
        registerAction(Days.TUESDAY, () -> 2);
    }

    public Integer getNumber(Days days) {
        return getAction(days).get();
    }
}
