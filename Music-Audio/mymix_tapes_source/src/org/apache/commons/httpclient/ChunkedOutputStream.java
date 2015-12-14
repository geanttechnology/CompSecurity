// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;

public class ChunkedOutputStream extends OutputStream
{

    private static final byte CRLF[] = {
        13, 10
    };
    private static final byte ENDCHUNK[] = CRLF;
    private static final byte ZERO[] = {
        48
    };
    private byte cache[];
    private int cachePosition;
    private OutputStream stream;
    private boolean wroteLastChunk;

    public ChunkedOutputStream(OutputStream outputstream)
        throws IOException
    {
        this(outputstream, 2048);
    }

    public ChunkedOutputStream(OutputStream outputstream, int i)
        throws IOException
    {
        stream = null;
        cachePosition = 0;
        wroteLastChunk = false;
        cache = new byte[i];
        stream = outputstream;
    }

    public void close()
        throws IOException
    {
        finish();
        super.close();
    }

    public void finish()
        throws IOException
    {
        if (!wroteLastChunk)
        {
            flushCache();
            writeClosingChunk();
            wroteLastChunk = true;
        }
    }

    public void flush()
        throws IOException
    {
        stream.flush();
    }

    protected void flushCache()
        throws IOException
    {
        if (cachePosition > 0)
        {
            byte abyte0[] = EncodingUtil.getAsciiBytes(Integer.toHexString(cachePosition) + "\r\n");
            stream.write(abyte0, 0, abyte0.length);
            stream.write(cache, 0, cachePosition);
            stream.write(ENDCHUNK, 0, ENDCHUNK.length);
            cachePosition = 0;
        }
    }

    protected void flushCacheWithAppend(byte abyte0[], int i, int j)
        throws IOException
    {
        byte abyte1[] = EncodingUtil.getAsciiBytes(Integer.toHexString(cachePosition + j) + "\r\n");
        stream.write(abyte1, 0, abyte1.length);
        stream.write(cache, 0, cachePosition);
        stream.write(abyte0, i, j);
        stream.write(ENDCHUNK, 0, ENDCHUNK.length);
        cachePosition = 0;
    }

    public void write(int i)
        throws IOException
    {
        cache[cachePosition] = (byte)i;
        cachePosition = cachePosition + 1;
        if (cachePosition == cache.length)
        {
            flushCache();
        }
    }

    public void write(byte abyte0[])
        throws IOException
    {
        write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j >= cache.length - cachePosition)
        {
            flushCacheWithAppend(abyte0, i, j);
            return;
        } else
        {
            System.arraycopy(abyte0, i, cache, cachePosition, j);
            cachePosition = cachePosition + j;
            return;
        }
    }

    protected void writeClosingChunk()
        throws IOException
    {
        stream.write(ZERO, 0, ZERO.length);
        stream.write(CRLF, 0, CRLF.length);
        stream.write(ENDCHUNK, 0, ENDCHUNK.length);
    }

}
