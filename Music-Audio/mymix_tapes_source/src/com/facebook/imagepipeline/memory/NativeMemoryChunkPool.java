// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            BasePool, PoolParams, NativeMemoryChunk, PoolStatsTracker

public class NativeMemoryChunkPool extends BasePool
{

    private final int mBucketSizes[];

    public NativeMemoryChunkPool(MemoryTrimmableRegistry memorytrimmableregistry, PoolParams poolparams, PoolStatsTracker poolstatstracker)
    {
        super(memorytrimmableregistry, poolparams, poolstatstracker);
        memorytrimmableregistry = poolparams.bucketSizes;
        mBucketSizes = new int[memorytrimmableregistry.size()];
        for (int i = 0; i < mBucketSizes.length; i++)
        {
            mBucketSizes[i] = memorytrimmableregistry.keyAt(i);
        }

        initialize();
    }

    protected NativeMemoryChunk alloc(int i)
    {
        return new NativeMemoryChunk(i);
    }

    protected volatile Object alloc(int i)
    {
        return alloc(i);
    }

    protected void free(NativeMemoryChunk nativememorychunk)
    {
        Preconditions.checkNotNull(nativememorychunk);
        nativememorychunk.close();
    }

    protected volatile void free(Object obj)
    {
        free((NativeMemoryChunk)obj);
    }

    protected int getBucketedSize(int i)
    {
        if (i <= 0)
        {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        int ai[] = mBucketSizes;
        int k = ai.length;
        for (int j = 0; j < k; j++)
        {
            int l = ai[j];
            if (l >= i)
            {
                return l;
            }
        }

        return i;
    }

    protected int getBucketedSizeForValue(NativeMemoryChunk nativememorychunk)
    {
        Preconditions.checkNotNull(nativememorychunk);
        return nativememorychunk.getSize();
    }

    protected volatile int getBucketedSizeForValue(Object obj)
    {
        return getBucketedSizeForValue((NativeMemoryChunk)obj);
    }

    public int getMinBufferSize()
    {
        return mBucketSizes[0];
    }

    protected int getSizeInBytes(int i)
    {
        return i;
    }

    protected boolean isReusable(NativeMemoryChunk nativememorychunk)
    {
        Preconditions.checkNotNull(nativememorychunk);
        return !nativememorychunk.isClosed();
    }

    protected volatile boolean isReusable(Object obj)
    {
        return isReusable((NativeMemoryChunk)obj);
    }
}
