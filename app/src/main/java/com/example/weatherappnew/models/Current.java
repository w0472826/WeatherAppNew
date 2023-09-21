package com.example.weatherappnew.models;

import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("temp_c")
    private float temperature;

    private Condition condition;

    @SerializedName("feelslike_c")
    private float feel;

    @SerializedName("wind_kph")
    private float wind;

    private String humidity;

    public Current(float temperature, String humidity, Condition condition, float feel, float wind){
        this.temperature = temperature;
        this.condition = condition;
        this.feel = feel;
        this.wind = wind;
        this.humidity = humidity;
    }

    public float getTemperature(){ return temperature; }

    public Condition getCondition(){ return condition;}

    public float getFeel(){ return feel;}

    public float getWind(){ return wind;}

    public String getHumidity(){return humidity;}

}
