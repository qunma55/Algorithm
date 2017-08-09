package org.hewei.concurrency.daemon;

import java.util.Date;

class Event {
    private String event;
    private Date date;

    public Event() {}

    public void setDate(Date d) {
        date = d;
    }

    public void setEvent(String e) {
        event = e;
    }

    public Date getDate() {
        return this.date;
    }

    public String getEvent() {
        return this.event;
    }
}
