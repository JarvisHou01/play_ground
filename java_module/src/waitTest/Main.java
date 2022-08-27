package waitTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Message some = new Message("some");




        new Thread(new Waiter(some),"waiter thread").start();
        new Thread(new Notifier(some),"notifier thread").start();
    }
}
