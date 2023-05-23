package com.example.czolo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private TextView wordTextView, timerTextView;
    private Button startButton, shuffleButton;
    private List<List<String>> categoriesList;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 60000; // 60 seconds
    private boolean timerRunning;

    private boolean run = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categorySpinner = findViewById(R.id.category_spinner);
        wordTextView = findViewById(R.id.word_text_view);
        timerTextView = findViewById(R.id.timer_text_view);
        startButton = findViewById(R.id.start_button);
        shuffleButton = findViewById(R.id.shuffle_button);

        List<String> animalsList = new ArrayList<>();


        try {
            InputStream inputStream = getAssets().open("animals.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                animalsList.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        List<String> fruitsList = new ArrayList<>();
        fruitsList.add("Mango");

        try {
            InputStream inputStream = getAssets().open("fruits.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                fruitsList.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        List<String> countriesList = new ArrayList<>();
        countriesList.add("Polska");

        try {
            InputStream inputStream = getAssets().open("countries.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                countriesList.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        List<String> sportsList = new ArrayList<>();
        sportsList.add("Koszykówka");

        try {
            InputStream inputStream = getAssets().open("sports.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                sportsList.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        List<String> gameList = new ArrayList<>();
        gameList.add("Wiedźmin");

        try {
            InputStream inputStream = getAssets().open("games.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                gameList.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        categoriesList = new ArrayList<>();
        categoriesList.add(animalsList);
        categoriesList.add(fruitsList);
        categoriesList.add(countriesList);
        categoriesList.add(sportsList);
        categoriesList.add(gameList);

        List<String> categoryLabels = new ArrayList<>();
        categoryLabels.add("Zwierzeta");
        categoryLabels.add("Owoce");
        categoryLabels.add("Kraje");
        categoryLabels.add("Sport");
        categoryLabels.add("Gry Komputerowe");

        CategorySpinnerAdapter spinnerAdapter = new CategorySpinnerAdapter(this, categoriesList, categoryLabels);
        categorySpinner.setAdapter(spinnerAdapter);

        wordTextView.setVisibility(View.INVISIBLE);

        Button howToPlay = findViewById(R.id.howToPlay);
        howToPlay.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));

        startButton.setOnClickListener(view -> new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Show countdown in the wordTextView
                wordTextView.setText(String.valueOf(millisUntilFinished / 1000));
                startButton.setVisibility(View.GONE);
                wordTextView.setVisibility(View.VISIBLE);
                shuffleButton.setEnabled(false);
                categorySpinner.setEnabled(false);
            }

            @Override
            public void onFinish() {
                // Update word and start timer
                if (!timerRunning) {
                    shuffleWord();
                    startTimer();
                }
                wordTextView.setVisibility(View.VISIBLE);
                shuffleButton.setEnabled(true);
                categorySpinner.setEnabled(true);
            }
        }.start());

        // Set up shuffle button click listener
        shuffleButton.setOnClickListener(view -> new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Show countdown in the wordTextView
                wordTextView.setText(String.valueOf(millisUntilFinished / 1000));
                startButton.setVisibility(View.GONE);
                wordTextView.setVisibility(View.VISIBLE);
                shuffleButton.setEnabled(false);
                categorySpinner.setEnabled(false);
                run = false;
            }

            @Override
            public void onFinish() {
                run = true;
                shuffleWord();
                startTimer();
                shuffleButton.setEnabled(true);
                categorySpinner.setEnabled(true);
            }
        }.start());

        // Set up category spinner item selected listener
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                shuffleWord();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                if (run) {
                    timeLeftInMillis = millisUntilFinished;
                    updateTimerText();
                }
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                timerRunning = false;
                timeLeftInMillis = 0;
                updateTimerText();
                timerTextView.setText("  Koniec!  ");
                shuffleButton.setVisibility(View.VISIBLE);
                vibrator.vibrate(VibrationEffect.createOneShot(1500, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        }.start();

        timerRunning = true;
        shuffleButton.setVisibility(View.VISIBLE);
    }

    private void updateTimerText() {
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        if (seconds == 1 || seconds == 2 || seconds == 3 || seconds == 4 || seconds == 5){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
        }
        @SuppressLint("DefaultLocale") String timeLeftFormatted = String.format("%02d", seconds);
        timerTextView.setText(timeLeftFormatted);
    }

    private void shuffleWord() {
        // Get selected category
        int categoryIndex = categorySpinner.getSelectedItemPosition();
        List<String> categoryList = categoriesList.get(categoryIndex);

        // Generate random index
        int randomIndex = new Random().nextInt(categoryList.size());

        // Get word from list
        String word = categoryList.get(randomIndex);

        // Set word in text view
        wordTextView.setText(word);

        // Reset timer
        if (timerRunning) {
            countDownTimer.cancel();
            timerRunning = false;
        }
        timeLeftInMillis = 60000;
        updateTimerText();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("category", categorySpinner.getSelectedItemPosition());
        outState.putString("word", wordTextView.getText().toString());
        outState.putLong("timeLeftInMillis", timeLeftInMillis);
        outState.putBoolean("timerRunning", timerRunning);
        if (timerRunning) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int category = savedInstanceState.getInt("category");
        categorySpinner.setSelection(category);
        String word = savedInstanceState.getString("word");
        wordTextView.setText(word);
        timeLeftInMillis = savedInstanceState.getLong("timeLeftInMillis");
        timerRunning = savedInstanceState.getBoolean("timerRunning");
        if (timerRunning) {
            startTimer();
        } else {
            updateTimerText();
        }
    }
}