// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.Map;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            PoolParams, NoOpPoolStatsTracker, GenericByteArrayPool, OOMSoftReferenceBucket, 
//            PoolStatsTracker, Bucket

public class FlexByteArrayPool
{
    static class SoftRefByteArrayPool extends GenericByteArrayPool
    {

        Bucket newBucket(int i)
        {
            return new OOMSoftReferenceBucket(getSizeInBytes(i), mPoolParams.maxNumThreads, 0);
        }

        public SoftRefByteArrayPool(MemoryTrimmableRegistry memorytrimmableregistry, PoolParams poolparams, PoolStatsTracker poolstatstracker)
        {
            super(memorytrimmableregistry, poolparams, poolstatstracker);
        }
    }


    final SoftRefByteArrayPool mDelegatePool;
    private final ResourceReleaser mResourceReleaser = new ResourceReleaser() {

        final FlexByteArrayPool this$0;

        public volatile void release(Object obj)
        {
            release((byte[])obj);
        }

        public void release(byte abyte0[])
        {
            FlexByteArrayPool.this.release(abyte0);
        }

            
            {
                this$0 = FlexByteArrayPool.this;
                super();
            }
    };

    public FlexByteArrayPool(MemoryTrimmableRegistry memorytrimmableregistry, PoolParams poolparams)
    {
        boolean flag;
        if (poolparams.maxNumThreads > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mDelegatePool = new SoftRefByteArrayPool(memorytrimmableregistry, poolparams, NoOpPoolStatsTracker.getInstance());
    }

    public CloseableReference get(int i)
    {
        return CloseableReference.of(mDelegatePool.get(i), mResourceReleaser);
    }

    public int getMinBufferSize()
    {
        return mDelegatePool.getMinBufferSize();
    }

    public Map getStats()
    {
        return mDelegatePool.getStats();
    }

    public void release(byte abyte0[])
    {
        mDelegatePool.release(abyte0);
    }
}
