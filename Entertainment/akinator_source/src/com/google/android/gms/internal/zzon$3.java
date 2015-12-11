// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzon, zznm, zzou, zznx

class eApiClient extends c
{

    final zzon zzarm;
    final String zzaro;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznm));
    }

    protected void zza(zznm zznm1)
        throws RemoteException
    {
        zzou zzou1 = new zzou(this);
        ((zznx)zznm1.zzpc()).zza(new ClaimBleDeviceRequest(zzaro, null, zzou1));
    }

    eApiClient(zzon zzon1, GoogleApiClient googleapiclient, String s)
    {
        zzarm = zzon1;
        zzaro = s;
        super(googleapiclient);
    }
}
