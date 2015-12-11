// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ValueAnimator;

// Referenced classes of package jumiomobile:
//            mw

class my
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final mw a;

    my(mw mw1)
    {
        a = mw1;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        valueanimator = (Integer)valueanimator.getAnimatedValue("sweepAngle");
        mw.b(a, valueanimator.intValue());
        a.invalidate();
    }
}
