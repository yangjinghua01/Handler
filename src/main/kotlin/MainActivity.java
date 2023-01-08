public class MainActivity extends Activity{
    private TextView textView;
    private Handler mHandler = new Handler(){
        @Override
        public void handlerMessage(Message msg) {
            super.handlerMessage(msg);
            textView.setText((String) msg.obj);
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate 执行了");
        textView = findViewById(R.id.text_view);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.obj = "后台数据";
                mHandler.sendMessage(message);
            }
        }).start();
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume 方法执行了");
    }
}
