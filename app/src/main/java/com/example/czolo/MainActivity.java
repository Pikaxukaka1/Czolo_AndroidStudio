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
        animalsList.add("Lew");
        animalsList.add("Tygrys");
        animalsList.add("Słoń");
        animalsList.add("Żyrafa");
        animalsList.add("Zebra");
        animalsList.add("Kapibara");
        animalsList.add("Pies");
        animalsList.add("Kot");
        animalsList.add("Kangur");
        animalsList.add("Królik");
        animalsList.add("Żuraw");
        animalsList.add("Żółw");
        animalsList.add("Krowa");
        animalsList.add("Koń");
        animalsList.add("Wielbłąd");
        animalsList.add("Wąż");
        animalsList.add("Paw");
        animalsList.add("Małpa");
        animalsList.add("Kaczka");
        animalsList.add("Kura");
        animalsList.add("Indyk");
        animalsList.add("Wilk");
        animalsList.add("Lis");
        animalsList.add("Aligator");
        animalsList.add("Floppa");
        animalsList.add("Mrówkojad");
        animalsList.add("Dzik");
        animalsList.add("Pancernik");
        animalsList.add("Lama");
        animalsList.add("Alpaka");
        animalsList.add("Struś");
        animalsList.add("Owca");
        animalsList.add("Osioł");
        animalsList.add("Koza");
        animalsList.add("Gęś");
        animalsList.add("Foka");
        animalsList.add("Surykatka");
        animalsList.add("Lemur");
        animalsList.add("Pingwin");
        animalsList.add("Antylopa");
        animalsList.add("Puma");

        List<String> fruitsList = new ArrayList<>();
        fruitsList.add("Jabłko");
        fruitsList.add("Banan");
        fruitsList.add("Pomarańcza");
        fruitsList.add("Gruszka");
        fruitsList.add("Kiwi");
        fruitsList.add("Śliwka");
        fruitsList.add("Arbuz");
        fruitsList.add("Awokado");
        fruitsList.add("Ananas");
        fruitsList.add("Cytryna");
        fruitsList.add("Brzoskwinia");
        fruitsList.add("Mandarynka");
        fruitsList.add("Czereśnia");
        fruitsList.add("Granat");
        fruitsList.add("Kokos");
        fruitsList.add("Jagoda");
        fruitsList.add("Liczi");
        fruitsList.add("Limonka");
        fruitsList.add("Malina");
        fruitsList.add("Truskawka");
        fruitsList.add("Mango");
        fruitsList.add("Melon");
        fruitsList.add("Morela");
        fruitsList.add("Nektarynka");
        fruitsList.add("Orzech");
        fruitsList.add("Poziomka");
        fruitsList.add("Wiśnia");
        fruitsList.add("Winogrono");
        fruitsList.add("Żurawina");

        List<String> countriesList = new ArrayList<>();
        countriesList.add("Usa");
        countriesList.add("Chiny");
        countriesList.add("Indie");
        countriesList.add("Japonia");
        countriesList.add("Polska");
        countriesList.add("Afganistan");
        countriesList.add("Albania");
        countriesList.add("Algieria");
        countriesList.add("Andora");
        countriesList.add("Angola");
        countriesList.add("Argentyna");
        countriesList.add("Armenia");
        countriesList.add("Australia");
        countriesList.add("Belgia");
        countriesList.add("Białoruś");
        countriesList.add("Boliwia");
        countriesList.add("Brazylia");
        countriesList.add("Bułgaria");
        countriesList.add("Chile");
        countriesList.add("Chorwacja");
        countriesList.add("Czechy");
        countriesList.add("Dania");
        countriesList.add("Dominikana");
        countriesList.add("Egipt");
        countriesList.add("Ekwador");
        countriesList.add("Estonia");
        countriesList.add("Etiopia");
        countriesList.add("Filipiny");
        countriesList.add("Finlandia");
        countriesList.add("Francja");
        countriesList.add("Grecja");
        countriesList.add("Grenlandia");
        countriesList.add("Gruzja");
        countriesList.add("Hiszpania");
        countriesList.add("Holandia");
        countriesList.add("Indie");
        countriesList.add("Irak");
        countriesList.add("Iran");
        countriesList.add("Irlandia");
        countriesList.add("Islandia");
        countriesList.add("Izrael");
        countriesList.add("Jamajka");
        countriesList.add("Kanada");
        countriesList.add("Katar");
        countriesList.add("Kenia");
        countriesList.add("Kolumbia");
        countriesList.add("Kongo");
        countriesList.add("Korea");
        countriesList.add("Kuba");
        countriesList.add("Libia");
        countriesList.add("Litwa");
        countriesList.add("Łotwa");
        countriesList.add("Madagaskar");
        countriesList.add("Malezja");
        countriesList.add("Mali");
        countriesList.add("Malediwy");
        countriesList.add("Malta");
        countriesList.add("Maroko");
        countriesList.add("Meksyk");
        countriesList.add("Monako");
        countriesList.add("Niemcy");
        countriesList.add("Niger");
        countriesList.add("Nigeria");
        countriesList.add("Norwegia");
        countriesList.add("Pakistan");
        countriesList.add("Peru");
        countriesList.add("Portugalia");
        countriesList.add("Rumunia");
        countriesList.add("Szwajcaria");
        countriesList.add("Szwecja");
        countriesList.add("Tajlandia");
        countriesList.add("Turcja");
        countriesList.add("Ukraina");
        countriesList.add("Włochy");
        countriesList.add("Wielka Brytania");

        List<String> sportsList = new ArrayList<>();
        sportsList.add("Koszykówka");
        sportsList.add("Siadkówka");
        sportsList.add("Tenis");
        sportsList.add("Piłka ręczna");
        sportsList.add("Piłka nożna");
        sportsList.add("Boks");
        sportsList.add("Judo");
        sportsList.add("Karate");
        sportsList.add("Lekkoatletyka");
        sportsList.add("Pływanie");
        sportsList.add("Szermierka");
        sportsList.add("Zapasy");
        sportsList.add("Golf");
        sportsList.add("Wspinaczka");
        sportsList.add("Snowboard");
        sportsList.add("Narciarstwo");
        sportsList.add("Badminton");
        sportsList.add("Akrobatyka");

        List<String> gameList = new ArrayList<>();
        gameList.add("Wiedźmin");
        gameList.add("The Forest");
        gameList.add("Cyberpunk 2077");
        gameList.add("Among Us");
        gameList.add("League Of Legends");
        gameList.add("StarWars");
        gameList.add("Darkest Dungeon");
        gameList.add("Diablo");
        gameList.add("GTA");
        gameList.add("Gothic");
        gameList.add("Metin");
        gameList.add("Dying Light");
        gameList.add("Fallout");
        gameList.add("Elden Ring");
        gameList.add("Skyrim");
        gameList.add("The Sims");
        gameList.add("CS:GO");
        gameList.add("Assassin");
        gameList.add("God of War");
        gameList.add("Far Cry");
        gameList.add("FIFA");
        gameList.add("LEGO");
        gameList.add("Batman");
        gameList.add("Bloodborne");
        gameList.add("Minecraft");
        gameList.add("SpellForce");
        gameList.add("Sekiro");
        gameList.add("Kangurek Kao");
        gameList.add("Metro");
        gameList.add("Uncharted");
        gameList.add("Amnesia");

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