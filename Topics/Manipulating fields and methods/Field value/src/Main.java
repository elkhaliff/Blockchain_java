/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */

class FieldGetter {

    public static Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        try {
            Class itemClass = object.getClass();
            return itemClass.getField(fieldName).get(object);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}