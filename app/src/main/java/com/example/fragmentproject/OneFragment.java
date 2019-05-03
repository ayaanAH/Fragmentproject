package com.example.fragmentproject;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    ArrayList<Word> numberList;
    ListView numListView;
    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment


        numberList=new ArrayList<>();
        View rootView=LayoutInflater.from(getContext()).inflate(R.layout.fragment_one, container,false);

        numberList.add(new Word(R.drawable.number_one,"one","yi"));
        numberList.add(new Word(R.drawable.number_two,"two","èr"));
        numberList.add(new Word(R.drawable.number_three,"three","san"));
        numberList.add(new Word(R.drawable.number_four,"four","sì"));
        numberList.add(new Word(R.drawable.number_five,"five","wu"));
        numberList.add(new Word(R.drawable.number_six,"six","liù"));
        numberList.add(new Word(R.drawable.number_seven,"seven","qi"));
        numberList.add(new Word(R.drawable.number_eight,"eight","ba"));
        numberList.add(new Word(R.drawable.number_nine,"nine","jiu"));
        numberList.add(new Word(R.drawable.number_ten,"ten","shí"));

        numListView=rootView.findViewById(R.id.numbersLists);
        WordAdapter wrdAdapt=new WordAdapter(getActivity(),numberList,R.color.greyback);
        numListView.setAdapter(wrdAdapt);


        numListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getActivity(), SingleDisplay.class);
                String engTxt = numberList.get(position).getmDefaultTranslation().toString();
                String mandTxt = numberList.get(position).getmMandrinTranslation().toString();
                int imageImg = numberList.get(position).getImage();
                intent.putExtra("English", engTxt);
                intent.putExtra("Manderin", mandTxt);
                intent.putExtra("Image", imageImg);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
