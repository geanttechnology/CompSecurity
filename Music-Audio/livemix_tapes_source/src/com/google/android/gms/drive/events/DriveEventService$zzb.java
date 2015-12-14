// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.RemoteException;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzy;

// Referenced classes of package com.google.android.gms.drive.events:
//            DriveEventService

final class zzahE extends com.google.android.gms.drive.internal.ahE
{

    final DriveEventService zzahE;

    public void zzc(OnEventResponse oneventresponse)
        throws RemoteException
    {
        DriveEventService driveeventservice = zzahE;
        driveeventservice;
        JVM INSTR monitorenter ;
        zzy.zzv("DriveEventService", (new StringBuilder()).append("onEvent: ").append(oneventresponse).toString());
        DriveEventService.zza(zzahE);
        if (zzahE.zzahB == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        oneventresponse = zza(zzahE.zzahB, oneventresponse);
        zzahE.zzahB.sendMessage(oneventresponse);
_L2:
        return;
        zzy.zzx("DriveEventService", "Receiving event before initialize is completed.");
        if (true) goto _L2; else goto _L1
_L1:
        oneventresponse;
        driveeventservice;
        JVM INSTR monitorexit ;
        throw oneventresponse;
    }

    (DriveEventService driveeventservice)
    {
        zzahE = driveeventservice;
        super();
    }
}
