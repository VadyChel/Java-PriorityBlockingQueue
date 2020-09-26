package updateblequeue;

import java.util.HashMap;

public class QueueItem implements Comparable<QueueItem>{
    private int id;
    private int version;
    private HashMap content;

    public QueueItem(int id, int version, HashMap content) {
        this.setId(id);
        this.setVersion(version);
        this.setContent(content);
    }

    @Override
    public int compareTo(QueueItem o) {
        return 0;
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

    public HashMap getContent() {
        return content;
    }

    public void setContent(HashMap content) {
        this.content = content;
    }
}
