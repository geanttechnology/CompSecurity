// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.commonsware.cwac.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public class AdapterWrapper extends BaseAdapter
{

    private ListAdapter wrapped;

    public AdapterWrapper(ListAdapter listadapter)
    {
        wrapped = null;
        wrapped = listadapter;
        listadapter.registerDataSetObserver(new DataSetObserver() {

            final AdapterWrapper this$0;

            public void onChanged()
            {
                notifyDataSetChanged();
            }

            public void onInvalidated()
            {
                notifyDataSetInvalidated();
            }

            
            {
                this$0 = AdapterWrapper.this;
                super();
            }
        });
    }

    public boolean areAllItemsEnabled()
    {
        return wrapped.areAllItemsEnabled();
    }

    public int getCount()
    {
        return wrapped.getCount();
    }

    public Object getItem(int i)
    {
        return wrapped.getItem(i);
    }

    public long getItemId(int i)
    {
        return wrapped.getItemId(i);
    }

    public int getItemViewType(int i)
    {
        return wrapped.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return wrapped.getView(i, view, viewgroup);
    }

    public int getViewTypeCount()
    {
        return wrapped.getViewTypeCount();
    }

    protected ListAdapter getWrappedAdapter()
    {
        return wrapped;
    }

    public boolean isEnabled(int i)
    {
        return wrapped.isEnabled(i);
    }
}
