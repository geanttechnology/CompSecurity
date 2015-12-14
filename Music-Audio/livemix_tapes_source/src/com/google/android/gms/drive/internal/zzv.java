// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzaa, zzt, OpenContentsRequest, zzbj, 
//            zzal, DriveServiceResponse

public class zzv extends zzaa
    implements DriveFile
{
    private static class zza
        implements com.google.android.gms.drive.DriveFile.DownloadProgressListener
    {

        private final zzl zzaiL;

        public void onProgress(long l, long l1)
        {
            zzaiL.zza(new com.google.android.gms.common.api.zzl.zzb(this, l, l1) {

                final long zzaiM;
                final long zzaiN;
                final zza zzaiO;

                public void zza(com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
                {
                    downloadprogresslistener.onProgress(zzaiM, zzaiN);
                }

                public void zznh()
                {
                }

                public void zzo(Object obj)
                {
                    zza((com.google.android.gms.drive.DriveFile.DownloadProgressListener)obj);
                }

            
            {
                zzaiO = zza1;
                zzaiM = l;
                zzaiN = l1;
                super();
            }
            });
        }

        public zza(zzl zzl1)
        {
            zzaiL = zzl1;
        }
    }


    public zzv(DriveId driveid)
    {
        super(driveid);
    }

    private static com.google.android.gms.drive.DriveFile.DownloadProgressListener zza(GoogleApiClient googleapiclient, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
    {
        if (downloadprogresslistener == null)
        {
            return null;
        } else
        {
            return new zza(googleapiclient.zzp(downloadprogresslistener));
        }
    }

    public PendingResult open(GoogleApiClient googleapiclient, int i, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
    {
        if (i != 0x10000000 && i != 0x20000000 && i != 0x30000000)
        {
            throw new IllegalArgumentException("Invalid mode provided.");
        } else
        {
            return googleapiclient.zza(new zzr.zzb(googleapiclient, i, zza(googleapiclient, downloadprogresslistener)) {

                final com.google.android.gms.drive.DriveFile.DownloadProgressListener zzaiJ;
                final zzv zzaiK;
                final int zzaij;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zzt)zzb);
                }

                protected void zza(zzt zzt1)
                    throws RemoteException
                {
                    zza(zzt1.zzqF().zza(new OpenContentsRequest(zzaiK.getDriveId(), zzaij, 0), new zzbj(this, zzaiJ)).zzqJ());
                }

            
            {
                zzaiK = zzv.this;
                zzaij = i;
                zzaiJ = downloadprogresslistener;
                super(googleapiclient);
            }
            });
        }
    }
}
