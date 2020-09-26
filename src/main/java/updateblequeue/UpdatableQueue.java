package updateblequeue;

import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class UpdatableQueue{
    private PriorityBlockingQueue<QueueItem> queue = new PriorityBlockingQueue();
    private int limitUpdates;

    public UpdatableQueue(int limitUpdates) {
        this.setLimitUpdates(limitUpdates);
    }

    public void setLimitUpdates(int limitUpdates){
        this.limitUpdates = limitUpdates;
    }

    public int getLimitUpdates() {
        return limitUpdates;
    }

    public QueueItem addQueueItem(int id, Object content){
        boolean state = false;

        for (QueueItem item: queue){
            if (item.getId() == id){
                state = true;
                item.setVersion(item.getVersion()+1);
                item.getContent().put(item.getVersion(), content);
                if (item.getContent().size() > this.limitUpdates){
                    System.out.println("Item "+item.getId()+" has reached limit updates: "+this.limitUpdates);
                    QueueItem obj = takeQueueItem(item.getId());
                    return obj;
                }
            }
        }

        if (!state){
            HashMap<Integer, Object> hashContent = new HashMap();
            QueueItem QueueItem = new QueueItem(id, 1, hashContent);
            hashContent.put(1, content);
            queue.add(QueueItem);
            return QueueItem;
        }
        return null;
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
