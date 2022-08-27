public class K {
    //状态锁
    private Object lock;
    //条件变量
    private int now,need;
    public void produce(int num){
        //同步
        synchronized (lock){
           //当前有的不满足需要，进行等待，直到满足条件
            while(now < need){
                try {
                    //等待阻塞
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我被唤醒了！");
            }
           // 做其他的事情
        }
    }
}