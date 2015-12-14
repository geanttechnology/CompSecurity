// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

class a extends FilterInputStream
{

    static final boolean a;
    private int b;
    private final byte c[] = new byte[8];
    private final ByteBuffer d;

    protected a(InputStream inputstream)
    {
        super(inputstream);
        b = 0;
        d = ByteBuffer.wrap(c);
    }

    public int a()
    {
        return b;
    }

    public String a(int i, Charset charset)
    {
        byte abyte0[] = new byte[i];
        a(abyte0);
        return new String(abyte0, charset);
    }

    public void a(long l)
    {
        if (skip(l) != l)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public void a(ByteOrder byteorder)
    {
        d.order(byteorder);
    }

    public void a(byte abyte0[])
    {
        a(abyte0, 0, abyte0.length);
    }

    public void a(byte abyte0[], int i, int j)
    {
        if (read(abyte0, i, j) != j)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public ByteOrder b()
    {
        return d.order();
    }

    public void b(long l)
    {
        l -= b;
        if (!a && l < 0L)
        {
            throw new AssertionError();
        } else
        {
            a(l);
            return;
        }
    }

    public short c()
    {
        a(c, 0, 2);
        d.rewind();
        return d.getShort();
    }

    public int d()
    {
        return c() & 0xffff;
    }

    public int e()
    {
        a(c, 0, 4);
        d.rewind();
        return d.getInt();
    }

    public long f()
    {
        return (long)e() & 0xffffffffL;
    }

    public int read()
    {
        int j = in.read();
        int k = b;
        int i;
        if (j >= 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        b = i + k;
        return j;
    }

    public int read(byte abyte0[])
    {
        int j = in.read(abyte0);
        int k = b;
        int i;
        if (j >= 0)
        {
            i = j;
        } else
        {
            i = 0;
        }
        b = i + k;
        return j;
    }

    public int read(byte abyte0[], int i, int j)
    {
        j = in.read(abyte0, i, j);
        int k = b;
        if (j >= 0)
        {
            i = j;
        } else
        {
            i = 0;
        }
        b = i + k;
        return j;
    }

    public long skip(long l)
    {
        l = in.skip(l);
        b = (int)((long)b + l);
        return l;
    }

    static 
    {
        boolean flag;
        if (!com/android/camera/exif/a.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
