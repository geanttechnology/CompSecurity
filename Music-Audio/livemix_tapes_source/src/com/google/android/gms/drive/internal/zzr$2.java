// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzr, zzt, CreateContentsRequest, zzal

class lient extends b
{

    final zzr zzaii;
    final int zzaij;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new CreateContentsRequest(zzaij), new h(this));
    }

    lient(zzr zzr1, GoogleApiClient googleapiclient, int i)
    {
        zzaii = zzr1;
        zzaij = i;
        super(googleapiclient);
    }
}
