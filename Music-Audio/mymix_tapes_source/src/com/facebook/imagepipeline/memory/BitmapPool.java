// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.nativecode.Bitmaps;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            BasePool, PoolParams, PoolStatsTracker

public class BitmapPool extends BasePool
{

    public BitmapPool(MemoryTrimmableRegistry memorytrimmableregistry, PoolParams poolparams, PoolStatsTracker poolstatstracker)
    {
        super(memorytrimmableregistry, poolparams, poolstatstracker);
        initialize();
    }

    protected Bitmap alloc(int i)
    {
        return Bitmap.createBitmap(1, i, Bitmaps.BITMAP_CONFIG);
    }

    protected volatile Object alloc(int i)
    {
        return alloc(i);
    }

    protected void free(Bitmap bitmap)
    {
        Preconditions.checkNotNull(bitmap);
        bitmap.recycle();
    }

    protected volatile void free(Object obj)
    {
        free((Bitmap)obj);
    }

    protected int getBucketedSize(int i)
    {
        return i;
    }

    protected int getBucketedSizeForValue(Bitmap bitmap)
    {
        Preconditions.checkNotNull(bitmap);
        return bitmap.getAllocationByteCount() / 4;
    }

    protected volatile int getBucketedSizeForValue(Object obj)
    {
        return getBucketedSizeForValue((Bitmap)obj);
    }

    protected int getSizeInBytes(int i)
    {
        return i * 4;
    }

    protected boolean isReusable(Bitmap bitmap)
    {
        Preconditions.checkNotNull(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable() && Bitmaps.BITMAP_CONFIG.equals(bitmap.getConfig());
    }

    protected volatile boolean isReusable(Object obj)
    {
        return isReusable((Bitmap)obj);
    }
}
