// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;

// Referenced classes of package org.lucasr.smoothie:
//            AsyncAbsListView, ItemManaged, ItemManager

public class AsyncGridView extends GridView
    implements AsyncAbsListView
{

    private final ItemManaged mItemManaged;

    public AsyncGridView(Context context)
    {
        this(context, null);
    }

    public AsyncGridView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AsyncGridView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mItemManaged = new ItemManaged(this);
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mItemManaged.cancelAllRequests();
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        super.setAdapter(mItemManaged.wrapAdapter(listadapter));
        mItemManaged.triggerUpdate();
    }

    public void setItemManager(ItemManager itemmanager)
    {
        mItemManaged.setItemManager(itemmanager);
    }

    public void setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
    {
        mItemManaged.setOnItemSelectedListener(onitemselectedlistener);
        if (!mItemManaged.hasItemManager())
        {
            super.setOnItemSelectedListener(onitemselectedlistener);
        }
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        mItemManaged.setOnScrollListener(onscrolllistener);
        if (!mItemManaged.hasItemManager())
        {
            super.setOnScrollListener(onscrolllistener);
        }
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        mItemManaged.setOnTouchListener(ontouchlistener);
        if (!mItemManaged.hasItemManager())
        {
            super.setOnTouchListener(ontouchlistener);
        }
    }
}
