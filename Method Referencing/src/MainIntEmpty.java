public class MainIntEmpty {
    public static void main(String[] args) {
        User john = new User();
        IntEmpty intEmptyFI;

        intEmptyFI = john::intEmpty;
        intEmptyFI = ()-> john.intEmpty();
        new IntEmpty() {
            public int intEmpty() {
                return john.intEmpty();
            }
        };

/*
        Following method-referencing have compilation error.

        intEmptyFI = String::charAt;
        non-static method cannot be referenced from static content

        intEmptyFI = john::voidEmpty;
        bad return type, cannot convert void to int

        Following method compilation error: Cannot resolve method
        intEmptyFI = john::voidString;
        intEmptyFI = john::intString;
        intEmptyFI = john::intBooleanString;
*/

    }
}
