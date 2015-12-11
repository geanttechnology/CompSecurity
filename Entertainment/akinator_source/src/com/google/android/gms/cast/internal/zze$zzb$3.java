// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;


// Referenced classes of package com.google.android.gms.cast.internal:
//            zze, ApplicationStatus

class zzZh
    implements Runnable
{

    final zze zzZd;
    final zzZh zzZf;
    final ApplicationStatus zzZh;

    public void run()
    {
        zze.zza(zzZd, zzZh);
    }

    nStatus(nStatus nstatus, zze zze1, ApplicationStatus applicationstatus)
    {
        zzZf = nstatus;
        zzZd = zze1;
        zzZh = applicationstatus;
        super();
    }
}
