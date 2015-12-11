// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;


// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzab, zzp, zzm

class zzaOv
    implements Runnable
{

    final zzm zzaOv;
    final zzaOv zzaOw;

    public void run()
    {
        if (!zzaOw.aOs.isConnected())
        {
            zzaOw.aOs.zzyd().zzzP().c("Connected to service");
            zzab.zza(zzaOw.aOs, zzaOv);
        }
    }

    ( , zzm zzm)
    {
        zzaOw = ;
        zzaOv = zzm;
        super();
    }
}
