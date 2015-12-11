// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;

final class blq
    implements android.view.animation.Animation.AnimationListener
{

    private blp a;

    blq(blp blp1)
    {
        a = blp1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        a.a();
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
