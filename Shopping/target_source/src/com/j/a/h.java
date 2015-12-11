// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a;

import android.widget.AbsListView;
import com.j.a.d.e;
import com.j.a.g.o;
import org.json.JSONException;

public class h
    implements android.widget.AbsListView.OnScrollListener
{

    android.widget.AbsListView.OnScrollListener a;
    private int b;
    private int c;

    public h(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        b = -1;
        c = -1;
        a = onscrolllistener;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        try
        {
            int l = abslistview.getLastVisiblePosition();
            if (e.e().i() && (i != b || l != c))
            {
                b = i;
                c = l;
                o.c(abslistview);
            }
        }
        catch (JSONException jsonexception) { }
        if (a != null)
        {
            a.onScroll(abslistview, i, j, k);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (a != null)
        {
            a.onScrollStateChanged(abslistview, i);
        }
    }
}
