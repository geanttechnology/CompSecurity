// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

public class MultiColumnListAdapter extends BaseAdapter
    implements WrapperListAdapter
{
    public class Row extends LinearLayout
    {

        private final int numUsedCols;
        final MultiColumnListAdapter this$0;

        public int getNumUsedCols()
        {
            return numUsedCols;
        }

        public RowItemWrapper wrapperAt(int i)
        {
            return (RowItemWrapper)getChildAt(i);
        }

        public Row(Context context, int i)
        {
            this$0 = MultiColumnListAdapter.this;
            super(context);
            numUsedCols = i;
            setOrientation(0);
            for (i = 0; i < numCols; i++)
            {
                addView(getRowItemWrapper(context));
            }

        }
    }

    public class RowItemWrapper extends FrameLayout
        implements android.view.View.OnClickListener
    {

        private int position;
        final MultiColumnListAdapter this$0;

        public View getWrappedView()
        {
            return getChildAt(0);
        }

        public void onClick(View view)
        {
            MultiColumnListAdapter.this.onClick(position, view);
        }

        public void setPosition(int i)
        {
            position = i;
        }

        public void wrap(View view)
        {
            if (getChildCount() > 0)
            {
                removeViewAt(0);
            }
            addView(view);
        }

        public RowItemWrapper(Context context)
        {
            this$0 = MultiColumnListAdapter.this;
            super(context);
            multicolumnlistadapter = new android.widget.LinearLayout.LayoutParams(0, -2, 1.0F);
            gravity = 80;
            setLayoutParams(MultiColumnListAdapter.this);
            setBackgroundResource(0x7f02024e);
            setOnClickListener(this);
        }
    }


    private int numCols;
    private ListAdapter wrappedAdapter;

    public MultiColumnListAdapter(int i)
    {
        this(null, i);
    }

    public MultiColumnListAdapter(ListAdapter listadapter, int i)
    {
        setWrappedAdapter(listadapter);
        numCols = i;
    }

    private void doPrepareRowItemWrapper(int i, RowItemWrapper rowitemwrapper, View view)
    {
        rowitemwrapper.wrap(view);
        rowitemwrapper.setPosition(i);
        prepareRowItemWrapper(i, rowitemwrapper, view);
    }

    private int itemCountForRow(int i)
    {
        int j = numCols;
        return Math.min(numCols, wrappedAdapter.getCount() - i * j);
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public int getCount()
    {
        return ((wrappedAdapter.getCount() + numCols) - 1) / numCols;
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return itemCountForRow(i) - 1;
    }

    public int getNumColumns()
    {
        return numCols;
    }

    protected RowItemWrapper getRowItemWrapper(Context context)
    {
        return new RowItemWrapper(context);
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        int k = itemCountForRow(i);
        int l = numCols;
        int j;
        if ((view instanceof Row) && ((Row)view).getNumUsedCols() == k)
        {
            view = (Row)view;
        } else
        {
            view = new Row(viewgroup.getContext(), k);
        }
        for (j = 0; j < k; j++)
        {
            int i1 = i * l + j;
            viewgroup = view.wrapperAt(j);
            View view1 = wrappedAdapter.getView(i1, viewgroup.getWrappedView(), viewgroup);
            if (view1.getParent() != null)
            {
                ((ViewGroup)view1.getParent()).removeView(view1);
            }
            doPrepareRowItemWrapper(i1, viewgroup, view1);
        }

        return view;
    }

    public int getViewTypeCount()
    {
        return numCols;
    }

    public ListAdapter getWrappedAdapter()
    {
        return wrappedAdapter;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isEmpty()
    {
        return wrappedAdapter.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        return false;
    }

    protected void onClick(int i, View view)
    {
    }

    protected void prepareRowItemWrapper(int i, RowItemWrapper rowitemwrapper, View view)
    {
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        wrappedAdapter.registerDataSetObserver(datasetobserver);
    }

    public void setWrappedAdapter(ListAdapter listadapter)
    {
        wrappedAdapter = listadapter;
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        wrappedAdapter.unregisterDataSetObserver(datasetobserver);
    }

}
