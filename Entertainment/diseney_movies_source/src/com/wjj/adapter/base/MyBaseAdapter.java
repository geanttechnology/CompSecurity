// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class MyBaseAdapter extends BaseAdapter
{

    protected LayoutInflater inflater;
    protected List list;

    public MyBaseAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);
        list = new ArrayList();
    }

    public abstract View MygetView(int i, View view, ViewGroup viewgroup);

    public void addData(List list1, boolean flag)
    {
        if (flag)
        {
            list.clear();
        }
        list.addAll(list1);
    }

    public void addDataToTop(List list1, boolean flag)
    {
        if (flag)
        {
            list.clear();
        }
        list.addAll(0, list1);
    }

    public int getCount()
    {
        return list.size();
    }

    public List getData()
    {
        return list;
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return MygetView(i, view, viewgroup);
    }
}
