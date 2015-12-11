// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.wishabi.flipp.app:
//            bd, FlyerActivity

final class be
    implements android.view.animation.Animation.AnimationListener
{

    final bd a;

    be(bd bd1)
    {
        a = bd1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (FlyerActivity.c(a.a) != null)
        {
            FlyerActivity.c(a.a).setVisibility(4);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
