// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.tsz.afinal.bitmap.core.BitmapCache;
import net.tsz.afinal.bitmap.core.BitmapCommonUtils;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;
import net.tsz.afinal.bitmap.core.BitmapProcess;
import net.tsz.afinal.bitmap.display.Displayer;
import net.tsz.afinal.bitmap.display.SimpleDisplayer;
import net.tsz.afinal.bitmap.download.Downloader;
import net.tsz.afinal.bitmap.download.SimpleHttpDownloader;
import net.tsz.afinal.core.AsyncTask;

public class FinalBitmap
{
    private static class AsyncDrawable extends BitmapDrawable
    {

        private final WeakReference bitmapWorkerTaskReference;

        public BitmapLoadAndDisplayTask getBitmapWorkerTask()
        {
            return (BitmapLoadAndDisplayTask)bitmapWorkerTaskReference.get();
        }

        public AsyncDrawable(Resources resources, Bitmap bitmap, BitmapLoadAndDisplayTask bitmaploadanddisplaytask)
        {
            super(resources, bitmap);
            bitmapWorkerTaskReference = new WeakReference(bitmaploadanddisplaytask);
        }
    }

    private class BitmapLoadAndDisplayTask extends AsyncTask
    {

        private Object data;
        private final BitmapDisplayConfig displayConfig;
        private final WeakReference imageViewReference;
        final FinalBitmap this$0;

        private ImageView getAttachedImageView()
        {
            ImageView imageview = (ImageView)imageViewReference.get();
            if (this == FinalBitmap.getBitmapTaskFromImageView(imageview))
            {
                return imageview;
            } else
            {
                return null;
            }
        }

        protected transient Bitmap doInBackground(Object aobj[])
        {
            Object obj;
            String s;
            data = aobj[0];
            s = String.valueOf(data);
            obj = null;
            aobj = ((Object []) (mPauseWorkLock));
            aobj;
            JVM INSTR monitorenter ;
_L2:
            if (mPauseWork && !isCancelled())
            {
                break MISSING_BLOCK_LABEL_161;
            }
            aobj = ((Object []) (obj));
            if (FinalBitmap.mImageCache != null)
            {
                aobj = ((Object []) (obj));
                if (!isCancelled())
                {
                    aobj = ((Object []) (obj));
                    if (getAttachedImageView() != null)
                    {
                        aobj = ((Object []) (obj));
                        if (!mExitTasksEarly)
                        {
                            aobj = FinalBitmap.mImageCache.getBitmapFromDiskCache(s);
                        }
                    }
                }
            }
            obj = ((Object) (aobj));
            if (aobj == null)
            {
                obj = ((Object) (aobj));
                if (!isCancelled())
                {
                    obj = ((Object) (aobj));
                    if (getAttachedImageView() != null)
                    {
                        obj = ((Object) (aobj));
                        if (!mExitTasksEarly)
                        {
                            obj = processBitmap(s, displayConfig);
                        }
                    }
                }
            }
            if (obj != null && FinalBitmap.mImageCache != null)
            {
                FinalBitmap.mImageCache.addBitmapToCache(s, ((Bitmap) (obj)));
            }
            return ((Bitmap) (obj));
            Exception exception;
            try
            {
                mPauseWorkLock.wait();
            }
            catch (InterruptedException interruptedexception) { }
            finally { }
            if (true) goto _L2; else goto _L1
_L1:
            aobj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Object[])aobj);
        }

        protected void onCancelled(Bitmap bitmap)
        {
            super.onCancelled(bitmap);
            synchronized (mPauseWorkLock)
            {
                mPauseWorkLock.notifyAll();
            }
            return;
            exception;
            bitmap;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((Bitmap)obj);
        }

        protected void onPostExecute(Bitmap bitmap)
        {
            if (isCancelled() || mExitTasksEarly)
            {
                bitmap = null;
            }
            ImageView imageview = getAttachedImageView();
            if (bitmap != null && imageview != null)
            {
                mConfig.displayer.loadCompletedisplay(imageview, bitmap, displayConfig);
            } else
            if (bitmap == null && imageview != null)
            {
                mConfig.displayer.loadFailDisplay(imageview, displayConfig.getLoadfailBitmap());
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Bitmap)obj);
        }


        public BitmapLoadAndDisplayTask(ImageView imageview, BitmapDisplayConfig bitmapdisplayconfig)
        {
            this$0 = FinalBitmap.this;
            super();
            imageViewReference = new WeakReference(imageview);
            displayConfig = bitmapdisplayconfig;
        }
    }

    private class CacheExecutecTask extends AsyncTask
    {

        public static final int MESSAGE_CLEAR = 0;
        public static final int MESSAGE_CLEAR_DISK = 5;
        public static final int MESSAGE_CLEAR_KEY = 6;
        public static final int MESSAGE_CLEAR_KEY_IN_DISK = 8;
        public static final int MESSAGE_CLEAR_KEY_IN_MEMORY = 7;
        public static final int MESSAGE_CLEAR_MEMORY = 4;
        public static final int MESSAGE_CLOSE = 3;
        public static final int MESSAGE_FLUSH = 2;
        public static final int MESSAGE_INIT_DISK_CACHE = 1;
        final FinalBitmap this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Object[])aobj);
        }

        protected transient Void doInBackground(Object aobj[])
        {
            ((Integer)aobj[0]).intValue();
            JVM INSTR tableswitch 0 8: default 60
        //                       0 62
        //                       1 72
        //                       2 82
        //                       3 99
        //                       4 113
        //                       5 123
        //                       6 133
        //                       7 149
        //                       8 165;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            return null;
_L2:
            clearCacheInternalInBackgroud();
            continue; /* Loop/switch isn't completed */
_L3:
            initDiskCacheInternalInBackgroud();
            continue; /* Loop/switch isn't completed */
_L4:
            clearMemoryCacheInBackgroud();
            flushCacheInternalInBackgroud();
            continue; /* Loop/switch isn't completed */
_L5:
            clearMemoryCacheInBackgroud();
            closeCacheInternalInBackgroud();
_L6:
            clearMemoryCacheInBackgroud();
            continue; /* Loop/switch isn't completed */
_L7:
            clearDiskCacheInBackgroud();
            continue; /* Loop/switch isn't completed */
_L8:
            clearCacheInBackgroud(String.valueOf(aobj[1]));
            continue; /* Loop/switch isn't completed */
_L9:
            clearMemoryCacheInBackgroud(String.valueOf(aobj[1]));
            continue; /* Loop/switch isn't completed */
_L10:
            clearDiskCacheInBackgroud(String.valueOf(aobj[1]));
            if (true) goto _L1; else goto _L11
_L11:
        }

        private CacheExecutecTask()
        {
            this$0 = FinalBitmap.this;
            super();
        }

        CacheExecutecTask(CacheExecutecTask cacheexecutectask)
        {
            this();
        }
    }

    private class FinalBitmapConfig
    {

        public BitmapProcess bitmapProcess;
        public String cachePath;
        public BitmapDisplayConfig defaultDisplayConfig;
        public int diskCacheSize;
        public Displayer displayer;
        public Downloader downloader;
        public int memCacheSize;
        public float memCacheSizePercent;
        public int originalDiskCacheSize;
        public int poolSize;
        final FinalBitmap this$0;

        public void init()
        {
            if (downloader == null)
            {
                downloader = new SimpleHttpDownloader();
            }
            if (displayer == null)
            {
                displayer = new SimpleDisplayer();
            }
            bitmapProcess = new BitmapProcess(downloader, cachePath, originalDiskCacheSize);
        }

        public FinalBitmapConfig(Context context)
        {
            this$0 = FinalBitmap.this;
            super();
            poolSize = 3;
            originalDiskCacheSize = 0x1e00000;
            defaultDisplayConfig = new BitmapDisplayConfig();
            defaultDisplayConfig.setAnimation(null);
            defaultDisplayConfig.setAnimationType(1);
            int i = (int)Math.floor(context.getResources().getDisplayMetrics().widthPixels / 4);
            defaultDisplayConfig.setBitmapHeight(i);
            defaultDisplayConfig.setBitmapWidth(i);
        }
    }


    private static ExecutorService bitmapLoadAndDisplayExecutor;
    private static FinalBitmap mFinalBitmap;
    private static BitmapCache mImageCache;
    private HashMap configMap;
    private FinalBitmapConfig mConfig;
    private Context mContext;
    private boolean mExitTasksEarly;
    private boolean mPauseWork;
    private final Object mPauseWorkLock = new Object();

    private FinalBitmap(Context context)
    {
        mExitTasksEarly = false;
        mPauseWork = false;
        configMap = new HashMap();
        mContext = context;
        mConfig = new FinalBitmapConfig(context);
        configDiskCachePath(BitmapCommonUtils.getDiskCacheDir(context, "afinalCache").getAbsolutePath());
        configDisplayer(new SimpleDisplayer());
        configDownlader(new SimpleHttpDownloader());
    }

    public static boolean checkImageTask(Object obj, ImageView imageview)
    {
label0:
        {
            imageview = getBitmapTaskFromImageView(imageview);
            if (imageview != null)
            {
                Object obj1 = ((BitmapLoadAndDisplayTask) (imageview)).data;
                if (obj1 != null && obj1.equals(obj))
                {
                    break label0;
                }
                imageview.cancel(true);
            }
            return true;
        }
        return false;
    }

    private void clearCacheInBackgroud(String s)
    {
        if (mImageCache != null)
        {
            mImageCache.clearCache(s);
        }
    }

    private void clearCacheInternalInBackgroud()
    {
        if (mImageCache != null)
        {
            mImageCache.clearCache();
        }
        if (mConfig != null && mConfig.bitmapProcess != null)
        {
            mConfig.bitmapProcess.clearCacheInternal();
        }
    }

    private void clearDiskCacheInBackgroud()
    {
        if (mImageCache != null)
        {
            mImageCache.clearDiskCache();
        }
        if (mConfig != null && mConfig.bitmapProcess != null)
        {
            mConfig.bitmapProcess.clearCacheInternal();
        }
    }

    private void clearDiskCacheInBackgroud(String s)
    {
        if (mImageCache != null)
        {
            mImageCache.clearDiskCache(s);
        }
    }

    private void clearMemoryCacheInBackgroud()
    {
        if (mImageCache != null)
        {
            mImageCache.clearMemoryCache();
        }
    }

    private void clearMemoryCacheInBackgroud(String s)
    {
        if (mImageCache != null)
        {
            mImageCache.clearMemoryCache(s);
        }
    }

    private void closeCacheInternalInBackgroud()
    {
        if (mImageCache != null)
        {
            mImageCache.close();
            mImageCache = null;
        }
        if (mConfig != null && mConfig.bitmapProcess != null)
        {
            mConfig.bitmapProcess.clearCacheInternal();
        }
    }

    private FinalBitmap configBitmapLoadThreadSize(int i)
    {
        if (i >= 1)
        {
            mConfig.poolSize = i;
        }
        return this;
    }

    private FinalBitmap configDiskCachePath(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            mConfig.cachePath = s;
        }
        return this;
    }

    private FinalBitmap configDiskCacheSize(int i)
    {
        mConfig.diskCacheSize = i;
        return this;
    }

    private FinalBitmap configMemoryCachePercent(float f)
    {
        mConfig.memCacheSizePercent = f;
        return this;
    }

    private FinalBitmap configMemoryCacheSize(int i)
    {
        mConfig.memCacheSize = i;
        return this;
    }

    public static FinalBitmap create(Context context)
    {
        if (mFinalBitmap == null)
        {
            mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            mFinalBitmap.init();
        }
        return mFinalBitmap;
    }

    public static FinalBitmap create(Context context, String s)
    {
        if (mFinalBitmap == null)
        {
            mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            mFinalBitmap.configDiskCachePath(s);
            mFinalBitmap.init();
        }
        return mFinalBitmap;
    }

    public static FinalBitmap create(Context context, String s, float f)
    {
        if (mFinalBitmap == null)
        {
            mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            mFinalBitmap.configDiskCachePath(s);
            mFinalBitmap.configMemoryCachePercent(f);
            mFinalBitmap.init();
        }
        return mFinalBitmap;
    }

    public static FinalBitmap create(Context context, String s, float f, int i)
    {
        if (mFinalBitmap == null)
        {
            mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            mFinalBitmap.configDiskCachePath(s);
            mFinalBitmap.configBitmapLoadThreadSize(i);
            mFinalBitmap.configMemoryCachePercent(f);
            mFinalBitmap.init();
        }
        return mFinalBitmap;
    }

    public static FinalBitmap create(Context context, String s, float f, int i, int j)
    {
        if (mFinalBitmap == null)
        {
            mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            mFinalBitmap.configDiskCachePath(s);
            mFinalBitmap.configBitmapLoadThreadSize(j);
            mFinalBitmap.configMemoryCachePercent(f);
            mFinalBitmap.configDiskCacheSize(i);
            mFinalBitmap.init();
        }
        return mFinalBitmap;
    }

    public static FinalBitmap create(Context context, String s, int i)
    {
        if (mFinalBitmap == null)
        {
            mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            mFinalBitmap.configDiskCachePath(s);
            mFinalBitmap.configMemoryCacheSize(i);
            mFinalBitmap.init();
        }
        return mFinalBitmap;
    }

    public static FinalBitmap create(Context context, String s, int i, int j)
    {
        if (mFinalBitmap == null)
        {
            mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            mFinalBitmap.configDiskCachePath(s);
            mFinalBitmap.configBitmapLoadThreadSize(j);
            mFinalBitmap.configMemoryCacheSize(i);
            mFinalBitmap.init();
        }
        return mFinalBitmap;
    }

    public static FinalBitmap create(Context context, String s, int i, int j, int k)
    {
        if (mFinalBitmap == null)
        {
            mFinalBitmap = new FinalBitmap(context.getApplicationContext());
            mFinalBitmap.configDiskCachePath(s);
            mFinalBitmap.configBitmapLoadThreadSize(k);
            mFinalBitmap.configMemoryCacheSize(i);
            mFinalBitmap.configDiskCacheSize(j);
            mFinalBitmap.init();
        }
        return mFinalBitmap;
    }

    private void doDisplay(ImageView imageview, String s, BitmapDisplayConfig bitmapdisplayconfig)
    {
        if (!TextUtils.isEmpty(s) && imageview != null)
        {
            BitmapDisplayConfig bitmapdisplayconfig1 = bitmapdisplayconfig;
            if (bitmapdisplayconfig == null)
            {
                bitmapdisplayconfig1 = mConfig.defaultDisplayConfig;
            }
            bitmapdisplayconfig = null;
            if (mImageCache != null)
            {
                bitmapdisplayconfig = mImageCache.getBitmapFromMemCache(s);
            }
            if (bitmapdisplayconfig != null)
            {
                imageview.setImageBitmap(bitmapdisplayconfig);
                return;
            }
            if (checkImageTask(s, imageview))
            {
                bitmapdisplayconfig = new BitmapLoadAndDisplayTask(imageview, bitmapdisplayconfig1);
                imageview.setImageDrawable(new AsyncDrawable(mContext.getResources(), bitmapdisplayconfig1.getLoadingBitmap(), bitmapdisplayconfig));
                bitmapdisplayconfig.executeOnExecutor(bitmapLoadAndDisplayExecutor, new Object[] {
                    s
                });
                return;
            }
        }
    }

    private void flushCacheInternalInBackgroud()
    {
        if (mImageCache != null)
        {
            mImageCache.flush();
        }
        if (mConfig != null && mConfig.bitmapProcess != null)
        {
            mConfig.bitmapProcess.flushCacheInternal();
        }
    }

    private static BitmapLoadAndDisplayTask getBitmapTaskFromImageView(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview instanceof AsyncDrawable)
            {
                return ((AsyncDrawable)imageview).getBitmapWorkerTask();
            }
        }
        return null;
    }

    private BitmapDisplayConfig getDisplayConfig()
    {
        BitmapDisplayConfig bitmapdisplayconfig = new BitmapDisplayConfig();
        bitmapdisplayconfig.setAnimation(mConfig.defaultDisplayConfig.getAnimation());
        bitmapdisplayconfig.setAnimationType(mConfig.defaultDisplayConfig.getAnimationType());
        bitmapdisplayconfig.setBitmapHeight(mConfig.defaultDisplayConfig.getBitmapHeight());
        bitmapdisplayconfig.setBitmapWidth(mConfig.defaultDisplayConfig.getBitmapWidth());
        bitmapdisplayconfig.setLoadfailBitmap(mConfig.defaultDisplayConfig.getLoadfailBitmap());
        bitmapdisplayconfig.setLoadingBitmap(mConfig.defaultDisplayConfig.getLoadingBitmap());
        return bitmapdisplayconfig;
    }

    private FinalBitmap init()
    {
        mConfig.init();
        net.tsz.afinal.bitmap.core.BitmapCache.ImageCacheParams imagecacheparams = new net.tsz.afinal.bitmap.core.BitmapCache.ImageCacheParams(mConfig.cachePath);
        if ((double)mConfig.memCacheSizePercent > 0.050000000000000003D && (double)mConfig.memCacheSizePercent < 0.80000000000000004D)
        {
            imagecacheparams.setMemCacheSizePercent(mContext, mConfig.memCacheSizePercent);
        } else
        if (mConfig.memCacheSize > 0x200000)
        {
            imagecacheparams.setMemCacheSize(mConfig.memCacheSize);
        } else
        {
            imagecacheparams.setMemCacheSizePercent(mContext, 0.3F);
        }
        if (mConfig.diskCacheSize > 0x500000)
        {
            imagecacheparams.setDiskCacheSize(mConfig.diskCacheSize);
        }
        mImageCache = new BitmapCache(imagecacheparams);
        bitmapLoadAndDisplayExecutor = Executors.newFixedThreadPool(mConfig.poolSize, new ThreadFactory() {

            final FinalBitmap this$0;

            public Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable);
                runnable.setPriority(4);
                return runnable;
            }

            
            {
                this$0 = FinalBitmap.this;
                super();
            }
        });
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(1)
        });
        return this;
    }

    private void initDiskCacheInternalInBackgroud()
    {
        if (mImageCache != null)
        {
            mImageCache.initDiskCache();
        }
        if (mConfig != null && mConfig.bitmapProcess != null)
        {
            mConfig.bitmapProcess.initHttpDiskCache();
        }
    }

    private Bitmap processBitmap(String s, BitmapDisplayConfig bitmapdisplayconfig)
    {
        if (mConfig != null && mConfig.bitmapProcess != null)
        {
            return mConfig.bitmapProcess.processBitmap(s, bitmapdisplayconfig);
        } else
        {
            return null;
        }
    }

    public void clearCache()
    {
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(0)
        });
    }

    public void clearCache(String s)
    {
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(6), s
        });
    }

    public void clearDiskCache()
    {
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(5)
        });
    }

    public void clearDiskCache(String s)
    {
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(8), s
        });
    }

    public void clearMemoryCache()
    {
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(4)
        });
    }

    public void clearMemoryCache(String s)
    {
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(7), s
        });
    }

    public void closeCache()
    {
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(3)
        });
    }

    public FinalBitmap configBitmapMaxHeight(int i)
    {
        mConfig.defaultDisplayConfig.setBitmapHeight(i);
        return this;
    }

    public FinalBitmap configBitmapMaxWidth(int i)
    {
        mConfig.defaultDisplayConfig.setBitmapWidth(i);
        return this;
    }

    public FinalBitmap configCalculateBitmapSizeWhenDecode(boolean flag)
    {
        if (mConfig != null && mConfig.bitmapProcess != null)
        {
            mConfig.bitmapProcess.configCalculateBitmap(flag);
        }
        return this;
    }

    public void configCompressFormat(android.graphics.Bitmap.CompressFormat compressformat)
    {
        mImageCache.setCompressFormat(compressformat);
    }

    public FinalBitmap configDisplayer(Displayer displayer)
    {
        mConfig.displayer = displayer;
        return this;
    }

    public FinalBitmap configDownlader(Downloader downloader)
    {
        mConfig.downloader = downloader;
        return this;
    }

    public FinalBitmap configLoadfailImage(int i)
    {
        mConfig.defaultDisplayConfig.setLoadfailBitmap(BitmapFactory.decodeResource(mContext.getResources(), i));
        return this;
    }

    public FinalBitmap configLoadfailImage(Bitmap bitmap)
    {
        mConfig.defaultDisplayConfig.setLoadfailBitmap(bitmap);
        return this;
    }

    public FinalBitmap configLoadingImage(int i)
    {
        mConfig.defaultDisplayConfig.setLoadingBitmap(BitmapFactory.decodeResource(mContext.getResources(), i));
        return this;
    }

    public FinalBitmap configLoadingImage(Bitmap bitmap)
    {
        mConfig.defaultDisplayConfig.setLoadingBitmap(bitmap);
        return this;
    }

    public void display(ImageView imageview, String s)
    {
        doDisplay(imageview, s, null);
    }

    public void display(ImageView imageview, String s, int i, int j)
    {
        BitmapDisplayConfig bitmapdisplayconfig1 = (BitmapDisplayConfig)configMap.get((new StringBuilder(String.valueOf(i))).append("_").append(j).toString());
        BitmapDisplayConfig bitmapdisplayconfig = bitmapdisplayconfig1;
        if (bitmapdisplayconfig1 == null)
        {
            bitmapdisplayconfig = getDisplayConfig();
            bitmapdisplayconfig.setBitmapHeight(j);
            bitmapdisplayconfig.setBitmapWidth(i);
            configMap.put((new StringBuilder(String.valueOf(i))).append("_").append(j).toString(), bitmapdisplayconfig);
        }
        doDisplay(imageview, s, bitmapdisplayconfig);
    }

    public void display(ImageView imageview, String s, int i, int j, Bitmap bitmap, Bitmap bitmap1)
    {
        BitmapDisplayConfig bitmapdisplayconfig1 = (BitmapDisplayConfig)configMap.get((new StringBuilder(String.valueOf(i))).append("_").append(j).append("_").append(String.valueOf(bitmap)).append("_").append(String.valueOf(bitmap1)).toString());
        BitmapDisplayConfig bitmapdisplayconfig = bitmapdisplayconfig1;
        if (bitmapdisplayconfig1 == null)
        {
            bitmapdisplayconfig = getDisplayConfig();
            bitmapdisplayconfig.setBitmapHeight(j);
            bitmapdisplayconfig.setBitmapWidth(i);
            bitmapdisplayconfig.setLoadingBitmap(bitmap);
            bitmapdisplayconfig.setLoadfailBitmap(bitmap1);
            configMap.put((new StringBuilder(String.valueOf(i))).append("_").append(j).append("_").append(String.valueOf(bitmap)).append("_").append(String.valueOf(bitmap1)).toString(), bitmapdisplayconfig);
        }
        doDisplay(imageview, s, bitmapdisplayconfig);
    }

    public void display(ImageView imageview, String s, Bitmap bitmap)
    {
        BitmapDisplayConfig bitmapdisplayconfig1 = (BitmapDisplayConfig)configMap.get(String.valueOf(bitmap));
        BitmapDisplayConfig bitmapdisplayconfig = bitmapdisplayconfig1;
        if (bitmapdisplayconfig1 == null)
        {
            bitmapdisplayconfig = getDisplayConfig();
            bitmapdisplayconfig.setLoadingBitmap(bitmap);
            configMap.put(String.valueOf(bitmap), bitmapdisplayconfig);
        }
        doDisplay(imageview, s, bitmapdisplayconfig);
    }

    public void display(ImageView imageview, String s, Bitmap bitmap, Bitmap bitmap1)
    {
        BitmapDisplayConfig bitmapdisplayconfig1 = (BitmapDisplayConfig)configMap.get((new StringBuilder(String.valueOf(String.valueOf(bitmap)))).append("_").append(String.valueOf(bitmap1)).toString());
        BitmapDisplayConfig bitmapdisplayconfig = bitmapdisplayconfig1;
        if (bitmapdisplayconfig1 == null)
        {
            bitmapdisplayconfig = getDisplayConfig();
            bitmapdisplayconfig.setLoadingBitmap(bitmap);
            bitmapdisplayconfig.setLoadfailBitmap(bitmap1);
            configMap.put((new StringBuilder(String.valueOf(String.valueOf(bitmap)))).append("_").append(String.valueOf(bitmap1)).toString(), bitmapdisplayconfig);
        }
        doDisplay(imageview, s, bitmapdisplayconfig);
    }

    public void display(ImageView imageview, String s, BitmapDisplayConfig bitmapdisplayconfig)
    {
        doDisplay(imageview, s, bitmapdisplayconfig);
    }

    public void exitTasksEarly(boolean flag)
    {
        mExitTasksEarly = flag;
        if (flag)
        {
            pauseWork(false);
        }
    }

    public void flushCache()
    {
        (new CacheExecutecTask(null)).execute(new Object[] {
            Integer.valueOf(2)
        });
    }

    public Bitmap getBitmapFromCache(String s)
    {
        Bitmap bitmap1 = getBitmapFromMemoryCache(s);
        Bitmap bitmap = bitmap1;
        if (bitmap1 == null)
        {
            bitmap = getBitmapFromDiskCache(s);
        }
        return bitmap;
    }

    public Bitmap getBitmapFromDiskCache(String s)
    {
        return mImageCache.getBitmapFromDiskCache(s);
    }

    public Bitmap getBitmapFromMemoryCache(String s)
    {
        return mImageCache.getBitmapFromMemCache(s);
    }

    public void onDestroy()
    {
        closeCache();
    }

    public void onPause()
    {
        setExitTasksEarly(true);
        flushCache();
    }

    public void onResume()
    {
        setExitTasksEarly(false);
    }

    public void pauseWork(boolean flag)
    {
        synchronized (mPauseWorkLock)
        {
            mPauseWork = flag;
            if (!mPauseWork)
            {
                mPauseWorkLock.notifyAll();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setExitTasksEarly(boolean flag)
    {
        mExitTasksEarly = flag;
    }
















}
