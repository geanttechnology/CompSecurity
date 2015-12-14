// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.n;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;

public abstract class b
    implements android.widget.AbsListView.OnScrollListener, n, d
{

    private int a;
    private int b;
    private float c;
    private float d;
    private View e;

    public b()
    {
        a = 0;
        b = 0;
        c = 0.0F;
        d = 0.0F;
        e = null;
    }

    private void a(ViewGroup viewgroup)
    {
        int i = a;
        int j = b;
        View view = e;
        float f = c;
        float f1 = d;
        if (viewgroup.getChildCount() > 0)
        {
            e = viewgroup.getChildAt(0);
            c = e.getX();
            d = e.getY();
            if (e == view)
            {
                a = a + (int)(f - c);
                b = b + (int)(f1 - d);
                a(null, a, b, i, j);
                return;
            }
        }
    }

    public void a(PLA_AbsListView pla_abslistview, int i)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 43
    //                   1 48
    //                   2 38;
           goto _L1 _L2 _L3 _L4
_L1:
        a((ObservableScrollView)null, i);
        return;
_L4:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 1;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(PLA_AbsListView pla_abslistview, int i, int j, int k)
    {
        a(((ViewGroup) (pla_abslistview)));
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        a(abslistview);
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 43
    //                   1 48
    //                   2 38;
           goto _L1 _L2 _L3 _L4
_L1:
        a((ObservableScrollView)null, i);
        return;
_L4:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 1;
        if (true) goto _L1; else goto _L5
_L5:
    }
}
