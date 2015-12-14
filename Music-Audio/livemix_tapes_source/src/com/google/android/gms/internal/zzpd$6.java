// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzpd, zzpc

class eApiClient extends c
{

    final zzpd zzaJD;
    final String zzaJl;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpc));
    }

    protected void zza(zzpc zzpc1)
        throws RemoteException
    {
        zzpc1.zzp(this, zzaJl);
    }

    eApiClient(zzpd zzpd1, GoogleApiClient googleapiclient, String s)
    {
        zzaJD = zzpd1;
        zzaJl = s;
        super(googleapiclient, null);
    }
}
