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

public class AkCharacterAdapter extends BaseAdapter
{
    private class ViewHolder
    {

        TextView getUiCharacterDescText;
        final AkCharacterAdapter this$0;
        TextView uiCharacterNameText;
        RelativeLayout uiMainLayout;

        private ViewHolder()
        {
            this$0 = AkCharacterAdapter.this;
            super();
        }

    }


    private ArrayList mCharacters;
    private LayoutInflater mInflater;
    private HashSet mSelectedItemsIndex;
    private Typeface tf;

    public AkCharacterAdapter(Context context, ArrayList arraylist)
    {
        tf = AkApplication.getTypeFace();
        mCharacters = null;
        mInflater = null;
        mSelectedItemsIndex = new HashSet();
        mInflater = LayoutInflater.from(context);
        mCharacters = arraylist;
    }

    public void addSelectedItems(Integer integer)
    {
        mSelectedItemsIndex.add(integer);
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return mCharacters.size();
    }

    public Object getItem(int i)
    {
        return mCharacters.get(i);
    }

    public long getItemId(int i)
    {
        return (long)((com.elokence.limuleapi.Session.LimuleObject)mCharacters.get(i)).getIdBase();
    }

    public HashSet getSelectedItemsIndex()
    {
        return mSelectedItemsIndex;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = mInflater.inflate(0x7f030056, null);
            viewgroup.uiCharacterNameText = (TextView)view.findViewById(0x7f0d0257);
            ((ViewHolder) (viewgroup)).uiCharacterNameText.setTextSize(0, ((ViewHolder) (viewgroup)).uiCharacterNameText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).uiCharacterNameText.setTypeface(tf);
            viewgroup.getUiCharacterDescText = (TextView)view.findViewById(0x7f0d0258);
            ((ViewHolder) (viewgroup)).getUiCharacterDescText.setTextSize(0, ((ViewHolder) (viewgroup)).uiCharacterNameText.getTextSize() * AkApplication.getCoeffFont());
            ((ViewHolder) (viewgroup)).getUiCharacterDescText.setTypeface(tf);
            viewgroup.uiMainLayout = (RelativeLayout)view.findViewById(0x7f0d0256);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).uiCharacterNameText.setText(((com.elokence.limuleapi.Session.LimuleObject)mCharacters.get(i)).getName());
        ((ViewHolder) (viewgroup)).getUiCharacterDescText.setText(((com.elokence.limuleapi.Session.LimuleObject)mCharacters.get(i)).getDescription());
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
