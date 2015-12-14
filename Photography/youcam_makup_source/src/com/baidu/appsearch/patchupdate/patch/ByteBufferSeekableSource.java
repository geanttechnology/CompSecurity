// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.appsearch.patchupdate.patch;

import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.baidu.appsearch.patchupdate.patch:
//            SeekableSource

public class ByteBufferSeekableSource
    implements SeekableSource
{

    private ByteBuffer mByteBuffer;

    public ByteBufferSeekableSource(ByteBuffer bytebuffer)
    {
        if (bytebuffer == null)
        {
            throw new NullPointerException("input parameter bb is null");
        }
        mByteBuffer = bytebuffer;
        bytebuffer.rewind();
        try
        {
            seek(0L);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            throw new RuntimeException(bytebuffer);
        }
    }

    public ByteBufferSeekableSource(byte abyte0[])
    {
        this(ByteBuffer.wrap(abyte0));
    }

    public void close()
    {
        mByteBuffer = null;
    }

    public int read(ByteBuffer bytebuffer)
    {
        if (mByteBuffer.hasRemaining()) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i = 0;
_L6:
        j = i;
        if (!mByteBuffer.hasRemaining()) goto _L4; else goto _L3
_L3:
        j = i;
        if (!bytebuffer.hasRemaining()) goto _L4; else goto _L5
_L5:
        bytebuffer.put(mByteBuffer.get());
        i++;
          goto _L6
    }

    public void seek(long l)
    {
        if (l > (long)mByteBuffer.limit())
        {
            throw new IOException((new StringBuilder()).append("pos ").append(l).append(" cannot seek ").append(mByteBuffer.limit()).toString());
        } else
        {
            mByteBuffer.position((int)l);
            return;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("BBSeekable bb=").append(mByteBuffer.position()).append("-").append(mByteBuffer.limit()).append("").toString();
    }
}
