package updateblequeue;

import java.util.Queue;

public interface UpdatebleQueue extends Queue<QueueItem> {
    QueueItem pop();
    QueueItem add(int id, String content);
}
