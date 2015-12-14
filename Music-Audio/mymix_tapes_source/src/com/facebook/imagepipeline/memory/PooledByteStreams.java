// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            ByteArrayPool

public class PooledByteStreams
{

    private static final int DEFAULT_TEMP_BUF_SIZE = 16384;
    private final ByteArrayPool mByteArrayPool;
    private final int mTempBufSize;

    public PooledByteStreams(ByteArrayPool bytearraypool)
    {
        this(bytearraypool, 16384);
    }

    PooledByteStreams(ByteArrayPool bytearraypool, int i)
    {
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mTempBufSize = i;
        mByteArrayPool = bytearraypool;
    }

    public long copy(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[];
        long l;
        l = 0L;
        abyte0 = (byte[])mByteArrayPool.get(mTempBufSize);
_L1:
        int i = inputstream.read(abyte0, 0, mTempBufSize);
        if (i == -1)
        {
            mByteArrayPool.release(abyte0);
            return l;
        }
        outputstream.write(abyte0, 0, i);
        l += i;
          goto _L1
        inputstream;
        mByteArrayPool.release(abyte0);
        throw inputstream;
    }

    public long copy(InputStream inputstream, OutputStream outputstream, long l)
        throws IOException
    {
        byte abyte0[];
        long l1;
        boolean flag = false;
        if (l > 0L)
        {
            flag = true;
        }
        Preconditions.checkState(flag);
        l1 = 0L;
        abyte0 = (byte[])mByteArrayPool.get(mTempBufSize);
_L2:
        if (l1 >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = inputstream.read(abyte0, 0, (int)Math.min(mTempBufSize, l - l1));
        if (i == -1)
        {
            mByteArrayPool.release(abyte0);
            return l1;
        }
        outputstream.write(abyte0, 0, i);
        l1 += i;
        if (true) goto _L2; else goto _L1
_L1:
        mByteArrayPool.release(abyte0);
        return l1;
        inputstream;
        mByteArrayPool.release(abyte0);
        throw inputstream;
    }
}
