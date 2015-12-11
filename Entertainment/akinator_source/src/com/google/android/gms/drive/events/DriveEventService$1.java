// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Looper;
import com.google.android.gms.drive.internal.zzz;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.android.gms.drive.events:
//            DriveEventService

class zzajN extends Thread
{

    final CountDownLatch zzajN;
    final DriveEventService zzajO;

    public void run()
    {
        Looper.prepare();
        zzajO.zzajL = new a(zzajO);
        zzajO.zzajM = false;
        zzajN.countDown();
        zzz.zzx("DriveEventService", "Bound and starting loop");
        Looper.loop();
        zzz.zzx("DriveEventService", "Finished loop");
        if (DriveEventService.zzb(zzajO) != null)
        {
            DriveEventService.zzb(zzajO).countDown();
        }
        return;
        Exception exception;
        exception;
        if (DriveEventService.zzb(zzajO) != null)
        {
            DriveEventService.zzb(zzajO).countDown();
        }
        throw exception;
    }

    a(DriveEventService driveeventservice, CountDownLatch countdownlatch)
    {
        zzajO = driveeventservice;
        zzajN = countdownlatch;
        super();
    }
}
