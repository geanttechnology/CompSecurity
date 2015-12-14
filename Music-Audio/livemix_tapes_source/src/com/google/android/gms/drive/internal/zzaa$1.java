// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzaa, zzt, GetMetadataRequest, zzal

class ient extends d
{

    final boolean zzaja;
    final zzaa zzajb;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzt));
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new GetMetadataRequest(zzajb.zzags, zzaja), new b(this));
    }

    ient(zzaa zzaa1, GoogleApiClient googleapiclient, boolean flag)
    {
        zzajb = zzaa1;
        zzaja = flag;
        super(zzaa1, googleapiclient, null);
    }
}
