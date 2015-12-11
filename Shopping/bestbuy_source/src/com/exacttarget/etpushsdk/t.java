// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.os.SystemClock;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.m;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETException, ETPush

final class t
    implements Runnable
{

    final Activity a;

    t(Activity activity)
    {
        a = activity;
        super();
    }

    public void run()
    {
        Integer integer = Integer.valueOf(a.hashCode());
        m.a("~!ETPush", String.format("%1$d resuming started...", new Object[] {
            integer
        }));
        ETPush.c();
        m.a("~!ETPush", String.format("Set Alarm for %d seconds from now to handle background work.", new Object[] {
            Long.valueOf(15L)
        }));
        android.app.PendingIntent pendingintent = ETPush.e();
        ETPush.t().set(2, SystemClock.elapsedRealtime() + 15000L, pendingintent);
        m.a("~!ETPush", "Save time for onResume() to determine if in foreground.");
        d.a(ETPush.a(), "pause_time_key", Long.valueOf(System.currentTimeMillis()));
        m.a("~!ETPush", String.format("%1$d pausing done...", new Object[] {
            integer
        }));
        ETPush.u().countDown();
        return;
        Object obj;
        obj;
        m.c("~!ETPush", ((ETException) (obj)).getMessage(), ((Throwable) (obj)));
        ETPush.u().countDown();
        return;
        obj;
        ETPush.u().countDown();
        throw obj;
    }
}
