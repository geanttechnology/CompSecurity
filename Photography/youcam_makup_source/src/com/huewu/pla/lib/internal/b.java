// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.view.View;
import android.widget.OverScroller;

// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AbsListView

class b
    implements Runnable
{

    final PLA_AbsListView a;
    private final OverScroller b;
    private int c;

    b(PLA_AbsListView pla_abslistview)
    {
        a = pla_abslistview;
        super();
        b = new OverScroller(pla_abslistview.getContext());
    }

    void a()
    {
        a.v = -1;
        a.removeCallbacks(this);
        a.g(0);
        PLA_AbsListView.c(a);
        b.abortAnimation();
    }

    void a(int i)
    {
        int j;
        if (i < 0)
        {
            j = 0x7fffffff;
        } else
        {
            j = 0;
        }
        c = j;
        b.fling(0, j, 0, i, 0, 0x7fffffff, 0, 0x7fffffff);
        a.v = 4;
        a.postOnAnimation(this);
    }

    void a(int i, int j)
    {
        int k;
        if (i < 0)
        {
            k = 0x7fffffff;
        } else
        {
            k = 0;
        }
        c = k;
        b.startScroll(0, k, 0, i, j);
        a.v = 4;
        a.postOnAnimation(this);
    }

    public void run()
    {
        a.v;
        JVM INSTR tableswitch 3 4: default 28
    //                   3 33
    //                   4 43;
           goto _L1 _L2 _L3
_L1:
        a();
_L4:
        return;
_L2:
        if (b.isFinished()) goto _L4; else goto _L3
_L3:
        if (a.Q)
        {
            a.d();
        }
        if (a.V == 0 || a.getChildCount() == 0)
        {
            a();
            return;
        }
        OverScroller overscroller = b;
        boolean flag = overscroller.computeScrollOffset();
        int j = overscroller.getCurrY();
        int i = c - j;
        boolean flag1;
        if (i > 0)
        {
            a.q = a.E;
            View view = a.getChildAt(0);
            a.r = view.getTop();
            i = Math.min(a.getHeight() - a.getPaddingBottom() - a.getPaddingTop() - 1, i);
        } else
        {
            int k = a.getChildCount() - 1;
            a.q = a.E + k;
            View view1 = a.getChildAt(k);
            a.r = view1.getTop();
            i = Math.max(-(a.getHeight() - a.getPaddingBottom() - a.getPaddingTop() - 1), i);
        }
        flag1 = a.d(i, i);
        if (flag1 && i != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag && i == 0)
        {
            if (flag1)
            {
                a.invalidate();
            }
            c = j;
            a.postOnAnimation(this);
            return;
        } else
        {
            a();
            return;
        }
    }
}
