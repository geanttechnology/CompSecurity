// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.imagepipeline.memory.PooledByteBuffer;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            ValueDescriptor, EncodedCountingMemoryCacheFactory

static final class 
    implements ValueDescriptor
{

    public int getSizeInBytes(PooledByteBuffer pooledbytebuffer)
    {
        return pooledbytebuffer.size();
    }

    public volatile int getSizeInBytes(Object obj)
    {
        return getSizeInBytes((PooledByteBuffer)obj);
    }

    ()
    {
    }
}
