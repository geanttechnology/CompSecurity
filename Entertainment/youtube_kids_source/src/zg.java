// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.google.android.apps.youtube.kids.activities.SplashScreenActivity;
import java.util.concurrent.CountDownLatch;

public final class zg
    implements Runnable
{

    final SplashScreenActivity a;

    public zg(SplashScreenActivity splashscreenactivity)
    {
        a = splashscreenactivity;
        super();
    }

    public final void run()
    {
        Exception exception;
        try
        {
            SplashScreenActivity.a(a).await();
        }
        catch (InterruptedException interruptedexception)
        {
            SplashScreenActivity.e(a).post(new zh(this));
            return;
        }
        finally
        {
            SplashScreenActivity.e(a).post(new zh(this));
        }
        SplashScreenActivity.e(a).post(new zh(this));
        return;
        throw exception;
    }
}
