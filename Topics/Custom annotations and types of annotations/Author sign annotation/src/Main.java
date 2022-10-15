
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
    String name();
}

class TestClass {
    @Author(name = "Jane Johnson")
    public void myMethod() {
        // some code
    }
}