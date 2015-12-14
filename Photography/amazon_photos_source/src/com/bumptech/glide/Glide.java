// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.ImageVideoDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.file.StreamFileDataLoadProvider;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableLoadProvider;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider;
import com.bumptech.glide.load.resource.transcode.GifBitmapWrapperDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.GlideBitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.provider.DataLoadProviderRegistry;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.bumptech.glide:
//            GlideBuilder, RequestManager

public class Glide
{
    private static class ClearTarget extends ViewTarget
    {

        public void onLoadCleared(Drawable drawable)
        {
        }

        public void onLoadFailed(Exception exception, Drawable drawable)
        {
        }

        public void onLoadStarted(Drawable drawable)
        {
        }

        public void onResourceReady(Object obj, GlideAnimation glideanimation)
        {
        }

        public ClearTarget(View view)
        {
            super(view);
        }
    }


    private static volatile Glide glide;
    private final CenterCrop bitmapCenterCrop;
    private final FitCenter bitmapFitCenter;
    private final BitmapPool bitmapPool;
    private final BitmapPreFiller bitmapPreFiller;
    private final DataLoadProviderRegistry dataLoadProviderRegistry = new DataLoadProviderRegistry();
    private final DecodeFormat decodeFormat;
    private final GifBitmapWrapperTransformation drawableCenterCrop;
    private final GifBitmapWrapperTransformation drawableFitCenter;
    private final Engine engine;
    private final ImageViewTargetFactory imageViewTargetFactory = new ImageViewTargetFactory();
    private final GenericLoaderFactory loaderFactory;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final MemoryCache memoryCache;
    private final TranscoderRegistry transcoderRegistry = new TranscoderRegistry();

    Glide(Engine engine1, MemoryCache memorycache, BitmapPool bitmappool, Context context, DecodeFormat decodeformat)
    {
        engine = engine1;
        bitmapPool = bitmappool;
        memoryCache = memorycache;
        decodeFormat = decodeformat;
        loaderFactory = new GenericLoaderFactory(context);
        bitmapPreFiller = new BitmapPreFiller(memorycache, bitmappool, decodeformat);
        engine1 = new StreamBitmapDataLoadProvider(bitmappool, decodeformat);
        dataLoadProviderRegistry.register(java/io/InputStream, android/graphics/Bitmap, engine1);
        memorycache = new FileDescriptorBitmapDataLoadProvider(bitmappool, decodeformat);
        dataLoadProviderRegistry.register(android/os/ParcelFileDescriptor, android/graphics/Bitmap, memorycache);
        engine1 = new ImageVideoDataLoadProvider(engine1, memorycache);
        dataLoadProviderRegistry.register(com/bumptech/glide/load/model/ImageVideoWrapper, android/graphics/Bitmap, engine1);
        memorycache = new GifDrawableLoadProvider(context, bitmappool);
        dataLoadProviderRegistry.register(java/io/InputStream, com/bumptech/glide/load/resource/gif/GifDrawable, memorycache);
        dataLoadProviderRegistry.register(com/bumptech/glide/load/model/ImageVideoWrapper, com/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper, new ImageVideoGifDrawableLoadProvider(engine1, memorycache, bitmappool));
        dataLoadProviderRegistry.register(java/io/InputStream, java/io/File, new StreamFileDataLoadProvider());
        register(java/io/File, android/os/ParcelFileDescriptor, new com.bumptech.glide.load.model.file_descriptor.FileDescriptorFileLoader.Factory());
        register(java/io/File, java/io/InputStream, new com.bumptech.glide.load.model.stream.StreamFileLoader.Factory());
        register(Integer.TYPE, android/os/ParcelFileDescriptor, new com.bumptech.glide.load.model.file_descriptor.FileDescriptorResourceLoader.Factory());
        register(Integer.TYPE, java/io/InputStream, new com.bumptech.glide.load.model.stream.StreamResourceLoader.Factory());
        register(java/lang/Integer, android/os/ParcelFileDescriptor, new com.bumptech.glide.load.model.file_descriptor.FileDescriptorResourceLoader.Factory());
        register(java/lang/Integer, java/io/InputStream, new com.bumptech.glide.load.model.stream.StreamResourceLoader.Factory());
        register(java/lang/String, android/os/ParcelFileDescriptor, new com.bumptech.glide.load.model.file_descriptor.FileDescriptorStringLoader.Factory());
        register(java/lang/String, java/io/InputStream, new com.bumptech.glide.load.model.stream.StreamStringLoader.Factory());
        register(android/net/Uri, android/os/ParcelFileDescriptor, new com.bumptech.glide.load.model.file_descriptor.FileDescriptorUriLoader.Factory());
        register(android/net/Uri, java/io/InputStream, new com.bumptech.glide.load.model.stream.StreamUriLoader.Factory());
        register(java/net/URL, java/io/InputStream, new com.bumptech.glide.load.model.stream.StreamUrlLoader.Factory());
        register(com/bumptech/glide/load/model/GlideUrl, java/io/InputStream, new com.bumptech.glide.load.model.stream.HttpUrlGlideUrlLoader.Factory());
        register([B, java/io/InputStream, new com.bumptech.glide.load.model.stream.StreamByteArrayLoader.Factory());
        transcoderRegistry.register(android/graphics/Bitmap, com/bumptech/glide/load/resource/bitmap/GlideBitmapDrawable, new GlideBitmapDrawableTranscoder(context.getResources(), bitmappool));
        transcoderRegistry.register(com/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper, com/bumptech/glide/load/resource/drawable/GlideDrawable, new GifBitmapWrapperDrawableTranscoder(new GlideBitmapDrawableTranscoder(context.getResources(), bitmappool)));
        bitmapCenterCrop = new CenterCrop(bitmappool);
        drawableCenterCrop = new GifBitmapWrapperTransformation(bitmappool, bitmapCenterCrop);
        bitmapFitCenter = new FitCenter(bitmappool);
        drawableFitCenter = new GifBitmapWrapperTransformation(bitmappool, bitmapFitCenter);
    }

    public static ModelLoader buildFileDescriptorModelLoader(Class class1, Context context)
    {
        return buildModelLoader(class1, android/os/ParcelFileDescriptor, context);
    }

    public static ModelLoader buildModelLoader(Class class1, Class class2, Context context)
    {
        if (class1 == null)
        {
            if (Log.isLoggable("Glide", 3))
            {
                Log.d("Glide", "Unable to load null model, setting placeholder only");
            }
            return null;
        } else
        {
            return get(context).getLoaderFactory().buildModelLoader(class1, class2);
        }
    }

    public static ModelLoader buildStreamModelLoader(Class class1, Context context)
    {
        return buildModelLoader(class1, java/io/InputStream, context);
    }

    public static void clear(View view)
    {
        clear(((Target) (new ClearTarget(view))));
    }

    public static void clear(Target target)
    {
        Util.assertMainThread();
        target = target.getRequest();
        if (target != null)
        {
            target.clear();
        }
    }

    public static Glide get(Context context)
    {
        if (glide != null) goto _L2; else goto _L1
_L1:
        com/bumptech/glide/Glide;
        JVM INSTR monitorenter ;
        Object obj;
        GlideBuilder glidebuilder;
        if (glide != null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        context = context.getApplicationContext();
        obj = (new ManifestParser(context)).parse();
        glidebuilder = new GlideBuilder(context);
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); ((GlideModule)iterator.next()).applyOptions(context, glidebuilder)) { }
        break MISSING_BLOCK_LABEL_82;
        context;
        com/bumptech/glide/Glide;
        JVM INSTR monitorexit ;
        throw context;
        glide = glidebuilder.createGlide();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((GlideModule)((Iterator) (obj)).next()).registerComponents(context, glide)) { }
        com/bumptech/glide/Glide;
        JVM INSTR monitorexit ;
_L2:
        return glide;
    }

    private GenericLoaderFactory getLoaderFactory()
    {
        return loaderFactory;
    }

    public static File getPhotoCacheDir(Context context)
    {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    public static File getPhotoCacheDir(Context context, String s)
    {
label0:
        {
label1:
            {
                context = context.getCacheDir();
                if (context == null)
                {
                    break label0;
                }
                s = new File(context, s);
                context = s;
                if (s.mkdirs())
                {
                    break label1;
                }
                if (s.exists())
                {
                    context = s;
                    if (s.isDirectory())
                    {
                        break label1;
                    }
                }
                context = null;
            }
            return context;
        }
        if (Log.isLoggable("Glide", 6))
        {
            Log.e("Glide", "default disk cache dir is null");
        }
        return null;
    }

    public static RequestManager with(Activity activity)
    {
        return RequestManagerRetriever.get().get(activity);
    }

    public static RequestManager with(Context context)
    {
        return RequestManagerRetriever.get().get(context);
    }

    public static RequestManager with(Fragment fragment)
    {
        return RequestManagerRetriever.get().get(fragment);
    }

    public static RequestManager with(FragmentActivity fragmentactivity)
    {
        return RequestManagerRetriever.get().get(fragmentactivity);
    }

    DataLoadProvider buildDataProvider(Class class1, Class class2)
    {
        return dataLoadProviderRegistry.get(class1, class2);
    }

    Target buildImageViewTarget(ImageView imageview, Class class1)
    {
        return imageViewTargetFactory.buildTarget(imageview, class1);
    }

    ResourceTranscoder buildTranscoder(Class class1, Class class2)
    {
        return transcoderRegistry.get(class1, class2);
    }

    public void clearMemory()
    {
        bitmapPool.clearMemory();
        memoryCache.clearMemory();
    }

    CenterCrop getBitmapCenterCrop()
    {
        return bitmapCenterCrop;
    }

    FitCenter getBitmapFitCenter()
    {
        return bitmapFitCenter;
    }

    public BitmapPool getBitmapPool()
    {
        return bitmapPool;
    }

    DecodeFormat getDecodeFormat()
    {
        return decodeFormat;
    }

    GifBitmapWrapperTransformation getDrawableCenterCrop()
    {
        return drawableCenterCrop;
    }

    GifBitmapWrapperTransformation getDrawableFitCenter()
    {
        return drawableFitCenter;
    }

    Engine getEngine()
    {
        return engine;
    }

    Handler getMainHandler()
    {
        return mainHandler;
    }

    public void register(Class class1, Class class2, ModelLoaderFactory modelloaderfactory)
    {
        class1 = loaderFactory.register(class1, class2, modelloaderfactory);
        if (class1 != null)
        {
            class1.teardown();
        }
    }

    public void trimMemory(int i)
    {
        bitmapPool.trimMemory(i);
        memoryCache.trimMemory(i);
    }
}
