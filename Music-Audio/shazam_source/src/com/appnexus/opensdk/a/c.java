// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.a;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

// Referenced classes of package com.appnexus.opensdk.a:
//            g

public final class c
    implements g
{

    private Animation a;
    private Animation b;

    public c(long l)
    {
        AccelerateInterpolator accelerateinterpolator = new AccelerateInterpolator();
        a = new AlphaAnimation(0.0F, 1.0F);
        a.setDuration(l);
        a.setInterpolator(accelerateinterpolator);
        b = new AlphaAnimation(1.0F, 0.0F);
        b.setDuration(l);
        b.setInterpolator(accelerateinterpolator);
    }

    public final Animation a()
    {
        return a;
    }

    public final Animation b()
    {
        return b;
    }
}
