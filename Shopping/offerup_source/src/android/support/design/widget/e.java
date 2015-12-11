// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.bi;
import android.support.v4.widget.au;

// Referenced classes of package android.support.design.widget:
//            CoordinatorLayout, AppBarLayout

final class e
    implements Runnable
{

    private final CoordinatorLayout a;
    private final AppBarLayout b;
    private AppBarLayout.Behavior c;

    e(AppBarLayout.Behavior behavior, CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout)
    {
        c = behavior;
        super();
        a = coordinatorlayout;
        b = appbarlayout;
    }

    public final void run()
    {
        if (b != null && AppBarLayout.Behavior.a(c) != null && AppBarLayout.Behavior.a(c).g())
        {
            c.a(a, b, AppBarLayout.Behavior.a(c).c());
            bi.a(b, this);
        }
    }
}
