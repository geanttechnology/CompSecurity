// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.SubscribeRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzor, zznq, zzou, zzob

class eApiClient extends c
{

    final zzor zzarC;
    final Subscription zzarD;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznq));
    }

    protected void zza(zznq zznq1)
        throws RemoteException
    {
        zzou zzou1 = new zzou(this);
        ((zzob)zznq1.zzpc()).zza(new SubscribeRequest(zzarD, false, zzou1));
    }

    eApiClient(zzor zzor1, GoogleApiClient googleapiclient, Subscription subscription)
    {
        zzarC = zzor1;
        zzarD = subscription;
        super(googleapiclient);
    }
}
