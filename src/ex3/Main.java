package ex3;

public class Main {
    public static void main(String[] args) {
        try {
            Test test = new Test();

            String string = Serializable.serializableTest(test);
            System.out.println(string);

            test.setA(12);
            test.setC("ddddd");
            string = Serializable.serializableTest(test);
            System.out.println(string);

            Test test2 = Serializable.deserializableTest(string);
            System.out.println(test2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
