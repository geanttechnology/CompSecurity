// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.query.Query;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzr, zzt, QueryRequest, zzal

class lient extends g
{

    final Query zzaih;
    final zzr zzaii;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new QueryRequest(zzaih), new i(this));
    }

    lient(zzr zzr1, GoogleApiClient googleapiclient, Query query)
    {
        zzaii = zzr1;
        zzaih = query;
        super(googleapiclient);
    }
}
