// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            BasePool, ByteArrayPool, PoolParams, PoolStatsTracker

public class GenericByteArrayPool extends BasePool
    implements ByteArrayPool
{

    private final int mBucketSizes[];

    public GenericByteArrayPool(MemoryTrimmableRegistry memorytrimmableregistry, PoolParams poolparams, PoolStatsTracker poolstatstracker)
    {
        super(memorytrimmableregistry, poolparams, poolstatstracker);
        memorytrimmableregistry = poolparams.bucketSizes;
        mBucketSizes = new int[memorytrimmableregistry.size()];
        for (int i = 0; i < memorytrimmableregistry.size(); i++)
        {
            mBucketSizes[i] = memorytrimmableregistry.keyAt(i);
        }

        initialize();
    }

    protected volatile Object alloc(int i)
    {
        return alloc(i);
    }

    protected byte[] alloc(int i)
    {
        return new byte[i];
    }

    protected volatile void free(Object obj)
    {
        free((byte[])obj);
    }

    protected void free(byte abyte0[])
    {
        Preconditions.checkNotNull(abyte0);
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

    protected volatile int getBucketedSizeForValue(Object obj)
    {
        return getBucketedSizeForValue((byte[])obj);
    }

    protected int getBucketedSizeForValue(byte abyte0[])
    {
        Preconditions.checkNotNull(abyte0);
        return abyte0.length;
    }

    public int getMinBufferSize()
    {
        return mBucketSizes[0];
    }

    protected int getSizeInBytes(int i)
    {
        return i;
    }
}
