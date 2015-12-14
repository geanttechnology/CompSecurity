// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class h extends FilterInputStream
{

    private static final byte a[] = {
        -1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 
        77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 
        1, 18, 0, 2, 0, 0, 0, 1, 0
    };
    private static final int b = 31;
    private final byte c;
    private int d;

    public h(InputStream inputstream, int i)
    {
        super(inputstream);
        if (i < -1 || i > 8)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot add invalid orientation: ")).append(i).toString());
        } else
        {
            c = (byte)i;
            return;
        }
    }

    public final void mark(int i)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean markSupported()
    {
        return false;
    }

    public final int read()
    {
        int i;
        if (d < 2 || d > 31)
        {
            i = super.read();
        } else
        if (d == 31)
        {
            i = c;
        } else
        {
            i = a[d - 2] & 0xff;
        }
        if (i != -1)
        {
            d = d + 1;
        }
        return i;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (d > 31)
        {
            i = super.read(abyte0, i, j);
        } else
        if (d == 31)
        {
            abyte0[i] = c;
            i = 1;
        } else
        if (d < 2)
        {
            i = super.read(abyte0, i, 2 - d);
        } else
        {
            j = Math.min(31 - d, j);
            System.arraycopy(a, d - 2, abyte0, i, j);
            i = j;
        }
        if (i > 0)
        {
            d = d + i;
        }
        return i;
    }

    public final void reset()
    {
        throw new UnsupportedOperationException();
    }

    public final long skip(long l)
    {
        l = super.skip(l);
        if (l > 0L)
        {
            d = (int)((long)d + l);
        }
        return l;
    }

}
