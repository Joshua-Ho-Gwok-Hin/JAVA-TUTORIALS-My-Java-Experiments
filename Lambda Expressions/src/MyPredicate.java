import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface MyPredicate {
    boolean myOwnTest(PlatformUser anonymousClassThatImplementsMyPredicate);
}

class UserIsAdmin implements MyPredicate {
    public boolean myOwnTest(PlatformUser anonymousClassThatImplementsMyPredicate) {
        return anonymousClassThatImplementsMyPredicate.isAdmin();
    }
}

class UserHasPhoneNumber implements MyPredicate {
    @Override
    public boolean myOwnTest(PlatformUser anonymousClassThatImplementsMyPredicate) {
        return anonymousClassThatImplementsMyPredicate.havePhone();
    }
}

class PlatformUser {
    public PlatformUser(String name, boolean isAdmin, boolean havePhone) {
        this.name = name;
        this.isAdmin = isAdmin;
        this.havePhone = havePhone;
    }

    String name;
    boolean isAdmin;
    boolean havePhone;
    boolean isAdmin() {
        return this.isAdmin;
    }

    public boolean havePhone() {
        return havePhone;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}

class PlatformUserService {
    List<PlatformUser> platformServiceUsers = new ArrayList<>();

    List<PlatformUser> addUser(PlatformUser platformUser) {
        platformServiceUsers.add(platformUser);
        return platformServiceUsers;
    }

    void printNumberOfUsers(List<PlatformUser> roster, int number) {// Method that match 1 characteristic
        if (number < roster.size()) {
            for (int i = 0; i < number; i++) {
                System.out.println(roster.get(i));
            }
        } else {
            for (var user : roster) {
                System.out.println(user);
            }
        }
    }

    void methodThatBehaveDifferently(List<PlatformUser> roster, MyPredicate booleanTestObject) {
        for (var u : roster) {
            if (booleanTestObject.myOwnTest(u))
            System.out.println(u.toString());
        }
    }

    void standardFunctionalInterface(List<PlatformUser> roster, Predicate<PlatformUser> booleanTestObject) {
        for (var r : roster) {
            if (booleanTestObject.test(r)) {
                System.out.println(r.toString());
            }
        }
    }

    void printPredicate(List<PlatformUser> roster, Predicate<PlatformUser> implementedPredicate) {
        for (var user : roster) {
            if (implementedPredicate.test(user)) {
                System.out.println(user);
            }
        }
    }
}

class MyProgram {
    public static void main(String[] args) {
        PlatformUserService userService = new PlatformUserService();
        PlatformUser john = new PlatformUser("John", true, false);
        PlatformUser david = new PlatformUser("David", false, true);
        PlatformUser mark = new PlatformUser("Mark", false, false);
        userService.addUser(john);
        userService.addUser(david);
        userService.addUser(mark);
        List<PlatformUser> thisListRoster = userService.platformServiceUsers;
        userService.methodThatBehaveDifferently(thisListRoster, new UserIsAdmin());
        userService.methodThatBehaveDifferently(thisListRoster, new UserHasPhoneNumber());
        userService.printNumberOfUsers(thisListRoster, 2);
        userService.methodThatBehaveDifferently(thisListRoster, new MyPredicate() { // specify search criteria in an anonymous class, no need to create UserIsAdmin and UserHasPhone classes
            @Override
            public boolean myOwnTest(PlatformUser anonymousClassThatImplementsMyPredicate) {
                PlatformUser testSubject = anonymousClassThatImplementsMyPredicate;
                return (!testSubject.isAdmin() && !testSubject.havePhone());
            }
        });
        userService.methodThatBehaveDifferently(thisListRoster, user -> !user.isAdmin() && !user.havePhone);
        userService.standardFunctionalInterface(thisListRoster, new Predicate<PlatformUser>() {
            @Override
            public boolean test(PlatformUser platformUser) {
                return !platformUser.isAdmin() && !platformUser.havePhone();
            }
        });
        userService.standardFunctionalInterface(thisListRoster, platformUser -> !platformUser.havePhone() && !platformUser.isAdmin());

    }
}


