package fr.wirth.test.complex;

import fr.wirth.test.Days;
import fr.wirth.test.Strategy;

import java.util.function.Function;

public class DaysQtyInYearStrategy extends Strategy<Days, Function<Integer, Integer>> {

    private FakeService fakeService = new FakeService();

    public DaysQtyInYearStrategy() {
        registerAction(Days.MONDAY, fakeService::getMondayQty);
        registerAction(Days.TUESDAY, fakeService::getTuesdayQty);
    }

    public Integer getQtyForYear(Days days, Integer year) {
        return getAction(days).apply(year);
    }
}
