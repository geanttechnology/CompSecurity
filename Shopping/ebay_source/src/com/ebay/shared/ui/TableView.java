// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.shared.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public class TableView extends LinearLayout
    implements android.view.View.OnClickListener
{
    public static abstract class TableViewAdapter extends BaseAdapter
    {

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public abstract void itemClick(int i);

        public TableViewAdapter()
        {
        }
    }

    class TableViewObserver extends DataSetObserver
    {

        final TableView this$0;

        public void onChanged()
        {
            resetContents();
            requestLayout();
        }

        public void onInvalidated()
        {
            resetContents();
            requestLayout();
        }

        TableViewObserver()
        {
            this$0 = TableView.this;
            super();
        }
    }


    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = 0x8000000000000000L;
    private TableViewAdapter adapter;
    private int dividerId;
    private final LayoutInflater inflater;
    private TableViewObserver observer;
    int selectedPosition;
    long selectedRowId;

    public TableView(Context context)
    {
        super(context);
        selectedPosition = -1;
        selectedRowId = 0x8000000000000000L;
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public TableView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        selectedPosition = -1;
        selectedRowId = 0x8000000000000000L;
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        context = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.TableView);
        dividerId = context.getResourceId(0, 0);
        context.recycle();
    }

    private void resetContents()
    {
        removeAllViews();
        if (adapter != null)
        {
            int j = adapter.getCount();
            for (int i = 0; i < j; i++)
            {
                ViewGroup viewgroup = (ViewGroup)adapter.getView(i, null, this);
                if (viewgroup == null)
                {
                    continue;
                }
                viewgroup.setClickable(true);
                viewgroup.setOnClickListener(this);
                viewgroup.setTag(0x7f0301c1, Integer.valueOf(i));
                viewgroup.setPadding(0, 4, 0, 4);
                addView(viewgroup);
                if (dividerId != 0 && j > 1 && i < j - 1)
                {
                    addView(inflater.inflate(dividerId, this, false));
                }
            }

        }
    }

    public TableViewAdapter getAdapter()
    {
        return adapter;
    }

    public void onClick(View view)
    {
        view = (Integer)view.getTag(0x7f0301c1);
        if (adapter != null && view != null)
        {
            adapter.itemClick(view.intValue());
        }
    }

    public void setAdapter(TableViewAdapter tableviewadapter)
    {
        if (adapter != null)
        {
            adapter.unregisterDataSetObserver(observer);
        }
        adapter = tableviewadapter;
        if (adapter != null)
        {
            observer = new TableViewObserver();
            adapter.registerDataSetObserver(observer);
        }
        resetContents();
    }

}
