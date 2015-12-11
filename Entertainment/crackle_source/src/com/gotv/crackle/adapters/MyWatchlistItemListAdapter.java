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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.model.QueueItem;
import java.util.ArrayList;
import java.util.List;

public class MyWatchlistItemListAdapter extends BaseAdapter
{

    private Context mContext;
    private List mItems;
    private android.view.View.OnClickListener mOnClickListener;
    private android.view.View.OnClickListener mPlayItemListener;

    public MyWatchlistItemListAdapter(Context context, List list, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        mOnClickListener = onclicklistener;
        mPlayItemListener = onclicklistener1;
        mContext = context;
        mItems = new ArrayList(list);
    }

    private View getViewForPosition(int i, View view)
    {
        Object obj = (LayoutInflater)mContext.getSystemService("layout_inflater");
        Object obj1;
        StringBuilder stringbuilder;
        if (view == null)
        {
            view = ((LayoutInflater) (obj)).inflate(0x7f030062, null);
        }
        obj = (QueueItem)mItems.get(i);
        obj1 = (LinearLayout)view.findViewById(0x7f0a014b);
        ((LinearLayout) (obj1)).setOnClickListener(mOnClickListener);
        ((LinearLayout) (obj1)).setTag(mItems.get(i));
        ((TextView)view.findViewById(0x7f0a007a)).setText(((BrowseModel)mItems.get(i)).getTitle());
        obj1 = (TextView)view.findViewById(0x7f0a014c);
        stringbuilder = new StringBuilder();
        if (((QueueItem) (obj)).getSeason() != null && !((QueueItem) (obj)).getSeason().equalsIgnoreCase(""))
        {
            stringbuilder.append((new StringBuilder()).append("S").append(((QueueItem) (obj)).getSeason()).toString());
            if (((QueueItem) (obj)).getEpisode() != null && !((QueueItem) (obj)).getEpisode().equalsIgnoreCase(""))
            {
                stringbuilder.append((new StringBuilder()).append(" E").append(((QueueItem) (obj)).getEpisode()).toString());
            }
            ((TextView) (obj1)).setText(stringbuilder);
        } else
        {
            ((TextView) (obj1)).setVisibility(8);
        }
        obj = (TextView)view.findViewById(0x7f0a007d);
        ((TextView) (obj)).setText("");
        if (((BrowseModel)mItems.get(i)).getExpiresInDays() != null && ((BrowseModel)mItems.get(i)).getExpiresInLessThan5days())
        {
            ((TextView) (obj)).setText(mContext.getResources().getQuantityString(0x7f0e0000, ((BrowseModel)mItems.get(i)).getExpiresInDays().intValue(), new Object[] {
                ((BrowseModel)mItems.get(i)).getExpiresInDays()
            }));
        }
        obj = (ImageButton)view.findViewById(0x7f0a007e);
        ((ImageButton) (obj)).setOnClickListener(mPlayItemListener);
        ((ImageButton) (obj)).setTag(mItems.get(i));
        return view;
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
        return getViewForPosition(i, view);
    }
}
