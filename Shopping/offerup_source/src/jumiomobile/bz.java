// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package jumiomobile:
//            by

class bz
    implements android.view.animation.Animation.AnimationListener
{

    final by a;

    bz(by by1)
    {
        a = by1;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        by.a(a);
        if (by.b(a) < by.c())
        {
            by.d(a).startAnimation(by.c(a));
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
