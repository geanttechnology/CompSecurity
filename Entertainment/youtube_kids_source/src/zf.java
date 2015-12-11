// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.SplashScreenActivity;
import java.util.concurrent.CountDownLatch;

public final class zf
    implements Runnable
{

    private SplashScreenActivity a;

    public zf(SplashScreenActivity splashscreenactivity)
    {
        a = splashscreenactivity;
        super();
    }

    public final void run()
    {
        for (; SplashScreenActivity.a(a).getCount() > 0L; SplashScreenActivity.a(a).countDown()) { }
    }
}
