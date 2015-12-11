// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DisableFitRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzoo, zznn, zzou, zzny

class eApiClient extends c
{

    final zzoo zzarr;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznn));
    }

    protected void zza(zznn zznn1)
        throws RemoteException
    {
        zzou zzou1 = new zzou(this);
        ((zzny)zznn1.zzpc()).zza(new DisableFitRequest(zzou1));
    }

    eApiClient(zzoo zzoo1, GoogleApiClient googleapiclient)
    {
        zzarr = zzoo1;
        super(googleapiclient);
    }
}
