// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.internal.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzpq

class eApiClient extends b
{

    final zzpq zzaLF;
    final String zzaLL;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zzej(zzaLL);
        zza(((com.google.android.gms.common.api.Result) (Status.zzaaD)));
    }

    eApiClient(zzpq zzpq1, GoogleApiClient googleapiclient, String s)
    {
        zzaLF = zzpq1;
        zzaLL = s;
        super(googleapiclient, null);
    }
}
