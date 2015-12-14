// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;

// Referenced classes of package com.google.android.gms.internal:
//            zzpq

class eApiClient extends c
{

    final zzpq zzaLF;
    final Moment zzaLK;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzaLK);
    }

    eApiClient(zzpq zzpq1, GoogleApiClient googleapiclient, Moment moment)
    {
        zzaLF = zzpq1;
        zzaLK = moment;
        super(googleapiclient, null);
    }
}
