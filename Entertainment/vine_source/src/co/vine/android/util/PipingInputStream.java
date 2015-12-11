// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PipingInputStream extends FilterInputStream
{

    private InputStream mInputStream;
    private OutputStream mOutputStream;

    public PipingInputStream(InputStream inputstream, OutputStream outputstream)
    {
        super(inputstream);
        if (inputstream == null)
        {
            throw new IllegalArgumentException("InputStream cannot be null");
        } else
        {
            mInputStream = inputstream;
            mOutputStream = outputstream;
            return;
        }
    }

    public int read()
        throws IOException
    {
        int i = mInputStream.read();
        if (i != -1 && mOutputStream != null)
        {
            mOutputStream.write(i);
        }
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        j = mInputStream.read(abyte0, i, j);
        if (j != -1 && mOutputStream != null)
        {
            mOutputStream.write(abyte0, i, j);
        }
        return j;
    }
}
