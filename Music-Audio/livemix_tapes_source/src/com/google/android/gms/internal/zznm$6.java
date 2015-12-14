// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznm, zzmk, zzmv

class eApiClient extends a
{

    final zznm zzaoP;

    protected BleDevicesResult zzH(Status status)
    {
        return BleDevicesResult.zzP(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmk));
    }

    protected void zza(zzmk zzmk1)
        throws RemoteException
    {
        a a = new a(this, null);
        String s = zzmk1.getContext().getPackageName();
        ((zzmv)zzmk1.zzoA()).zza(new ListClaimedBleDevicesRequest(a, s));
    }

    protected Result zzb(Status status)
    {
        return zzH(status);
    }

    eApiClient(zznm zznm1, GoogleApiClient googleapiclient)
    {
        zzaoP = zznm1;
        super(googleapiclient);
    }
}
