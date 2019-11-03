import java.util.ArrayList;

public class TType {
    public static void main(String[] args) {
        Test<Father> a = new Test<>();
        Test<Son> b = new Test<>();
        Father t1 = new Father();
        Son t2 = new Son();
        a.add(t2);
    }
}
class Father{

}
class Son extends Father{

}
class Test<T>{
    T a;
    public void add(T a){
        this.a = a;
    }
}
