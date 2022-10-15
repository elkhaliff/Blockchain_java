import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class FieldGetter {
    public String[] getPublicFields(Object object) {
        List<String> list = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                list.add(field.getName());
            }
        }
        return list.stream()
                .toArray(String[]::new);
    }
}