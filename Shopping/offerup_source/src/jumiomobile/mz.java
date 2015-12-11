// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ValueAnimator;
import android.graphics.Paint;

// Referenced classes of package jumiomobile:
//            mw

class mz
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final mw a;

    mz(mw mw1)
    {
        a = mw1;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        valueanimator = (Integer)valueanimator.getAnimatedValue("color");
        mw.a(a).setColor(valueanimator.intValue());
        a.invalidate();
    }
}
