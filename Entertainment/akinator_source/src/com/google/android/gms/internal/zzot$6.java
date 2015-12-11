// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzot, zzns, zzou, zzod

class eApiClient extends c
{

    final PendingIntent zzarJ;
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
        ((zzod)zzns1.zzpc()).zza(new SessionUnregistrationRequest(zzarJ, zzou1));
    }

    eApiClient(zzot zzot1, GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        zzarQ = zzot1;
        zzarJ = pendingintent;
        super(googleapiclient);
    }
}
