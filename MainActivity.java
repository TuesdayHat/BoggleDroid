package com.epicodus.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.resetButton) Button mResetButton;
    GridView gridView;

    String[] vowels = "aeiou".toUpperCase().split("");
    String[] consonants = "bcdfghjklmnprstvwxyz".toUpperCase().split("");

    String[] letters = lettersGen(vowels, consonants);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new LetterAdapter(this, letters));

        mResetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        letters = lettersGen(vowels, consonants);

        String displayLetters = TextUtils.join(", ", letters);

        Toast.makeText(MainActivity.this, "New Game!", Toast.LENGTH_LONG).show();

        gridView.setAdapter(new LetterAdapter(this, letters));
    }

    public String[] lettersGen(String[] vowels, String[] cons){
        String[] array = new String[16];
        Random rand = new Random();

        for(int i=0; i<array.length;i++){
            int consOrVowel = rand.nextInt(3);
            if (consOrVowel == 0){
                array[i] = vowels[rand.nextInt(vowels.length-1)+1];
            } else {
                array[i] = cons[rand.nextInt(cons.length-1)+1];
            }
        }

        return array;
    }


}
