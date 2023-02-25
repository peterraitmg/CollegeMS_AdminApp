package com.project.admincollegeapp.Model;

import android.widget.EditText;

public class NotificationData {
    private String title;
    private String message;

    public NotificationData(String title) {
        this.title = title;
    }

    public NotificationData(EditText noticeTitle) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationData(String title, String message) {
        this.title = title;
        this.message = message;
    }
}
