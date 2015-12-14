// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            PooledByteBufferFactory, PooledByteStreams, NativePooledByteBufferOutputStream, NativeMemoryChunkPool, 
//            NativePooledByteBuffer, PooledByteBuffer, PooledByteBufferOutputStream

public class NativePooledByteBufferFactory
    implements PooledByteBufferFactory
{

    private final NativeMemoryChunkPool mPool;
    private final PooledByteStreams mPooledByteStreams;

    public NativePooledByteBufferFactory(NativeMemoryChunkPool nativememorychunkpool, PooledByteStreams pooledbytestreams)
    {
        mPool = nativememorychunkpool;
        mPooledByteStreams = pooledbytestreams;
    }

    NativePooledByteBuffer newByteBuf(InputStream inputstream, NativePooledByteBufferOutputStream nativepooledbytebufferoutputstream)
        throws IOException
    {
        mPooledByteStreams.copy(inputstream, nativepooledbytebufferoutputstream);
        return nativepooledbytebufferoutputstream.toByteBuffer();
    }

    public NativePooledByteBuffer newByteBuffer(int i)
    {
        CloseableReference closeablereference;
        NativePooledByteBuffer nativepooledbytebuffer;
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        closeablereference = CloseableReference.of(mPool.get(i), mPool);
        nativepooledbytebuffer = new NativePooledByteBuffer(closeablereference, i);
        closeablereference.close();
        return nativepooledbytebuffer;
        Exception exception;
        exception;
        closeablereference.close();
        throw exception;
    }

    public NativePooledByteBuffer newByteBuffer(InputStream inputstream)
        throws IOException
    {
        NativePooledByteBufferOutputStream nativepooledbytebufferoutputstream = new NativePooledByteBufferOutputStream(mPool);
        inputstream = newByteBuf(inputstream, nativepooledbytebufferoutputstream);
        nativepooledbytebufferoutputstream.close();
        return inputstream;
        inputstream;
        nativepooledbytebufferoutputstream.close();
        throw inputstream;
    }

    public NativePooledByteBuffer newByteBuffer(InputStream inputstream, int i)
        throws IOException
    {
        NativePooledByteBufferOutputStream nativepooledbytebufferoutputstream = new NativePooledByteBufferOutputStream(mPool, i);
        inputstream = newByteBuf(inputstream, nativepooledbytebufferoutputstream);
        nativepooledbytebufferoutputstream.close();
        return inputstream;
        inputstream;
        nativepooledbytebufferoutputstream.close();
        throw inputstream;
    }

    public NativePooledByteBuffer newByteBuffer(byte abyte0[])
    {
        NativePooledByteBufferOutputStream nativepooledbytebufferoutputstream = new NativePooledByteBufferOutputStream(mPool, abyte0.length);
        nativepooledbytebufferoutputstream.write(abyte0, 0, abyte0.length);
        abyte0 = nativepooledbytebufferoutputstream.toByteBuffer();
        nativepooledbytebufferoutputstream.close();
        return abyte0;
        abyte0;
        throw Throwables.propagate(abyte0);
        abyte0;
        nativepooledbytebufferoutputstream.close();
        throw abyte0;
    }

    public volatile PooledByteBuffer newByteBuffer(int i)
    {
        return newByteBuffer(i);
    }

    public volatile PooledByteBuffer newByteBuffer(InputStream inputstream)
        throws IOException
    {
        return newByteBuffer(inputstream);
    }

    public volatile PooledByteBuffer newByteBuffer(InputStream inputstream, int i)
        throws IOException
    {
        return newByteBuffer(inputstream, i);
    }

    public volatile PooledByteBuffer newByteBuffer(byte abyte0[])
    {
        return newByteBuffer(abyte0);
    }

    public NativePooledByteBufferOutputStream newOutputStream()
    {
        return new NativePooledByteBufferOutputStream(mPool);
    }

    public NativePooledByteBufferOutputStream newOutputStream(int i)
    {
        return new NativePooledByteBufferOutputStream(mPool, i);
    }

    public volatile PooledByteBufferOutputStream newOutputStream()
    {
        return newOutputStream();
    }

    public volatile PooledByteBufferOutputStream newOutputStream(int i)
    {
        return newOutputStream(i);
    }
}
