// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzu, zzt, CloseContentsRequest, zzbr, 
//            zzal

class lient extends a
{

    final zzu zzaiG;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new CloseContentsRequest(zzu.zza(zzaiG).getRequestId(), false), new zzbr(this));
    }

    lient(zzu zzu1, GoogleApiClient googleapiclient)
    {
        zzaiG = zzu1;
        super(googleapiclient);
    }
}
