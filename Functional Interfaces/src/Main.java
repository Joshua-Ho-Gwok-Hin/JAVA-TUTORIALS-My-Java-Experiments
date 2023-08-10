import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Predicate<Integer> integerPredicate = integer -> integer % 2 == 0;
        BiPredicate<Integer, Integer> biPredicate = (i, j) -> i %2 == 0 && i>0;
        BiPredicate<Integer,Integer> biPredicate1 = (i, j) -> i %2 == 0 && i<100;
        System.out.println("integerPredicate.test(10) result = " + integerPredicate.test(10));
        System.out.println("biPredicate.test(10, 1) result = " + biPredicate.test(10, 1));
        System.out.println("biPredicate.test(10, 1) result = " + biPredicate1.test(10, 1));

        BiPredicate<Integer, Integer> combine = biPredicate.and(biPredicate1);
        BiPredicate<Integer, Integer> combineWithLambda = biPredicate1.and(new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer integer, Integer integer2) {
                return integer %2 == 0 && integer2 > 0;
            }
        });
        System.out.println("combine.test(10, 1) result = " + combine.test(10, 1));

        BiPredicate<Integer, Integer> combineWithLambda2 = biPredicate1.and((i, j) -> i % 2 == 0 && j>0);
        BiPredicate<Integer,Integer> combineWithLambda3 = (biPredicate1).and((i, j) -> i % 2 == 0 && j>0);
        BiPredicate<Integer,Integer> combineWithLambda4 = (new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer i, Integer j) {
                return i % 2 == 0 && j > 0;
            }
        }).and(biPredicate1);

//        BiPredicate<Integer,Integer> combineWithLambda5 = ((i, j) -> i % 2 == 0 && j>0).and(biPredicate);

        Predicate<Integer> largerThanZeroFI = integer -> integer > 0;
        Predicate<Integer> smallerThan100FI = integer -> integer < 100;
        Predicate<Integer> combineTheseTwo = largerThanZeroFI.and(smallerThan100FI);
//        Predicate<Integer> combineTheseTwo3 = (k -> false).and(smallerThan100FI);
//        Predicate<Integer> combineTheseTwo1 = (integer -> integer > 0).and(k -> k < 100);
        Predicate<Integer> combineTheseTwo2 = largerThanZeroFI.and(k -> k < 100);
        System.out.println(combineTheseTwo2.test(50));
//        System.out.println(combineTheseTwo3.test(50));





    }
}