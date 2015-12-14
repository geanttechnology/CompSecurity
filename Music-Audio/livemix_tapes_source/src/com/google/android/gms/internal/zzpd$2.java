// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.nearby.connection.AppMetadata;

// Referenced classes of package com.google.android.gms.internal:
//            zzpd, zzpc

class eApiClient extends b
{

    final String val$name;
    final AppMetadata zzaJA;
    final long zzaJB;
    final zzl zzaJC;
    final zzpd zzaJD;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpc));
    }

    protected void zza(zzpc zzpc1)
        throws RemoteException
    {
        zzpc1.zza(this, val$name, zzaJA, zzaJB, zzaJC);
    }

    eApiClient(GoogleApiClient googleapiclient, String s, AppMetadata appmetadata, long l, zzl zzl)
    {
        zzaJD = final_zzpd1;
        val$name = s;
        zzaJA = appmetadata;
        zzaJB = l;
        zzaJC = zzl;
        super(googleapiclient, null);
    }
}
