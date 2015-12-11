// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class SpinnerListAdapter extends BaseAdapter
{

    private Context mContext;
    private List mDefaultItems;

    public SpinnerListAdapter(Context context, List list)
    {
        mContext = context;
        mDefaultItems = list;
    }

    public int getCount()
    {
        return mDefaultItems.size();
    }

    public Object getItem(int i)
    {
        if (i < mDefaultItems.size())
        {
            return mDefaultItems.get(i);
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f030051, null);
        viewgroup = (String)mDefaultItems.get(i);
        ((TextView)view.findViewById(0x7f0a0031)).setText(viewgroup);
        return view;
    }
}
