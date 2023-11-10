package com.kanikakohli.horoscopeexamp;

import com.google.gson.annotations.SerializedName;

public class Modal {

    @SerializedName("event")
    private String event;
    @SerializedName("predict")
    private String predict;
    @SerializedName("color")
    private String color;

    public String getPredict() {
        return predict;
    }

    public void setPredict(String predict) {
        this.predict = predict;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }



}
