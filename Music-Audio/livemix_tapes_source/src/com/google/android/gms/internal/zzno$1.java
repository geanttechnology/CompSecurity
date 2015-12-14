// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataInsertRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzno, zzmm, zznt, zzmx

class eApiClient extends c
{

    final DataSet zzaoW;
    final boolean zzaoX;
    final zzno zzaoY;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmm));
    }

    protected void zza(zzmm zzmm1)
        throws RemoteException
    {
        zznt zznt1 = new zznt(this);
        String s = zzmm1.getContext().getPackageName();
        ((zzmx)zzmm1.zzoA()).zza(new DataInsertRequest(zzaoW, zznt1, s, zzaoX));
    }

    eApiClient(zzno zzno1, GoogleApiClient googleapiclient, DataSet dataset, boolean flag)
    {
        zzaoY = zzno1;
        zzaoW = dataset;
        zzaoX = flag;
        super(googleapiclient);
    }
}
