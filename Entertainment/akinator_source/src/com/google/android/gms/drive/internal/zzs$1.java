// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.query.Query;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs, zzu, QueryRequest, zzam

class lient extends g
{

    final Query zzaku;
    final zzs zzakv;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzu1.zzrm().zza(new QueryRequest(zzaku), new i(this));
    }

    lient(zzs zzs1, GoogleApiClient googleapiclient, Query query)
    {
        zzakv = zzs1;
        zzaku = query;
        super(googleapiclient);
    }
}
