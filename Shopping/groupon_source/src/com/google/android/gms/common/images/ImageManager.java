// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzku;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.common.images:
//            zza

public final class ImageManager
{
    private final class ImageReceiver extends ResultReceiver
    {

        private final Uri mUri;
        private final ArrayList zzYX;
        final ImageManager zzYY;

        static ArrayList zza(ImageReceiver imagereceiver)
        {
            return imagereceiver.zzYX;
        }

        public void onReceiveResult(int i, Bundle bundle)
        {
            bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.zzf(zzYY).execute(zzYY. new zzc(mUri, bundle));
        }
    }

    public static interface OnImageLoadedListener
    {

        public abstract void onImageLoaded(Uri uri, Drawable drawable, boolean flag);
    }

    private static final class zzb extends zzku
    {

        protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
        {
            zza(flag, (zza.zza)obj, (Bitmap)obj1, (Bitmap)obj2);
        }

        protected int sizeOf(Object obj, Object obj1)
        {
            return zza((zza.zza)obj, (Bitmap)obj1);
        }

        protected int zza(zza.zza zza1, Bitmap bitmap)
        {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void zza(boolean flag, zza.zza zza1, Bitmap bitmap, Bitmap bitmap1)
        {
            super.entryRemoved(flag, zza1, bitmap, bitmap1);
        }
    }

    private final class zzc
        implements Runnable
    {

        private final Uri mUri;
        final ImageManager zzYY;
        private final ParcelFileDescriptor zzYZ;

        public void run()
        {
            Object obj;
            CountDownLatch countdownlatch;
            boolean flag;
            boolean flag1;
            com.google.android.gms.common.internal.zzb.zzbZ("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            flag = false;
            flag1 = false;
            obj = null;
            countdownlatch = null;
            if (zzYZ == null) goto _L2; else goto _L1
_L1:
            obj = BitmapFactory.decodeFileDescriptor(zzYZ.getFileDescriptor());
            flag = flag1;
_L3:
            OutOfMemoryError outofmemoryerror;
            try
            {
                zzYZ.close();
            }
            catch (IOException ioexception)
            {
                Log.e("ImageManager", "closed failed", ioexception);
            }
_L2:
            countdownlatch = new CountDownLatch(1);
            ImageManager.zzg(zzYY).post(zzYY. new zzf(mUri, ((Bitmap) (obj)), flag, countdownlatch));
            try
            {
                countdownlatch.await();
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                Log.w("ImageManager", (new StringBuilder()).append("Latch interrupted while posting ").append(mUri).toString());
            }
            break MISSING_BLOCK_LABEL_164;
            outofmemoryerror;
            Log.e("ImageManager", (new StringBuilder()).append("OOM while loading bitmap for uri: ").append(mUri).toString(), outofmemoryerror);
            flag = true;
            outofmemoryerror = countdownlatch;
              goto _L3
        }

        public zzc(Uri uri, ParcelFileDescriptor parcelfiledescriptor)
        {
            zzYY = ImageManager.this;
            super();
            mUri = uri;
            zzYZ = parcelfiledescriptor;
        }
    }

    private final class zzf
        implements Runnable
    {

        private final Bitmap mBitmap;
        private final Uri mUri;
        final ImageManager zzYY;
        private boolean zzZb;
        private final CountDownLatch zzoD;

        private void zza(ImageReceiver imagereceiver, boolean flag)
        {
            imagereceiver = ImageReceiver.zza(imagereceiver);
            int j = imagereceiver.size();
            int i = 0;
            while (i < j) 
            {
                zza zza1 = (zza)imagereceiver.get(i);
                if (flag)
                {
                    zza1.zza(ImageManager.zzb(zzYY), mBitmap, false);
                } else
                {
                    ImageManager.zzd(zzYY).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza1.zza(ImageManager.zzb(zzYY), ImageManager.zzc(zzYY), false);
                }
                if (!(zza1 instanceof zza.zzc))
                {
                    ImageManager.zza(zzYY).remove(zza1);
                }
                i++;
            }
        }

        public void run()
        {
            com.google.android.gms.common.internal.zzb.zzbY("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean flag;
            if (mBitmap != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (ImageManager.zzh(zzYY) != null)
            {
                if (zzZb)
                {
                    ImageManager.zzh(zzYY).evictAll();
                    System.gc();
                    zzZb = false;
                    ImageManager.zzg(zzYY).post(this);
                    return;
                }
                if (flag)
                {
                    ImageManager.zzh(zzYY).put(new zza.zza(mUri), mBitmap);
                }
            }
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.zze(zzYY).remove(mUri);
            if (imagereceiver != null)
            {
                zza(imagereceiver, flag);
            }
            zzoD.countDown();
            synchronized (ImageManager.zznm())
            {
                ImageManager.zznn().remove(mUri);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public zzf(Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
        {
            zzYY = ImageManager.this;
            super();
            mUri = uri;
            mBitmap = bitmap;
            zzZb = flag;
            zzoD = countdownlatch;
        }
    }


    private static final Object zzYN = new Object();
    private static HashSet zzYO = new HashSet();
    private final Context mContext;
    private final Handler mHandler;
    private final ExecutorService zzYR;
    private final zzb zzYS;
    private final zzkj zzYT;
    private final Map zzYU;
    private final Map zzYV;
    private final Map zzYW;

    static Map zza(ImageManager imagemanager)
    {
        return imagemanager.zzYU;
    }

    static Context zzb(ImageManager imagemanager)
    {
        return imagemanager.mContext;
    }

    static zzkj zzc(ImageManager imagemanager)
    {
        return imagemanager.zzYT;
    }

    static Map zzd(ImageManager imagemanager)
    {
        return imagemanager.zzYW;
    }

    static Map zze(ImageManager imagemanager)
    {
        return imagemanager.zzYV;
    }

    static ExecutorService zzf(ImageManager imagemanager)
    {
        return imagemanager.zzYR;
    }

    static Handler zzg(ImageManager imagemanager)
    {
        return imagemanager.mHandler;
    }

    static zzb zzh(ImageManager imagemanager)
    {
        return imagemanager.zzYS;
    }

    static Object zznm()
    {
        return zzYN;
    }

    static HashSet zznn()
    {
        return zzYO;
    }

}
