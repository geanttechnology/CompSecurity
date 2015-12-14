// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.SubscribeRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznq, zzmo, zznt, zzmz

class eApiClient extends c
{

    final zznq zzapf;
    final Subscription zzapg;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmo));
    }

    protected void zza(zzmo zzmo1)
        throws RemoteException
    {
        zznt zznt1 = new zznt(this);
        String s = zzmo1.getContext().getPackageName();
        ((zzmz)zzmo1.zzoA()).zza(new SubscribeRequest(zzapg, false, zznt1, s));
    }

    eApiClient(zznq zznq1, GoogleApiClient googleapiclient, Subscription subscription)
    {
        zzapf = zznq1;
        zzapg = subscription;
        super(googleapiclient);
    }
}
