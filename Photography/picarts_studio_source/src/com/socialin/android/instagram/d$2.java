// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.widget.AbsListView;
import android.widget.GridView;

// Referenced classes of package com.socialin.android.instagram:
//            d

final class a
    implements android.widget.istView.OnScrollListener
{

    private d a;

    public final void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (!d.a(a) && d.b(a).getAdapter() != null && (i + j) - 1 == d.b(a).getCount() - 1)
        {
            d.c(a);
        }
    }

    public final void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    Listener(d d1)
    {
        a = d1;
        super();
    }
}
