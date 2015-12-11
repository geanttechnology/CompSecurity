// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ezi extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private double n;
    private boolean o;
    private ezf p;
    private int q;

    public ezi()
    {
        b = 0;
        d = 0;
        f = 0;
        h = 0;
        j = 0;
        l = 0;
        n = 0.0D;
        p = null;
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
                a = true;
                b = j1;
                break;

            case 16: // '\020'
                int k1 = eud1.f();
                c = true;
                d = k1;
                break;

            case 24: // '\030'
                int l1 = eud1.f();
                e = true;
                f = l1;
                break;

            case 32: // ' '
                int i2 = eud1.f();
                g = true;
                h = i2;
                break;

            case 40: // '('
                int j2 = eud1.f();
                i = true;
                j = j2;
                break;

            case 48: // '0'
                int k2 = eud1.f();
                k = true;
                l = k2;
                break;

            case 57: // '9'
                double d1 = eud1.b();
                m = true;
                n = d1;
                break;

            case 66: // 'B'
                ezf ezf1 = new ezf();
                eud1.a(ezf1);
                o = true;
                p = ezf1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        if (c)
        {
            eue1.a(2, d);
        }
        if (e)
        {
            eue1.a(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
        if (i)
        {
            eue1.a(5, j);
        }
        if (k)
        {
            eue1.a(6, l);
        }
        if (m)
        {
            eue1.a(7, n);
        }
        if (o)
        {
            eue1.b(8, p);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(7, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(8, p);
        }
        q = i1;
        return i1;
    }
}
