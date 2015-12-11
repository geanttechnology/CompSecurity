// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.view;

import android.animation.ValueAnimator;

// Referenced classes of package com.braintreepayments.cardform.view:
//            c

final class e
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private c a;

    e(c c1)
    {
        a = c1;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        c.a(a, ((Integer)valueanimator.getAnimatedValue()).intValue());
        a.invalidate();
    }
}
