// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;

final class w
    implements android.view.animation.Animation.AnimationListener
{

    private j a;
    private t b;

    w(t t1, j j1)
    {
        b = t1;
        a = j1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (a.e != null)
        {
            a.e = null;
            b.a(a, a.f, 0, 0, false);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
