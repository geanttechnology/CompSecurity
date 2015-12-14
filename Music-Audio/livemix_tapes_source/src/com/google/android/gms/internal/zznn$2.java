// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznn, zzml, zzmw

class eApiClient extends a
{

    final zznn zzaoU;
    final String zzaoV;

    protected DataTypeResult zzI(Status status)
    {
        return DataTypeResult.zzS(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzml));
    }

    protected void zza(zzml zzml1)
        throws RemoteException
    {
        a a = new a(this, null);
        String s = zzml1.getContext().getPackageName();
        ((zzmw)zzml1.zzoA()).zza(new DataTypeReadRequest(zzaoV, a, s));
    }

    protected Result zzb(Status status)
    {
        return zzI(status);
    }

    eApiClient(zznn zznn1, GoogleApiClient googleapiclient, String s)
    {
        zzaoU = zznn1;
        zzaoV = s;
        super(googleapiclient);
    }
}
