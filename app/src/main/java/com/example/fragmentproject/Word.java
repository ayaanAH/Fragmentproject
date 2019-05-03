package com.example.fragmentproject;

public class Word
{

    String mDefaultTranslation, mMandrinTranslation;
    int images=-1;

    public Word(int images, String mDefaultTranslation, String mMandrinTranslation)
    {
        this.images =images;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMandrinTranslation = mMandrinTranslation;
    }

    public Word(String mDefaultTranslation, String mMandrinTranslation)
    {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMandrinTranslation = mMandrinTranslation;
    }

    public String getmDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public int getImage()
    {
        return images;
    }

    public String getmMandrinTranslation()
    {
        return mMandrinTranslation;
    }
}
