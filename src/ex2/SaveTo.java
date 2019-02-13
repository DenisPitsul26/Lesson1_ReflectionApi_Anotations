package ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String path() default "E:\\JavaPro\\ReflectionApi_Anotations\\src\\ex2\\file.txt";
}
