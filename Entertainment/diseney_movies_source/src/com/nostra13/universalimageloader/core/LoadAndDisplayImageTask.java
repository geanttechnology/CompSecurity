// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoaderEngine, ImageLoaderConfiguration, ImageLoadingInfo, DisplayImageOptions, 
//            DisplayBitmapTask

final class LoadAndDisplayImageTask
    implements Runnable
{

    private static final int BUFFER_SIZE = 8192;
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED = "ImageView is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private static final String WARNING_POST_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String WARNING_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageView imageView;
    final ImageLoadingListener listener;
    private final boolean loggingEnabled;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    final DisplayImageOptions options;
    private final ImageDownloader slowNetworkDownloader;
    private final ImageSize targetSize;
    final String uri;

    public LoadAndDisplayImageTask(ImageLoaderEngine imageloaderengine, ImageLoadingInfo imageloadinginfo, Handler handler1)
    {
        engine = imageloaderengine;
        imageLoadingInfo = imageloadinginfo;
        handler = handler1;
        configuration = imageloaderengine.configuration;
        downloader = configuration.downloader;
        networkDeniedDownloader = configuration.networkDeniedDownloader;
        slowNetworkDownloader = configuration.slowNetworkDownloader;
        decoder = configuration.decoder;
        loggingEnabled = configuration.loggingEnabled;
        uri = imageloadinginfo.uri;
        memoryCacheKey = imageloadinginfo.memoryCacheKey;
        imageView = imageloadinginfo.imageView;
        targetSize = imageloadinginfo.targetSize;
        options = imageloadinginfo.options;
        listener = imageloadinginfo.listener;
    }

    private boolean checkTaskIsInterrupted()
    {
        boolean flag = Thread.interrupted();
        if (flag)
        {
            log("Task was interrupted [%s]");
        }
        return flag;
    }

    private boolean checkTaskIsNotActual()
    {
        String s = engine.getLoadingUriForView(imageView);
        boolean flag;
        if (memoryCacheKey.equals(s))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            handler.post(new Runnable() {

                final LoadAndDisplayImageTask this$0;

                public void run()
                {
                    listener.onLoadingCancelled(uri, imageView);
                }

            
            {
                this$0 = LoadAndDisplayImageTask.this;
                super();
            }
            });
            log("ImageView is reused for another image. Task is cancelled. [%s]");
        }
        return flag;
    }

    private Bitmap decodeImage(String s)
        throws IOException
    {
        ViewScaleType viewscaletype = ViewScaleType.fromImageView(imageView);
        s = new ImageDecodingInfo(memoryCacheKey, s, targetSize, viewscaletype, getDownloader(), options);
        return decoder.decode(s);
    }

    private boolean delayIfNeed()
    {
        if (options.shouldDelayBeforeLoading())
        {
            log("Delay %d ms before loading...  [%s]", new Object[] {
                Integer.valueOf(options.getDelayBeforeLoading()), memoryCacheKey
            });
            try
            {
                Thread.sleep(options.getDelayBeforeLoading());
            }
            catch (InterruptedException interruptedexception)
            {
                L.e("Task was interrupted [%s]", new Object[] {
                    memoryCacheKey
                });
                return true;
            }
            return checkTaskIsNotActual();
        } else
        {
            return false;
        }
    }

    private void downloadImage(File file)
        throws IOException
    {
        java.io.InputStream inputstream = getDownloader().getStream(uri, options.getExtraForDownloader());
        file = new BufferedOutputStream(new FileOutputStream(file), 8192);
        IoUtils.copyStream(inputstream, file);
        IoUtils.closeSilently(file);
        IoUtils.closeSilently(inputstream);
        return;
        Exception exception;
        exception;
        IoUtils.closeSilently(file);
        throw exception;
        file;
        IoUtils.closeSilently(inputstream);
        throw file;
    }

    private boolean downloadSizedImage(File file, int i, int j)
        throws IOException
    {
        Object obj;
        boolean flag1;
        obj = new ImageSize(i, j);
        DisplayImageOptions displayimageoptions = (new DisplayImageOptions.Builder()).cloneFrom(options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
        obj = new ImageDecodingInfo(memoryCacheKey, uri, ((ImageSize) (obj)), ViewScaleType.FIT_INSIDE, getDownloader(), displayimageoptions);
        obj = decoder.decode(((ImageDecodingInfo) (obj)));
        flag1 = false;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        file = new BufferedOutputStream(new FileOutputStream(file), 8192);
        boolean flag = ((Bitmap) (obj)).compress(configuration.imageCompressFormatForDiscCache, configuration.imageQualityForDiscCache, file);
        IoUtils.closeSilently(file);
        flag1 = flag;
        if (flag)
        {
            ((Bitmap) (obj)).recycle();
            flag1 = flag;
        }
        return flag1;
        Exception exception;
        exception;
        IoUtils.closeSilently(file);
        throw exception;
    }

    private void fireImageLoadingFailedEvent(final com.nostra13.universalimageloader.core.assist.FailReason.FailType failType, final Throwable failCause)
    {
        if (!Thread.interrupted())
        {
            handler.post(new Runnable() {

                final LoadAndDisplayImageTask this$0;
                private final Throwable val$failCause;
                private final com.nostra13.universalimageloader.core.assist.FailReason.FailType val$failType;

                public void run()
                {
                    if (options.shouldShowImageOnFail())
                    {
                        imageView.setImageResource(options.getImageOnFail());
                    }
                    listener.onLoadingFailed(uri, imageView, new FailReason(failType, failCause));
                }

            
            {
                this$0 = LoadAndDisplayImageTask.this;
                failType = failtype;
                failCause = throwable;
                super();
            }
            });
        }
    }

    private ImageDownloader getDownloader()
    {
        if (engine.isNetworkDenied())
        {
            return networkDeniedDownloader;
        }
        if (engine.isSlowNetwork())
        {
            return slowNetworkDownloader;
        } else
        {
            return downloader;
        }
    }

    private File getImageFileInDiscCache()
    {
        File file;
label0:
        {
            File file1 = configuration.discCache.get(uri);
            File file2 = file1.getParentFile();
            if (file2 != null)
            {
                file = file1;
                if (file2.exists())
                {
                    break label0;
                }
                file = file1;
                if (file2.mkdirs())
                {
                    break label0;
                }
            }
            file1 = configuration.reserveDiscCache.get(uri);
            file2 = file1.getParentFile();
            if (file2 != null)
            {
                file = file1;
                if (file2.exists())
                {
                    break label0;
                }
            }
            file2.mkdirs();
            file = file1;
        }
        return file;
    }

    private void log(String s)
    {
        if (loggingEnabled)
        {
            L.i(s, new Object[] {
                memoryCacheKey
            });
        }
    }

    private transient void log(String s, Object aobj[])
    {
        if (loggingEnabled)
        {
            L.i(s, aobj);
        }
    }

    private String tryCacheImageOnDisc(File file)
    {
        log("Cache image on disc [%s]");
        int i;
        int j;
        boolean flag;
        try
        {
            i = configuration.maxImageWidthForDiscCache;
            j = configuration.maxImageHeightForDiscCache;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            L.e(file);
            return uri;
        }
        flag = false;
        if (i <= 0 && j <= 0)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        flag = downloadSizedImage(file, i, j);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        downloadImage(file);
        configuration.discCache.put(uri, file);
        file = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
        return file;
    }

    private Bitmap tryLoadBitmap()
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        String s;
        Object obj1;
        Object obj2;
        File file;
        file = getImageFileInDiscCache();
        bitmap3 = null;
        s = null;
        obj1 = null;
        obj2 = null;
        bitmap = null;
        bitmap4 = bitmap3;
        bitmap1 = s;
        bitmap5 = obj1;
        bitmap2 = obj2;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        bitmap4 = bitmap3;
        bitmap1 = s;
        bitmap5 = obj1;
        bitmap2 = obj2;
        log("Load image from disc cache [%s]");
        bitmap4 = bitmap3;
        bitmap1 = s;
        bitmap5 = obj1;
        bitmap2 = obj2;
        bitmap = decodeImage(com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()));
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        if (bitmap.getWidth() <= 0) goto _L2; else goto _L3
_L3:
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        if (bitmap.getHeight() > 0) goto _L4; else goto _L2
_L2:
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        log("Load image from network [%s]");
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        if (!options.isCacheOnDisc()) goto _L6; else goto _L5
_L5:
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        s = tryCacheImageOnDisc(file);
_L7:
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        if (checkTaskIsNotActual())
        {
            break; /* Loop/switch isn't completed */
        }
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        bitmap = decodeImage(s);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        if (bitmap.getWidth() <= 0)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        if (bitmap.getHeight() > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        fireImageLoadingFailedEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.DECODING_ERROR, null);
        return bitmap;
_L6:
        bitmap4 = bitmap;
        bitmap1 = bitmap;
        bitmap5 = bitmap;
        bitmap2 = bitmap;
        s = uri;
        if (true) goto _L7; else goto _L4
        Object obj;
        obj;
        fireImageLoadingFailedEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.NETWORK_DENIED, null);
        return bitmap4;
        obj;
        L.e(((Throwable) (obj)));
        fireImageLoadingFailedEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.IO_ERROR, ((Throwable) (obj)));
        bitmap3 = bitmap1;
        if (file.exists())
        {
            file.delete();
            return bitmap1;
        }
          goto _L4
        obj;
        L.e(((Throwable) (obj)));
        fireImageLoadingFailedEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY, ((Throwable) (obj)));
        return bitmap5;
        obj;
        L.e(((Throwable) (obj)));
        fireImageLoadingFailedEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.UNKNOWN, ((Throwable) (obj)));
        bitmap3 = bitmap2;
_L4:
        return bitmap3;
    }

    private boolean waitIfPaused()
    {
        AtomicBoolean atomicboolean = engine.getPause();
        if (!atomicboolean.get()) goto _L2; else goto _L1
_L1:
        atomicboolean;
        JVM INSTR monitorenter ;
        log("ImageLoader is paused. Waiting...  [%s]");
        atomicboolean.wait();
        log(".. Resume loading [%s]");
        atomicboolean;
        JVM INSTR monitorexit ;
_L2:
        return checkTaskIsNotActual();
        Object obj;
        obj;
        L.e("Task was interrupted [%s]", new Object[] {
            memoryCacheKey
        });
        atomicboolean;
        JVM INSTR monitorexit ;
        return true;
        obj;
        atomicboolean;
        JVM INSTR monitorexit ;
        throw obj;
    }

    String getLoadingUri()
    {
        return uri;
    }

    public void run()
    {
_L2:
        return;
        if (waitIfPaused() || delayIfNeed()) goto _L2; else goto _L1
_L1:
        ReentrantLock reentrantlock;
        reentrantlock = imageLoadingInfo.loadFromUriLock;
        log("Start display image task [%s]");
        if (reentrantlock.isLocked())
        {
            log("Image already is loading. Waiting... [%s]");
        }
        reentrantlock.lock();
        boolean flag = checkTaskIsNotActual();
        if (flag)
        {
            reentrantlock.unlock();
            return;
        }
        Bitmap bitmap = (Bitmap)configuration.memoryCache.get(memoryCacheKey);
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_331;
        }
        bitmap = tryLoadBitmap();
        if (bitmap == null)
        {
            reentrantlock.unlock();
            return;
        }
        if (checkTaskIsNotActual())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        flag = checkTaskIsInterrupted();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        reentrantlock.unlock();
        return;
        Object obj = bitmap;
        if (!options.shouldPreProcess())
        {
            break MISSING_BLOCK_LABEL_172;
        }
        log("PreProcess image before caching in memory [%s]");
        bitmap = options.getPreProcessor().process(bitmap);
        obj = bitmap;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        L.w("Pre-processor returned null [%s]", new Object[0]);
        obj = bitmap;
        bitmap = ((Bitmap) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        bitmap = ((Bitmap) (obj));
        if (!options.isCacheInMemory())
        {
            break MISSING_BLOCK_LABEL_216;
        }
        log("Cache image in memory [%s]");
        configuration.memoryCache.put(memoryCacheKey, obj);
        bitmap = ((Bitmap) (obj));
_L4:
        obj = bitmap;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        obj = bitmap;
        if (!options.shouldPostProcess())
        {
            break MISSING_BLOCK_LABEL_278;
        }
        log("PostProcess image before displaying [%s]");
        bitmap = options.getPostProcessor().process(bitmap);
        obj = bitmap;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        L.w("Pre-processor returned null [%s]", new Object[] {
            memoryCacheKey
        });
        obj = bitmap;
        reentrantlock.unlock();
        if (checkTaskIsNotActual() || checkTaskIsInterrupted()) goto _L2; else goto _L3
_L3:
        obj = new DisplayBitmapTask(((Bitmap) (obj)), imageLoadingInfo, engine);
        ((DisplayBitmapTask) (obj)).setLoggingEnabled(loggingEnabled);
        handler.post(((Runnable) (obj)));
        return;
        log("...Get cached bitmap from memory after waiting. [%s]");
          goto _L4
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
