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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gotv.crackle.model.BrowseModel;
import java.util.ArrayList;
import java.util.List;

public class BrowseItemListAdapter extends BaseAdapter
{

    private Context mContext;
    private List mItems;
    private android.view.View.OnClickListener mOnClickListener;
    private android.view.View.OnClickListener mPlayItemListener;
    private com.gotv.crackle.base.BaseActivity.AppSection mSection;

    public BrowseItemListAdapter(Context context, List list, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, com.gotv.crackle.base.BaseActivity.AppSection appsection)
    {
        mOnClickListener = onclicklistener;
        mPlayItemListener = onclicklistener1;
        mSection = appsection;
        mContext = context;
        mItems = new ArrayList(list);
    }

    private View getViewForPosition(int i, View view)
    {
        Object obj = (LayoutInflater)mContext.getSystemService("layout_inflater");
        if (view == null)
        {
            view = ((LayoutInflater) (obj)).inflate(0x7f03001f, null);
        }
        obj = (Button)view.findViewById(0x7f0a0077);
        ((Button) (obj)).setTag(mItems.get(i));
        ((Button) (obj)).setOnClickListener(mOnClickListener);
        obj = (TextView)view.findViewById(0x7f0a0078);
        if (((BrowseModel)mItems.get(i)).getID().equalsIgnoreCase(mContext.getString(0x7f0b00d8)) || ((BrowseModel)mItems.get(i)).getID().equalsIgnoreCase(mContext.getString(0x7f0b00d9)))
        {
            ((TextView) (obj)).setVisibility(0);
            ((TextView) (obj)).setText(((BrowseModel)mItems.get(i)).getID());
            ((LinearLayout)view.findViewById(0x7f0a0079)).setVisibility(8);
        } else
        {
            ((LinearLayout)view.findViewById(0x7f0a0079)).setVisibility(0);
            ((TextView) (obj)).setVisibility(8);
            ((TextView)view.findViewById(0x7f0a007a)).setText(((BrowseModel)mItems.get(i)).getTitle());
            obj = (ImageButton)view.findViewById(0x7f0a007e);
            if (mSection == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES)
            {
                ((ImageButton) (obj)).setOnClickListener(mPlayItemListener);
                ((ImageButton) (obj)).setTag(mItems.get(i));
            } else
            {
                ((ImageButton) (obj)).setVisibility(8);
            }
            obj = (TextView)view.findViewById(0x7f0a007b);
            if (mSection == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES)
            {
                ((TextView) (obj)).setText(((BrowseModel)mItems.get(i)).getDuration());
            } else
            {
                ((TextView) (obj)).setVisibility(8);
            }
            obj = (TextView)view.findViewById(0x7f0a007c);
            if (mSection == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES || mSection == com.gotv.crackle.base.BaseActivity.AppSection.SHOWS)
            {
                ((TextView) (obj)).setText(((BrowseModel)mItems.get(i)).getRating());
            } else
            {
                ((TextView) (obj)).setVisibility(8);
            }
            obj = (TextView)view.findViewById(0x7f0a007d);
            ((TextView) (obj)).setText("");
            if (mSection == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES)
            {
                if (((BrowseModel)mItems.get(i)).getExpiresInDays() != null && ((BrowseModel)mItems.get(i)).getExpiresInLessThan5days())
                {
                    ((TextView) (obj)).setText(mContext.getResources().getQuantityString(0x7f0e0000, ((BrowseModel)mItems.get(i)).getExpiresInDays().intValue(), new Object[] {
                        ((BrowseModel)mItems.get(i)).getExpiresInDays()
                    }));
                    return view;
                }
            } else
            {
                ((TextView) (obj)).setVisibility(8);
                return view;
            }
        }
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
