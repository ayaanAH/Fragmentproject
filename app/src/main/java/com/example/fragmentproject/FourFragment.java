package com.example.fragmentproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FourFragment extends Fragment {

    ArrayList<Word> phraseList;
    ListView phraseListView;
    ImageView img2;
    public FourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView=LayoutInflater.from(getContext()).inflate(R.layout.fragment_three, container,false);
        phraseList=new ArrayList<>();

        phraseList.add(new Word("thank you so much","非常感谢。"));
        phraseList.add(new Word("I really appreciate…","我真的很感激…"));
        phraseList.add(new Word("where are you?","你在哪？"));
        phraseList.add(new Word("are you coming","你来吗"));
        phraseList.add(new Word("What do you think?","你怎么看？"));
        phraseList.add(new Word("Nice to meet you.","谢谢。这有很大帮助。"));
        phraseList.add(new Word("How can I help you?","很高兴见到你。"));
        phraseList.add(new Word(" I’ll be with you in a moment.","我怎么帮你？ 我马上就会和你在一起。"));
        phraseList.add(new Word("Oh really  Actually, I thought…","实际上，我想.."));

        phraseListView=rootView.findViewById(R.id.colorsLists);
        WordAdapter wrdAdapt=new WordAdapter(getActivity(),phraseList,R.color.greenback);
        phraseListView.setAdapter(wrdAdapt);

        phraseListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getActivity(), SingleDisplay.class);
                String engTxt = phraseList.get(position).getmDefaultTranslation().toString();
                String mandTxt = phraseList.get(position).getmMandrinTranslation().toString();
                int imageImg = phraseList.get(position).getImage();
                intent.putExtra("English", engTxt);
                intent.putExtra("Manderin", mandTxt);
                intent.putExtra("Image", imageImg);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
