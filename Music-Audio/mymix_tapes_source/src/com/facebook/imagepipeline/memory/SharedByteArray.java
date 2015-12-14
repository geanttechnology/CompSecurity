// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            PoolParams

public class SharedByteArray
    implements MemoryTrimmable
{

    final OOMSoftReference mByteArraySoftRef = new OOMSoftReference();
    final int mMaxByteArraySize;
    final int mMinByteArraySize;
    private final ResourceReleaser mResourceReleaser = new ResourceReleaser() {

        final SharedByteArray this$0;

        public volatile void release(Object obj)
        {
            release((byte[])obj);
        }

        public void release(byte abyte0[])
        {
            mSemaphore.release();
        }

            
            {
                this$0 = SharedByteArray.this;
                super();
            }
    };
    final Semaphore mSemaphore = new Semaphore(1);

    public SharedByteArray(MemoryTrimmableRegistry memorytrimmableregistry, PoolParams poolparams)
    {
        boolean flag1 = false;
        super();
        Preconditions.checkNotNull(memorytrimmableregistry);
        boolean flag;
        if (poolparams.minBucketSize > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        flag = flag1;
        if (poolparams.maxBucketSize >= poolparams.minBucketSize)
        {
            flag = true;
        }
        Preconditions.checkArgument(flag);
        mMaxByteArraySize = poolparams.maxBucketSize;
        mMinByteArraySize = poolparams.minBucketSize;
        memorytrimmableregistry.registerMemoryTrimmable(this);
    }

    private byte[] allocateByteArray(int i)
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        mByteArraySoftRef.clear();
        abyte0 = new byte[i];
        mByteArraySoftRef.set(abyte0);
        this;
        JVM INSTR monitorexit ;
        return abyte0;
        Exception exception;
        exception;
        throw exception;
    }

    private byte[] getByteArray(int i)
    {
        byte abyte0[];
label0:
        {
            i = getBucketedSize(i);
            byte abyte1[] = (byte[])mByteArraySoftRef.get();
            if (abyte1 != null)
            {
                abyte0 = abyte1;
                if (abyte1.length >= i)
                {
                    break label0;
                }
            }
            abyte0 = allocateByteArray(i);
        }
        return abyte0;
    }

    public CloseableReference get(int i)
    {
        boolean flag1 = true;
        CloseableReference closeablereference;
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Size must be greater than zero");
        if (i <= mMaxByteArraySize)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Requested size is too big");
        mSemaphore.acquireUninterruptibly();
        try
        {
            closeablereference = CloseableReference.of(getByteArray(i), mResourceReleaser);
        }
        catch (Throwable throwable)
        {
            mSemaphore.release();
            throw Throwables.propagate(throwable);
        }
        return closeablereference;
    }

    int getBucketedSize(int i)
    {
        return Integer.highestOneBit(Math.max(i, mMinByteArraySize) - 1) * 2;
    }

    public void trim(MemoryTrimType memorytrimtype)
    {
        if (!mSemaphore.tryAcquire())
        {
            return;
        }
        mByteArraySoftRef.clear();
        mSemaphore.release();
        return;
        memorytrimtype;
        mSemaphore.release();
        throw memorytrimtype;
    }
}
