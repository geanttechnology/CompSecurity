// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class ParseIOUtils
{

    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;
    private static final int SKIP_BUFFER_SIZE = 2048;
    private static byte SKIP_BYTE_BUFFER[];

    ParseIOUtils()
    {
    }

    public static void closeQuietly(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static void closeQuietly(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
    }

    public static void closeQuietly(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        outputstream.close();
        return;
        outputstream;
    }

    public static int copy(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        long l = copyLarge(inputstream, outputstream);
        if (l > 0x7fffffffL)
        {
            return -1;
        } else
        {
            return (int)l;
        }
    }

    public static long copyLarge(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        return copyLarge(inputstream, outputstream, new byte[4096]);
    }

    public static long copyLarge(InputStream inputstream, OutputStream outputstream, long l, long l1)
        throws IOException
    {
        return copyLarge(inputstream, outputstream, l, l1, new byte[4096]);
    }

    public static long copyLarge(InputStream inputstream, OutputStream outputstream, long l, long l1, byte abyte0[])
        throws IOException
    {
        if (l > 0L)
        {
            skipFully(inputstream, l);
        }
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        long l2 = 0L;
_L4:
        return l2;
_L2:
        int i;
        int i1;
        i1 = abyte0.length;
        int j = i1;
        i = j;
        if (l1 > 0L)
        {
            i = j;
            if (l1 < (long)i1)
            {
                i = (int)l1;
            }
        }
        l = 0L;
_L6:
        l2 = l;
        if (i <= 0) goto _L4; else goto _L3
_L3:
        int k;
        k = inputstream.read(abyte0, 0, i);
        l2 = l;
        if (-1 == k) goto _L4; else goto _L5
_L5:
        outputstream.write(abyte0, 0, k);
        long l3 = l + (long)k;
        l = l3;
        if (l1 > 0L)
        {
            i = (int)Math.min(l1 - l3, i1);
            l = l3;
        }
          goto _L6
    }

    public static long copyLarge(InputStream inputstream, OutputStream outputstream, byte abyte0[])
        throws IOException
    {
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if (-1 != i)
            {
                outputstream.write(abyte0, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while (true);
    }

    public static long skip(InputStream inputstream, long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Skip count must be non-negative, actual: ").append(l).toString());
        }
        if (SKIP_BYTE_BUFFER == null)
        {
            SKIP_BYTE_BUFFER = new byte[2048];
        }
        long l1 = l;
        do
        {
            long l2;
label0:
            {
                if (l1 > 0L)
                {
                    l2 = inputstream.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(l1, 2048L));
                    if (l2 >= 0L)
                    {
                        break label0;
                    }
                }
                return l - l1;
            }
            l1 -= l2;
        } while (true);
    }

    public static void skipFully(InputStream inputstream, long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bytes to skip must not be negative: ").append(l).toString());
        }
        long l1 = skip(inputstream, l);
        if (l1 != l)
        {
            throw new EOFException((new StringBuilder()).append("Bytes to skip: ").append(l).append(" actual: ").append(l1).toString());
        } else
        {
            return;
        }
    }

    public static byte[] toByteArray(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        copy(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }
}
