// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.zzf;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzq, zze

class zzaHO extends com.google.android.gms.location.places.a
{

    final int zzaHN;
    final int zzaHO;
    final zzq zzaHP;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zze)b);
    }

    protected void zza(zze zze1)
        throws RemoteException
    {
        zze1.zza(new zzf(this), zzq.zza(zzaHP), zzaHN, zzaHO, zzq.zzb(zzaHP));
    }

    (zzq zzq1, com.google.android.gms.common.api.c c, GoogleApiClient googleapiclient, int i, int j)
    {
        zzaHP = zzq1;
        zzaHN = i;
        zzaHO = j;
        super(c, googleapiclient);
    }
}
