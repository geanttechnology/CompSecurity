// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gotv.crackle.model.GenreItem;
import java.util.List;

public class BrowseListAdapter extends BaseAdapter
{

    private Context mContext;
    private List mDefaultItems;
    private List mDynamicItems;

    public BrowseListAdapter(Context context, List list, List list1)
    {
        mContext = context;
        mDefaultItems = list;
        mDynamicItems = list1;
    }

    public int getCount()
    {
        int j = mDefaultItems.size();
        int i;
        if (mDynamicItems != null)
        {
            i = mDynamicItems.size();
        } else
        {
            i = 0;
        }
        return i + j;
    }

    public Object getItem(int i)
    {
        if (i < mDefaultItems.size())
        {
            return mDefaultItems.get(i);
        }
        if (i >= mDefaultItems.size())
        {
            return ((GenreItem)mDynamicItems.get(i - mDefaultItems.size())).getID();
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
        viewgroup = (LayoutInflater)mContext.getSystemService("layout_inflater");
        if (view == null)
        {
            view = viewgroup.inflate(0x7f030051, null);
        }
        if (android.os.Build.VERSION.SDK_INT == 10)
        {
            view.setBackgroundColor(mContext.getResources().getColor(0x7f070027));
        }
        if (i < mDefaultItems.size())
        {
            viewgroup = (String)mDefaultItems.get(i);
            ((TextView)view.findViewById(0x7f0a0031)).setText(viewgroup);
        } else
        if (i >= mDefaultItems.size())
        {
            viewgroup = ((GenreItem)mDynamicItems.get(i - mDefaultItems.size())).getName();
            ((TextView)view.findViewById(0x7f0a0031)).setText(viewgroup);
            return view;
        }
        return view;
    }
}
