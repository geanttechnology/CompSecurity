// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;


final class p
{

    final byte a[];
    int b;
    int c;
    boolean d;
    boolean e;
    p f;
    p g;

    p()
    {
        a = new byte[2048];
        e = true;
        d = false;
    }

    p(p p1)
    {
        this(p1.a, p1.b, p1.c);
        p1.d = true;
    }

    private p(byte abyte0[], int i, int j)
    {
        a = abyte0;
        b = i;
        c = j;
        e = false;
        d = true;
    }

    public final p a()
    {
        p p1;
        if (f != this)
        {
            p1 = f;
        } else
        {
            p1 = null;
        }
        g.f = f;
        f.g = g;
        f = null;
        g = null;
        return p1;
    }

    public final p a(p p1)
    {
        p1.g = this;
        p1.f = f;
        f.g = p1;
        f = p1;
        return p1;
    }

    public final void a(p p1, int i)
    {
        if (!p1.e)
        {
            throw new IllegalArgumentException();
        }
        if (p1.c + i > 2048)
        {
            if (p1.d)
            {
                throw new IllegalArgumentException();
            }
            if ((p1.c + i) - p1.b > 2048)
            {
                throw new IllegalArgumentException();
            }
            System.arraycopy(p1.a, p1.b, p1.a, 0, p1.c - p1.b);
            p1.c = p1.c - p1.b;
            p1.b = 0;
        }
        System.arraycopy(a, b, p1.a, p1.c, i);
        p1.c = p1.c + i;
        b = b + i;
    }
}
