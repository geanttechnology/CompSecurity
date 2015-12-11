// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.RemoteException;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzz;

// Referenced classes of package com.google.android.gms.drive.events:
//            DriveEventService

final class zzajO extends com.google.android.gms.drive.internal.ajO
{

    final DriveEventService zzajO;

    public void zzc(OnEventResponse oneventresponse)
        throws RemoteException
    {
        DriveEventService driveeventservice = zzajO;
        driveeventservice;
        JVM INSTR monitorenter ;
        zzz.zzx("DriveEventService", (new StringBuilder()).append("onEvent: ").append(oneventresponse).toString());
        DriveEventService.zza(zzajO);
        if (zzajO.zzajL == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        oneventresponse = zza(zzajO.zzajL, oneventresponse);
        zzajO.zzajL.sendMessage(oneventresponse);
_L2:
        return;
        zzz.zzz("DriveEventService", "Receiving event before initialize is completed.");
        if (true) goto _L2; else goto _L1
_L1:
        oneventresponse;
        driveeventservice;
        JVM INSTR monitorexit ;
        throw oneventresponse;
    }

    (DriveEventService driveeventservice)
    {
        zzajO = driveeventservice;
        super();
    }
}
