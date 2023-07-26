import java.util.ArrayList;
import java.util.List;

public class GenericMethodWithoutFI {

    public static <A,B> void mySuperMethod(
            Iterable<A> source,
            MyPredicateTest<A> tester,
            MyFunctionApply<A,B> applyTo,
            MyConsumerAccept<B> accepting
    ){
        for (A a : source) {
            if (tester.test(a)) {
                B returnData = applyTo.apply(a);
                accepting.accept(returnData);
            }
        }
    }

    public static void main(String[] args) {
        List<String> myArrayOfStrings = new ArrayList<>();
        myArrayOfStrings.add("zero");
        myArrayOfStrings.add("apple");
        myArrayOfStrings.add("one");
        myArrayOfStrings.add("an");
        myArrayOfStrings.add("can");
        myArrayOfStrings.add("pepper");
        myArrayOfStrings.add("drink");
        myArrayOfStrings.add("pineapple");
        myArrayOfStrings.add("two");

        mySuperMethod(
                myArrayOfStrings,
                a -> a.length() >= 4,
                a -> a += " - this is added by MyFunctionApply.applyTo()",
                System.out::println);
    }

}

@FunctionalInterface
interface MyPredicateTest<A> {
    boolean test(A a);
}

@FunctionalInterface
interface MyFunctionApply<A, B> {
    B apply(A a);
}

@FunctionalInterface
interface MyConsumerAccept<B> {
    void accept(B b);
}






