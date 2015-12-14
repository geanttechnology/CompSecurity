// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            PooledByteBuffer, NativeMemoryChunk

public class NativePooledByteBuffer
    implements PooledByteBuffer
{

    CloseableReference mBufRef;
    private final int mSize;

    public NativePooledByteBuffer(CloseableReference closeablereference, int i)
    {
        Preconditions.checkNotNull(closeablereference);
        boolean flag;
        if (i >= 0 && i <= ((NativeMemoryChunk)closeablereference.get()).getSize())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mBufRef = closeablereference.clone();
        mSize = i;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        CloseableReference.closeSafely(mBufRef);
        mBufRef = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void ensureValid()
    {
        this;
        JVM INSTR monitorenter ;
        if (isClosed())
        {
            throw new PooledByteBuffer.ClosedException();
        }
        break MISSING_BLOCK_LABEL_22;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public long getNativePtr()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        ensureValid();
        l = ((NativeMemoryChunk)mBufRef.get()).getNativePtr();
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = CloseableReference.isValid(mBufRef);
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public byte read(int i)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        ensureValid();
        byte byte0;
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (i < mSize)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        byte0 = ((NativeMemoryChunk)mBufRef.get()).read(i);
        this;
        JVM INSTR monitorexit ;
        return byte0;
        Exception exception;
        exception;
        throw exception;
    }

    public void read(int i, byte abyte0[], int j, int k)
    {
        this;
        JVM INSTR monitorenter ;
        ensureValid();
        boolean flag;
        if (i + k <= mSize)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        ((NativeMemoryChunk)mBufRef.get()).read(i, abyte0, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public int size()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        ensureValid();
        i = mSize;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }
}
