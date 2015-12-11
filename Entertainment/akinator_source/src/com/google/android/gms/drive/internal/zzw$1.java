// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzw, zzu, OpenContentsRequest, zzbl, 
//            zzam, DriveServiceResponse

class lient extends b
{

    final com.google.android.gms.drive.ile.DownloadProgressListener zzakX;
    final zzw zzakY;
    final int zzakw;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zza(zzu1.zzrm().zza(new OpenContentsRequest(zzakY.getDriveId(), zzakw, 0), new zzbl(this, zzakX)).zzrr());
    }

    lient(zzw zzw1, GoogleApiClient googleapiclient, int i, com.google.android.gms.drive.ile.DownloadProgressListener downloadprogresslistener)
    {
        zzakY = zzw1;
        zzakw = i;
        zzakX = downloadprogresslistener;
        super(googleapiclient);
    }
}
