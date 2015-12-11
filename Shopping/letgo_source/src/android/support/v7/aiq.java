// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.InputStream;

public class aiq extends InputStream
{

    private final InputStream a;
    private final int b;

    public aiq(InputStream inputstream, int i)
    {
        a = inputstream;
        b = i;
    }

    public int available()
    {
        return b;
    }

    public void close()
        throws IOException
    {
        a.close();
    }

    public void mark(int i)
    {
        a.mark(i);
    }

    public boolean markSupported()
    {
        return a.markSupported();
    }

    public int read()
        throws IOException
    {
        return a.read();
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return a.read(abyte0);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        return a.read(abyte0, i, j);
    }

    public void reset()
        throws IOException
    {
        a.reset();
    }

    public long skip(long l)
        throws IOException
    {
        return a.skip(l);
    }
}
