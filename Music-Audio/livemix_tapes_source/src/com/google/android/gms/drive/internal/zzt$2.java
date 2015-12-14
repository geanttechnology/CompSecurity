// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzt, RemoveEventListenerRequest, zzbr, zzal, 
//            zzad

class lient extends a
{

    final zzad zzaiA;
    final zzt zzaiB;
    final DriveId zzaix;
    final int zzaiy;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzt1.zzqF().zza(new RemoveEventListenerRequest(zzaix, zzaiy), zzaiA, null, new zzbr(this));
    }

    lient(zzt zzt1, GoogleApiClient googleapiclient, DriveId driveid, int i, zzad zzad)
    {
        zzaiB = zzt1;
        zzaix = driveid;
        zzaiy = i;
        zzaiA = zzad;
        super(googleapiclient);
    }
}
