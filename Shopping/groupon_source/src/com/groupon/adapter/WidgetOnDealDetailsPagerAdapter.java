// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import commonlib.adapter.RecyclerPagerAdapter;

public class WidgetOnDealDetailsPagerAdapter extends RecyclerPagerAdapter
{

    private final int MAX_DEALS_ALLOWED_IN_WIDGET = 9;
    private final float PAGE_WIDTH_LANDSCAPE = 0.45F;
    private final float PAGE_WIDTH_PORTRAIT = 0.8F;
    private FilterableWidgetListAdapter adapter;
    private Context context;
    private final Object loadingItem = new Object();

    public WidgetOnDealDetailsPagerAdapter(FilterableWidgetListAdapter filterablewidgetlistadapter, Context context1)
    {
        adapter = filterablewidgetlistadapter;
        context = context1;
        notifyDataSetChanged();
    }

    public int getCount()
    {
        if (adapter != null)
        {
            return Math.min(9, adapter.getCount());
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        if (adapter == null || i >= getCount())
        {
            return loadingItem;
        } else
        {
            return adapter.getItem(i);
        }
    }

    public int getItemViewType(int i)
    {
        return adapter.getItemViewType(i);
    }

    public float getPageWidth(int i)
    {
        return context.getResources().getConfiguration().orientation != 2 ? 0.8F : 0.45F;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = adapter.getView(i, view, viewgroup);
        int j;
        if (i == 0)
        {
            j = context.getResources().getDimensionPixelSize(0x7f0b0220);
        } else
        {
            j = 0;
        }
        if (i < adapter.getCount() - 1)
        {
            i = context.getResources().getDimensionPixelSize(0x7f0b0221);
        } else
        {
            i = 0;
        }
        view.setPadding(j, 0, i, 0);
        return view;
    }
}
