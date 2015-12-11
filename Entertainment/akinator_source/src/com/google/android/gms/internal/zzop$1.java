// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataInsertRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzop, zzno, zzou, zznz

class eApiClient extends c
{

    final DataSet zzart;
    final boolean zzaru;
    final zzop zzarv;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzno));
    }

    protected void zza(zzno zzno1)
        throws RemoteException
    {
        zzou zzou1 = new zzou(this);
        ((zznz)zzno1.zzpc()).zza(new DataInsertRequest(zzart, zzou1, zzaru));
    }

    eApiClient(zzop zzop1, GoogleApiClient googleapiclient, DataSet dataset, boolean flag)
    {
        zzarv = zzop1;
        zzart = dataset;
        zzaru = flag;
        super(googleapiclient);
    }
}
