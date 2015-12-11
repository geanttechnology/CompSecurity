// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ValueAnimator;
import android.widget.ScrollView;

// Referenced classes of package jumiomobile:
//            kt

class ky
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final kt a;

    ky(kt kt1)
    {
        a = kt1;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        kt.e(a).setBackgroundColor(((Integer)valueanimator.getAnimatedValue()).intValue());
    }
}
