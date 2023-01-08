public class HandlerTest {
    public static void main(String[] args) {
        System.out.println("asdf");
        Looper.prepare();
        ActivityThread thread = new ActivityThread();
        thread.attach(false);
        Looper.loop();
    }
}
