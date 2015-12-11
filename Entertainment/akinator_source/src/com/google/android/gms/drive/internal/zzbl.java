// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzd, OnContentsResponse, zzv, OnDownloadProgressResponse

class zzbl extends zzd
{

    private final com.google.android.gms.internal.zzlb.zzb zzagy;
    private final com.google.android.gms.drive.DriveFile.DownloadProgressListener zzamp;

    zzbl(com.google.android.gms.internal.zzlb.zzb zzb, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
    {
        zzagy = zzb;
        zzamp = downloadprogresslistener;
    }

    public void zza(OnContentsResponse oncontentsresponse)
        throws RemoteException
    {
        Status status;
        if (oncontentsresponse.zzrw())
        {
            status = new Status(-1);
        } else
        {
            status = Status.zzabb;
        }
        zzagy.zzp(new zzs.zza(status, new zzv(oncontentsresponse.zzrv())));
    }

    public void zza(OnDownloadProgressResponse ondownloadprogressresponse)
        throws RemoteException
    {
        if (zzamp != null)
        {
            zzamp.onProgress(ondownloadprogressresponse.zzry(), ondownloadprogressresponse.zzrz());
        }
    }

    public void zzy(Status status)
        throws RemoteException
    {
        zzagy.zzp(new zzs.zza(status, null));
    }
}
