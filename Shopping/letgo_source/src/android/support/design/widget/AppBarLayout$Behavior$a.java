// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.ah;
import android.support.v4.widget.o;

// Referenced classes of package android.support.design.widget:
//            AppBarLayout, CoordinatorLayout

private class c
{

    final c a;
    private final CoordinatorLayout b;
    private final AppBarLayout c;

    public void a()
    {
        if (c != null && c(a) != null && a(a).g())
        {
            a.a(b, c, c(a).c());
            ah.a(c, this);
        }
    }

    ( , CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout)
    {
        a = ;
        super();
        b = coordinatorlayout;
        c = appbarlayout;
    }
}
