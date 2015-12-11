// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.os.Handler;

// Referenced classes of package com.offerup.android.activities:
//            SplashActivity

final class hr
    implements Runnable
{

    private SplashActivity a;

    private hr(SplashActivity splashactivity)
    {
        a = splashactivity;
        super();
    }

    hr(SplashActivity splashactivity, byte byte0)
    {
        this(splashactivity);
    }

    public final void run()
    {
        if (SplashActivity.a(a) != null && SplashActivity.b(a))
        {
            SplashActivity.d(a).removeCallbacks(SplashActivity.c(a));
            SplashActivity.e(a);
        }
    }
}
