// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.io.RandomAccessFile;

final class bui extends InputStream
{

    final buf a;
    private int b;
    private int c;

    private bui(buf buf1, buh buh1)
    {
        a = buf1;
        super();
        b = buf.a(buf1, buh1.b + 4);
        c = buh1.c;
    }

    bui(buf buf1, buh buh1, bug bug)
    {
        this(buf1, buh1);
    }

    public int read()
    {
        if (c == 0)
        {
            return -1;
        } else
        {
            buf.a(a).seek(b);
            int i = buf.a(a).read();
            b = buf.a(a, b + 1);
            c = c - 1;
            return i;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        buf.a(abyte0, "buffer");
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
            buf.a(a, b, abyte0, i, k);
            b = buf.a(a, b + k);
            c = c - k;
            return k;
        } else
        {
            return -1;
        }
    }
}
