// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.bumptech.glide:
//            Glide

public class GlideBuilder
{

    private BitmapPool bitmapPool;
    private final Context context;
    private DecodeFormat decodeFormat;
    private com.bumptech.glide.load.engine.cache.DiskCache.Factory diskCacheFactory;
    private ExecutorService diskCacheService;
    private Engine engine;
    private MemoryCache memoryCache;
    private ExecutorService sourceService;

    public GlideBuilder(Context context1)
    {
        context = context1.getApplicationContext();
    }

    Glide createGlide()
    {
        if (sourceService == null)
        {
            sourceService = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (diskCacheService == null)
        {
            diskCacheService = new FifoPriorityThreadPoolExecutor(1);
        }
        MemorySizeCalculator memorysizecalculator = new MemorySizeCalculator(context);
        if (bitmapPool == null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                bitmapPool = new LruBitmapPool(memorysizecalculator.getBitmapPoolSize());
            } else
            {
                bitmapPool = new BitmapPoolAdapter();
            }
        }
        if (memoryCache == null)
        {
            memoryCache = new LruResourceCache(memorysizecalculator.getMemoryCacheSize());
        }
        if (diskCacheFactory == null)
        {
            diskCacheFactory = new InternalCacheDiskCacheFactory(context, 0xfa00000);
        }
        if (engine == null)
        {
            engine = new Engine(memoryCache, diskCacheFactory, diskCacheService, sourceService);
        }
        if (decodeFormat == null)
        {
            decodeFormat = DecodeFormat.DEFAULT;
        }
        return new Glide(engine, memoryCache, bitmapPool, context, decodeFormat);
    }
}
