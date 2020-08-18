package com.jgerega107.covidapp;

public class Message {
    private String authorName;
    private String message;
    private long timestamp;
    private String pfpUrl;

    public Message(String message, String authorName) {
        this.message = message;
        timestamp = System.currentTimeMillis();
        this.authorName = authorName;
        this.pfpUrl = "";
    }

    public Message(){
        message = "";
        timestamp = System.currentTimeMillis();
        pfpUrl = "";
        authorName = "";
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp(){
        return timestamp;
    }

    public String getAuthorName(){
        return authorName;
    }

    public String getPfpUrl(){
        return pfpUrl;
    }

    public void setPfpUrl(String pfpUrl){
        this.pfpUrl = pfpUrl;
    }
}