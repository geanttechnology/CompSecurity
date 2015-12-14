// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.bumptech.glide.load.engine.bitmap_recycle:
//            BitmapPool, SizeConfigStrategy, AttributeStrategy, LruPoolStrategy

public class LruBitmapPool
    implements BitmapPool
{
    private static interface BitmapTracker
    {

        public abstract void add(Bitmap bitmap);

        public abstract void remove(Bitmap bitmap);
    }

    private static class NullBitmapTracker
        implements BitmapTracker
    {

        public void add(Bitmap bitmap)
        {
        }

        public void remove(Bitmap bitmap)
        {
        }

        private NullBitmapTracker()
        {
        }

    }


    private static final android.graphics.Bitmap.Config DEFAULT_CONFIG;
    private final Set allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    public LruBitmapPool(int i)
    {
        this(i, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    LruBitmapPool(int i, LruPoolStrategy lrupoolstrategy, Set set)
    {
        initialMaxSize = i;
        maxSize = i;
        strategy = lrupoolstrategy;
        allowedConfigs = set;
        tracker = new NullBitmapTracker();
    }

    private void dump()
    {
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked()
    {
        Log.v("LruBitmapPool", (new StringBuilder()).append("Hits=").append(hits).append(", misses=").append(misses).append(", puts=").append(puts).append(", evictions=").append(evictions).append(", currentSize=").append(currentSize).append(", maxSize=").append(maxSize).append("\nStrategy=").append(strategy).toString());
    }

    private void evict()
    {
        trimToSize(maxSize);
    }

    private static Set getDefaultAllowedConfigs()
    {
        HashSet hashset = new HashSet();
        hashset.addAll(Arrays.asList(android.graphics.Bitmap.Config.values()));
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            hashset.add(null);
        }
        return Collections.unmodifiableSet(hashset);
    }

    private static LruPoolStrategy getDefaultStrategy()
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            return new SizeConfigStrategy();
        } else
        {
            return new AttributeStrategy();
        }
    }

    private void trimToSize(int i)
    {
        this;
        JVM INSTR monitorenter ;
_L2:
        Bitmap bitmap;
        if (currentSize <= i)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        bitmap = strategy.removeLast();
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (Log.isLoggable("LruBitmapPool", 5))
        {
            Log.w("LruBitmapPool", "Size mismatch, resetting");
            dumpUnchecked();
        }
        currentSize = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        tracker.remove(bitmap);
        currentSize = currentSize - strategy.getSize(bitmap);
        bitmap.recycle();
        evictions = evictions + 1;
        if (Log.isLoggable("LruBitmapPool", 3))
        {
            Log.d("LruBitmapPool", (new StringBuilder()).append("Evicting bitmap=").append(strategy.logBitmap(bitmap)).toString());
        }
        dump();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void clearMemory()
    {
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            Log.d("LruBitmapPool", "clearMemory");
        }
        trimToSize(0);
    }

    public Bitmap get(int i, int j, android.graphics.Bitmap.Config config)
    {
        this;
        JVM INSTR monitorenter ;
        config = getDirty(i, j, config);
        if (config == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        config.eraseColor(0);
        this;
        JVM INSTR monitorexit ;
        return config;
        config;
        throw config;
    }

    public Bitmap getDirty(int i, int j, android.graphics.Bitmap.Config config)
    {
        this;
        JVM INSTR monitorenter ;
        LruPoolStrategy lrupoolstrategy = strategy;
        if (config == null) goto _L2; else goto _L1
_L1:
        Object obj = config;
_L7:
        obj = lrupoolstrategy.get(i, j, ((android.graphics.Bitmap.Config) (obj)));
        if (obj != null) goto _L4; else goto _L3
_L3:
        if (Log.isLoggable("LruBitmapPool", 3))
        {
            Log.d("LruBitmapPool", (new StringBuilder()).append("Missing bitmap=").append(strategy.logBitmap(i, j, config)).toString());
        }
        misses = misses + 1;
_L5:
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            Log.v("LruBitmapPool", (new StringBuilder()).append("Get bitmap=").append(strategy.logBitmap(i, j, config)).toString());
        }
        dump();
        this;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj));
_L2:
        obj = DEFAULT_CONFIG;
        continue; /* Loop/switch isn't completed */
_L4:
        hits = hits + 1;
        currentSize = currentSize - strategy.getSize(((Bitmap) (obj)));
        tracker.remove(((Bitmap) (obj)));
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            ((Bitmap) (obj)).setHasAlpha(true);
        }
          goto _L5
        config;
        throw config;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean put(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new NullPointerException("Bitmap must not be null");
        bitmap;
        this;
        JVM INSTR monitorexit ;
        throw bitmap;
        if (bitmap.isMutable() && strategy.getSize(bitmap) <= maxSize && allowedConfigs.contains(bitmap.getConfig())) goto _L2; else goto _L1
_L1:
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            Log.v("LruBitmapPool", (new StringBuilder()).append("Reject bitmap from pool, bitmap: ").append(strategy.logBitmap(bitmap)).append(", is mutable: ").append(bitmap.isMutable()).append(", is allowed config: ").append(allowedConfigs.contains(bitmap.getConfig())).toString());
        }
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        int i = strategy.getSize(bitmap);
        strategy.put(bitmap);
        tracker.add(bitmap);
        puts = puts + 1;
        currentSize = currentSize + i;
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            Log.v("LruBitmapPool", (new StringBuilder()).append("Put bitmap in pool=").append(strategy.logBitmap(bitmap)).toString());
        }
        dump();
        evict();
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void trimMemory(int i)
    {
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            Log.d("LruBitmapPool", (new StringBuilder()).append("trimMemory, level=").append(i).toString());
        }
        if (i >= 60)
        {
            clearMemory();
        } else
        if (i >= 40)
        {
            trimToSize(maxSize / 2);
            return;
        }
    }

    static 
    {
        DEFAULT_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
    }
}
