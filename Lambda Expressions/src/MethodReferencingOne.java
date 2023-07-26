public class MethodReferencingOne {
    public static void main(String[] args) {
        NoParamVoid nn = Classy::staticVoid;
        NoParamVoid nnn = ()-> Classy.staticVoid();
        NoParamVoid nnnn = () -> {};
//        StringParamVoid sV = () -> {};

//        StringParamVoid sv = Classy::staticStringIntParam;
        NoParamString nS = Classy::staticStringNoParam;
//        NoParamString nS = Classy::staticVoidStringParam;



    }
}
class Classy {
    void instanceVoid() {
        System.out.println("instanceVoid()");
    }
    void instanceVoidIntParam(int a) {
        System.out.println("instanceVoidIntParam(int a) - " + a);
    }
    String instanceStringNoParam() {
        return "instanceStringNoParam()";
    }
    String instanceStringIntParam(int a) {
        return "instanceStringIntParam(int a) - " + a;
    }
    static void staticVoid() {
        System.out.println("staticVoid()");
    }
    static void staticVoidIntParam(int a) {
        System.out.println("staticVoidIntParam(int a) - " + a);
    }
    static String staticStringNoParam() {
        return "staticStringNoParam()";
    }

    static void staticVoidStringParam(String s) {
        System.out.println("staticVoidStringParam(String s) - " + s);
    }
    static String staticStringIntParam(int a) {
        return "staticStringIntParam(int a) - " + a;
    }



}
