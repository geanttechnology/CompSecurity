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
import java.util.ArrayList;
import java.util.HashSet;

public class AkSoundlikeAdapter extends BaseAdapter
{

    private LayoutInflater mInflater;
    private HashSet mSelectedItemsIndex;
    private ArrayList mSoundlikes;
    private Typeface tf;

    public AkSoundlikeAdapter(Context context, ArrayList arraylist)
    {
        tf = AkApplication.getTypeFace();
        mSoundlikes = null;
        mInflater = null;
        mSelectedItemsIndex = new HashSet();
        mInflater = LayoutInflater.from(context);
        mSoundlikes = arraylist;
    }

    public void addSelectedItems(Integer integer)
    {
        mSelectedItemsIndex.add(integer);
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return mSoundlikes.size();
    }

    public Object getItem(int i)
    {
        return mSoundlikes.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public HashSet getSelectedItemsIndex()
    {
        return mSelectedItemsIndex;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ViewHolder {}

        if (view == null)
        {
            viewgroup = new ViewHolder(null);
            view = mInflater.inflate(0x7f030060, null);
            viewgroup.uiMainLayout = (RelativeLayout)view.findViewById(0x7f0d027b);
            viewgroup.uiSoundlikeNameText = (TextView)view.findViewById(0x7f0d027c);
            viewgroup.uiSoundlikeDescriptionText = (TextView)view.findViewById(0x7f0d027d);
            ((ViewHolder) (viewgroup)).uiSoundlikeNameText.setTextSize(0, ((ViewHolder) (viewgroup)).uiSoundlikeNameText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiSoundlikeDescriptionText.setTextSize(0, ((ViewHolder) (viewgroup)).uiSoundlikeDescriptionText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiSoundlikeNameText.setTypeface(tf);
            ((ViewHolder) (viewgroup)).uiSoundlikeDescriptionText.setTypeface(tf);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).uiSoundlikeNameText.setText(((com.elokence.limuleapi.Session.LimuleObject)mSoundlikes.get(i)).getName());
        ((ViewHolder) (viewgroup)).uiSoundlikeDescriptionText.setText(((com.elokence.limuleapi.Session.LimuleObject)mSoundlikes.get(i)).getDescription());
        if (mSelectedItemsIndex.contains(Integer.valueOf(i)))
        {
            ((ViewHolder) (viewgroup)).uiMainLayout.setBackgroundResource(0x7f02026a);
            return view;
        } else
        {
            ((ViewHolder) (viewgroup)).uiMainLayout.setBackgroundResource(0x7f020276);
            return view;
        }
    }

    public void removeSelectedItems(Integer integer)
    {
        mSelectedItemsIndex.remove(integer);
        notifyDataSetChanged();
    }
}
