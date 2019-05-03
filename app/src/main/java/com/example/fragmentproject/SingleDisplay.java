package com.example.fragmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SingleDisplay extends AppCompatActivity
{
    ImageView displayImg;
    TextView engTxtView, mandTxtView;
    int img= -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_display);

        engTxtView=findViewById(R.id.engg);
        mandTxtView=findViewById(R.id.mand);
        displayImg=findViewById(R.id.imageDis);
        img=getIntent().getExtras().getInt("Image");

        engTxtView.setText(getIntent().getExtras().getString("English"));
        mandTxtView.setText(getIntent().getExtras().getString("Manderin"));

        if (img==-1)
        {
            displayImg.setVisibility(View.GONE);
            RelativeLayout.LayoutParams layoutParams =
                    (RelativeLayout.LayoutParams)mandTxtView.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            mandTxtView.setLayoutParams(layoutParams);
        }
        else
            displayImg.setImageResource(img);


    }
}
