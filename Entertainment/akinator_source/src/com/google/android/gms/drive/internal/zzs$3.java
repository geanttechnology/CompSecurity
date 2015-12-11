// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs, zzu, GetMetadataRequest, zzam

class lient extends e
{

    final zzs zzakv;
    final String zzakx;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzu1.zzrm().zza(new GetMetadataRequest(DriveId.zzcB(zzakx), false), new c(this));
    }

    lient(zzs zzs1, GoogleApiClient googleapiclient, String s)
    {
        zzakv = zzs1;
        zzakx = s;
        super(googleapiclient);
    }
}
