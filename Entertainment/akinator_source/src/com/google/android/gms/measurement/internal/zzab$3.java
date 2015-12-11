// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzab, zzp, zzn, zzm

class zzaOs
    implements Runnable
{

    final zzab zzaOs;

    public void run()
    {
        zzm zzm1 = zzab.zzc(zzaOs);
        if (zzm1 == null)
        {
            zzaOs.zzyd().zzzK().zzec("Discarding data. Failed to send app launch");
            return;
        }
        try
        {
            zzm1.zza(zzaOs.zzzo().zzzG());
            zzab.zzd(zzaOs);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzaOs.zzyd().zzzK().zzj("Failed to send app launch to AppMeasurementService", remoteexception);
        }
    }

    (zzab zzab1)
    {
        zzaOs = zzab1;
        super();
    }
}
