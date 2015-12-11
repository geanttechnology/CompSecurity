// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzmx;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.common.images:
//            zza

public final class ImageManager
{

    private static final Object zzadG = new Object();
    private static HashSet zzadH = new HashSet();
    private static ImageManager zzadI;
    private static ImageManager zzadJ;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzadK = Executors.newFixedThreadPool(4);
    private final zzb zzadL;
    private final zzlv zzadM = new zzlv();
    private final Map zzadN = new HashMap();
    private final Map zzadO = new HashMap();
    private final Map zzadP = new HashMap();

    private ImageManager(Context context, boolean flag)
    {
        mContext = context.getApplicationContext();
        if (flag)
        {
            zzadL = new zzb(mContext);
            if (zzmx.zzqx())
            {
                zzoB();
            }
        } else
        {
            zzadL = null;
        }
    }

    public static ImageManager create(Context context)
    {
        return zzb(context, false);
    }

    static Bitmap zza(ImageManager imagemanager, zza.zza zza1)
    {
        return imagemanager.zza(zza1);
    }

    private Bitmap zza(zza.zza zza1)
    {
        if (zzadL == null)
        {
            return null;
        } else
        {
            return (Bitmap)zzadL.get(zza1);
        }
    }

    static Map zza(ImageManager imagemanager)
    {
        return imagemanager.zzadN;
    }

    static Context zzb(ImageManager imagemanager)
    {
        return imagemanager.mContext;
    }

    public static ImageManager zzb(Context context, boolean flag)
    {
        if (flag)
        {
            if (zzadJ == null)
            {
                zzadJ = new ImageManager(context, true);
            }
            return zzadJ;
        }
        if (zzadI == null)
        {
            zzadI = new ImageManager(context, false);
        }
        return zzadI;
    }

    static zzlv zzc(ImageManager imagemanager)
    {
        return imagemanager.zzadM;
    }

    static Map zzd(ImageManager imagemanager)
    {
        return imagemanager.zzadP;
    }

    static Map zze(ImageManager imagemanager)
    {
        return imagemanager.zzadO;
    }

    static ExecutorService zzf(ImageManager imagemanager)
    {
        return imagemanager.zzadK;
    }

    static Handler zzg(ImageManager imagemanager)
    {
        return imagemanager.mHandler;
    }

    static zzb zzh(ImageManager imagemanager)
    {
        return imagemanager.zzadL;
    }

    private void zzoB()
    {
        mContext.registerComponentCallbacks(new zze(zzadL));
    }

    static Object zzoC()
    {
        return zzadG;
    }

    static HashSet zzoD()
    {
        return zzadH;
    }

    public final void loadImage(ImageView imageview, int i)
    {
        zza(new zza.zzb(imageview, i));
    }

    public final void loadImage(ImageView imageview, Uri uri)
    {
        zza(new zza.zzb(imageview, uri));
    }

    public final void loadImage(ImageView imageview, Uri uri, int i)
    {
        imageview = new zza.zzb(imageview, uri);
        imageview.zzby(i);
        zza(imageview);
    }

    public final void loadImage(OnImageLoadedListener onimageloadedlistener, Uri uri)
    {
        zza(new zza.zzc(onimageloadedlistener, uri));
    }

    public final void loadImage(OnImageLoadedListener onimageloadedlistener, Uri uri, int i)
    {
        onimageloadedlistener = new zza.zzc(onimageloadedlistener, uri);
        onimageloadedlistener.zzby(i);
        zza(onimageloadedlistener);
    }

    public final void zza(zza zza1)
    {
        com.google.android.gms.common.internal.zzb.zzci("ImageManager.loadImage() must be called in the main thread");
        (new zzd(zza1)).run();
    }


    private class zzb extends zzmg
    {

        private static int zzaj(Context context)
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
            if (i != 0 && zzmx.zzqu())
            {
                i = zza.zza(activitymanager);
            } else
            {
                i = activitymanager.getMemoryClass();
            }
            return (int)((float)(i * 0x100000) * 0.33F);
        }

        protected final void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
        {
            zza(flag, (zza.zza)obj, (Bitmap)obj1, (Bitmap)obj2);
        }

        protected final int sizeOf(Object obj, Object obj1)
        {
            return zza((zza.zza)obj, (Bitmap)obj1);
        }

        protected final int zza(zza.zza zza1, Bitmap bitmap)
        {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected final void zza(boolean flag, zza.zza zza1, Bitmap bitmap, Bitmap bitmap1)
        {
            super.entryRemoved(flag, zza1, bitmap, bitmap1);
        }

        public zzb(Context context)
        {
            super(zzaj(context));
        }

        private class zza
        {

            static int zza(ActivityManager activitymanager)
            {
                return activitymanager.getLargeMemoryClass();
            }
        }

    }


    private class zze
        implements ComponentCallbacks2
    {

        private final zzb zzadL;

        public final void onConfigurationChanged(Configuration configuration)
        {
        }

        public final void onLowMemory()
        {
            zzadL.evictAll();
        }

        public final void onTrimMemory(int i)
        {
            if (i >= 60)
            {
                zzadL.evictAll();
            } else
            if (i >= 20)
            {
                zzadL.trimToSize(zzadL.size() / 2);
                return;
            }
        }

        public zze(zzb zzb1)
        {
            zzadL = zzb1;
        }
    }


    private class zzd
        implements Runnable
    {

        final ImageManager zzadR;
        private final com.google.android.gms.common.images.zza zzadT;

        public final void run()
        {
            com.google.android.gms.common.internal.zzb.zzci("LoadImageRunnable must be executed on the main thread");
            Object obj = (ImageReceiver)ImageManager.zza(zzadR).get(zzadT);
            if (obj != null)
            {
                ImageManager.zza(zzadR).remove(zzadT);
                ((ImageReceiver) (obj)).zzc(zzadT);
            }
            zza.zza zza1 = zzadT.zzadV;
            if (zza1.uri == null)
            {
                zzadT.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), true);
                return;
            }
            obj = ImageManager.zza(zzadR, zza1);
            if (obj != null)
            {
                zzadT.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ((Bitmap) (obj)), true);
                return;
            }
            obj = (Long)ImageManager.zzd(zzadR).get(zza1.uri);
            if (obj != null)
            {
                if (SystemClock.elapsedRealtime() - ((Long) (obj)).longValue() < 0x36ee80L)
                {
                    zzadT.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), true);
                    return;
                }
                ImageManager.zzd(zzadR).remove(zza1.uri);
            }
            zzadT.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ImageManager.zzc(zzadR));
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.zze(zzadR).get(zza1.uri);
            obj = imagereceiver;
            if (imagereceiver == null)
            {
                obj = zzadR. new ImageReceiver(zza1.uri);
                ImageManager.zze(zzadR).put(zza1.uri, obj);
            }
            ((ImageReceiver) (obj)).zzb(zzadT);
            if (!(zzadT instanceof zza.zzc))
            {
                ImageManager.zza(zzadR).put(zzadT, obj);
            }
            synchronized (ImageManager.zzoC())
            {
                if (!ImageManager.zzoD().contains(zza1.uri))
                {
                    ImageManager.zzoD().add(zza1.uri);
                    ((ImageReceiver) (obj)).zzoE();
                }
            }
            return;
            exception;
            obj1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public zzd(zza zza1)
        {
            zzadR = ImageManager.this;
            super();
            zzadT = zza1;
        }

        private class ImageReceiver extends ResultReceiver
        {

            private final Uri mUri;
            private final ArrayList zzadQ = new ArrayList();
            final ImageManager zzadR;

            static ArrayList zza(ImageReceiver imagereceiver)
            {
                return imagereceiver.zzadQ;
            }

            public final void onReceiveResult(int i, Bundle bundle)
            {
                bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
                ImageManager.zzf(zzadR).execute(zzadR. new zzc(mUri, bundle));
            }

            public final void zzb(com.google.android.gms.common.images.zza zza1)
            {
                com.google.android.gms.common.internal.zzb.zzci("ImageReceiver.addImageRequest() must be called in the main thread");
                zzadQ.add(zza1);
            }

            public final void zzc(com.google.android.gms.common.images.zza zza1)
            {
                com.google.android.gms.common.internal.zzb.zzci("ImageReceiver.removeImageRequest() must be called in the main thread");
                zzadQ.remove(zza1);
            }

            public final void zzoE()
            {
                Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
                intent.putExtra("com.google.android.gms.extras.uri", mUri);
                intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
                intent.putExtra("com.google.android.gms.extras.priority", 3);
                com.google.android.gms.common.images.ImageManager.zzb(zzadR).sendBroadcast(intent);
            }

            ImageReceiver(Uri uri)
            {
                zzadR = ImageManager.this;
                super(new Handler(Looper.getMainLooper()));
                mUri = uri;
            }

            private class zzc
                implements Runnable
            {

                private final Uri mUri;
                final ImageManager zzadR;
                private final ParcelFileDescriptor zzadS;

                public final void run()
                {
                    Object obj;
                    CountDownLatch countdownlatch;
                    boolean flag;
                    boolean flag1;
                    com.google.android.gms.common.internal.zzb.zzcj("LoadBitmapFromDiskRunnable can't be executed in the main thread");
                    flag = false;
                    flag1 = false;
                    obj = null;
                    countdownlatch = null;
                    if (zzadS == null) goto _L2; else goto _L1
_L1:
                    obj = BitmapFactory.decodeFileDescriptor(zzadS.getFileDescriptor());
                    flag = flag1;
_L3:
                    OutOfMemoryError outofmemoryerror;
                    try
                    {
                        zzadS.close();
                    }
                    catch (IOException ioexception)
                    {
                        Log.e("ImageManager", "closed failed", ioexception);
                    }
_L2:
                    countdownlatch = new CountDownLatch(1);
                    ImageManager.zzg(zzadR).post(zzadR. new zzf(mUri, ((Bitmap) (obj)), flag, countdownlatch));
                    try
                    {
                        countdownlatch.await();
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        Log.w("ImageManager", (new StringBuilder("Latch interrupted while posting ")).append(mUri).toString());
                    }
                    break MISSING_BLOCK_LABEL_158;
                    outofmemoryerror;
                    Log.e("ImageManager", (new StringBuilder("OOM while loading bitmap for uri: ")).append(mUri).toString(), outofmemoryerror);
                    flag = true;
                    outofmemoryerror = countdownlatch;
                      goto _L3
                }

                public zzc(Uri uri, ParcelFileDescriptor parcelfiledescriptor)
                {
                    zzadR = ImageManager.this;
                    super();
                    mUri = uri;
                    zzadS = parcelfiledescriptor;
                }

                private class zzf
                    implements Runnable
                {

                    private final Bitmap mBitmap;
                    private final Uri mUri;
                    final ImageManager zzadR;
                    private boolean zzadU;
                    private final CountDownLatch zzoS;

                    private void zza(ImageReceiver imagereceiver, boolean flag)
                    {
                        imagereceiver = ImageReceiver.zza(imagereceiver);
                        int j = imagereceiver.size();
                        int i = 0;
                        while (i < j) 
                        {
                            com.google.android.gms.common.images.zza zza1 = (com.google.android.gms.common.images.zza)imagereceiver.get(i);
                            if (flag)
                            {
                                zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), mBitmap, false);
                            } else
                            {
                                ImageManager.zzd(zzadR).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                                zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), false);
                            }
                            if (!(zza1 instanceof zza.zzc))
                            {
                                ImageManager.zza(zzadR).remove(zza1);
                            }
                            i++;
                        }
                    }

                    public final void run()
                    {
                        com.google.android.gms.common.internal.zzb.zzci("OnBitmapLoadedRunnable must be executed in the main thread");
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
                                ImageManager.zzh(zzadR).put(new zza.zza(mUri), mBitmap);
                            }
                        }
                        ImageReceiver imagereceiver = (ImageReceiver)ImageManager.zze(zzadR).remove(mUri);
                        if (imagereceiver != null)
                        {
                            zza(imagereceiver, flag);
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

                    public zzf(Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
                    {
                        zzadR = ImageManager.this;
                        super();
                        mUri = uri;
                        mBitmap = bitmap;
                        zzadU = flag;
                        zzoS = countdownlatch;
                    }
                }

            }

        }

    }

}
