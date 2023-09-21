package com.example.weatherappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherappnew.databinding.ActivityMainBinding;
import com.example.weatherappnew.models.Weather;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_main);

        String json = getJsonFromFile();
        //Log.i("TESTING", json);

        // Use GSON to parse the json string
        Gson gson = new Gson();
        Weather weather = gson.fromJson(json, Weather.class);

        // Display the temperature
        TextView textViewTemperature = findViewById(R.id.textViewTemperature);
        String temperature = String.valueOf(weather.getCurrent().getTemperature()) + "°C";
        textViewTemperature.setText(temperature);

        // Display the feel like
        TextView textViewFeel = findViewById(R.id.textViewFeel);
        String feel = "Feels like: " + String.valueOf(weather.getCurrent().getFeel()) + "°C";
        textViewFeel.setText(feel);

        // Display the wind kph
        TextView textViewWind = findViewById(R.id.textViewWind);
        String wind = "Wind: NW " + String.valueOf(weather.getCurrent().getWind()) + " kph";
        textViewWind.setText(wind);

        //Display the condition description
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        textViewDescription.setText(weather.getCurrent().getCondition().getText());

        //Display the weather icon
        ImageView imageView = findViewById(R.id.imageViewIcon);
        String imageUrl = "https:" + weather.getCurrent().getCondition().getIcon();
        imageUrl = imageUrl.replace("64x64","128x128");
        Glide.with(view).load(imageUrl).into(imageView);

    }

    // Get JSON string from .json file
    private String getJsonFromFile() {
        String json = "";

        InputStream inputStream = this.getResources().openRawResource(R.raw.weather_api);

        // Create InputStreamReader object
        InputStreamReader isReader = new InputStreamReader(inputStream);

        // Create a BufferedReader object
        BufferedReader reader = new BufferedReader(isReader);

        // Read the buffer and save to string
        json = reader.lines().collect(Collectors.joining(System.lineSeparator()));

        return json;
    }
}