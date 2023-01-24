package com.example.springhibernatedemo.utils;

public class HeartbeatMessage {
    private String messageId;
    private String message;
    private String messageDate;

    public HeartbeatMessage() {
        this.messageId = "no id";
        this.message = "no message";
        this.messageDate = "no date";
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
}
