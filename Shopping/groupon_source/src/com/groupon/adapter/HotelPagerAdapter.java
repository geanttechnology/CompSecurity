// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.groupon.fragment.DealCardEndlessAdapter;
import commonlib.adapter.RecyclerPagerAdapter;

public class HotelPagerAdapter extends RecyclerPagerAdapter
{

    private static final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_LOADER = 1;
    private DealCardEndlessAdapter adapter;
    private final int hotelPagerMargin;
    private final Object loadingItem = new Object();

    public HotelPagerAdapter(int i)
    {
        hotelPagerMargin = i;
    }

    public int getCount()
    {
        int i = 0;
        boolean flag = false;
        if (adapter != null)
        {
            int j = adapter.getWrappedAdapterCount();
            i = ((flag) ? 1 : 0);
            if (adapter.hasMorePages())
            {
                i = 1;
            }
            i += j;
        }
        return i;
    }

    public Object getItem(int i)
    {
        if (adapter == null || i >= getCount() || getItemViewType(i) == 1)
        {
            return loadingItem;
        } else
        {
            return adapter.getItem(i);
        }
    }

    public int getItemViewType(int i)
    {
        return i != getCount() - 1 || !adapter.hasMorePages() ? 0 : 1;
    }

    public float getPageWidth(int i)
    {
        if (getItemViewType(i) == 1)
        {
            return 0.3F;
        } else
        {
            return super.getPageWidth(i);
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = adapter.getView(i, view, viewgroup);
        if (getItemViewType(i) == 1)
        {
            view.setMinimumHeight(0);
            view.setMinimumWidth(0);
            return view;
        }
        if (i < getCount() - 1)
        {
            i = hotelPagerMargin;
        } else
        {
            i = 0;
        }
        view.setPadding(0, 0, i, 0);
        return view;
    }

    public void setAdapter(DealCardEndlessAdapter dealcardendlessadapter)
    {
        adapter = dealcardendlessadapter;
        notifyDataSetChanged();
    }
}
