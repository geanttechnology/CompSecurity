// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

// Referenced classes of package org.lucasr.smoothie:
//            ItemManager

class AsyncBaseAdapter extends BaseAdapter
{

    private final ItemManager mItemManager;
    private final BaseAdapter mWrappedAdapter;

    AsyncBaseAdapter(ItemManager itemmanager, BaseAdapter baseadapter)
    {
        mItemManager = itemmanager;
        mWrappedAdapter = baseadapter;
    }

    public boolean areAllItemsEnabled()
    {
        return mWrappedAdapter.areAllItemsEnabled();
    }

    public int getCount()
    {
        return mWrappedAdapter.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return mWrappedAdapter.getDropDownView(i, view, viewgroup);
    }

    public Object getItem(int i)
    {
        return mWrappedAdapter.getItem(i);
    }

    public long getItemId(int i)
    {
        return mWrappedAdapter.getItemId(i);
    }

    public int getItemViewType(int i)
    {
        return mWrappedAdapter.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = mWrappedAdapter.getView(i, view, viewgroup);
        mItemManager.loadItem(viewgroup, view, i);
        return view;
    }

    public int getViewTypeCount()
    {
        return mWrappedAdapter.getViewTypeCount();
    }

    ListAdapter getWrappedAdapter()
    {
        return mWrappedAdapter;
    }

    public boolean hasStableIds()
    {
        return mWrappedAdapter.hasStableIds();
    }

    public boolean isEmpty()
    {
        return mWrappedAdapter.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        return mWrappedAdapter.isEnabled(i);
    }

    public void notifyDataSetChanged()
    {
        mWrappedAdapter.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated()
    {
        mWrappedAdapter.notifyDataSetInvalidated();
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        mWrappedAdapter.registerDataSetObserver(datasetobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mWrappedAdapter.unregisterDataSetObserver(datasetobserver);
    }
}
