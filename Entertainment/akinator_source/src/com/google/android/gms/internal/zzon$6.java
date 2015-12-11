// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzon, zznm, zznx

class eApiClient extends a
{

    final zzon zzarm;

    protected BleDevicesResult zzH(Status status)
    {
        return BleDevicesResult.zzP(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznm));
    }

    protected void zza(zznm zznm1)
        throws RemoteException
    {
        a a = new a(this, null);
        ((zznx)zznm1.zzpc()).zza(new ListClaimedBleDevicesRequest(a));
    }

    protected Result zzb(Status status)
    {
        return zzH(status);
    }

    eApiClient(zzon zzon1, GoogleApiClient googleapiclient)
    {
        zzarm = zzon1;
        super(googleapiclient);
    }
}
