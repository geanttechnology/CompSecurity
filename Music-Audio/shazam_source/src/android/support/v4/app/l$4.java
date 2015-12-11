// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.animation.Animation;

// Referenced classes of package android.support.v4.app:
//            l, Fragment

final class a
    implements android.view.animation.ation.AnimationListener
{

    final Fragment a;
    final l b;

    public final void onAnimationEnd(Animation animation)
    {
        if (a.l != null)
        {
            a.l = null;
            b.a(a, a.m, 0, 0, false);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    ment(l l1, Fragment fragment)
    {
        b = l1;
        a = fragment;
        super();
    }
}
