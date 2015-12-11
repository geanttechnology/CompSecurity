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

final class zzoS
    implements Runnable
{

    private final Bitmap mBitmap;
    private final Uri mUri;
    final ImageManager zzadR;
    private boolean zzadU;
    private final CountDownLatch zzoS;

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
                zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), mBitmap, false);
            } else
            {
                ImageManager.zzd(zzadR).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), false);
            }
            if (!(zza1 instanceof zzadR))
            {
                ImageManager.zza(zzadR).remove(zza1);
            }
            i++;
        }
    }

    public final void run()
    {
        zzb.zzci("OnBitmapLoadedRunnable must be executed in the main thread");
        boolean flag;
        if (mBitmap != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ImageManager.zzh(zzadR) != null)
        {
            if (zzadU)
            {
                ImageManager.zzh(zzadR).evictAll();
                System.gc();
                zzadU = false;
                ImageManager.zzg(zzadR).post(this);
                return;
            }
            if (flag)
            {
                ImageManager.zzh(zzadR).put(new put(mUri), mBitmap);
            }
        }
        eReceiver ereceiver = (eReceiver)ImageManager.zze(zzadR).remove(mUri);
        if (ereceiver != null)
        {
            zza(ereceiver, flag);
        }
        zzoS.countDown();
        synchronized (ImageManager.zzoC())
        {
            ImageManager.zzoD().remove(mUri);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public eReceiver(ImageManager imagemanager, Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
    {
        zzadR = imagemanager;
        super();
        mUri = uri;
        mBitmap = bitmap;
        zzadU = flag;
        zzoS = countdownlatch;
    }
}
