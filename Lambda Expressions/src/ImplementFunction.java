import java.util.function.Function;

public class ImplementFunction {
    public static void main(String[] args) {

        Admin john = new Admin(3, "John Williams");
//        public String giveMeName(Function<Admin, String> myName) {
//            return myName.apply(this);
//        }

//        Option 1: Create Concrete class that implements Function<T,R>
        class GiveMeMyName implements Function<Admin, String> {
            @Override
            public String apply(Admin admin) {
                return admin.name + "Concrete Class that implements Function<T,R>";
            }
        }
        String concreteClass = john.giveMeName(new GiveMeMyName());
        System.out.println(concreteClass);

//        Option 2: Anonymous Class that implements Function<T,R>
        String anonymous = john.giveMeName(new Function<Admin, String>() {
            @Override
            public String apply(Admin admin) {
                return admin.name + " anonymous class extending Function<T,R>";
            }
        });
        System.out.println(anonymous);

//        Option 3: Lambda Expression to override .apply();
        String anotherTime = john.giveMeName((e) -> e.name + " Lambda");
        System.out.println(anotherTime);

        String one = john.myOwnFunctionMethod(new GetNameUsingMyFunction());
        System.out.println(one);

        String two = john.myOwnFunctionMethod(new MyFunction<Admin, String>() {
            public String apply(Admin admin){
                return admin.name + " from anonymous class";
            }
        });
        System.out.println(two);

        String three = john.myOwnFunctionMethod((admin -> admin.name + " lambda expression"));
        System.out.println(three);
    }
}

interface MyFunction<Admin, String> {
    String apply(Admin admin);
}

class GetNameUsingMyFunction implements MyFunction<Admin,String> {
    public String apply(Admin admin) {
        return admin.name + " from GetNameUsingMyFunction class";
    }
}


class Admin {
    String name;
    Integer id;

    Admin(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "My name is " + name + " and my serial no. is " + id;
    }

    public String giveMeName(Function<Admin, String> myName) {
        return myName.apply(this);
    }

    public String myOwnFunctionMethod(MyFunction<Admin, String> myFunction) {
        return myFunction.apply(this);
    }

}
