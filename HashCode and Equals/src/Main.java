public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ClassWithSameHashCodes one = new ClassWithSameHashCodes("two");
        ClassWithSameHashCodes two = new ClassWithSameHashCodes("one");

        System.out.println(one.equals(two));
        System.out.println(one.hashCode());
        System.out.println(two.hashCode());
    }
}