public class ActivityThread {
    final H mH =  new H();
    public void attach(boolean b) {
        MainActivity mainActivity = new MainActivity();
        mainActivity.onCreate();
//        通过handler 去执行生命周期
        Message message = new Message();
        message.obj = mainActivity;
        mH.sendMessage(message);
    }
    private class H extends Handler{
        public void handlerMessage(Message msg){
            MainActivity mainActivity  = (MainActivity) msg.obj;
            mainActivity.onResume();
        }

    }
}
