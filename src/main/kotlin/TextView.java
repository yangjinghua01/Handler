public class TextView {
    private Thread mCurrentThread;

    public TextView() {
        mCurrentThread = Thread.currentThread();
    }

    public void setText(CharSequence text) {
        checkThread();
        System.out.println("更新UI成功"+text);
    }

    public void checkThread() {
        if (mCurrentThread != Thread.currentThread()) {
            throw new RuntimeException("只能在主线程中更新UI");
        }
    }
}
