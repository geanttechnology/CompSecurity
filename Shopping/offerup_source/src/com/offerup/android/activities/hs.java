// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;


// Referenced classes of package com.offerup.android.activities:
//            SplashActivity

final class hs
    implements Runnable
{

    private SplashActivity a;

    private hs(SplashActivity splashactivity)
    {
        a = splashactivity;
        super();
    }

    hs(SplashActivity splashactivity, byte byte0)
    {
        this(splashactivity);
    }

    public final void run()
    {
        SplashActivity.e(a);
    }
}
