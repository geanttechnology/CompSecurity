// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Looper;
import com.google.android.gms.drive.internal.zzy;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.android.gms.drive.events:
//            DriveEventService

class zzahD extends Thread
{

    final CountDownLatch zzahD;
    final DriveEventService zzahE;

    public void run()
    {
        Looper.prepare();
        zzahE.zzahB = new a(zzahE);
        zzahE.zzahC = false;
        zzahD.countDown();
        zzy.zzv("DriveEventService", "Bound and starting loop");
        Looper.loop();
        zzy.zzv("DriveEventService", "Finished loop");
        if (DriveEventService.zzb(zzahE) != null)
        {
            DriveEventService.zzb(zzahE).countDown();
        }
        return;
        Exception exception;
        exception;
        if (DriveEventService.zzb(zzahE) != null)
        {
            DriveEventService.zzb(zzahE).countDown();
        }
        throw exception;
    }

    a(DriveEventService driveeventservice, CountDownLatch countdownlatch)
    {
        zzahE = driveeventservice;
        zzahD = countdownlatch;
        super();
    }
}
