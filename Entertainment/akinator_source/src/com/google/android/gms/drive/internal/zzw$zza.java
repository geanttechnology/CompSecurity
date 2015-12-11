// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzlm;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzw

private static class zzakZ
    implements com.google.android.gms.drive.e.DownloadProgressListener
{

    private final zzlm zzakZ;

    public void onProgress(long l, long l1)
    {
        zzakZ.zza(new com.google.android.gms.internal.zzlm.zzb(l, l1) {

            final long zzala;
            final long zzalb;
            final zzw.zza zzalc;

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
                zzalc = zzw.zza.this;
                zzala = l;
                zzalb = l1;
                super();
            }
        });
    }

    public _cls1.zzalb(zzlm zzlm1)
    {
        zzakZ = zzlm1;
    }
}
