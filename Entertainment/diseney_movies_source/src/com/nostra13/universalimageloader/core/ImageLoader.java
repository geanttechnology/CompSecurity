// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.FakeBitmapDisplayer;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoaderEngine, ImageLoaderConfiguration, DisplayImageOptions, ImageLoadingInfo, 
//            ProcessAndDisplayImageTask, LoadAndDisplayImageTask

public class ImageLoader
{

    private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    static final String LOG_DESTROY = "Destroy ImageLoader";
    static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
    static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    public static final String TAG = com/nostra13/universalimageloader/core/ImageLoader.getSimpleName();
    private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static volatile ImageLoader instance;
    private ImageLoaderConfiguration configuration;
    private final ImageLoadingListener emptyListener = new SimpleImageLoadingListener();
    private ImageLoaderEngine engine;
    private final BitmapDisplayer fakeBitmapDisplayer = new FakeBitmapDisplayer();

    protected ImageLoader()
    {
    }

    private void checkConfiguration()
    {
        if (configuration == null)
        {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        } else
        {
            return;
        }
    }

    public static ImageLoader getInstance()
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new ImageLoader();
        }
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        Exception exception;
        exception;
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void cancelDisplayTask(ImageView imageview)
    {
        engine.cancelDisplayTaskFor(imageview);
    }

    public void clearDiscCache()
    {
        checkConfiguration();
        configuration.discCache.clear();
    }

    public void clearMemoryCache()
    {
        checkConfiguration();
        configuration.memoryCache.clear();
    }

    public void denyNetworkDownloads(boolean flag)
    {
        engine.denyNetworkDownloads(flag);
    }

    public void destroy()
    {
        if (configuration != null && configuration.loggingEnabled)
        {
            L.d("Destroy ImageLoader", new Object[0]);
        }
        stop();
        engine = null;
        configuration = null;
    }

    public void displayImage(String s, ImageView imageview)
    {
        displayImage(s, imageview, null, null);
    }

    public void displayImage(String s, ImageView imageview, DisplayImageOptions displayimageoptions)
    {
        displayImage(s, imageview, displayimageoptions, null);
    }

    public void displayImage(String s, ImageView imageview, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        ImageLoadingListener imageloadinglistener1;
        ImageSize imagesize;
        String s1;
        checkConfiguration();
        if (imageview == null)
        {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        imageloadinglistener1 = imageloadinglistener;
        if (imageloadinglistener == null)
        {
            imageloadinglistener1 = emptyListener;
        }
        imageloadinglistener = displayimageoptions;
        if (displayimageoptions == null)
        {
            imageloadinglistener = configuration.defaultDisplayImageOptions;
        }
        if (TextUtils.isEmpty(s))
        {
            engine.cancelDisplayTaskFor(imageview);
            imageloadinglistener1.onLoadingStarted(s, imageview);
            if (imageloadinglistener.shouldShowImageForEmptyUri())
            {
                imageview.setImageResource(imageloadinglistener.getImageForEmptyUri());
            } else
            {
                imageview.setImageBitmap(null);
            }
            imageloadinglistener1.onLoadingComplete(s, imageview, null);
            return;
        }
        imagesize = ImageSizeUtils.defineTargetSizeForView(imageview, configuration.maxImageWidthForMemoryCache, configuration.maxImageHeightForMemoryCache);
        s1 = MemoryCacheUtil.generateKey(s, imagesize);
        engine.prepareDisplayTaskFor(imageview, s1);
        imageloadinglistener1.onLoadingStarted(s, imageview);
        displayimageoptions = (Bitmap)configuration.memoryCache.get(s1);
        if (displayimageoptions != null && !displayimageoptions.isRecycled())
        {
            if (configuration.loggingEnabled)
            {
                L.i("Load image from memory cache [%s]", new Object[] {
                    s1
                });
            }
            if (imageloadinglistener.shouldPostProcess())
            {
                s = new ImageLoadingInfo(s, imageview, imagesize, s1, imageloadinglistener, imageloadinglistener1, engine.getLockForUri(s));
                s = new ProcessAndDisplayImageTask(engine, displayimageoptions, s, imageloadinglistener.getHandler());
                engine.submit(s);
                return;
            } else
            {
                imageloadinglistener.getDisplayer().display(displayimageoptions, imageview);
                imageloadinglistener1.onLoadingComplete(s, imageview, displayimageoptions);
                return;
            }
        }
        if (!imageloadinglistener.shouldShowStubImage()) goto _L2; else goto _L1
_L1:
        imageview.setImageResource(imageloadinglistener.getStubImage());
_L4:
        s = new ImageLoadingInfo(s, imageview, imagesize, s1, imageloadinglistener, imageloadinglistener1, engine.getLockForUri(s));
        s = new LoadAndDisplayImageTask(engine, s, imageloadinglistener.getHandler());
        engine.submit(s);
        return;
_L2:
        if (imageloadinglistener.isResetViewBeforeLoading())
        {
            imageview.setImageBitmap(null);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void displayImage(String s, ImageView imageview, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, imageview, null, imageloadinglistener);
    }

    public DiscCacheAware getDiscCache()
    {
        checkConfiguration();
        return configuration.discCache;
    }

    public String getLoadingUriForView(ImageView imageview)
    {
        return engine.getLoadingUriForView(imageview);
    }

    public MemoryCacheAware getMemoryCache()
    {
        checkConfiguration();
        return configuration.memoryCache;
    }

    public void handleSlowNetwork(boolean flag)
    {
        engine.handleSlowNetwork(flag);
    }

    public void init(ImageLoaderConfiguration imageloaderconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        if (imageloaderconfiguration != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        imageloaderconfiguration;
        this;
        JVM INSTR monitorexit ;
        throw imageloaderconfiguration;
        if (configuration != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (imageloaderconfiguration.loggingEnabled)
        {
            L.d("Initialize ImageLoader with configuration", new Object[0]);
        }
        engine = new ImageLoaderEngine(imageloaderconfiguration);
        configuration = imageloaderconfiguration;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        L.w("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
          goto _L1
    }

    public boolean isInited()
    {
        return configuration != null;
    }

    public void loadImage(String s, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, null, displayimageoptions, imageloadinglistener);
    }

    public void loadImage(String s, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, null, null, imageloadinglistener);
    }

    public void loadImage(String s, ImageSize imagesize, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        checkConfiguration();
        ImageSize imagesize1 = imagesize;
        if (imagesize == null)
        {
            imagesize1 = new ImageSize(configuration.maxImageWidthForMemoryCache, configuration.maxImageHeightForMemoryCache);
        }
        imagesize = displayimageoptions;
        if (displayimageoptions == null)
        {
            imagesize = configuration.defaultDisplayImageOptions;
        }
        if (!(imagesize.getDisplayer() instanceof FakeBitmapDisplayer))
        {
            imagesize = (new DisplayImageOptions.Builder()).cloneFrom(imagesize).displayer(fakeBitmapDisplayer).build();
        }
        displayimageoptions = new ImageView(configuration.context);
        displayimageoptions.setLayoutParams(new android.view.ViewGroup.LayoutParams(imagesize1.getWidth(), imagesize1.getHeight()));
        displayimageoptions.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        displayImage(s, displayimageoptions, imagesize, imageloadinglistener);
    }

    public void loadImage(String s, ImageSize imagesize, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, imagesize, null, imageloadinglistener);
    }

    public void pause()
    {
        engine.pause();
    }

    public void resume()
    {
        engine.resume();
    }

    public void stop()
    {
        engine.stop();
    }

}
