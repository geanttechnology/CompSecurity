// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;

// Referenced classes of package myobfuscated.cx:
//            d

final class e
    implements android.widget.AbsListView.OnScrollListener
{

    private int a;
    private d b;

    private e(d d1)
    {
        b = d1;
        super();
        a = -1;
    }

    e(d d1, byte byte0)
    {
        this(d1);
    }

    public final void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (a == 2 || a == 1)
        {
            d.b(b, j / 2 + i);
        }
        if (!d.g(b) && !d.h(b))
        {
            if (d.f(b) != null && d.f(b).getAdapter() != null)
            {
                k = d.f(b).getAdapter().getCount();
            } else
            {
                k = 0;
            }
            if ((i + j) - 1 == k - 1)
            {
                d.i(b);
            }
        }
    }

    public final void onScrollStateChanged(AbsListView abslistview, int i)
    {
        a = i;
    }
}
