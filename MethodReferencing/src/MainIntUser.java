public class MainIntUser {
    public static void main(String[] args) {
        User john = new User();
        IntUser intUserFI;

        intUserFI = User::intEmpty;
        intUserFI = u -> u.intEmpty();
        new IntUser(){
            public int intUser(User u){
                return u.intEmpty();
            }
        };

//        Incompatible types: User is not convertible to String
//        intUserFI = john::intString;

//        Cannot resolve method 'methodName'
//        intUserFI = john::voidEmpty;
//        intUserFI = john::intEmpty;
//        intUserFI = john::intBooleanString;

//        Non-static method cannot be referenced from a static content
//        intUserFI = User::voidString;
//        intUserFI = User::intString;
//        intUserFI = User::intBooleanString;

//        Bad return type in method referencing: cannot convert void to int.
//        intUserFI = User::voidEmpty;

    }
}
