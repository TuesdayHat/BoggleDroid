package com.epicodus.boggle;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class LetterAdapter extends BaseAdapter{
    private Context mContext;
    private String[] mLetters;


    public LetterAdapter (Context context, String[] letters){
        this.mContext = context;
        this.mLetters = letters;
    }

    @Override
    public int getCount() {
        return mLetters.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View converterView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if(converterView == null) {
            gridView = inflater.inflate(R.layout.letter_grid_item, null);

            Button letterButton = (Button) gridView
                    .findViewById(R.id.grid_item_letter);

            letterButton.setText(mLetters[position]);

        } else {
            gridView = (View) converterView;
        }
        return gridView;
    }
}
