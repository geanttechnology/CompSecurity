// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            e, DragSortListView

final class m extends e
{

    private int b;
    private int c;
    private float d;
    private float e;
    private DragSortListView f;

    public m(DragSortListView dragsortlistview, float f1, int i)
    {
        f = dragsortlistview;
        super(dragsortlistview, 0.5F, i);
    }

    private int e()
    {
        int i = f.getFirstVisiblePosition();
        int j = (DragSortListView.h(f) + f.getDividerHeight()) / 2;
        View view = f.getChildAt(b - i);
        if (view != null)
        {
            if (b == c)
            {
                return view.getTop();
            }
            if (b < c)
            {
                return view.getTop() - j;
            } else
            {
                return (view.getBottom() + j) - DragSortListView.i(f);
            }
        } else
        {
            d();
            return -1;
        }
    }

    public final void a()
    {
        b = DragSortListView.f(f);
        c = DragSortListView.g(f);
        DragSortListView.a(f, 2);
        d = DragSortListView.d(f).y - e();
        e = DragSortListView.d(f).x - f.getPaddingLeft();
    }

    public final void a(float f1)
    {
        int i = e();
        int j = f.getPaddingLeft();
        float f2 = DragSortListView.d(f).y - i;
        float f3 = DragSortListView.d(f).x - j;
        f1 = 1.0F - f1;
        if (f1 < Math.abs(f2 / d) || f1 < Math.abs(f3 / e))
        {
            DragSortListView.d(f).y = i + (int)(d * f1);
            DragSortListView.d(f).x = f.getPaddingLeft() + (int)(e * f1);
            DragSortListView.a(f, true);
        }
    }

    public final void b()
    {
        DragSortListView.j(f);
    }
}
