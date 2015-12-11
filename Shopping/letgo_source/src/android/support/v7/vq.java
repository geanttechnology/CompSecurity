// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class vq
{

    public static long a(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        return a(inputstream, outputstream, false);
    }

    public static long a(InputStream inputstream, OutputStream outputstream, boolean flag)
        throws IOException
    {
        return a(inputstream, outputstream, flag, 1024);
    }

    public static long a(InputStream inputstream, OutputStream outputstream, boolean flag, int i)
        throws IOException
    {
        byte abyte0[];
        long l;
        abyte0 = new byte[i];
        l = 0L;
_L1:
        i = inputstream.read(abyte0, 0, abyte0.length);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        l += i;
        outputstream.write(abyte0, 0, i);
          goto _L1
        Exception exception;
        exception;
        if (flag)
        {
            a(((Closeable) (inputstream)));
            a(((Closeable) (outputstream)));
        }
        throw exception;
        if (flag)
        {
            a(((Closeable) (inputstream)));
            a(((Closeable) (outputstream)));
        }
        return l;
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static byte[] a(InputStream inputstream)
        throws IOException
    {
        return a(inputstream, true);
    }

    public static byte[] a(InputStream inputstream, boolean flag)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        a(inputstream, ((OutputStream) (bytearrayoutputstream)), flag);
        return bytearrayoutputstream.toByteArray();
    }
}
