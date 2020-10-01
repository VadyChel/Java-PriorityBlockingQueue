package updateblequeue;

import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class UpdatableQueue{
    private PriorityBlockingQueue<QueueItem> queue = new PriorityBlockingQueue<QueueItem>();

    public synchronized QueueItem add(int id, String content){
        boolean state = false;

        for (QueueItem item: queue){
            if (item.getId() == id){
                state = true;
                item.setVersion(item.getVersion()+1);
                item.setContent(content);
                item.getUpdates().put(item.getVersion(), content);
            }
        }

        if (!state){
            HashMap<Integer, Object> hashContent = new HashMap<Integer, Object>();
            QueueItem QueueItem = new QueueItem(id, 1, content, hashContent);
            hashContent.put(1, content);
            queue.add(QueueItem);
            return QueueItem;
        }
        return null;
    }

    public synchronized QueueItem pop(){
        QueueItem item = null;
        try {
            item = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert item != null;
        System.out.println(item.getVersion() +" - version");
        System.out.println(item.getId() +" - id");
        System.out.println(item.getContent() +" - content");
        System.out.println(item.getUpdates() + " - updates");

        return item;
    }
}
