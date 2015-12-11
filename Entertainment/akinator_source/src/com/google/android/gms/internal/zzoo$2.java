// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzoo, zznn, zzny

class eApiClient extends a
{

    final zzoo zzarr;
    final String zzars;

    protected DataTypeResult zzI(Status status)
    {
        return DataTypeResult.zzR(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznn));
    }

    protected void zza(zznn zznn1)
        throws RemoteException
    {
        a a = new a(this, null);
        ((zzny)zznn1.zzpc()).zza(new DataTypeReadRequest(zzars, a));
    }

    protected Result zzb(Status status)
    {
        return zzI(status);
    }

    eApiClient(zzoo zzoo1, GoogleApiClient googleapiclient, String s)
    {
        zzarr = zzoo1;
        zzars = s;
        super(googleapiclient);
    }
}
