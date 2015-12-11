// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.Activity;
import com.exacttarget.etpushsdk.event.BackgroundEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.m;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETException, ETPush

final class v
    implements Runnable
{

    final Activity a;

    v(Activity activity)
    {
        a = activity;
        super();
    }

    public void run()
    {
        Integer integer;
        long l;
        long l1;
        m.a("~!ETPush", "activityResume thread started");
        ETPush.c();
        integer = Integer.valueOf(a.hashCode());
        m.a("~!ETPush", String.format("%1$d resuming started...", new Object[] {
            integer
        }));
        com.exacttarget.etpushsdk.ETPush.d();
        l = System.currentTimeMillis();
        l1 = ((Long)d.a(ETPush.a(), "pause_time_key", Long.valueOf(-1L), new Object[0])).longValue();
        m.a("~!ETPush", String.format("Current time: %d Pause time: %d", new Object[] {
            Long.valueOf(l), Long.valueOf(l1)
        }));
        if (l1 != -1L && l - l1 <= 10000L)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        m.a("~!ETPush", String.format("%d will notify that app came into foreground...", new Object[] {
            integer
        }));
        EventBus.getInstance().b(new BackgroundEvent(false));
        if (l1 == -1L)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        d.a(ETPush.a(), "pause_time_key");
        m.a("~!ETPush", String.format("%s removed", new Object[] {
            "pause_time_key"
        }));
        m.a("~!ETPush", String.format("%d resuming done...", new Object[] {
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
