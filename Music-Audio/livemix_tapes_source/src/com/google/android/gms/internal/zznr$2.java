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
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznr, zzmp, zznt, zzna

class eApiClient extends c
{

    final zznr zzapj;
    final SensorRequest zzapk;
    final zzj zzapl;
    final PendingIntent zzapm;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmp));
    }

    protected void zza(zzmp zzmp1)
        throws RemoteException
    {
        zznt zznt1 = new zznt(this);
        String s = zzmp1.getContext().getPackageName();
        ((zzna)zzmp1.zzoA()).zza(new SensorRegistrationRequest(zzapk, zzapl, zzapm, zznt1, s));
    }

    protected Result zzb(Status status)
    {
        return zzd(status);
    }

    protected Status zzd(Status status)
    {
        return status;
    }

    eApiClient(zznr zznr1, GoogleApiClient googleapiclient, SensorRequest sensorrequest, zzj zzj, PendingIntent pendingintent)
    {
        zzapj = zznr1;
        zzapk = sensorrequest;
        zzapl = zzj;
        zzapm = pendingintent;
        super(googleapiclient);
    }
}
