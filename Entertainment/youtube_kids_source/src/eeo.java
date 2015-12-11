// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eeo extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;

    public eeo()
    {
        b = 1;
        d = 0;
        f = 0;
        h = "";
        j = false;
        l = 0;
        m = -1;
    }

    public final int a()
    {
        if (m < 0)
        {
            b();
        }
        return m;
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

            case 34: // '"'
                String s = eud1.i();
                g = true;
                h = s;
                break;

            case 40: // '('
                int i2 = eud1.f();
                k = true;
                l = i2;
                break;

            case 48: // '0'
                boolean flag = eud1.h();
                i = true;
                j = flag;
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
        if (k)
        {
            eue1.a(5, l);
        }
        if (i)
        {
            eue1.a(6, j);
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
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.d(5, l);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(6, j);
        }
        m = i1;
        return i1;
    }
}
