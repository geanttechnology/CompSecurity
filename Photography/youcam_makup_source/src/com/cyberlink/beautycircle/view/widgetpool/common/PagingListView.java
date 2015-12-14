// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.AbsListView;
import android.widget.ListView;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.perfectcorp.utility.e;

public class PagingListView extends ListView
    implements android.widget.AbsListView.OnScrollListener
{

    final Context a;
    private android.widget.AbsListView.OnScrollListener b;
    private int c;
    private int d;
    private boolean e;

    public PagingListView(Context context)
    {
        super(context);
        e = false;
        a = context;
        a();
    }

    public PagingListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = false;
        a = context;
        a();
    }

    public PagingListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        e = false;
        a = context;
        a();
    }

    private void a()
    {
        super.setOnScrollListener(this);
        c = (int)(a.getResources().getDisplayMetrics().density * 50F);
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1)
    {
        e = true;
        super.onOverScrolled(i, j, flag, flag1);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        d = j;
        if (b != null)
        {
            b.onScroll(abslistview, i, j, k);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (d > 0 && i == 0 && e)
        {
            com.perfectcorp.utility.e.a(new Object[] {
                "OverScroll Complete detected. Enable load next."
            });
            e = false;
            android.widget.ListAdapter listadapter = getAdapter();
            if (listadapter != null && (listadapter instanceof m))
            {
                ((m)listadapter).c(true);
            }
        }
        if (b != null)
        {
            b.onScrollStateChanged(abslistview, i);
        }
    }

    protected boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        return super.overScrollBy(i, j, k, l, i1, j1, k1, c, flag);
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        b = onscrolllistener;
    }
}
