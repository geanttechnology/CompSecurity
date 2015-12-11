// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzor, zznq, zzob

class eApiClient extends a
{

    final zzor zzarC;

    protected ListSubscriptionsResult zzL(Status status)
    {
        return ListSubscriptionsResult.zzS(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznq));
    }

    protected void zza(zznq zznq1)
        throws RemoteException
    {
        a a = new a(this, null);
        ((zzob)zznq1.zzpc()).zza(new ListSubscriptionsRequest(null, a));
    }

    protected Result zzb(Status status)
    {
        return zzL(status);
    }

    eApiClient(zzor zzor1, GoogleApiClient googleapiclient)
    {
        zzarC = zzor1;
        super(googleapiclient);
    }
}
