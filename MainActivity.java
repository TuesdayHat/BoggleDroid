package com.epicodus.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    String[] vowels = "aeiou".toUpperCase().split("");
    String[] consonants = "bcdfghjklmnprstvwxyz".toUpperCase().split("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] letters = lettersGen(vowels, consonants);
    }

    public String[] lettersGen(String[] vowels, String[] cons){
        String[] array = new String[16];
        Random rand = new Random();

        for(int i=0; i<array.length;i++){
            int consOrVowel = rand.nextInt(1);
            if (consOrVowel == 0){
                array[i] = cons[rand.nextInt(cons.length)];
            } else {
                array[i] = vowels[rand.nextInt(vowels.length)];
            }
        }

        return array;
    }


}
