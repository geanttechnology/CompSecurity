// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.widget.AbsListView;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.bumptech.glide:
//            i, k, f, g, 
//            j

public final class e
    implements android.widget.AbsListView.OnScrollListener
{

    private final int a = 5;
    private final i b = new i(6);
    private final k c;
    private final f d;
    private final g e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;

    public e(k k1, f f1, g g1, int l)
    {
        j = true;
        c = k1;
        d = f1;
        e = g1;
    }

    private void a(int l, boolean flag)
    {
        if (j != flag)
        {
            j = flag;
            for (int i1 = 0; i1 < a; i1++)
            {
                c.a(b.a(0, 0));
            }

        }
        int j1;
        int k1;
        int l1;
        if (flag)
        {
            j1 = a;
        } else
        {
            j1 = -a;
        }
        j1 = l + j1;
        if (l < j1)
        {
            k1 = Math.max(f, l);
            l1 = j1;
        } else
        {
            l1 = Math.min(g, l);
            k1 = j1;
        }
        l1 = Math.min(i, l1);
        k1 = Math.min(i, Math.max(0, k1));
        if (l < j1)
        {
            for (l = k1; l < l1; l++)
            {
                a(d.a(l), l, true);
            }

        } else
        {
            for (l = l1 - 1; l >= k1; l--)
            {
                a(d.a(l), l, false);
            }

        }
        g = k1;
        f = l1;
    }

    private void a(Object obj)
    {
        Object obj1 = e;
        if (((g) (obj1)).a == null)
        {
            obj1 = null;
        } else
        {
            obj1 = Arrays.copyOf(((g) (obj1)).a, ((g) (obj1)).a.length);
        }
        if (obj1 != null)
        {
            d.a(obj).a(b.a(obj1[0], obj1[1]));
        }
    }

    private void a(List list, int l, boolean flag)
    {
        int i1 = list.size();
        if (flag)
        {
            for (l = 0; l < i1; l++)
            {
                a(list.get(l));
            }

        } else
        {
            for (l = i1 - 1; l >= 0; l--)
            {
                a(list.get(l));
            }

        }
    }

    public final void onScroll(AbsListView abslistview, int l, int i1, int j1)
    {
        i = j1;
        if (l <= h) goto _L2; else goto _L1
_L1:
        a(l + i1, true);
_L4:
        h = l;
        return;
_L2:
        if (l < h)
        {
            a(l, false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void onScrollStateChanged(AbsListView abslistview, int l)
    {
    }
}
