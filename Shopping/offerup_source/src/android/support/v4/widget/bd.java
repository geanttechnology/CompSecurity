// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.v4.widget:
//            SwipeRefreshLayout

final class bd
    implements android.view.animation.Animation.AnimationListener
{

    private SwipeRefreshLayout a;

    bd(SwipeRefreshLayout swiperefreshlayout)
    {
        a = swiperefreshlayout;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (!SwipeRefreshLayout.f(a))
        {
            SwipeRefreshLayout.a(a, null);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
