public class User {
    void voidEmpty() {}
    void voidString(String s) {}
    int intEmpty(){ return 1;}
    int intString(String s) { return 2;}
    int intBooleanString(boolean b, String s) { return 3;}

    User userUser(User user) {
        return user;
    }

    static void staticVoidEmpty() {}
    static void staticVoidString(String s) {}
    static int staticIntEmpty(){ return 1;}
    static int staticIntString(String s) { return 2;}
    static int staticIntBooleanString(boolean b, String s) { return 3;}
}
