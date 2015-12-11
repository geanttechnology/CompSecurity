// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class RecyclerViewWithEmpty extends RecyclerView
{

    private View a;
    private final android.support.v7.widget.RecyclerView.AdapterDataObserver b;

    public RecyclerViewWithEmpty(Context context)
    {
        this(context, null);
    }

    public RecyclerViewWithEmpty(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RecyclerViewWithEmpty(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = new android.support.v7.widget.RecyclerView.AdapterDataObserver() {

            final RecyclerViewWithEmpty a;

            public void onChanged()
            {
                a.a();
            }

            public void onItemRangeInserted(int j, int k)
            {
                a.a();
            }

            public void onItemRangeRemoved(int j, int k)
            {
                a.a();
            }

            
            {
                a = RecyclerViewWithEmpty.this;
                super();
            }
        };
    }

    void a()
    {
        byte byte1 = 8;
        byte byte0 = 1;
        if (a != null && getAdapter() != null)
        {
            View view;
            int i;
            if (getAdapter().getItemCount() > 1)
            {
                byte0 = 0;
            }
            view = a;
            if (byte0 != 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
            if (byte0 != 0)
            {
                byte0 = byte1;
            } else
            {
                byte0 = 0;
            }
            setVisibility(byte0);
        }
    }

    public void setAdapter(android.support.v7.widget.RecyclerView.Adapter adapter)
    {
        android.support.v7.widget.RecyclerView.Adapter adapter1 = getAdapter();
        if (adapter1 != null)
        {
            adapter1.unregisterAdapterDataObserver(b);
        }
        super.setAdapter(adapter);
        if (adapter != null)
        {
            adapter.registerAdapterDataObserver(b);
        }
        a();
    }

    public void setEmptyView(View view)
    {
        if (a != null)
        {
            a.setVisibility(8);
        }
        a = view;
        a();
    }
}
