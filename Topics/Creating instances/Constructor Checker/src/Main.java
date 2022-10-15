import java.lang.reflect.Modifier;
import java.util.Arrays;

class ConstructorChecker {

    public boolean checkPublicParameterlessConstructor(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredConstructors())
                .anyMatch(c -> Modifier.isPublic(c.getModifiers())
                        && c.getParameterCount() == 0);
    }
}