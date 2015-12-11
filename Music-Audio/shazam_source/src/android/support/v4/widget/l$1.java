// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.v4.widget:
//            l, h, b

final class a
    implements android.view.animation.ation.AnimationListener
{

    final l a;

    public final void onAnimationEnd(Animation animation)
    {
        if (l.a(a))
        {
            l.b(a).setAlpha(255);
            l.b(a).start();
            if (l.c(a) && l.d(a) != null)
            {
                l.d(a).a();
            }
        } else
        {
            l.b(a).stop();
            l.e(a).setVisibility(8);
            l.f(a);
            if (l.g(a))
            {
                l.a(a, 0.0F);
            } else
            {
                l.a(a, a.c - l.h(a), true);
            }
        }
        l.a(a, l.e(a).getTop());
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    on(l l1)
    {
        a = l1;
        super();
    }
}
