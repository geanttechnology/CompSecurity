// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.io.RandomAccessFile;

final class abf extends InputStream
{

    final abd a;
    private int b;
    private int c;

    private abf(abd abd1, abe abe1)
    {
        a = abd1;
        super();
        b = abd.a(abd1, abe1.b + 4);
        c = abe1.c;
    }

    abf(abd abd1, abe abe1, abd._cls1 _pcls1)
    {
        this(abd1, abe1);
    }

    public int read()
    {
        if (c == 0)
        {
            return -1;
        } else
        {
            abd.a(a).seek(b);
            int i = abd.a(a).read();
            b = abd.a(a, b + 1);
            c = c - 1;
            return i;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        abd.a(abyte0, "buffer");
        if ((i | j) < 0 || j > abyte0.length - i)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (c > 0)
        {
            int k = j;
            if (j > c)
            {
                k = c;
            }
            abd.a(a, b, abyte0, i, k);
            b = abd.a(a, b + k);
            c = c - k;
            return k;
        } else
        {
            return -1;
        }
    }
}
