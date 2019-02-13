package ex3;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class Serializable {

    public static String serializableTest(Test test) throws IllegalAccessException {
        Class<?> сlassTest = test.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] fields = сlassTest.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(Save.class)) {
                int mods = field.getModifiers();
                if (Modifier.isPrivate(mods))
                    field.setAccessible(true);

                sb.append(field.getName()).append("-");
                if (field.getType() == int.class)
                    sb.append(field.getInt(test));
                else if (field.getType() == String.class)
                    sb.append(field.get(test));
                else if (field.getType() == long.class)
                    sb.append(field.getLong(test));
                else if (field.getType() == double.class)
                    sb.append(field.getDouble(test));
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static Test deserializableTest(String string) throws IllegalAccessException {
        Test test = new Test();
        Class<?> сlassTest = test.getClass();
        Map<String,String> partsMap = stringToMap(string);

        Field[] fields = сlassTest.getDeclaredFields();
        for (Field field : fields) {
            int mods = field.getModifiers();
            if (Modifier.isPrivate(mods))
                field.setAccessible(true);

            if (field.isAnnotationPresent(Save.class)) {
                if (partsMap.containsKey(field.getName())) {
                    if (field.getType() == int.class)
                        field.setInt(test, Integer.parseInt(partsMap.get(field.getName())));
                    else if (field.getType() == String.class)
                        field.set(test, partsMap.get(field.getName()));
                    else if (field.getType() == long.class)
                        field.setLong(test, Long.parseLong(partsMap.get(field.getName())));
                    else if (field.getType() == double.class)
                        field.setDouble(test, Double.parseDouble(partsMap.get(field.getName())));
                }
            }

        }
        return test;
    }

    private static Map<String,String> stringToMap(String string) {
        String[] parts = string.split(";");
        Map<String,String> partsMap = new HashMap<>();
        for (String part : parts) {
            String[] keyAndValue = part.split("-");
            partsMap.put(keyAndValue[0],keyAndValue[1]);
        }
        return partsMap;
    }
}
