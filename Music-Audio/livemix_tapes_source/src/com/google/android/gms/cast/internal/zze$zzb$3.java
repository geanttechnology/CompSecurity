// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;


// Referenced classes of package com.google.android.gms.cast.internal:
//            zze, ApplicationStatus

class zzXp
    implements Runnable
{

    final zze zzXl;
    final zzXp zzXn;
    final ApplicationStatus zzXp;

    public void run()
    {
        zze.zza(zzXl, zzXp);
    }

    nStatus(nStatus nstatus, zze zze1, ApplicationStatus applicationstatus)
    {
        zzXn = nstatus;
        zzXl = zze1;
        zzXp = applicationstatus;
        super();
    }
}
