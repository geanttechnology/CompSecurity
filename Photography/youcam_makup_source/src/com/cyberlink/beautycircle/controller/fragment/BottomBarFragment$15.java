// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment, b

class d
    implements d
{

    public boolean a;
    final BottomBarFragment b;
    private int c;
    private float d;

    public void a(PLA_AbsListView pla_abslistview, int i)
    {
        b.a = true;
        for (Iterator iterator = BottomBarFragment.a(b).iterator(); iterator.hasNext(); ((b)iterator.next()).a(pla_abslistview, i)) { }
        if (i == 0)
        {
            a = false;
            BottomBarFragment.b(b, false);
        } else
        if (pla_abslistview != null)
        {
            a = true;
            c = pla_abslistview.getFirstVisiblePosition();
            pla_abslistview = pla_abslistview.getChildAt(0);
            float f;
            if (pla_abslistview != null)
            {
                f = pla_abslistview.getY();
            } else
            {
                f = 0.0F;
            }
            d = f;
            return;
        }
    }

    public void a(PLA_AbsListView pla_abslistview, int i, int j, int k)
    {
        boolean flag = false;
        for (Iterator iterator = BottomBarFragment.a(b).iterator(); iterator.hasNext(); ((b)iterator.next()).a(pla_abslistview, i, j, k)) { }
        float f;
        if (a && j > 0)
        {
            if ((f = pla_abslistview.getChildAt(0).getY()) < 0.0F)
            {
                if (c == i)
                {
                    BottomBarFragment.a(b, f - d);
                }
                if (BottomBarFragment.b(b).containsKey(pla_abslistview) || BottomBarFragment.c(b).containsKey(pla_abslistview))
                {
                    View view = (View)BottomBarFragment.b(b).get(pla_abslistview);
                    View view1 = (View)BottomBarFragment.c(b).get(pla_abslistview);
                    if (i < ((CLMultiColumnListView)pla_abslistview).getHeaderViewsCount())
                    {
                        BottomBarFragment.a(b, false);
                    } else
                    {
                        flag = true;
                    }
                    b.a(view, view1, flag);
                }
                c = i;
                d = f;
                return;
            }
        }
    }

    iew(BottomBarFragment bottombarfragment)
    {
        b = bottombarfragment;
        super();
        a = false;
        c = -1;
        d = -1F;
    }
}
