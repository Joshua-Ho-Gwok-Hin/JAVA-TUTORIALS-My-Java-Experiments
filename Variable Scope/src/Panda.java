import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Panda {
    int age;

    public static void main(String[] args) {
        Collection<String> strings = new ArrayList<>();
        Panda p1 = new Panda();
        Panda p2 = new Panda();
        p1.age = 1;
        p2.age = 6;
        check(p1, p-> {return p.age < 5;});
        check(p2, p-> {return p.age < 5;});
        check(new Panda(), new Predicate<Panda>() {
            @Override
            public boolean test(Panda p) {
                return p.age > 5;
            }
        });
    }

    private static void check(Panda panda, Predicate<Panda> predicate) {
        String result = predicate.test(panda) ? "match" : "not match";
        System.out.println(result);

    }
}
