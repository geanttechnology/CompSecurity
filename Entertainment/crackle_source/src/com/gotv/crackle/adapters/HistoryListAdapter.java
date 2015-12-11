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
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.model.QueueItem;
import java.util.List;

public class HistoryListAdapter extends BaseAdapter
{

    private Context mContext;
    private List mItems;
    private android.view.View.OnClickListener mOnClickListener;
    private android.view.View.OnClickListener mPlayItemListener;

    public HistoryListAdapter(Context context, List list, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        mOnClickListener = onclicklistener;
        mPlayItemListener = onclicklistener1;
        mContext = context;
        mItems = list;
    }

    private View getViewForPosition(int i, View view)
    {
        Object obj = (LayoutInflater)mContext.getSystemService("layout_inflater");
        Object obj1;
        int j;
        if (view == null)
        {
            if (Application.getInstance().isTablet())
            {
                view = ((LayoutInflater) (obj)).inflate(0x7f03004c, null);
            } else
            {
                view = ((LayoutInflater) (obj)).inflate(0x7f030062, null);
            }
        }
        obj = (QueueItem)mItems.get(i);
        view.setOnClickListener(mOnClickListener);
        view.setTag(mItems.get(i));
        obj1 = (ImageButton)view.findViewById(0x7f0a007e);
        ((ImageButton) (obj1)).setOnClickListener(mPlayItemListener);
        ((ImageButton) (obj1)).setTag(mItems.get(i));
        obj1 = (TextView)view.findViewById(0x7f0a007a);
        ((TextView) (obj1)).setTag(mItems.get(i));
        j = 0;
        if (((QueueItem) (obj)).getViewedDaysAgo() != null)
        {
            j = ((QueueItem) (obj)).getViewedDaysAgo().intValue();
        }
        if (Application.getInstance().isTablet())
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(((BrowseModel)mItems.get(i)).getTitle());
            if (((QueueItem) (obj)).getSeason() != null && !((QueueItem) (obj)).getSeason().equalsIgnoreCase(""))
            {
                stringbuilder.append(": S");
                stringbuilder.append(((QueueItem) (obj)).getSeason());
                if (((QueueItem) (obj)).getEpisode() != null && !((QueueItem) (obj)).getEpisode().equalsIgnoreCase(""))
                {
                    stringbuilder.append(" E");
                    stringbuilder.append(((QueueItem) (obj)).getEpisode());
                }
            }
            ((TextView) (obj1)).setText(stringbuilder);
            ((TextView)view.findViewById(0x7f0a00f3)).setText(mContext.getResources().getQuantityString(0x7f0e0001, j, new Object[] {
                Integer.valueOf(j)
            }));
            ((TextView)view.findViewById(0x7f0a007b)).setText(((BrowseModel)mItems.get(i)).getDuration());
            return view;
        }
        ((TextView) (obj1)).setText(((QueueItem) (obj)).getTitle());
        obj1 = (TextView)view.findViewById(0x7f0a014c);
        StringBuilder stringbuilder1 = new StringBuilder();
        if (((QueueItem) (obj)).getSeason() != null && !((QueueItem) (obj)).getSeason().equalsIgnoreCase(""))
        {
            stringbuilder1.append((new StringBuilder()).append("S").append(((QueueItem) (obj)).getSeason()).toString());
            if (((QueueItem) (obj)).getEpisode() != null && !((QueueItem) (obj)).getEpisode().equalsIgnoreCase(""))
            {
                stringbuilder1.append((new StringBuilder()).append(" E").append(((QueueItem) (obj)).getEpisode()).toString());
            }
        }
        ((TextView) (obj1)).setText(stringbuilder1);
        obj1 = (TextView)view.findViewById(0x7f0a007d);
        stringbuilder1 = new StringBuilder();
        stringbuilder1.append(mContext.getResources().getQuantityString(0x7f0e0001, j, new Object[] {
            Integer.valueOf(j)
        }));
        if (((QueueItem) (obj)).getDuration() != null)
        {
            stringbuilder1.append((new StringBuilder()).append(" | ").append(((QueueItem) (obj)).getDuration()).toString());
        }
        ((TextView) (obj1)).setText(stringbuilder1);
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
