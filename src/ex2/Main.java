package ex2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer container = new TextContainer();
        Class<?> containerClass = container.getClass();

        if (containerClass.isAnnotationPresent(SaveTo.class)) {
            SaveTo saveTo = containerClass.getAnnotation(SaveTo.class);
            Method[] methods = containerClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)){
                    try {
                        method.invoke(container, saveTo.path());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else
            System.out.println("class is not annotated");

    }
}
