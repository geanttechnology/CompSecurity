// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class SubtitleListAdapter extends BaseAdapter
{

    private Context mContext;
    private List mItems;
    private String mSelectedItem;

    public SubtitleListAdapter(Context context, List list, String s)
    {
        mSelectedItem = "";
        mContext = context;
        list.add(0, context.getString(0x7f0b00d5));
        mItems = list;
        if (s != null)
        {
            mSelectedItem = s;
            return;
        } else
        {
            mSelectedItem = context.getString(0x7f0b00d5);
            return;
        }
    }

    public int getCount()
    {
        return mItems.size();
    }

    public Object getItem(int i)
    {
        return mItems.get(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = null;
        viewgroup = (LayoutInflater)mContext.getSystemService("layout_inflater");
        if (true)
        {
            view = viewgroup.inflate(0x7f030051, null);
        }
        viewgroup = (String)mItems.get(i);
        view.setTag(viewgroup);
        ((TextView)view.findViewById(0x7f0a0031)).setText(viewgroup);
        ImageView imageview = (ImageView)view.findViewById(0x7f0a00d3);
        if (mSelectedItem.equalsIgnoreCase(viewgroup))
        {
            imageview.setVisibility(0);
            return view;
        } else
        {
            imageview.setVisibility(4);
            return view;
        }
    }
}
