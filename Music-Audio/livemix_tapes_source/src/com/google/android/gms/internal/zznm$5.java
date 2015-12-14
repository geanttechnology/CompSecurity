// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznm, zzmk, zznt, zzmv

class eApiClient extends c
{

    final zznm zzaoP;
    final String zzaoR;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmk));
    }

    protected void zza(zzmk zzmk1)
        throws RemoteException
    {
        zznt zznt1 = new zznt(this);
        String s = zzmk1.getContext().getPackageName();
        ((zzmv)zzmk1.zzoA()).zza(new UnclaimBleDeviceRequest(zzaoR, zznt1, s));
    }

    eApiClient(zznm zznm1, GoogleApiClient googleapiclient, String s)
    {
        zzaoP = zznm1;
        zzaoR = s;
        super(googleapiclient);
    }
}
