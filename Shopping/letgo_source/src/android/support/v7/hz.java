// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public abstract class hz extends android.support.v7.widget.RecyclerView.OnScrollListener
{

    private int a;
    private int b;
    private boolean c;
    private int d;

    public hz()
    {
        a = 0;
        b = 0;
        c = true;
        d = 0;
    }

    public abstract void a(int i, int j);

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        super.onScrollStateChanged(recyclerview, i);
    }

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        super.onScrolled(recyclerview, i, j);
        recyclerview = (StaggeredGridLayoutManager)recyclerview.getLayoutManager();
        i = recyclerview.getChildCount();
        j = recyclerview.getItemCount();
        int k = recyclerview.findFirstVisibleItemPositions(new int[recyclerview.getSpanCount()])[0];
        if (j < b)
        {
            a = d;
            b = j;
            if (j == 0)
            {
                c = true;
            }
        }
        if (c && j > b)
        {
            c = false;
            b = j;
            a = a + 1;
        }
        if (!c && j - i <= k + 6)
        {
            a(a + 1, j);
            c = true;
        }
    }
}
