public class MainIntUser {
    public static void main(String[] args) {
        User john = new User();
        IntUser intUserFI;
        UserUser userUser;

        userUser = john::userUser;
        userUser = u -> john.userUser(u);

        intUserFI = User::intEmpty;
        intUserFI = u -> u.intEmpty();
        new IntUser(){
            public int intUser(User u){
                return u.intEmpty();
            }
        };
/*
        intUserFI = User::staticVoidEmpty;
        intUserFI = john::staticVoidEmpty;
        intUserFI = String::indexOf;

//        Incompatible types: User is not convertible to String
//        intUserFI = john::intString;

//        Cannot resolve method 'methodName'
        intUserFI = john::voidEmpty;
        intUserFI = john::intEmpty;
//        intUserFI = john::intBooleanString;

        intUserFI = User::voidEmpty;
        intUserFI = User::intEmpty;

        intUserFI = john::voidString;
        intUserFI = john::intEmpty;
        intUserFI = s -> john.voidString(s);


//        Non-static method cannot be referenced from a static content
        intUserFI = User::voidString;
        userUser = User::userUser;
//        intUserFI = User::intString;
//        intUserFI = User::intBooleanString;

//        Bad return type in method referencing: cannot convert void to int.
//        intUserFI = User::voidEmpty;

 */

    }
}
