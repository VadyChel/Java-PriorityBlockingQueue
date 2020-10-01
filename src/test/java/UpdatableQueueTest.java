import org.junit.Assert;
import org.junit.Test;
import updateblequeue.QueueItem;
import updateblequeue.UpdatableQueue;

import java.util.ArrayList;

public class UpdatableQueueTest {
    @Test
    public void addAndTakeElementsOnFiveThreadsWithCycles() {
        final UpdatableQueue queue = new UpdatableQueue();
        final ArrayList<QueueItem> OutputItems = new ArrayList<QueueItem>();

        new Thread(){
            @Override
            public void run() {
                int count = 1;
                while (count < 10){
                    queue.add(count, "Content 1");
                    count++;
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                int count = 1;
                while (count < 20){
                    queue.add(count, "Content 2");
                    count++;
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                int count = 1;
                while (count < 30){
                    queue.add(count, "Content 3");
                    count++;
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                int count = 1;
                while (count < 40){
                    queue.add(count, "Content 4");
                    count++;
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                int count = 1;
                while (count < 40){
                    QueueItem item = queue.pop();
                    OutputItems.add(item);
                    count++;
                }
                Assert.assertEquals(40, OutputItems.size());
                Assert.assertEquals(4, OutputItems.get(OutputItems.size()).getUpdates().size());
                Assert.assertEquals(1, OutputItems.get(0).getUpdates().size());
            }
        }.start();

    }

    @Test
    public void addAndTakeElementsOnFourThreads() {
        final UpdatableQueue queue = new UpdatableQueue();
        final ArrayList<QueueItem> OutputItems = new ArrayList<QueueItem>();

        new Thread(){
            @Override
            public void run() {
                queue.add(1, "Content 1");
                queue.add(2, "Content 1");
                queue.add(3, "Content 1");
                queue.add(4, "Content 1");
                queue.add(5, "Content 1");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                queue.add(1, "Content 2");
                queue.add(2, "Content 2");
                queue.add(3, "Content 2");
                queue.add(4, "Content 2");
                queue.add(5, "Content 2");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                queue.add(1, "Content 3");
                queue.add(2, "Content 3");
                queue.add(3, "Content 3");
                queue.add(4, "Content 3");
                queue.add(5, "Content 3");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                int count = 1;
                while (count < 40){
                    QueueItem item = queue.pop();
                    OutputItems.add(item);
                    count++;
                }

                for (QueueItem item: OutputItems){
                    Assert.assertEquals(3, item.getUpdates().size());
                }
                Assert.assertEquals(5, OutputItems.size());
            }
        }.start();

    }

    @Test
    public void addAndTakeElements() {
        final UpdatableQueue queue = new UpdatableQueue();
        final ArrayList<QueueItem> OutputItems = new ArrayList<QueueItem>();

        queue.add(1, "Content 1");
        queue.add(2, "Content 1");
        queue.add(3, "Content 1");
        queue.add(4, "Content 1");
        queue.add(5, "Content 1");

        queue.add(1, "Content 2");
        queue.add(2, "Content 2");
        queue.add(3, "Content 2");
        queue.add(4, "Content 2");
        queue.add(5, "Content 2");

        queue.add(1, "Content 3");
        queue.add(2, "Content 3");
        queue.add(3, "Content 3");
        queue.add(4, "Content 3");
        queue.add(5, "Content 3");

        queue.add(1, "Content 4");
        queue.add(2, "Content 4");
        queue.add(3, "Content 4");
        queue.add(4, "Content 4");
        queue.add(5, "Content 4");

        int count = 1;
        while (count < 6){
            QueueItem item = queue.pop();
            OutputItems.add(item);
            count++;
        }

        for (QueueItem item: OutputItems){
            Assert.assertEquals(4, item.getUpdates().size());
        }
        Assert.assertEquals(5, OutputItems.size());
    }

}
