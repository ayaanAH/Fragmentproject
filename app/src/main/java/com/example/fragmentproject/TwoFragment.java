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
public class TwoFragment extends Fragment {


    ArrayList<Word> familyList;
    ListView familyListView;
    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        familyList=new ArrayList<>();
        View rootView=LayoutInflater.from(getContext()).inflate(R.layout.fragment_two, container,false);

        familyList.add(new Word(R.drawable.family_father,"Father","父亲"));
        familyList.add(new Word(R.drawable.family_mother,"Mother","妈妈"));
        familyList.add(new Word(R.drawable.family_son,"Son","儿子"));
        familyList.add(new Word(R.drawable.family_daughter,"Daughter","女儿"));
        familyList.add(new Word(R.drawable.family_younger_brother,"Younger brother","弟弟"));
        familyList.add(new Word(R.drawable.family_younger_sister,"Younger sister","妹妹"));
        familyList.add(new Word(R.drawable.family_grandmother,"Grandmother","姥姥"));
        familyList.add(new Word(R.drawable.family_grandfather,"Grandfather","爷爷"));
        familyList.add(new Word(R.drawable.family_older_brother,"Elder brother","哥哥"));

        familyListView=rootView.findViewById(R.id.familyLists);
        WordAdapter wrdAdapt=new WordAdapter(getActivity(),familyList,R.color.greyback);
        familyListView.setAdapter(wrdAdapt);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Intent intent = new Intent(getActivity(), SingleDisplay.class);
                String engTxt = familyList.get(position).getmDefaultTranslation().toString();
                String mandTxt = familyList.get(position).getmMandrinTranslation().toString();
                int imageImg = familyList.get(position).getImage();
                intent.putExtra("English", engTxt);
                intent.putExtra("Manderin", mandTxt);
                intent.putExtra("Image", imageImg);
                startActivity(intent);

            }
        });

        return rootView;
    }

}
