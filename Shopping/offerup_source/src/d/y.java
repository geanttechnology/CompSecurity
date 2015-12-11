// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;


final class y
{

    final byte a[];
    int b;
    int c;
    boolean d;
    boolean e;
    y f;
    y g;

    y()
    {
        a = new byte[2048];
        e = true;
        d = false;
    }

    y(y y1)
    {
        this(y1.a, y1.b, y1.c);
        y1.d = true;
    }

    private y(byte abyte0[], int i, int j)
    {
        a = abyte0;
        b = i;
        c = j;
        e = false;
        d = true;
    }

    public final y a()
    {
        y y1;
        if (f != this)
        {
            y1 = f;
        } else
        {
            y1 = null;
        }
        g.f = f;
        f.g = g;
        f = null;
        g = null;
        return y1;
    }

    public final y a(y y1)
    {
        y1.g = this;
        y1.f = f;
        f.g = y1;
        f = y1;
        return y1;
    }

    public final void a(y y1, int i)
    {
        if (!y1.e)
        {
            throw new IllegalArgumentException();
        }
        if (y1.c + i > 2048)
        {
            if (y1.d)
            {
                throw new IllegalArgumentException();
            }
            if ((y1.c + i) - y1.b > 2048)
            {
                throw new IllegalArgumentException();
            }
            System.arraycopy(y1.a, y1.b, y1.a, 0, y1.c - y1.b);
            y1.c = y1.c - y1.b;
            y1.b = 0;
        }
        System.arraycopy(a, b, y1.a, y1.c, i);
        y1.c = y1.c + i;
        b = b + i;
    }
}
