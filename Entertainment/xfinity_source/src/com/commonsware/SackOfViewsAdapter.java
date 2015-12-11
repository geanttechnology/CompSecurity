// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.commonsware;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class SackOfViewsAdapter extends BaseAdapter
{

    private List views;

    public SackOfViewsAdapter(List list)
    {
        views = null;
        views = list;
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public int getCount()
    {
        return views.size();
    }

    public Object getItem(int i)
    {
        return views.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = (View)views.get(i);
        view = view1;
        if (view1 == null)
        {
            view = newView(i, viewgroup);
            views.set(i, view);
        }
        return view;
    }

    public int getViewTypeCount()
    {
        return getCount();
    }

    public boolean isEnabled(int i)
    {
        return false;
    }

    protected View newView(int i, ViewGroup viewgroup)
    {
        throw new RuntimeException("You must override newView()!");
    }
}
