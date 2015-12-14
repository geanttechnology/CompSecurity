// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            GenericByteArrayPool, FlexByteArrayPool, OOMSoftReferenceBucket, PoolParams, 
//            PoolStatsTracker, Bucket

static class  extends GenericByteArrayPool
{

    Bucket newBucket(int i)
    {
        return new OOMSoftReferenceBucket(getSizeInBytes(i), mPoolParams.maxNumThreads, 0);
    }

    public (MemoryTrimmableRegistry memorytrimmableregistry, PoolParams poolparams, PoolStatsTracker poolstatstracker)
    {
        super(memorytrimmableregistry, poolparams, poolstatstracker);
    }
}
