// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

public class VpsAdapter
    implements WrapperListAdapter
{

    private ListAdapter _flddelegate;
    private long vpsLastViewTime;
    private long vpsStartTimeNanos;
    private int vpsViewCount;

    public VpsAdapter(ListAdapter listadapter)
    {
        vpsViewCount = 0;
        vpsStartTimeNanos = System.nanoTime();
        vpsLastViewTime = 0x7fffffffffffffffL;
        _flddelegate = listadapter;
    }

    public boolean areAllItemsEnabled()
    {
        return _flddelegate.areAllItemsEnabled();
    }

    public int getCount()
    {
        return _flddelegate.getCount();
    }

    public Object getItem(int i)
    {
        return _flddelegate.getItem(i);
    }

    public long getItemId(int i)
    {
        return _flddelegate.getItemId(i);
    }

    public int getItemViewType(int i)
    {
        return _flddelegate.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = _flddelegate.getView(i, view, viewgroup);
        vpsViewCount = vpsViewCount + 1;
        vpsLastViewTime = System.nanoTime();
        return view;
    }

    public int getViewTypeCount()
    {
        return _flddelegate.getViewTypeCount();
    }

    public double getViewsPerSecond()
    {
        return ((double)vpsViewCount / (double)(vpsLastViewTime - vpsStartTimeNanos)) * 1000000000D;
    }

    public int getViewsPerSecondViewCount()
    {
        return vpsViewCount;
    }

    public ListAdapter getWrappedAdapter()
    {
        return _flddelegate;
    }

    public boolean hasStableIds()
    {
        return _flddelegate.hasStableIds();
    }

    public boolean isEmpty()
    {
        return _flddelegate.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        return _flddelegate.isEnabled(i);
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        _flddelegate.registerDataSetObserver(datasetobserver);
    }

    public void resetViewsPerSecond()
    {
        vpsViewCount = 0;
        vpsStartTimeNanos = System.nanoTime();
        vpsLastViewTime = 0x7fffffffffffffffL;
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        _flddelegate.unregisterDataSetObserver(datasetobserver);
    }
}
