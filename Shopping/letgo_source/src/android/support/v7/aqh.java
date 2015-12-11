// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            aqi

final class aqh
{

    final byte a[];
    int b;
    int c;
    boolean d;
    boolean e;
    aqh f;
    aqh g;

    aqh()
    {
        a = new byte[2048];
        e = true;
        d = false;
    }

    aqh(aqh aqh1)
    {
        this(aqh1.a, aqh1.b, aqh1.c);
        aqh1.d = true;
    }

    aqh(byte abyte0[], int i, int j)
    {
        a = abyte0;
        b = i;
        c = j;
        e = false;
        d = true;
    }

    public aqh a()
    {
        aqh aqh1;
        if (f != this)
        {
            aqh1 = f;
        } else
        {
            aqh1 = null;
        }
        g.f = f;
        f.g = g;
        f = null;
        g = null;
        return aqh1;
    }

    public aqh a(int i)
    {
        if (i <= 0 || i > c - b)
        {
            throw new IllegalArgumentException();
        } else
        {
            aqh aqh1 = new aqh(this);
            aqh1.c = aqh1.b + i;
            b = b + i;
            g.a(aqh1);
            return aqh1;
        }
    }

    public aqh a(aqh aqh1)
    {
        aqh1.g = this;
        aqh1.f = f;
        f.g = aqh1;
        f = aqh1;
        return aqh1;
    }

    public void a(aqh aqh1, int i)
    {
        if (!aqh1.e)
        {
            throw new IllegalArgumentException();
        }
        if (aqh1.c + i > 2048)
        {
            if (aqh1.d)
            {
                throw new IllegalArgumentException();
            }
            if ((aqh1.c + i) - aqh1.b > 2048)
            {
                throw new IllegalArgumentException();
            }
            System.arraycopy(aqh1.a, aqh1.b, aqh1.a, 0, aqh1.c - aqh1.b);
            aqh1.c = aqh1.c - aqh1.b;
            aqh1.b = 0;
        }
        System.arraycopy(a, b, aqh1.a, aqh1.c, i);
        aqh1.c = aqh1.c + i;
        b = b + i;
    }

    public void b()
    {
        if (g == this)
        {
            throw new IllegalStateException();
        }
        if (g.e)
        {
            int j = c - b;
            int k = g.c;
            int i;
            if (g.d)
            {
                i = 0;
            } else
            {
                i = g.b;
            }
            if (j <= i + (2048 - k))
            {
                a(g, j);
                a();
                aqi.a(this);
                return;
            }
        }
    }
}
