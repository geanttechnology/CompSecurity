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
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzos, zznr, zzou, zzoc

class eApiClient extends c
{

    final zzos zzarG;
    final SensorRequest zzarH;
    final zzj zzarI;
    final PendingIntent zzarJ;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznr));
    }

    protected void zza(zznr zznr1)
        throws RemoteException
    {
        zzou zzou1 = new zzou(this);
        ((zzoc)zznr1.zzpc()).zza(new SensorRegistrationRequest(zzarH, zzarI, zzarJ, zzou1));
    }

    protected Result zzb(Status status)
    {
        return zzd(status);
    }

    protected Status zzd(Status status)
    {
        return status;
    }

    eApiClient(zzos zzos1, GoogleApiClient googleapiclient, SensorRequest sensorrequest, zzj zzj, PendingIntent pendingintent)
    {
        zzarG = zzos1;
        zzarH = sensorrequest;
        zzarI = zzj;
        zzarJ = pendingintent;
        super(googleapiclient);
    }
}
