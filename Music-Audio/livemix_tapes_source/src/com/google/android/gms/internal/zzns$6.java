// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzns, zzmq, zznt, zznb

class eApiClient extends c
{

    final PendingIntent zzapm;
    final zzns zzapt;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmq));
    }

    protected void zza(zzmq zzmq1)
        throws RemoteException
    {
        zznt zznt1 = new zznt(this);
        String s = zzmq1.getContext().getPackageName();
        ((zznb)zzmq1.zzoA()).zza(new SessionUnregistrationRequest(zzapm, zznt1, s));
    }

    eApiClient(zzns zzns1, GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        zzapt = zzns1;
        zzapm = pendingintent;
        super(googleapiclient);
    }
}
