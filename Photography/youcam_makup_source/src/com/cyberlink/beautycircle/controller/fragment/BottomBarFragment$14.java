// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment, b

class d
    implements android.widget.istener
{

    final BottomBarFragment a;
    private boolean b;
    private int c;
    private float d;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        boolean flag = false;
        for (Iterator iterator = BottomBarFragment.a(a).iterator(); iterator.hasNext(); ((b)iterator.next()).onScroll(abslistview, i, j, k)) { }
        float f;
        if (b && j > 0)
        {
            if ((f = abslistview.getChildAt(0).getY()) < 0.0F)
            {
                if (c == i)
                {
                    BottomBarFragment.a(a, f - d);
                }
                if (BottomBarFragment.b(a).containsKey(abslistview) || BottomBarFragment.c(a).containsKey(abslistview))
                {
                    View view = (View)BottomBarFragment.b(a).get(abslistview);
                    View view1 = (View)BottomBarFragment.c(a).get(abslistview);
                    if (i < ((ListView)abslistview).getHeaderViewsCount() + 1)
                    {
                        BottomBarFragment.a(a, false);
                    } else
                    {
                        flag = true;
                    }
                    a.a(view, view1, flag);
                }
                c = i;
                d = f;
                return;
            }
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        for (Iterator iterator = BottomBarFragment.a(a).iterator(); iterator.hasNext(); ((b)iterator.next()).onScrollStateChanged(abslistview, i)) { }
        if (i == 0)
        {
            b = false;
            BottomBarFragment.b(a, false);
        } else
        if (abslistview != null)
        {
            b = true;
            c = abslistview.getFirstVisiblePosition();
            abslistview = abslistview.getChildAt(0);
            float f;
            if (abslistview != null)
            {
                f = abslistview.getY();
            } else
            {
                f = 0.0F;
            }
            d = f;
            return;
        }
    }

    I(BottomBarFragment bottombarfragment)
    {
        a = bottombarfragment;
        super();
        b = false;
        c = -1;
        d = -1F;
    }
}
