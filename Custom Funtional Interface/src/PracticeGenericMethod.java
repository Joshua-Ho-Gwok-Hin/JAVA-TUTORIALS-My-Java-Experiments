import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PracticeGenericMethod {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<String> myArrayList = new ArrayList<>();
        myArrayList.add("Hello");
        myArrayList.add("How");
        myArrayList.add("are");
        myArrayList.add("you");
        myArrayList.add("doing");
        myArrayList.add("Hello World");

        generateResults(
                myArrayList,
                s -> s.length() > 3,
                String::length,
                System.out::println);

        anotherMethod(
                myArrayList,
                s -> s.length() > 3,
                String::length,
                System.out::println);

    }

    public static <T, U, R> void generateResults(Iterable<T> sources, Predicate<T> conditions, Function<T, R> applying, Consumer<R> accepting) {
        for (T t: sources) {
            if (conditions.test(t)) {
                R returnData = applying.apply(t);
                accepting.accept(returnData);
            }
        }
    }

    public static <T, U, R> void anotherMethod(
            Iterable<T> source,
            Predicate<T> test,
            Function<T, R> function,
            Consumer<R> consumer) {
        for (T each : source) {
            if (test.test(each)) {
                consumer.accept(function.apply(each));
            }
        }
    }
}