// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.internal.zzlm;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzab, zzu, OpenContentsRequest, zzbl, 
//            zzam, DriveServiceResponse

public class zzw extends zzab
    implements DriveFile
{
    private static class zza
        implements com.google.android.gms.drive.DriveFile.DownloadProgressListener
    {

        private final zzlm zzakZ;

        public void onProgress(long l, long l1)
        {
            zzakZ.zza(new com.google.android.gms.internal.zzlm.zzb(this, l, l1) {

                final long zzala;
                final long zzalb;
                final zza zzalc;

                public void zza(com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
                {
                    downloadprogresslistener.onProgress(zzala, zzalb);
                }

                public void zznN()
                {
                }

                public void zzq(Object obj)
                {
                    zza((com.google.android.gms.drive.DriveFile.DownloadProgressListener)obj);
                }

            
            {
                zzalc = zza1;
                zzala = l;
                zzalb = l1;
                super();
            }
            });
        }

        public zza(zzlm zzlm1)
        {
            zzakZ = zzlm1;
        }
    }


    public zzw(DriveId driveid)
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
            return new zza(googleapiclient.zzo(downloadprogresslistener));
        }
    }

    public PendingResult open(GoogleApiClient googleapiclient, int i, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
    {
        if (i != 0x10000000 && i != 0x20000000 && i != 0x30000000)
        {
            throw new IllegalArgumentException("Invalid mode provided.");
        } else
        {
            return googleapiclient.zza(new zzs.zzb(googleapiclient, i, zza(googleapiclient, downloadprogresslistener)) {

                final com.google.android.gms.drive.DriveFile.DownloadProgressListener zzakX;
                final zzw zzakY;
                final int zzakw;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zzu)zzb);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zza(zzu1.zzrm().zza(new OpenContentsRequest(zzakY.getDriveId(), zzakw, 0), new zzbl(this, zzakX)).zzrr());
                }

            
            {
                zzakY = zzw.this;
                zzakw = i;
                zzakX = downloadprogresslistener;
                super(googleapiclient);
            }
            });
        }
    }
}
