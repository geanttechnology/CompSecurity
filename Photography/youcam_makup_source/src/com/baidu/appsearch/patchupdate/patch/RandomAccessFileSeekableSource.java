// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.appsearch.patchupdate.patch;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

// Referenced classes of package com.baidu.appsearch.patchupdate.patch:
//            SeekableSource

public class RandomAccessFileSeekableSource
    implements SeekableSource
{

    private RandomAccessFile mRandomAccessFile;

    public RandomAccessFileSeekableSource(RandomAccessFile randomaccessfile)
    {
        if (randomaccessfile == null)
        {
            throw new NullPointerException("input RandomAccessFile is null");
        } else
        {
            mRandomAccessFile = randomaccessfile;
            return;
        }
    }

    public void close()
    {
        mRandomAccessFile.close();
    }

    public long length()
    {
        return mRandomAccessFile.length();
    }

    public int read(ByteBuffer bytebuffer)
    {
        int i = mRandomAccessFile.read(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining());
        if (i == -1)
        {
            return -1;
        } else
        {
            bytebuffer.position(bytebuffer.position() + i);
            return i;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        return mRandomAccessFile.read(abyte0, i, j);
    }

    public void seek(long l)
    {
        mRandomAccessFile.seek(l);
    }
}
