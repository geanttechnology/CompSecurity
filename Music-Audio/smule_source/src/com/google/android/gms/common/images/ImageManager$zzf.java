// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.android.gms.common.images:
//            zza, ImageManager

final class zzns
    implements Runnable
{

    private final Bitmap mBitmap;
    private final Uri mUri;
    final ImageManager zzSc;
    private boolean zzSf;
    private final CountDownLatch zzns;

    private void zza(eReceiver ereceiver, boolean flag)
    {
        ereceiver = eReceiver.zza(ereceiver);
        int j = ereceiver.size();
        int i = 0;
        while (i < j) 
        {
            zza zza1 = (zza)ereceiver.get(i);
            if (flag)
            {
                zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzSc), mBitmap, false);
            } else
            {
                ImageManager.zzd(zzSc).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzSc), ImageManager.zzc(zzSc), false);
            }
            if (!(zza1 instanceof zzSc))
            {
                ImageManager.zza(zzSc).remove(zza1);
            }
            i++;
        }
    }

    public void run()
    {
        zzb.zzbI("OnBitmapLoadedRunnable must be executed in the main thread");
        boolean flag;
        if (mBitmap != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ImageManager.zzh(zzSc) != null)
        {
            if (zzSf)
            {
                ImageManager.zzh(zzSc).evictAll();
                System.gc();
                zzSf = false;
                ImageManager.zzg(zzSc).post(this);
                return;
            }
            if (flag)
            {
                ImageManager.zzh(zzSc).put(new put(mUri), mBitmap);
            }
        }
        eReceiver ereceiver = (eReceiver)ImageManager.zze(zzSc).remove(mUri);
        if (ereceiver != null)
        {
            zza(ereceiver, flag);
        }
        zzns.countDown();
        synchronized (ImageManager.zzlx())
        {
            ImageManager.zzly().remove(mUri);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public eReceiver(ImageManager imagemanager, Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
    {
        zzSc = imagemanager;
        super();
        mUri = uri;
        mBitmap = bitmap;
        zzSf = flag;
        zzns = countdownlatch;
    }
}
