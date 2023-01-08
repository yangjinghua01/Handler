fun main() {
    Looper.prepare()
    var thread = ActivityThread();
    thread.attach(false)
    Looper.loop()
}