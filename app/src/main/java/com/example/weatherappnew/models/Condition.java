package com.example.weatherappnew.models;

public class Condition {
    private String text;
    private String icon;

    public Condition(String text, String icon){
        this.text = text;
        this.icon = icon;
    }

    public String getText() {return text;}

    public String getIcon() {return icon;}

}
