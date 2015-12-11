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
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.common.images:
//            a

public final class ImageManager
{
    private final class ImageReceiver extends ResultReceiver
    {

        private final ArrayList Fh;
        final ImageManager Fi;
        private final Uri mUri;

        static ArrayList a(ImageReceiver imagereceiver)
        {
            return imagereceiver.Fh;
        }

        public void onReceiveResult(int i, Bundle bundle)
        {
            bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.f(Fi).execute(Fi. new c(mUri, bundle));
        }
    }

    public static interface OnImageLoadedListener
    {

        public abstract void onImageLoaded(Uri uri, Drawable drawable, boolean flag);
    }

    private static final class b extends hq
    {

        protected int a(a.a a1, Bitmap bitmap)
        {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void a(boolean flag, a.a a1, Bitmap bitmap, Bitmap bitmap1)
        {
            super.entryRemoved(flag, a1, bitmap, bitmap1);
        }

        protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
        {
            a(flag, (a.a)obj, (Bitmap)obj1, (Bitmap)obj2);
        }

        protected int sizeOf(Object obj, Object obj1)
        {
            return a((a.a)obj, (Bitmap)obj1);
        }
    }

    private final class c
        implements Runnable
    {

        final ImageManager Fi;
        private final ParcelFileDescriptor Fj;
        private final Uri mUri;

        public void run()
        {
            Object obj;
            CountDownLatch countdownlatch;
            boolean flag;
            boolean flag1;
            gx.az("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            flag = false;
            flag1 = false;
            obj = null;
            countdownlatch = null;
            if (Fj == null) goto _L2; else goto _L1
_L1:
            obj = BitmapFactory.decodeFileDescriptor(Fj.getFileDescriptor());
            flag = flag1;
_L3:
            OutOfMemoryError outofmemoryerror;
            try
            {
                Fj.close();
            }
            catch (IOException ioexception)
            {
                Log.e("ImageManager", "closed failed", ioexception);
            }
_L2:
            countdownlatch = new CountDownLatch(1);
            ImageManager.g(Fi).post(Fi. new f(mUri, ((Bitmap) (obj)), flag, countdownlatch));
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

        public c(Uri uri, ParcelFileDescriptor parcelfiledescriptor)
        {
            Fi = ImageManager.this;
            super();
            mUri = uri;
            Fj = parcelfiledescriptor;
        }
    }

    private final class f
        implements Runnable
    {

        final ImageManager Fi;
        private boolean Fl;
        private final CountDownLatch kK;
        private final Bitmap mBitmap;
        private final Uri mUri;

        private void a(ImageReceiver imagereceiver, boolean flag)
        {
            imagereceiver = ImageReceiver.a(imagereceiver);
            int j = imagereceiver.size();
            int i = 0;
            while (i < j) 
            {
                a a1 = (a)imagereceiver.get(i);
                if (flag)
                {
                    a1.a(ImageManager.b(Fi), mBitmap, false);
                } else
                {
                    ImageManager.d(Fi).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    a1.a(ImageManager.b(Fi), ImageManager.c(Fi), false);
                }
                if (!(a1 instanceof a.c))
                {
                    ImageManager.a(Fi).remove(a1);
                }
                i++;
            }
        }

        public void run()
        {
            gx.ay("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean flag;
            if (mBitmap != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (ImageManager.h(Fi) != null)
            {
                if (Fl)
                {
                    ImageManager.h(Fi).evictAll();
                    System.gc();
                    Fl = false;
                    ImageManager.g(Fi).post(this);
                    return;
                }
                if (flag)
                {
                    ImageManager.h(Fi).put(new a.a(mUri), mBitmap);
                }
            }
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.e(Fi).remove(mUri);
            if (imagereceiver != null)
            {
                a(imagereceiver, flag);
            }
            kK.countDown();
            synchronized (ImageManager.fd())
            {
                ImageManager.fe().remove(mUri);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public f(Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
        {
            Fi = ImageManager.this;
            super();
            mUri = uri;
            mBitmap = bitmap;
            Fl = flag;
            kK = countdownlatch;
        }
    }


    private static final Object EX = new Object();
    private static HashSet EY = new HashSet();
    private final ExecutorService Fb;
    private final b Fc;
    private final gw Fd;
    private final Map Fe;
    private final Map Ff;
    private final Map Fg;
    private final Context mContext;
    private final Handler mHandler;

    static Map a(ImageManager imagemanager)
    {
        return imagemanager.Fe;
    }

    static Context b(ImageManager imagemanager)
    {
        return imagemanager.mContext;
    }

    static gw c(ImageManager imagemanager)
    {
        return imagemanager.Fd;
    }

    static Map d(ImageManager imagemanager)
    {
        return imagemanager.Fg;
    }

    static Map e(ImageManager imagemanager)
    {
        return imagemanager.Ff;
    }

    static ExecutorService f(ImageManager imagemanager)
    {
        return imagemanager.Fb;
    }

    static Object fd()
    {
        return EX;
    }

    static HashSet fe()
    {
        return EY;
    }

    static Handler g(ImageManager imagemanager)
    {
        return imagemanager.mHandler;
    }

    static b h(ImageManager imagemanager)
    {
        return imagemanager.Fc;
    }

}
