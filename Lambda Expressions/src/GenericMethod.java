import java.util.*;
import java.util.function.*;

public class GenericMethod {

    public static <X, Y> void processElements(
            Iterable<X> iterableInterface,
            Predicate<X> predicateFItest,
            Function<X, Y> functionFIapply,
            Consumer<Y> consumerFIaccept
    ) {
        for (X eachObject : iterableInterface) {
            if (predicateFItest.test(eachObject)) {
                Y returnData = functionFIapply.apply(eachObject);
                consumerFIaccept.accept(returnData);
            }
        }
    }

    public static <A, B> void myGenericMethod(
            Iterable<A> source,
            Predicate<A> tester,
            Function<A, B> applyGetSomething,
            Consumer<B> acceptDoSomething
    ) {
        System.out.println("myGenericMethod()");
        for (A each : source) {
            if (tester.test(each)) {
                B data = applyGetSomething.apply(each);
                acceptDoSomething.accept(data);
            }
        }
    }

    public static void main(String[] args) {

        List<NewUser> newUsers = new ArrayList<>();
        newUsers.add(new NewUser("John"));
        newUsers.add(new NewUser("One"));
        newUsers.add(new NewUser("Two"));
        newUsers.add(new NewUser("Three"));
        newUsers.add(new NewUser("Four"));
        newUsers.add(new NewUser("Six"));
        newUsers.add(new NewUser("Johnny"));
        newUsers.add(new NewUser("Peter Parker"));

        processElements(
                newUsers,
                newUser -> newUser.name.length() > 4,
                returnData -> returnData.name,
                name -> System.out.print(name + " - ")
        );

        System.out.println("\nStream 1 newUser.size() = " + newUsers.size());
        newUsers.stream()
                .filter(newUser -> newUser.name.length() > 4)
                .map(newUser -> newUser.name)
                .forEach(data -> System.out.print(data + " - "));

        myGenericMethod(
                newUsers,
                newUser -> newUser.name.contains("o") || newUser.name.contains("a"),
                newUser -> newUser.name,
                data -> System.out.print(data + " - "));

        System.out.println("\nStream 2 newUser.size() = " + newUsers.size());
        newUsers.stream()
                .filter(newUser -> newUser.name.contains("a") || newUser.name.contains("o"))
                .map(newUser -> newUser.name)
                .forEach(NewUserName -> System.out.print(NewUserName + " - "));
    }


}

class NewUser {
    String name;

    public NewUser(String name) {
        NewUser.this.name = name;
    }

    @Override
    public String toString() {
        return "My name is " + name;
    }
}
