// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.service:
//            FitnessSensorService, FitnessSensorServiceRequest

private static class <init> extends com.google.android.gms.fitness.internal.service.est
{

    private final FitnessSensorService zzaqQ;

    public void zza(FitnessDataSourcesRequest fitnessdatasourcesrequest, zzmt zzmt1)
        throws RemoteException
    {
        zzaqQ.zzsI();
        zzmt1.zza(new DataSourcesResult(zzaqQ.onFindDataSources(fitnessdatasourcesrequest.getDataTypes()), Status.zzaaD));
    }

    public void zza(FitnessUnregistrationRequest fitnessunregistrationrequest, zznh zznh1)
        throws RemoteException
    {
        zzaqQ.zzsI();
        if (zzaqQ.onUnregister(fitnessunregistrationrequest.getDataSource()))
        {
            zznh1.zzr(Status.zzaaD);
            return;
        } else
        {
            zznh1.zzr(new Status(13));
            return;
        }
    }

    public void zza(FitnessSensorServiceRequest fitnesssensorservicerequest, zznh zznh1)
        throws RemoteException
    {
        zzaqQ.zzsI();
        if (zzaqQ.onRegister(fitnesssensorservicerequest))
        {
            zznh1.zzr(Status.zzaaD);
            return;
        } else
        {
            zznh1.zzr(new Status(13));
            return;
        }
    }

    private st(FitnessSensorService fitnesssensorservice)
    {
        zzaqQ = fitnesssensorservice;
    }

    zzaqQ(FitnessSensorService fitnesssensorservice, zzaqQ zzaqq)
    {
        this(fitnesssensorservice);
    }
}
