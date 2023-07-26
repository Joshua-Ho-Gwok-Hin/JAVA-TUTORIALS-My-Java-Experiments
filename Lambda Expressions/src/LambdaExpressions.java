import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressions {


    public static void main(String[] args) {
        List<ExampleUser> userList = new ArrayList<>();
        var john = new ExampleUser("John");
        var peter = new ExampleUser("Peter");
        var mark = new ExampleUser("Mark");
        var luke = new ExampleUser("Luke");
        var harry = new ExampleUser("Harry");
        var potter = new ExampleUser("Potter");
        var tony = new ExampleUser("Tony");
        var stark = new ExampleUser("Stark");
        userList.add(john);
        userList.add(peter);
        userList.add(mark);
        userList.add(luke);
        userList.add(harry);
        userList.add(potter);
        userList.add(tony);
        userList.add(stark);
        System.out.println("userList.size() = " + userList.size());
        userList.forEach(System.out::println);




//        Option 1: Create a class to implement Predicate<T> (This example uses 3 lines of code)
        class SomeoneNameJohn implements Predicate<ExampleUser> {
            @Override
            public boolean test(ExampleUser user) {
                return (user.name.equals("John"));
            }
        }
        userList.removeIf(new SomeoneNameJohn());
        System.out.println("userList.size() = " + userList.size());

//        Option 2: Straight away invoke method and using anonymous class that implements Predicate<T> (This example uses 2 lines of code)
        userList.removeIf(new Predicate<ExampleUser>() {
            @Override
            public boolean test(ExampleUser user) {
                return (user.name.equals("Peter"));
            }
        });
        System.out.println("userList.size() = " + userList.size());


//        Option 3: Use Lambda expression. This one line of code replaces the above 2 options.
        userList.removeIf(user -> user.name.equals("Luke"));
        System.out.println("userList.size() = " + userList.size());

        Map<Integer, ExampleUser> mapUserSerialNumber = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            mapUserSerialNumber.put(i, userList.get(i));
            System.out.println("HashMap " + mapUserSerialNumber.get(i));
        }

        class OverridingApplyReturnString implements Function<ExampleUser, String> {
            public String apply(ExampleUser user) {
                return "OverridingApplyReturnString " + user.name;
            }
        }

        john.giveMeBackMyName(new OverridingApplyReturnString());
        System.out.println("-".repeat(20));

        class ChangeIdTo20 implements Consumer<ExampleUser> {
            @Override
            public void accept(ExampleUser user) {
                user.id = 20;
            }
        }
        userList.forEach(new ChangeIdTo20());
        userList.forEach(System.out::println);


        userList.forEach(new Consumer<ExampleUser>() {
            @Override
            public void accept(ExampleUser user) {
                user.id = 30;
            }
        });
        userList.forEach(System.out::println);

        userList.forEach(user -> user.id = 40);
        userList.forEach(System.out::println);


    }
}

class ExampleUser {
    String name;
    int id;
    static int count;

    public ExampleUser(String name) {
        this.name = name;
        count++;
        id = count;
    }

    public String toString() {
        return name + " id is " + id;
    }

    public void giveMeBackMyName(Function<ExampleUser, String> applyFunction) {
        System.out.println(applyFunction);
    }


}
