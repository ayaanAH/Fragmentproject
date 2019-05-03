package com.example.fragmentproject;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>
{
    int color;

    public WordAdapter(Activity context, ArrayList<Word> numberList,int colorBack) {
        super(context,0,numberList);
        this.color=colorBack;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View root= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);

        Word currentWord=getItem(position);


        TextView defaultTrans=root.findViewById(R.id.default_lang);
        TextView manderinTrans=root.findViewById(R.id.manderin_lang);
        ImageView imgTrans=root.findViewById(R.id.img1);

        defaultTrans.setText(""+currentWord.getmDefaultTranslation());
        manderinTrans.setText(currentWord.getmMandrinTranslation());
        if(currentWord.getImage()!=-1)
            imgTrans.setImageResource(currentWord.getImage());
        else
            imgTrans.setVisibility(View.GONE);


        View viewContainer = root.findViewById(R.id.container);
        int colour= ContextCompat.getColor(getContext(),color);
        viewContainer.setBackgroundColor(colour);

        return root;
    }

}
