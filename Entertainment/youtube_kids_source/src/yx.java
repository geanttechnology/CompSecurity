// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;

final class yx
    implements android.view.animation.Animation.AnimationListener
{

    private int a;
    private yw b;

    yx(yw yw1, int i)
    {
        b = yw1;
        a = i;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        yw.a(b, a - 1);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
