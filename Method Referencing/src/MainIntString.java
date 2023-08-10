public class MainIntString {
    public static void main(String[] args) {
        User john = new User();
        IntString intStringFI;

        intStringFI = john::intString;
        intStringFI = s -> john.intString(s);
        new IntString(){
            public int intString(String s){
                return john.intString(s);
            }
        };

        intStringFI = String::length;


/*        Following method-referencing have compilation error: Bad return type, cannot convert void to int
        intStringFI = john::voidString;
        intStringFI = System.out::println;
        Following method compilation error: Cannot resolve method
        intStringFI = john::voidEmpty;
        intStringFI = john::intEmpty;
        intStringFI = john::intBooleanString;
*/

    }
}
