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
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ev;
import com.google.android.gms.internal.fr;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
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

        boolean AA;
        final ImageManager AB;
        private final ArrayList Az = new ArrayList();
        private final Uri mUri;

        static ArrayList a(ImageReceiver imagereceiver)
        {
            return imagereceiver.Az;
        }

        public void c(com.google.android.gms.common.images.a a1)
        {
            boolean flag;
            if (!AA)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ed.a(flag, "Cannot add an ImageRequest when mHandlingRequests is true");
            ed.ac("ImageReceiver.addImageRequest() must be called in the main thread");
            Az.add(a1);
        }

        public void d(com.google.android.gms.common.images.a a1)
        {
            boolean flag;
            if (!AA)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ed.a(flag, "Cannot remove an ImageRequest when mHandlingRequests is true");
            ed.ac("ImageReceiver.removeImageRequest() must be called in the main thread");
            Az.remove(a1);
        }

        public void dN()
        {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.a(AB).sendBroadcast(intent);
        }

        public void onReceiveResult(int i, Bundle bundle)
        {
            bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.d(AB).execute(AB. new c(mUri, bundle));
        }

        ImageReceiver(Uri uri)
        {
            AB = ImageManager.this;
            super(new Handler(Looper.getMainLooper()));
            AA = false;
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

    private static final class b extends ev
    {

        private static int w(Context context)
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
            if (i != 0 && fr.eJ())
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
            super(w(context));
        }
    }

    private final class c
        implements Runnable
    {

        final ImageManager AB;
        private final ParcelFileDescriptor AC;
        private final Uri mUri;

        public void run()
        {
            Object obj;
            CountDownLatch countdownlatch;
            boolean flag;
            boolean flag1;
            ed.ad("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            flag = false;
            flag1 = false;
            obj = null;
            countdownlatch = null;
            if (AC == null) goto _L2; else goto _L1
_L1:
            obj = BitmapFactoryInstrumentation.decodeFileDescriptor(AC.getFileDescriptor());
            flag = flag1;
_L3:
            OutOfMemoryError outofmemoryerror;
            try
            {
                AC.close();
            }
            catch (IOException ioexception)
            {
                Log.e("ImageManager", "closed failed", ioexception);
            }
_L2:
            countdownlatch = new CountDownLatch(1);
            ImageManager.e(AB).post(AB. new f(mUri, ((Bitmap) (obj)), flag, countdownlatch));
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
            AB = ImageManager.this;
            super();
            mUri = uri;
            AC = parcelfiledescriptor;
        }
    }

    private final class d
        implements Runnable
    {

        final ImageManager AB;
        private final com.google.android.gms.common.images.a AD;

        public void run()
        {
            ed.ac("LoadImageRunnable must be executed on the main thread");
            ImageManager.a(AB, AD);
            a.a a1 = AD.AF;
            if (a1.uri == null)
            {
                AD.b(ImageManager.a(AB), true);
                return;
            }
            Object obj = ImageManager.a(AB, a1);
            if (obj != null)
            {
                AD.a(ImageManager.a(AB), ((Bitmap) (obj)), true);
                return;
            }
            AD.x(ImageManager.a(AB));
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.b(AB).get(a1.uri);
            obj = imagereceiver;
            if (imagereceiver == null)
            {
                obj = AB. new ImageReceiver(a1.uri);
                ImageManager.b(AB).put(a1.uri, obj);
            }
            ((ImageReceiver) (obj)).c(AD);
            if (AD.AI != 1)
            {
                ImageManager.c(AB).put(AD, obj);
            }
            synchronized (ImageManager.dd())
            {
                if (!ImageManager.dM().contains(a1.uri))
                {
                    ImageManager.dM().add(a1.uri);
                    ((ImageReceiver) (obj)).dN();
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
            AB = ImageManager.this;
            super();
            AD = a1;
        }
    }

    private static final class e
        implements ComponentCallbacks2
    {

        private final b Aw;

        public void onConfigurationChanged(Configuration configuration)
        {
        }

        public void onLowMemory()
        {
            Aw.evictAll();
        }

        public void onTrimMemory(int i)
        {
            if (i >= 60)
            {
                Aw.evictAll();
            } else
            if (i >= 20)
            {
                Aw.trimToSize(Aw.size() / 2);
                return;
            }
        }

        public e(b b1)
        {
            Aw = b1;
        }
    }

    private final class f
        implements Runnable
    {

        final ImageManager AB;
        private boolean AE;
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zf;

        private void a(ImageReceiver imagereceiver, boolean flag)
        {
            imagereceiver.AA = true;
            ArrayList arraylist = ImageReceiver.a(imagereceiver);
            int j = arraylist.size();
            int i = 0;
            while (i < j) 
            {
                com.google.android.gms.common.images.a a1 = (com.google.android.gms.common.images.a)arraylist.get(i);
                if (flag)
                {
                    a1.a(ImageManager.a(AB), mBitmap, false);
                } else
                {
                    a1.b(ImageManager.a(AB), false);
                }
                if (a1.AI != 1)
                {
                    ImageManager.c(AB).remove(a1);
                }
                i++;
            }
            imagereceiver.AA = false;
        }

        public void run()
        {
            ed.ac("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean flag;
            if (mBitmap != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (ImageManager.f(AB) != null)
            {
                if (AE)
                {
                    ImageManager.f(AB).evictAll();
                    System.gc();
                    AE = false;
                    ImageManager.e(AB).post(this);
                    return;
                }
                if (flag)
                {
                    ImageManager.f(AB).put(new a.a(mUri), mBitmap);
                }
            }
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.b(AB).remove(mUri);
            if (imagereceiver != null)
            {
                a(imagereceiver, flag);
            }
            zf.countDown();
            synchronized (ImageManager.dd())
            {
                ImageManager.dM().remove(mUri);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public f(Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
        {
            AB = ImageManager.this;
            super();
            mUri = uri;
            mBitmap = bitmap;
            AE = flag;
            zf = countdownlatch;
        }
    }


    private static final Object Ar = new Object();
    private static HashSet As = new HashSet();
    private static ImageManager At;
    private static ImageManager Au;
    private final ExecutorService Av = Executors.newFixedThreadPool(4);
    private final b Aw;
    private final Map Ax = new HashMap();
    private final Map Ay = new HashMap();
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private ImageManager(Context context, boolean flag)
    {
        mContext = context.getApplicationContext();
        if (flag)
        {
            Aw = new b(mContext);
            if (fr.eM())
            {
                dL();
            }
        } else
        {
            Aw = null;
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
        if (Aw == null)
        {
            return null;
        } else
        {
            return (Bitmap)Aw.get(a1);
        }
    }

    public static ImageManager a(Context context, boolean flag)
    {
        if (flag)
        {
            if (Au == null)
            {
                Au = new ImageManager(context, true);
            }
            return Au;
        }
        if (At == null)
        {
            At = new ImageManager(context, false);
        }
        return At;
    }

    static boolean a(ImageManager imagemanager, com.google.android.gms.common.images.a a1)
    {
        return imagemanager.b(a1);
    }

    static Map b(ImageManager imagemanager)
    {
        return imagemanager.Ay;
    }

    private boolean b(com.google.android.gms.common.images.a a1)
    {
        ed.ac("ImageManager.cleanupHashMaps() must be called in the main thread");
        if (a1.AI == 1)
        {
            return true;
        }
        ImageReceiver imagereceiver = (ImageReceiver)Ax.get(a1);
        if (imagereceiver == null)
        {
            return true;
        }
        if (imagereceiver.AA)
        {
            return false;
        } else
        {
            Ax.remove(a1);
            imagereceiver.d(a1);
            return true;
        }
    }

    static Map c(ImageManager imagemanager)
    {
        return imagemanager.Ax;
    }

    public static ImageManager create(Context context)
    {
        return a(context, false);
    }

    static ExecutorService d(ImageManager imagemanager)
    {
        return imagemanager.Av;
    }

    private void dL()
    {
        mContext.registerComponentCallbacks(new e(Aw));
    }

    static HashSet dM()
    {
        return As;
    }

    static Object dd()
    {
        return Ar;
    }

    static Handler e(ImageManager imagemanager)
    {
        return imagemanager.mHandler;
    }

    static b f(ImageManager imagemanager)
    {
        return imagemanager.Aw;
    }

    public void a(com.google.android.gms.common.images.a a1)
    {
        ed.ac("ImageManager.loadImage() must be called in the main thread");
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
        uri.L(i);
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
        uri.L(i);
        uri.a(onimageloadedlistener);
        a(uri);
    }

}
