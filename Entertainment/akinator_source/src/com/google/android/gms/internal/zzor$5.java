// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.request.UnsubscribeRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzor, zznq, zzou, zzob

class eApiClient extends c
{

    final zzor zzarC;
    final DataSource zzarE;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznq));
    }

    protected void zza(zznq zznq1)
        throws RemoteException
    {
        zzou zzou1 = new zzou(this);
        ((zzob)zznq1.zzpc()).zza(new UnsubscribeRequest(null, zzarE, zzou1));
    }

    eApiClient(zzor zzor1, GoogleApiClient googleapiclient, DataSource datasource)
    {
        zzarC = zzor1;
        zzarE = datasource;
        super(googleapiclient);
    }
}
