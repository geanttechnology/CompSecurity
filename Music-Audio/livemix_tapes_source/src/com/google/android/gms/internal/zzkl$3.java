// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzkl, zzkm

class eApiClient extends b
{

    final zzkl zzXZ;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzkm));
    }

    protected void zza(zzkm zzkm1)
        throws RemoteException
    {
        zzkm1.zza(new b.zzb(this));
    }

    eApiClient(zzkl zzkl1, GoogleApiClient googleapiclient)
    {
        zzXZ = zzkl1;
        super(zzkl1, googleapiclient);
    }
}
