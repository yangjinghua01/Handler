public class Handler {
    MessageQueue mQueue;

    public Handler() {
        Looper looper = Looper.myLooper();
        if (looper == null){
            throw  new RuntimeException("");
        }
        mQueue = looper.mQueue;
    }

    public void sendMessage(Message message){
        sendMessageDelayed(message,0);
    }
    public void handlerMessage(Message msg){

    }
    public final boolean sendMessageDelayed(Message msg,long delayMillis){
        if (delayMillis<0){
            delayMillis=0;
        }
        return sendMessageAtTime(msg,System.currentTimeMillis()+delayMillis);
    }

    private boolean sendMessageAtTime(Message msg, long uptomeMillis) {
        MessageQueue queue = mQueue;
        if (queue==null){
            RuntimeException e = new RuntimeException(this+"sendMessageAtTime() called with no mQueue");
            return false;
        }
        return enqueueMessage(queue,msg,uptomeMillis);
    }
    private boolean enqueueMessage(MessageQueue queue,Message msg, long uptimeMillis){
        msg.target = this;
        return queue.enqeueMessage(msg,uptimeMillis);
    }
}
