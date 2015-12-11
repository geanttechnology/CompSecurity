// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.SplashScreenActivity;
import java.util.concurrent.CountDownLatch;

final class ze
    implements Runnable
{

    private zd a;

    ze(zd zd1)
    {
        a = zd1;
        super();
    }

    public final void run()
    {
        SplashScreenActivity.a(a.a).countDown();
    }
}
