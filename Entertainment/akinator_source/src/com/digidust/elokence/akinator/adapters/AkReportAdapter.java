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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

public class AkReportAdapter extends BaseAdapter
{

    private LayoutInflater mInflater;
    private ArrayList mReports;
    private Typeface tf;

    public AkReportAdapter(Context context, ArrayList arraylist)
    {
        tf = AkApplication.getTypeFace();
        mReports = null;
        mInflater = null;
        mInflater = LayoutInflater.from(context);
        mReports = arraylist;
    }

    public void clear()
    {
        mReports.clear();
    }

    public int getCount()
    {
        return mReports.size();
    }

    public Object getItem(int i)
    {
        return mReports.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ViewHolder {}

        String s;
        String s1;
        if (view == null)
        {
            viewgroup = new ViewHolder(null);
            view = mInflater.inflate(0x7f03005f, null);
            viewgroup.layoutReportMain = (RelativeLayout)view.findViewById(0x7f0d0272);
            viewgroup.question = (TextView)view.findViewById(0x7f0d0273);
            viewgroup.givenAnswer = (TextView)view.findViewById(0x7f0d027a);
            viewgroup.expectedAnswer = (TextView)view.findViewById(0x7f0d0277);
            viewgroup.givenAnswerLabel = (TextView)view.findViewById(0x7f0d0279);
            viewgroup.expectedAnswerLabel = (TextView)view.findViewById(0x7f0d0276);
            ((ViewHolder) (viewgroup)).question.setTypeface(tf);
            ((ViewHolder) (viewgroup)).givenAnswer.setTypeface(tf);
            ((ViewHolder) (viewgroup)).expectedAnswer.setTypeface(tf);
            ((ViewHolder) (viewgroup)).givenAnswerLabel.setTypeface(tf);
            ((ViewHolder) (viewgroup)).expectedAnswerLabel.setTypeface(tf);
            ((ViewHolder) (viewgroup)).question.setTextSize(0, ((ViewHolder) (viewgroup)).question.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).givenAnswer.setTextSize(0, ((ViewHolder) (viewgroup)).givenAnswer.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).expectedAnswer.setTextSize(0, ((ViewHolder) (viewgroup)).expectedAnswer.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).givenAnswerLabel.setTextSize(0, ((ViewHolder) (viewgroup)).givenAnswerLabel.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).expectedAnswerLabel.setTextSize(0, ((ViewHolder) (viewgroup)).expectedAnswerLabel.getTextSize() * AkApplication.getCoeffFont());
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        s = ((com.elokence.limuleapi.Session.ObjectReport)mReports.get(i)).getGivenAnswer();
        s1 = ((com.elokence.limuleapi.Session.ObjectReport)mReports.get(i)).getExpectedAnswer();
        if (s.compareTo(s1) == 0)
        {
            ((ViewHolder) (viewgroup)).layoutReportMain.setBackgroundResource(0x7f020262);
        } else
        {
            ((ViewHolder) (viewgroup)).layoutReportMain.setBackgroundResource(0x7f02026e);
        }
        ((ViewHolder) (viewgroup)).question.setText(((com.elokence.limuleapi.Session.ObjectReport)mReports.get(i)).getQuestionLabel());
        ((ViewHolder) (viewgroup)).givenAnswer.setText(s);
        ((ViewHolder) (viewgroup)).expectedAnswer.setText(s1);
        ((ViewHolder) (viewgroup)).givenAnswerLabel.setText(TraductionFactory.sharedInstance().getTraductionFromToken("REPONSE_DONNEE"));
        ((ViewHolder) (viewgroup)).expectedAnswerLabel.setText(TraductionFactory.sharedInstance().getTraductionFromToken("REPONSE_ATTENDUE"));
        return view;
    }

    public boolean isEnabled(int i)
    {
        return false;
    }
}
