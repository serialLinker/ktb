package fr.wirth;

import fr.wirth.test.Strategy;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class StrategyTester {

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        var reflections = new Reflections("fr.wirth.test");
        Set<Class<? extends Strategy>> classes = reflections.getSubTypesOf(Strategy.class);

        for (var clazz : classes) {
            var instance = clazz.getDeclaredConstructor().newInstance();
            for (var value : instance.getType().getEnumConstants()) {
                try {
                    instance.getAction((Enum) value);
                } catch (RuntimeException e) {
                    fail("missing action on " + clazz.getSimpleName() + " for enum value : " + value);
                }
            }
        }
    }


}
