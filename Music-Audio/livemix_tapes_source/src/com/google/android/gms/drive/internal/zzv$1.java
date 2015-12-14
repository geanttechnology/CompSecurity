// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzv, zzt, OpenContentsRequest, zzbj, 
//            zzal, DriveServiceResponse

class lient extends b
{

    final com.google.android.gms.drive.ile.DownloadProgressListener zzaiJ;
    final zzv zzaiK;
    final int zzaij;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zza(zzt1.zzqF().zza(new OpenContentsRequest(zzaiK.getDriveId(), zzaij, 0), new zzbj(this, zzaiJ)).zzqJ());
    }

    lient(zzv zzv1, GoogleApiClient googleapiclient, int i, com.google.android.gms.drive.ile.DownloadProgressListener downloadprogresslistener)
    {
        zzaiK = zzv1;
        zzaij = i;
        zzaiJ = downloadprogresslistener;
        super(googleapiclient);
    }
}
