// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.PopupWindow;

// Referenced classes of package android.support.v7.widget:
//            s

private final class <init>
    implements android.widget.istView.OnScrollListener
{

    final s a;

    public final void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public final void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 1 && !a.f() && s.b(a).getContentView() != null)
        {
            s.d(a).removeCallbacks(s.c(a));
            s.c(a).run();
        }
    }

    private crollListener(s s1)
    {
        a = s1;
        super();
    }

    a(s s1, byte byte0)
    {
        this(s1);
    }
}
