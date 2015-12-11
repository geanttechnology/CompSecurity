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
import com.gotv.crackle.Application;
import java.util.ArrayList;
import java.util.List;

public class FolderListAdapter extends BaseAdapter
{

    private Context mContext;
    private List mItems;

    public FolderListAdapter(Context context, List list)
    {
        mContext = context;
        mItems = new ArrayList(list);
        if (!Application.getInstance().isTablet())
        {
            mItems.remove(0);
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
        view = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x1090003, null);
        view.setBackgroundColor(mContext.getResources().getColor(0x7f070016));
        ((TextView)view).setText((String)getItem(i));
        ((TextView)view).setTextAppearance(mContext, 0x1030044);
        ((TextView)view).setTypeface(Application.getInstance().getTypeFace());
        return view;
    }
}
