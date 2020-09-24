package Queue;

import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class UpdatableQueue{
    public PriorityBlockingQueue<QueueItem> queue = new PriorityBlockingQueue();

    public void addQueueItem(int id, String content){
        boolean state = false;

        for (QueueItem item: queue){
            if (item.getId() == id){
                state = true;
                item.setVersion(item.getVersion()+1);
                item.content.put(item.getVersion(), content);
            }
        }

        if (!state){
            HashMap<Integer, String> hashContent = new HashMap();
            QueueItem QueueItem = new QueueItem(id, 1, hashContent);
            hashContent.put(1, content);
            queue.add(QueueItem);
        }
    }

    public QueueItem takeQueueItem(int id){
        boolean state = false;

        for (QueueItem item: queue){
            if (item.getId() == id){
                state = true;
                System.out.println(item.getVersion() +" - version");
                System.out.println(item.getId() +" - id");
                System.out.println(item.getContent() +" - content");
                queue.remove(item);

                return item;
            }
        }

        System.out.println("The queue has not this element: "+id);
        return null;
    }
}
