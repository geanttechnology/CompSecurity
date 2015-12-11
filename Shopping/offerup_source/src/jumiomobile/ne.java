// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ValueAnimator;

// Referenced classes of package jumiomobile:
//            nd

class ne
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final nd a;

    ne(nd nd1)
    {
        a = nd1;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        nd.a(a, 1.0F - ((Float)valueanimator.getAnimatedValue()).floatValue());
        a.b = a.a * nd.a(a);
        a.postInvalidate();
    }
}
