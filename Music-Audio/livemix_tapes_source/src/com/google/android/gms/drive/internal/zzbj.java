// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzd, OnContentsResponse, zzu, OnDownloadProgressResponse

class zzbj extends zzd
{

    private final com.google.android.gms.common.api.zzc.zzb zzQz;
    private final com.google.android.gms.drive.DriveFile.DownloadProgressListener zzajW;

    zzbj(com.google.android.gms.common.api.zzc.zzb zzb, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
    {
        zzQz = zzb;
        zzajW = downloadprogresslistener;
    }

    public void zza(OnContentsResponse oncontentsresponse)
        throws RemoteException
    {
        Status status;
        if (oncontentsresponse.zzqO())
        {
            status = new Status(-1);
        } else
        {
            status = Status.zzaaD;
        }
        zzQz.zzn(new zzr.zza(status, new zzu(oncontentsresponse.zzqN())));
    }

    public void zza(OnDownloadProgressResponse ondownloadprogressresponse)
        throws RemoteException
    {
        if (zzajW != null)
        {
            zzajW.onProgress(ondownloadprogressresponse.zzqQ(), ondownloadprogressresponse.zzqR());
        }
    }

    public void zzy(Status status)
        throws RemoteException
    {
        zzQz.zzn(new zzr.zza(status, null));
    }
}
