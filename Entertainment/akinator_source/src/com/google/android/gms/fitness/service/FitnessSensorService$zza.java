// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.service:
//            FitnessSensorService, FitnessSensorServiceRequest

private static class <init> extends com.google.android.gms.fitness.internal.service.est
{

    private final FitnessSensorService zzato;

    public void zza(FitnessDataSourcesRequest fitnessdatasourcesrequest, zznv zznv1)
        throws RemoteException
    {
        zzato.zztv();
        zznv1.zza(new DataSourcesResult(zzato.onFindDataSources(fitnessdatasourcesrequest.getDataTypes()), Status.zzabb));
    }

    public void zza(FitnessUnregistrationRequest fitnessunregistrationrequest, zzoj zzoj1)
        throws RemoteException
    {
        zzato.zztv();
        if (zzato.onUnregister(fitnessunregistrationrequest.getDataSource()))
        {
            zzoj1.zzo(Status.zzabb);
            return;
        } else
        {
            zzoj1.zzo(new Status(13));
            return;
        }
    }

    public void zza(FitnessSensorServiceRequest fitnesssensorservicerequest, zzoj zzoj1)
        throws RemoteException
    {
        zzato.zztv();
        if (zzato.onRegister(fitnesssensorservicerequest))
        {
            zzoj1.zzo(Status.zzabb);
            return;
        } else
        {
            zzoj1.zzo(new Status(13));
            return;
        }
    }

    private st(FitnessSensorService fitnesssensorservice)
    {
        zzato = fitnesssensorservice;
    }

    zzato(FitnessSensorService fitnesssensorservice, zzato zzato1)
    {
        this(fitnesssensorservice);
    }
}
