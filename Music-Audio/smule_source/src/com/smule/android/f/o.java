// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.smule.android.network.core.b;
import java.util.concurrent.TimeUnit;

public class o
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private static String a = com/smule/android/f/o.getSimpleName();
    private static long b;
    private int c;
    private long d;
    private long e;

    public o()
    {
        c = 0;
        d = 0L;
        e = b;
    }

    static String a()
    {
        return a;
    }

    private void b()
    {
        com.smule.android.network.core.b.a(new Runnable() {

            final o a;

            public void run()
            {
                Log.i(o.a(), "Starting a new session.");
                com.smule.android.network.core.b.a().a(true);
            }

            
            {
                a = o.this;
                super();
            }
        });
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
    }

    public void onActivityResumed(Activity activity)
    {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        c = c + 1;
        long l = System.currentTimeMillis() / 1000L;
        if (c == 1 && d > 0L)
        {
            Log.i(a, (new StringBuilder()).append("Application came back from background at ").append(l).append(".").toString());
            if (l > d + e)
            {
                b();
            }
        }
    }

    public void onActivityStopped(Activity activity)
    {
        c = c - 1;
        if (c == 0)
        {
            d = System.currentTimeMillis() / 1000L;
            Log.i(a, (new StringBuilder()).append("Application went to background at ").append(d).append(".").toString());
        }
    }

    static 
    {
        b = TimeUnit.MINUTES.toSeconds(10L);
    }
}
