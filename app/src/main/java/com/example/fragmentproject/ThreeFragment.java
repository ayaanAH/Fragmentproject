package com.example.fragmentproject;


import android.content.Intent;
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
public class ThreeFragment extends Fragment {


    ArrayList<Word> colorList;
    ListView colorListView;
    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=LayoutInflater.from(getContext()).inflate(R.layout.fragment_three, container,false);
        colorList=new ArrayList<>();

        colorList.add(new Word(R.drawable.color_red,"Red","红色-Hóngsè"    ));
        colorList.add(new Word(R.drawable.color_green,"Green","绿色-Lǜsè"    ));
        colorList.add(new Word(R.drawable.color_brown,"Brown","棕色-Zōngsè"  ));
        colorList.add(new Word(R.drawable.color_gray,"Grey","灰色-Huīsè"    ));
        colorList.add(new Word(R.drawable.color_black,"Black","黑色-Hēisè"   ));
        colorList.add(new Word(R.drawable.color_white,"White","白色-Báisè"   ));
        colorList.add(new Word(R.drawable.color_mustard_yellow,"Yellow","黄色-Huángsè"));

        colorListView=rootView.findViewById(R.id.colorsLists);
        WordAdapter wrdAdapt=new WordAdapter(getActivity(),colorList,R.color.greenback);
        colorListView.setAdapter(wrdAdapt);

        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getActivity(), SingleDisplay.class);
                String engTxt = colorList.get(position).getmDefaultTranslation().toString();
                String mandTxt = colorList.get(position).getmMandrinTranslation().toString();
                int imageImg = colorList.get(position).getImage();
                intent.putExtra("English", engTxt);
                intent.putExtra("Manderin", mandTxt);
                intent.putExtra("Image", imageImg);
                startActivity(intent);

            }
        });

        return rootView;
    }

}
