// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.zzl;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzv

private static class zzaiL
    implements com.google.android.gms.drive.e.DownloadProgressListener
{

    private final zzl zzaiL;

    public void onProgress(long l, long l1)
    {
        zzaiL.zza(new com.google.android.gms.common.api.zzl.zzb(l, l1) {

            final long zzaiM;
            final long zzaiN;
            final zzv.zza zzaiO;

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
                zzaiO = zzv.zza.this;
                zzaiM = l;
                zzaiN = l1;
                super();
            }
        });
    }

    public _cls1.zzaiN(zzl zzl1)
    {
        zzaiL = zzl1;
    }
}
