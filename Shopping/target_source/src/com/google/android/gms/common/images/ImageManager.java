// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.b.cv;
import com.google.android.gms.b.cw;
import com.google.android.gms.common.internal.e;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
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

        final ImageManager a;
        private final Uri b;
        private final ArrayList c;

        static ArrayList a(ImageReceiver imagereceiver)
        {
            return imagereceiver.c;
        }

        public void onReceiveResult(int k, Bundle bundle)
        {
            bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.f(a).execute(a. new c(b, bundle));
        }
    }

    public static interface a
    {

        public abstract void a(Uri uri, Drawable drawable, boolean flag);
    }

    private static final class b extends cw
    {

        protected int a(a.a a1, Bitmap bitmap)
        {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected int a(Object obj, Object obj1)
        {
            return a((a.a)obj, (Bitmap)obj1);
        }

        protected void a(boolean flag, a.a a1, Bitmap bitmap, Bitmap bitmap1)
        {
            super.a(flag, a1, bitmap, bitmap1);
        }

        protected void a(boolean flag, Object obj, Object obj1, Object obj2)
        {
            a(flag, (a.a)obj, (Bitmap)obj1, (Bitmap)obj2);
        }
    }

    private final class c
        implements Runnable
    {

        final ImageManager a;
        private final Uri b;
        private final ParcelFileDescriptor c;

        public void run()
        {
            Object obj;
            CountDownLatch countdownlatch;
            boolean flag;
            boolean flag1;
            com.google.android.gms.common.internal.e.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            flag = false;
            flag1 = false;
            obj = null;
            countdownlatch = null;
            if (c == null) goto _L2; else goto _L1
_L1:
            obj = BitmapFactoryInstrumentation.decodeFileDescriptor(c.getFileDescriptor());
            flag = flag1;
_L3:
            OutOfMemoryError outofmemoryerror;
            try
            {
                c.close();
            }
            catch (IOException ioexception)
            {
                Log.e("ImageManager", "closed failed", ioexception);
            }
_L2:
            countdownlatch = new CountDownLatch(1);
            ImageManager.g(a).post(a. new d(b, ((Bitmap) (obj)), flag, countdownlatch));
            try
            {
                countdownlatch.await();
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                Log.w("ImageManager", (new StringBuilder()).append("Latch interrupted while posting ").append(b).toString());
            }
            break MISSING_BLOCK_LABEL_164;
            outofmemoryerror;
            Log.e("ImageManager", (new StringBuilder()).append("OOM while loading bitmap for uri: ").append(b).toString(), outofmemoryerror);
            flag = true;
            outofmemoryerror = countdownlatch;
              goto _L3
        }

        public c(Uri uri, ParcelFileDescriptor parcelfiledescriptor)
        {
            a = ImageManager.this;
            super();
            b = uri;
            c = parcelfiledescriptor;
        }
    }

    private final class d
        implements Runnable
    {

        final ImageManager a;
        private final Uri b;
        private final Bitmap c;
        private final CountDownLatch d;
        private boolean e;

        private void a(ImageReceiver imagereceiver, boolean flag)
        {
            imagereceiver = ImageReceiver.a(imagereceiver);
            int l = imagereceiver.size();
            int k = 0;
            while (k < l) 
            {
                com.google.android.gms.common.images.a a1 = (com.google.android.gms.common.images.a)imagereceiver.get(k);
                if (flag)
                {
                    a1.a(ImageManager.b(a), c, false);
                } else
                {
                    ImageManager.d(a).put(b, Long.valueOf(SystemClock.elapsedRealtime()));
                    a1.a(ImageManager.b(a), ImageManager.c(a), false);
                }
                if (!(a1 instanceof a.b))
                {
                    ImageManager.a(a).remove(a1);
                }
                k++;
            }
        }

        public void run()
        {
            com.google.android.gms.common.internal.e.a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean flag;
            if (c != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (ImageManager.h(a) != null)
            {
                if (e)
                {
                    ImageManager.h(a).a();
                    System.gc();
                    e = false;
                    ImageManager.g(a).post(this);
                    return;
                }
                if (flag)
                {
                    ImageManager.h(a).b(new a.a(b), c);
                }
            }
            ImageReceiver imagereceiver = (ImageReceiver)com.google.android.gms.common.images.ImageManager.e(a).remove(b);
            if (imagereceiver != null)
            {
                a(imagereceiver, flag);
            }
            d.countDown();
            synchronized (ImageManager.a())
            {
                ImageManager.b().remove(b);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public d(Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
        {
            a = ImageManager.this;
            super();
            b = uri;
            c = bitmap;
            e = flag;
            d = countdownlatch;
        }
    }


    private static final Object a = new Object();
    private static HashSet b = new HashSet();
    private final Context c;
    private final Handler d;
    private final ExecutorService e;
    private final b f;
    private final cv g;
    private final Map h;
    private final Map i;
    private final Map j;

    static Object a()
    {
        return a;
    }

    static Map a(ImageManager imagemanager)
    {
        return imagemanager.h;
    }

    static Context b(ImageManager imagemanager)
    {
        return imagemanager.c;
    }

    static HashSet b()
    {
        return b;
    }

    static cv c(ImageManager imagemanager)
    {
        return imagemanager.g;
    }

    static Map d(ImageManager imagemanager)
    {
        return imagemanager.j;
    }

    static Map e(ImageManager imagemanager)
    {
        return imagemanager.i;
    }

    static ExecutorService f(ImageManager imagemanager)
    {
        return imagemanager.e;
    }

    static Handler g(ImageManager imagemanager)
    {
        return imagemanager.d;
    }

    static b h(ImageManager imagemanager)
    {
        return imagemanager.f;
    }

}
