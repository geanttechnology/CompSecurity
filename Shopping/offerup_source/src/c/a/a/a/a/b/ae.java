// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import java.io.InputStream;
import java.io.RandomAccessFile;

// Referenced classes of package c.a.a.a.a.b:
//            ad, ab

final class ae extends InputStream
{

    private int a;
    private int b;
    private ab c;

    private ae(ab ab1, ad ad1)
    {
        c = ab1;
        super();
        a = ab.a(ab1, ad1.b + 4);
        b = ad1.c;
    }

    ae(ab ab1, ad ad1, byte byte0)
    {
        this(ab1, ad1);
    }

    public final int read()
    {
        if (b == 0)
        {
            return -1;
        } else
        {
            ab.a(c).seek(a);
            int i = ab.a(c).read();
            a = ab.a(c, a + 1);
            b = b - 1;
            return i;
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        ab.a(abyte0, "buffer");
        if ((i | j) < 0 || j > abyte0.length - i)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (b > 0)
        {
            int k = j;
            if (j > b)
            {
                k = b;
            }
            ab.a(c, a, abyte0, i, k);
            a = ab.a(c, a + k);
            b = b - k;
            return k;
        } else
        {
            return -1;
        }
    }
}
