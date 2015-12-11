// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.fg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.common.images:
//            a

public final class ImageManager
{
    private final class ImageReceiver extends ResultReceiver
    {

        private final Uri mUri;
        private final ArrayList oj = new ArrayList();
        boolean ok;
        final ImageManager ol;

        static ArrayList a(ImageReceiver imagereceiver)
        {
            return imagereceiver.oj;
        }

        public void bB()
        {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.a(ol).sendBroadcast(intent);
        }

        public void c(com.google.android.gms.common.images.a a1)
        {
            boolean flag;
            if (!ok)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ds.a(flag, "Cannot add an ImageRequest when mHandlingRequests is true");
            ds.N("ImageReceiver.addImageRequest() must be called in the main thread");
            oj.add(a1);
        }

        public void d(com.google.android.gms.common.images.a a1)
        {
            boolean flag;
            if (!ok)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ds.a(flag, "Cannot remove an ImageRequest when mHandlingRequests is true");
            ds.N("ImageReceiver.removeImageRequest() must be called in the main thread");
            oj.remove(a1);
        }

        public void onReceiveResult(int i, Bundle bundle)
        {
            bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.d(ol).execute(ol. new c(mUri, bundle));
        }

        ImageReceiver(Uri uri)
        {
            ol = ImageManager.this;
            super(new Handler(Looper.getMainLooper()));
            ok = false;
            mUri = uri;
        }
    }

    public static interface OnImageLoadedListener
    {

        public abstract void onImageLoaded(Uri uri, Drawable drawable, boolean flag);
    }

    private static final class a
    {

        static int a(ActivityManager activitymanager)
        {
            return activitymanager.getLargeMemoryClass();
        }
    }

    private static final class b extends ek
    {

        private static int q(Context context)
        {
            ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
            int i;
            if ((context.getApplicationInfo().flags & 0x100000) != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0 && fg.cD())
            {
                i = a.a(activitymanager);
            } else
            {
                i = activitymanager.getMemoryClass();
            }
            return (int)((float)(i * 0x100000) * 0.33F);
        }

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

        public b(Context context)
        {
            super(q(context));
        }
    }

    private final class c
        implements Runnable
    {

        private final Uri mUri;
        final ImageManager ol;
        private final ParcelFileDescriptor om;

        public void run()
        {
            Object obj;
            CountDownLatch countdownlatch;
            boolean flag;
            boolean flag1;
            ds.O("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            flag = false;
            flag1 = false;
            obj = null;
            countdownlatch = null;
            if (om == null) goto _L2; else goto _L1
_L1:
            obj = BitmapFactory.decodeFileDescriptor(om.getFileDescriptor());
            flag = flag1;
_L3:
            OutOfMemoryError outofmemoryerror;
            try
            {
                om.close();
            }
            catch (IOException ioexception)
            {
                Log.e("ImageManager", "closed failed", ioexception);
            }
_L2:
            countdownlatch = new CountDownLatch(1);
            ImageManager.e(ol).post(ol. new f(mUri, ((Bitmap) (obj)), flag, countdownlatch));
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
            ol = ImageManager.this;
            super();
            mUri = uri;
            om = parcelfiledescriptor;
        }
    }

    private final class d
        implements Runnable
    {

        final ImageManager ol;
        private final com.google.android.gms.common.images.a on;

        public void run()
        {
            ds.N("LoadImageRunnable must be executed on the main thread");
            ImageManager.a(ol, on);
            a.a a1 = on.op;
            if (a1.uri == null)
            {
                on.b(ImageManager.a(ol), true);
                return;
            }
            Object obj = ImageManager.a(ol, a1);
            if (obj != null)
            {
                on.a(ImageManager.a(ol), ((Bitmap) (obj)), true);
                return;
            }
            on.r(ImageManager.a(ol));
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.b(ol).get(a1.uri);
            obj = imagereceiver;
            if (imagereceiver == null)
            {
                obj = ol. new ImageReceiver(a1.uri);
                ImageManager.b(ol).put(a1.uri, obj);
            }
            ((ImageReceiver) (obj)).c(on);
            if (on.os != 1)
            {
                ImageManager.c(ol).put(on, obj);
            }
            synchronized (ImageManager.aZ())
            {
                if (!ImageManager.bA().contains(a1.uri))
                {
                    ImageManager.bA().add(a1.uri);
                    ((ImageReceiver) (obj)).bB();
                }
            }
            return;
            exception;
            obj1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public d(com.google.android.gms.common.images.a a1)
        {
            ol = ImageManager.this;
            super();
            on = a1;
        }
    }

    private static final class e
        implements ComponentCallbacks2
    {

        private final b og;

        public void onConfigurationChanged(Configuration configuration)
        {
        }

        public void onLowMemory()
        {
            og.evictAll();
        }

        public void onTrimMemory(int i)
        {
            if (i >= 60)
            {
                og.evictAll();
            } else
            if (i >= 20)
            {
                og.trimToSize(og.size() / 2);
                return;
            }
        }

        public e(b b1)
        {
            og = b1;
        }
    }

    private final class f
        implements Runnable
    {

        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch mX;
        final ImageManager ol;
        private boolean oo;

        private void a(ImageReceiver imagereceiver, boolean flag)
        {
            imagereceiver.ok = true;
            ArrayList arraylist = ImageReceiver.a(imagereceiver);
            int j = arraylist.size();
            int i = 0;
            while (i < j) 
            {
                com.google.android.gms.common.images.a a1 = (com.google.android.gms.common.images.a)arraylist.get(i);
                if (flag)
                {
                    a1.a(ImageManager.a(ol), mBitmap, false);
                } else
                {
                    a1.b(ImageManager.a(ol), false);
                }
                if (a1.os != 1)
                {
                    ImageManager.c(ol).remove(a1);
                }
                i++;
            }
            imagereceiver.ok = false;
        }

        public void run()
        {
            ds.N("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean flag;
            if (mBitmap != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (ImageManager.f(ol) != null)
            {
                if (oo)
                {
                    ImageManager.f(ol).evictAll();
                    System.gc();
                    oo = false;
                    ImageManager.e(ol).post(this);
                    return;
                }
                if (flag)
                {
                    ImageManager.f(ol).put(new a.a(mUri), mBitmap);
                }
            }
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.b(ol).remove(mUri);
            if (imagereceiver != null)
            {
                a(imagereceiver, flag);
            }
            mX.countDown();
            synchronized (ImageManager.aZ())
            {
                ImageManager.bA().remove(mUri);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public f(Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
        {
            ol = ImageManager.this;
            super();
            mUri = uri;
            mBitmap = bitmap;
            oo = flag;
            mX = countdownlatch;
        }
    }


    private static final Object ob = new Object();
    private static HashSet oc = new HashSet();
    private static ImageManager od;
    private static ImageManager oe;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService of = Executors.newFixedThreadPool(4);
    private final b og;
    private final Map oh = new HashMap();
    private final Map oi = new HashMap();

    private ImageManager(Context context, boolean flag)
    {
        mContext = context.getApplicationContext();
        if (flag)
        {
            og = new b(mContext);
            if (fg.cG())
            {
                bz();
            }
        } else
        {
            og = null;
        }
    }

    static Context a(ImageManager imagemanager)
    {
        return imagemanager.mContext;
    }

    static Bitmap a(ImageManager imagemanager, a.a a1)
    {
        return imagemanager.a(a1);
    }

    private Bitmap a(a.a a1)
    {
        if (og == null)
        {
            return null;
        } else
        {
            return (Bitmap)og.get(a1);
        }
    }

    public static ImageManager a(Context context, boolean flag)
    {
        if (flag)
        {
            if (oe == null)
            {
                oe = new ImageManager(context, true);
            }
            return oe;
        }
        if (od == null)
        {
            od = new ImageManager(context, false);
        }
        return od;
    }

    static boolean a(ImageManager imagemanager, com.google.android.gms.common.images.a a1)
    {
        return imagemanager.b(a1);
    }

    static Object aZ()
    {
        return ob;
    }

    static Map b(ImageManager imagemanager)
    {
        return imagemanager.oi;
    }

    private boolean b(com.google.android.gms.common.images.a a1)
    {
        ds.N("ImageManager.cleanupHashMaps() must be called in the main thread");
        if (a1.os == 1)
        {
            return true;
        }
        ImageReceiver imagereceiver = (ImageReceiver)oh.get(a1);
        if (imagereceiver == null)
        {
            return true;
        }
        if (imagereceiver.ok)
        {
            return false;
        } else
        {
            oh.remove(a1);
            imagereceiver.d(a1);
            return true;
        }
    }

    static HashSet bA()
    {
        return oc;
    }

    private void bz()
    {
        mContext.registerComponentCallbacks(new e(og));
    }

    static Map c(ImageManager imagemanager)
    {
        return imagemanager.oh;
    }

    public static ImageManager create(Context context)
    {
        return a(context, false);
    }

    static ExecutorService d(ImageManager imagemanager)
    {
        return imagemanager.of;
    }

    static Handler e(ImageManager imagemanager)
    {
        return imagemanager.mHandler;
    }

    static b f(ImageManager imagemanager)
    {
        return imagemanager.og;
    }

    public void a(com.google.android.gms.common.images.a a1)
    {
        ds.N("ImageManager.loadImage() must be called in the main thread");
        boolean flag = b(a1);
        a1 = new d(a1);
        if (flag)
        {
            a1.run();
            return;
        } else
        {
            mHandler.post(a1);
            return;
        }
    }

    public void loadImage(ImageView imageview, int i)
    {
        com.google.android.gms.common.images.a a1 = new com.google.android.gms.common.images.a(i);
        a1.a(imageview);
        a(a1);
    }

    public void loadImage(ImageView imageview, Uri uri)
    {
        uri = new com.google.android.gms.common.images.a(uri);
        uri.a(imageview);
        a(uri);
    }

    public void loadImage(ImageView imageview, Uri uri, int i)
    {
        uri = new com.google.android.gms.common.images.a(uri);
        uri.F(i);
        uri.a(imageview);
        a(uri);
    }

    public void loadImage(OnImageLoadedListener onimageloadedlistener, Uri uri)
    {
        uri = new com.google.android.gms.common.images.a(uri);
        uri.a(onimageloadedlistener);
        a(uri);
    }

    public void loadImage(OnImageLoadedListener onimageloadedlistener, Uri uri, int i)
    {
        uri = new com.google.android.gms.common.images.a(uri);
        uri.F(i);
        uri.a(onimageloadedlistener);
        a(uri);
    }

}
