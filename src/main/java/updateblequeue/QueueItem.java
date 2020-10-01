package updateblequeue;

import java.util.HashMap;

public class QueueItem implements Comparable<QueueItem>{
    private int id;
    private int version;
    private String content;
    private HashMap updates;

    public QueueItem(int id, int version, String content, HashMap updates) {
        this.setId(id);
        this.setVersion(version);
        this.setContent(content);
        this.setUpdates(updates);
    }

    @Override
    public int compareTo(QueueItem o) {
        return 0;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public HashMap getUpdates() {
        return updates;
    }

    public void setUpdates(HashMap updates) {
        this.updates = updates;
    }
}
