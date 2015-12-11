// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.PopupWindow;

final class lg
    implements android.widget.AbsListView.OnScrollListener
{

    private kx a;

    lg(kx kx1)
    {
        a = kx1;
        super();
    }

    public final void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public final void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 1 && !a.d() && kx.b(a).getContentView() != null)
        {
            kx.d(a).removeCallbacks(kx.c(a));
            kx.c(a).run();
        }
    }
}
