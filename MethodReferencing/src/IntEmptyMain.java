public class IntEmptyMain {
    public static void main(String[] args) {
        User john = new User();
        IntEmpty intEmptyFI;

        intEmptyFI = String::charAt;
        intEmptyFI = john::voidEmpty;
        intEmptyFI = john::voidString;
        intEmptyFI = john::intString;
        intEmptyFI = john::intBooleanString;

        intEmptyFI = john::intEmpty;
        intEmptyFI = ()-> john.intEmpty();
        new IntEmpty() {
            public int intEmpty() {
                return john.intEmpty();
            }
        };

    }
}
