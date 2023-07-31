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

        /*

        intUserFI = john::intString;
        intUserFI = john::voidEmpty;
        intUserFI = john::intEmpty;
        intUserFI = john::intString;
        intUserFI = john::intBooleanString;

        intUserFI = User::voidEmpty;
        intUserFI = User::voidString;
        intUserFI = User::intString;
        intUserFI = User::intBooleanString;
        */

    }
}
