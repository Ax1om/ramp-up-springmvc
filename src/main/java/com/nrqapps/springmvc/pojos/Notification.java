package com.nrqapps.springmvc.pojos;

import org.springframework.util.StringUtils;

/**
 * Created by mauricio on 8/28/17.
 * NrqApps © 2017
 */
public class Notification {
    public static final String USER_NOTIFICATION = "userNotification";
    public static final String SUCCESS = "success";
    public static final String INFO = "info";
    public static final String WARN = "warn";
    public static final String ERROR = "error";

    private String type;
    private String message;
    private Integer time;

    public Notification(String type, String message) {
        this.type = type;
        setMessage(message);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return '{' +
                "type: '" + type + '\'' +
                ", message: '" + message + '\'' +
                ", time: " + time +
                '}';
    }

}
