// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznq, zzmo, zzmz

class eApiClient extends a
{

    final zznq zzapf;

    protected ListSubscriptionsResult zzL(Status status)
    {
        return ListSubscriptionsResult.zzT(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmo));
    }

    protected void zza(zzmo zzmo1)
        throws RemoteException
    {
        a a = new a(this, null);
        String s = zzmo1.getContext().getPackageName();
        ((zzmz)zzmo1.zzoA()).zza(new ListSubscriptionsRequest(null, a, s));
    }

    protected Result zzb(Status status)
    {
        return zzL(status);
    }

    eApiClient(zznq zznq1, GoogleApiClient googleapiclient)
    {
        zzapf = zznq1;
        super(googleapiclient);
    }
}
