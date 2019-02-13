package ex1;

public class Tester {

    public Tester() {
    }

    @MyTest(param1 = 3, param2 = 5)
    public static void test(int a, int b) {
        System.out.println(a +" "+ b);
    }
}
