// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.view.animation.Animation;

// Referenced classes of package com.picsart.studio.view:
//            SwipeRefreshLayout

final class a
    implements Runnable
{

    private SwipeRefreshLayout a;

    public final void run()
    {
        SwipeRefreshLayout.h(a);
        if (SwipeRefreshLayout.e(a) != null)
        {
            SwipeRefreshLayout.a(a, SwipeRefreshLayout.k(a));
            SwipeRefreshLayout.m(a).setDuration(SwipeRefreshLayout.l(a));
            SwipeRefreshLayout.m(a).setAnimationListener(SwipeRefreshLayout.n(a));
            SwipeRefreshLayout.m(a).reset();
            SwipeRefreshLayout.m(a).setInterpolator(SwipeRefreshLayout.o(a));
            a.startAnimation(SwipeRefreshLayout.m(a));
        }
        SwipeRefreshLayout.a(a, SwipeRefreshLayout.i(a) + a.getPaddingTop(), SwipeRefreshLayout.j(a));
    }

    (SwipeRefreshLayout swiperefreshlayout)
    {
        a = swiperefreshlayout;
        super();
    }
}
