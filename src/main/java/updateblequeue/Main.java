package updateblequeue;

public class Main {

    public static void main(String[] args) {
        final UpdatableQueue queue = new UpdatableQueue();

        new Thread(){
            @Override
            public void run() {
                queue.add(10, "Content first of 10 id item");
                queue.add(1, "Content first of 1 id item");
                queue.add(10, "Content second of 10 id item");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                queue.add(130, "1000");
                queue.add(1056, "Content first of 1056 id item");
                queue.add(10, "Content third of 10 id item");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                queue.pop();
                queue.pop();
                queue.pop();
            }
        }.start();

    }
}
