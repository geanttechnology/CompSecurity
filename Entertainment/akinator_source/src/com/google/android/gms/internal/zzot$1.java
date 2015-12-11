// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionStartRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzot, zzns, zzou, zzod

class eApiClient extends c
{

    final Session zzarP;
    final zzot zzarQ;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzns));
    }

    protected void zza(zzns zzns1)
        throws RemoteException
    {
        zzou zzou1 = new zzou(this);
        ((zzod)zzns1.zzpc()).zza(new SessionStartRequest(zzarP, zzou1));
    }

    eApiClient(zzot zzot1, GoogleApiClient googleapiclient, Session session)
    {
        zzarQ = zzot1;
        zzarP = session;
        super(googleapiclient);
    }
}
