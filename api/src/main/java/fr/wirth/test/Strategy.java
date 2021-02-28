package fr.wirth.test;

import java.lang.reflect.ParameterizedType;
import java.util.EnumMap;

public abstract class Strategy<T extends Enum<T>, U> {

    private final EnumMap<T, U> map;
    private final Class<T> clazz;

    public Strategy() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        map = new EnumMap<>(clazz);
        for (var key : clazz.getEnumConstants()) {
            map.put(key, null);
        }
    }

    public void registerAction(T key, U action) {
        this.map.put(key, action);
    }

    public U getAction(T key) {
        var action = map.get(key);
        if (action == null) {
            throw new RuntimeException();
        }
        return action;
    }

    //TODO use @VisibleForTesting
    public Class<T> getType() {
        return clazz;
    }
}
