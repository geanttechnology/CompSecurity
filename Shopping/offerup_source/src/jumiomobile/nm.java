// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ValueAnimator;

// Referenced classes of package jumiomobile:
//            nl

class nm
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final nl a;

    nm(nl nl1)
    {
        a = nl1;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.postInvalidate();
    }
}
