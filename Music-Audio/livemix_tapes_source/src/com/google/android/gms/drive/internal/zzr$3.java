// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzr, zzt, GetMetadataRequest, zzal

class lient extends e
{

    final zzr zzaii;
    final String zzaik;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new GetMetadataRequest(DriveId.zzcC(zzaik), false), new c(this));
    }

    lient(zzr zzr1, GoogleApiClient googleapiclient, String s)
    {
        zzaii = zzr1;
        zzaik = s;
        super(googleapiclient);
    }
}
