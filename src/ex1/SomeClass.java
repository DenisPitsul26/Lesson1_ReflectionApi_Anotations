package ex1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SomeClass {

    public static void sameMethod() {
        Tester tester = new Tester();
        Class<?> testerClass = Tester.class;

        Method[] methods = testerClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)){
                try {
                    MyTest myTest = method.getAnnotation(MyTest.class);
                    method.invoke(tester, myTest.param1(), myTest.param2());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
