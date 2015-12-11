// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.result.SessionStopResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzot, zzns, zzod

class eApiClient extends a
{

    final String val$name;
    final zzot zzarQ;
    final String zzarR;

    protected SessionStopResult zzN(Status status)
    {
        return SessionStopResult.zzU(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzns));
    }

    protected void zza(zzns zzns1)
        throws RemoteException
    {
        b b = new b(this, null);
        ((zzod)zzns1.zzpc()).zza(new SessionStopRequest(val$name, zzarR, b));
    }

    protected Result zzb(Status status)
    {
        return zzN(status);
    }

    eApiClient(GoogleApiClient googleapiclient, String s, String s1)
    {
        zzarQ = final_zzot1;
        val$name = s;
        zzarR = s1;
        super(googleapiclient);
    }
}
