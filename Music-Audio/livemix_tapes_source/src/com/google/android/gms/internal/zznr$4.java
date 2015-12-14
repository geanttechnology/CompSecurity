// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznr, zzmp, zzna

class eApiClient extends c
{

    final zznr zzapj;
    final a zzapo;
    final zzj zzapp;
    final PendingIntent zzapq;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmp));
    }

    protected void zza(zzmp zzmp1)
        throws RemoteException
    {
        c c = new c(this, zzapo, null);
        String s = zzmp1.getContext().getPackageName();
        ((zzna)zzmp1.zzoA()).zza(new SensorUnregistrationRequest(zzapp, zzapq, c, s));
    }

    protected Result zzb(Status status)
    {
        return zzd(status);
    }

    protected Status zzd(Status status)
    {
        return status;
    }

    eApiClient(zznr zznr1, GoogleApiClient googleapiclient, a a, zzj zzj, PendingIntent pendingintent)
    {
        zzapj = zznr1;
        zzapo = a;
        zzapp = zzj;
        zzapq = pendingintent;
        super(googleapiclient);
    }
}
