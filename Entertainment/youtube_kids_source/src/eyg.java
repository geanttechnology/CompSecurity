// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eyg extends eug
{

    public int a;
    public int b;
    public eyi c;
    public int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;
    private boolean i;
    private float j;
    private boolean k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;

    public eyg()
    {
        a = 10;
        b = 250;
        h = 200;
        j = 0.9F;
        l = 15;
        n = 50;
        c = null;
        d = 0;
        q = -1;
    }

    public final int a()
    {
        if (q < 0)
        {
            b();
        }
        return q;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (a(eud1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                int j1 = eud1.f();
                e = true;
                a = j1;
                break;

            case 16: // '\020'
                int k1 = eud1.f();
                f = true;
                b = k1;
                break;

            case 24: // '\030'
                int l1 = eud1.f();
                g = true;
                h = l1;
                break;

            case 37: // '%'
                float f1 = eud1.c();
                i = true;
                j = f1;
                break;

            case 40: // '('
                int i2 = eud1.f();
                k = true;
                l = i2;
                break;

            case 48: // '0'
                int j2 = eud1.f();
                m = true;
                n = j2;
                break;

            case 58: // ':'
                eyi eyi1 = new eyi();
                eud1.a(eyi1);
                o = true;
                c = eyi1;
                break;

            case 64: // '@'
                int k2 = eud1.f();
                p = true;
                d = k2;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (e)
        {
            eue1.a(1, a);
        }
        if (f)
        {
            eue1.a(2, b);
        }
        if (g)
        {
            eue1.a(3, h);
        }
        if (i)
        {
            eue1.a(4, j);
        }
        if (k)
        {
            eue1.a(5, l);
        }
        if (m)
        {
            eue1.a(6, n);
        }
        if (o)
        {
            eue1.b(7, c);
        }
        if (p)
        {
            eue1.a(8, d);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (e)
        {
            j1 = eue.d(1, a) + 0;
        }
        int i1 = j1;
        if (f)
        {
            i1 = j1 + eue.d(2, b);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.d(3, h);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(4, j);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.d(5, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(6, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(7, c);
        }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.d(8, d);
        }
        q = i1;
        return i1;
    }
}
