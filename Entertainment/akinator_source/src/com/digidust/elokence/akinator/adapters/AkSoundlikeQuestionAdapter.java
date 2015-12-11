// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkApplication;
import java.util.ArrayList;

public class AkSoundlikeQuestionAdapter extends BaseAdapter
{

    private LayoutInflater mInflater;
    private ArrayList mSoundlikesQuestions;
    private Typeface tf;

    public AkSoundlikeQuestionAdapter(Context context, ArrayList arraylist)
    {
        tf = AkApplication.getTypeFace();
        mSoundlikesQuestions = null;
        mInflater = null;
        mInflater = LayoutInflater.from(context);
        mSoundlikesQuestions = arraylist;
    }

    public int getCount()
    {
        return mSoundlikesQuestions.size();
    }

    public Object getItem(int i)
    {
        return mSoundlikesQuestions.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ViewHolder {}

        if (view == null)
        {
            viewgroup = new ViewHolder(null);
            view = mInflater.inflate(0x7f030061, null);
            viewgroup.uiSoundlikeQuestionText = (TextView)view.findViewById(0x7f0d027c);
            ((ViewHolder) (viewgroup)).uiSoundlikeQuestionText.setTextSize(0, ((ViewHolder) (viewgroup)).uiSoundlikeQuestionText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiSoundlikeQuestionText.setTypeface(tf);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).uiSoundlikeQuestionText.setText(((com.elokence.limuleapi.Session.QuestionObject)mSoundlikesQuestions.get(i)).getQuestion());
        return view;
    }
}
