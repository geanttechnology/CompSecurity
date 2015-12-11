// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzos, zznr, zzoc

class eApiClient extends c
{

    final zzos zzarG;
    final a zzarL;
    final zzj zzarM;
    final PendingIntent zzarN;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznr));
    }

    protected void zza(zznr zznr1)
        throws RemoteException
    {
        c c = new c(this, zzarL, null);
        ((zzoc)zznr1.zzpc()).zza(new SensorUnregistrationRequest(zzarM, zzarN, c));
    }

    protected Result zzb(Status status)
    {
        return zzd(status);
    }

    protected Status zzd(Status status)
    {
        return status;
    }

    eApiClient(zzos zzos1, GoogleApiClient googleapiclient, a a, zzj zzj, PendingIntent pendingintent)
    {
        zzarG = zzos1;
        zzarL = a;
        zzarM = zzj;
        zzarN = pendingintent;
        super(googleapiclient);
    }
}
