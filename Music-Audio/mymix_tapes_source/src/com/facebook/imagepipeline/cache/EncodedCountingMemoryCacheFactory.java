// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.PooledByteBuffer;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            CountingMemoryCache, NativeMemoryCacheTrimStrategy, ValueDescriptor

public class EncodedCountingMemoryCacheFactory
{

    public EncodedCountingMemoryCacheFactory()
    {
    }

    public static CountingMemoryCache get(Supplier supplier, MemoryTrimmableRegistry memorytrimmableregistry)
    {
        supplier = new CountingMemoryCache(new ValueDescriptor() {

            public int getSizeInBytes(PooledByteBuffer pooledbytebuffer)
            {
                return pooledbytebuffer.size();
            }

            public volatile int getSizeInBytes(Object obj)
            {
                return getSizeInBytes((PooledByteBuffer)obj);
            }

        }, new NativeMemoryCacheTrimStrategy(), supplier);
        memorytrimmableregistry.registerMemoryTrimmable(supplier);
        return supplier;
    }
}
