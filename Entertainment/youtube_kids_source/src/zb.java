// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.SplashScreenActivity;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class zb
    implements mj
{

    private SplashScreenActivity a;

    public zb(SplashScreenActivity splashscreenactivity)
    {
        a = splashscreenactivity;
        super();
    }

    public final void a(Object obj)
    {
        obj = (bqv)obj;
        if (SplashScreenActivity.a(a).getCount() > 0L)
        {
            SplashScreenActivity.b(a).f.set(obj);
            SplashScreenActivity.a(a).countDown();
        }
    }

    public final void a(mp mp)
    {
        if (SplashScreenActivity.a(a).getCount() > 0L)
        {
            SplashScreenActivity.a(a).countDown();
        }
    }
}
