// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.result.SessionStopResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzns, zzmq, zznb

class eApiClient extends a
{

    final String val$name;
    final zzns zzapt;
    final String zzapu;

    protected SessionStopResult zzN(Status status)
    {
        return SessionStopResult.zzV(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmq));
    }

    protected void zza(zzmq zzmq1)
        throws RemoteException
    {
        b b = new b(this, null);
        String s = zzmq1.getContext().getPackageName();
        ((zznb)zzmq1.zzoA()).zza(new SessionStopRequest(val$name, zzapu, b, s));
    }

    protected Result zzb(Status status)
    {
        return zzN(status);
    }

    eApiClient(GoogleApiClient googleapiclient, String s, String s1)
    {
        zzapt = final_zzns1;
        val$name = s;
        zzapu = s1;
        super(googleapiclient);
    }
}
