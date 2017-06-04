package com.example.demo.model;

public class SimpleStompMessage {
    private String content;

    public SimpleStompMessage() {
    }

    public SimpleStompMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
