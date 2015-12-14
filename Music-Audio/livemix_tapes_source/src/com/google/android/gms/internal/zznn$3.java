// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DisableFitRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznn, zzml, zznt, zzmw

class eApiClient extends c
{

    final zznn zzaoU;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzml));
    }

    protected void zza(zzml zzml1)
        throws RemoteException
    {
        zznt zznt1 = new zznt(this);
        String s = zzml1.getContext().getPackageName();
        ((zzmw)zzml1.zzoA()).zza(new DisableFitRequest(zznt1, s));
    }

    eApiClient(zznn zznn1, GoogleApiClient googleapiclient)
    {
        zzaoU = zznn1;
        super(googleapiclient);
    }
}
