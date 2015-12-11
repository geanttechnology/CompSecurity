// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.animation.ValueAnimator;

// Referenced classes of package android.support.design.widget:
//            bp, bs

final class bt
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private bp a;

    bt(bs bs, bp bp1)
    {
        a = bp1;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.a();
    }
}
