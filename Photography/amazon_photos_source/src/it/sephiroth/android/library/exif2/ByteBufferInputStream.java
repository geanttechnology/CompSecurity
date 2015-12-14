// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import java.io.InputStream;
import java.nio.ByteBuffer;

class ByteBufferInputStream extends InputStream
{

    private ByteBuffer mBuf;

    public ByteBufferInputStream(ByteBuffer bytebuffer)
    {
        mBuf = bytebuffer;
    }

    public int read()
    {
        if (!mBuf.hasRemaining())
        {
            return -1;
        } else
        {
            return mBuf.get() & 0xff;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (!mBuf.hasRemaining())
        {
            return -1;
        } else
        {
            j = Math.min(j, mBuf.remaining());
            mBuf.get(abyte0, i, j);
            return j;
        }
    }
}
