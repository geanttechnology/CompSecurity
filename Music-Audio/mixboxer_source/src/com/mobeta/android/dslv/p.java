// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.SystemClock;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView, o

final class p
    implements Runnable
{

    private boolean a;
    private long b;
    private long c;
    private int d;
    private float e;
    private long f;
    private int g;
    private float h;
    private boolean i;
    private DragSortListView j;

    public p(DragSortListView dragsortlistview)
    {
        j = dragsortlistview;
        super();
        i = false;
    }

    public final void a(int k)
    {
        if (!i)
        {
            a = false;
            i = true;
            f = SystemClock.uptimeMillis();
            b = f;
            g = k;
            j.post(this);
        }
    }

    public final void a(boolean flag)
    {
        j.removeCallbacks(this);
        i = false;
    }

    public final boolean a()
    {
        return i;
    }

    public final int b()
    {
        if (i)
        {
            return g;
        } else
        {
            return -1;
        }
    }

    public final void run()
    {
        if (a)
        {
            i = false;
            return;
        }
        int l = j.getFirstVisiblePosition();
        int k = j.getLastVisiblePosition();
        int j1 = j.getCount();
        int i1 = j.getPaddingTop();
        int k1 = j.getHeight() - i1 - j.getPaddingBottom();
        int l1 = Math.min(DragSortListView.e(j), DragSortListView.q(j) + DragSortListView.c(j));
        int i2 = Math.max(DragSortListView.e(j), DragSortListView.q(j) - DragSortListView.c(j));
        View view1;
        if (g == 0)
        {
            View view = j.getChildAt(0);
            if (view == null)
            {
                i = false;
                return;
            }
            if (l == 0 && view.getTop() == i1)
            {
                i = false;
                return;
            }
            h = DragSortListView.t(j).a((DragSortListView.r(j) - (float)i2) / DragSortListView.s(j));
        } else
        {
            View view2 = j.getChildAt(k - l);
            if (view2 == null)
            {
                i = false;
                return;
            }
            if (k == j1 - 1 && view2.getBottom() <= k1 + i1)
            {
                i = false;
                return;
            }
            h = -DragSortListView.t(j).a(((float)l1 - DragSortListView.u(j)) / DragSortListView.v(j));
        }
        c = SystemClock.uptimeMillis();
        e = c - b;
        d = Math.round(h * e);
        if (d >= 0)
        {
            d = Math.min(k1, d);
            k = l;
        } else
        {
            d = Math.max(-k1, d);
        }
        view1 = j.getChildAt(k - l);
        j1 = view1.getTop() + d;
        l = j1;
        if (k == 0)
        {
            l = j1;
            if (j1 > i1)
            {
                l = i1;
            }
        }
        DragSortListView.b(j, true);
        j.setSelectionFromTop(k, l - i1);
        j.layoutChildren();
        j.invalidate();
        DragSortListView.b(j, false);
        DragSortListView.c(j, k, view1, false);
        b = c;
        j.post(this);
    }
}
