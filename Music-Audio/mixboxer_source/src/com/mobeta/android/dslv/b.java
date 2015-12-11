// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            e, DragSortListView

final class b extends e
{

    private float b;
    private float c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private DragSortListView i;

    public b(DragSortListView dragsortlistview, float f1, int j)
    {
        i = dragsortlistview;
        super(dragsortlistview, 0.5F, j);
        e = -1;
        f = -1;
    }

    public final void a()
    {
        float f1;
        int j;
        j = -1;
        e = -1;
        f = -1;
        g = DragSortListView.k(i);
        h = DragSortListView.l(i);
        DragSortListView.a(i, 1);
        b = DragSortListView.d(i).x;
        if (!DragSortListView.m(i))
        {
            break MISSING_BLOCK_LABEL_194;
        }
        f1 = (float)i.getWidth() * 2.0F;
        if (DragSortListView.n(i) != 0.0F) goto _L2; else goto _L1
_L1:
        DragSortListView dragsortlistview = i;
        if (b >= 0.0F)
        {
            j = 1;
        }
        DragSortListView.a(dragsortlistview, (float)j * f1);
_L4:
        return;
_L2:
        f1 *= 2.0F;
        if (DragSortListView.n(i) < 0.0F && DragSortListView.n(i) > -f1)
        {
            DragSortListView.a(i, -f1);
            return;
        }
        if (DragSortListView.n(i) <= 0.0F || DragSortListView.n(i) >= f1) goto _L4; else goto _L3
_L3:
        DragSortListView.a(i, f1);
        return;
        DragSortListView.o(i);
        return;
    }

    public final void a(float f1)
    {
        View view;
        int i1;
        f1 = 1.0F - f1;
        i1 = i.getFirstVisiblePosition();
        view = i.getChildAt(g - i1);
        if (!DragSortListView.m(i)) goto _L2; else goto _L1
_L1:
        float f2 = (float)(SystemClock.uptimeMillis() - a) / 1000F;
        if (f2 != 0.0F) goto _L4; else goto _L3
_L3:
        return;
_L4:
        float f3 = DragSortListView.n(i);
        int j1 = i.getWidth();
        DragSortListView dragsortlistview = i;
        int j;
        if (DragSortListView.n(i) > 0.0F)
        {
            j = 1;
        } else
        {
            j = -1;
        }
        DragSortListView.b(dragsortlistview, (float)j * f2 * (float)j1);
        b = b + f3 * f2;
        DragSortListView.d(i).x = (int)b;
        if (b < (float)j1 && b > (float)(-j1))
        {
            a = SystemClock.uptimeMillis();
            DragSortListView.a(i, true);
            return;
        }
_L2:
        if (view != null)
        {
            if (e == -1)
            {
                e = DragSortListView.b(i, g, view, false);
                c = view.getHeight() - e;
            }
            int k = Math.max((int)(c * f1), 1);
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            layoutparams.height = k + e;
            view.setLayoutParams(layoutparams);
        }
        if (h != g)
        {
            View view1 = i.getChildAt(h - i1);
            if (view1 != null)
            {
                if (f == -1)
                {
                    f = DragSortListView.b(i, h, view1, false);
                    d = view1.getHeight() - f;
                }
                int l = Math.max((int)(d * f1), 1);
                android.view.ViewGroup.LayoutParams layoutparams1 = view1.getLayoutParams();
                layoutparams1.height = l + f;
                view1.setLayoutParams(layoutparams1);
                return;
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final void b()
    {
        DragSortListView.p(i);
    }
}
