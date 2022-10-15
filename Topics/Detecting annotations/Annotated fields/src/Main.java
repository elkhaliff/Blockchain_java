import java.lang.reflect.*;

class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {

        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotations().length > 0)
                .map(Field::getName)
                .toArray(String[]::new);
    }
}