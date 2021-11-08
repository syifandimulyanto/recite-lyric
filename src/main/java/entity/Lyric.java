package entity;

import java.util.List;

public class Lyric {
    public List<String> subject;
    public String body;

    public Lyric(List<String> subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
