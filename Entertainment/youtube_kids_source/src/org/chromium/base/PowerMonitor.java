// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

public class PowerMonitor
    implements ApplicationStatus.ApplicationStateListener
{

    private static final Runnable c = new _cls1();
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper());

    PowerMonitor()
    {
    }

    static void a()
    {
        nativeOnMainActivitySuspended();
    }

    public static void a(Intent intent)
    {
    }

    private static boolean isBatteryPower()
    {
        throw new NullPointerException();
    }

    private static native void nativeOnBatteryChargingChanged();

    private static native void nativeOnMainActivityResumed();

    private static native void nativeOnMainActivitySuspended();

    public final void a(int i)
    {
        if (i == 1)
        {
            b.removeCallbacks(c);
            nativeOnMainActivityResumed();
        } else
        if (i == 2)
        {
            b.postDelayed(c, 60000L);
            return;
        }
    }


    private class _cls1
        implements Runnable
    {

        public final void run()
        {
            PowerMonitor.a();
        }

        _cls1()
        {
        }
    }

}
